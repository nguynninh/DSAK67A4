package project.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingPanel extends JPanel implements Runnable {
    //PRIVATE SETTING
    private final String nameStore = "Cửa hàng trò chơi";
    private final String imageStore = "icon/logo.png";
    private final int screenWith = 700;
    private final int screenHeight = 600;

    //THREAD
    private final Thread storeThread;

    // Date
    private Date date;

    private Color colorBg = Color.WHITE;

    private SlideShowPanel pnSlider;

    //Button
    private JButton btnMenu;
    private JButton btnAchievements;
    private JButton btnAvatar;
    private JButton btnOption;
    private JButton btnHelp;

    public SettingPanel() {
        this.setPreferredSize(new Dimension(screenWith, screenHeight));
        this.setBackground(colorBg);
        this.setDoubleBuffered(true);
        this.setName(nameStore);
        date = new Date();

        pnSlider = new SlideShowPanel();

        storeThread = new Thread(this);
        storeThread.start();
    }

    @Override
    public void run() {
        try {
            this.setLayout(new BorderLayout());
            this.setBackground(colorBg);
            this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

            // Start Header Panel
            JPanel headerPanel = new JPanel();
            headerPanel.setPreferredSize(new Dimension(screenWith, 50));
            headerPanel.setLayout(new BorderLayout());
            headerPanel.setBackground(colorBg);

            // Start Left Header Panel
            JPanel leftHeaderPanel = new JPanel();
            leftHeaderPanel.setLayout(new FlowLayout());
            leftHeaderPanel.setBackground(colorBg);

            btnMenu = new JButton();
            btnMenu.setPreferredSize(new Dimension(32, 32));
            btnMenu.setBackground(colorBg);
            btnMenu.setBorderPainted(false);
            leftHeaderPanel.add(btnMenu);
            loadImage(btnMenu, "menu.png");

            JLabel jLabel = new JLabel();
            jLabel.setText(nameStore);
            jLabel.setFont(new Font("Arial", Font.BOLD, 20));
            leftHeaderPanel.add(jLabel);

            headerPanel.add(leftHeaderPanel, BorderLayout.WEST);
            // End Left Header Panel

            // Start Right Header Panel
            JPanel rightHeaderPanel = new JPanel();
            rightHeaderPanel.setLayout(new FlowLayout());
            rightHeaderPanel.setBackground(colorBg);

            JLabel lblScore = new JLabel();
            lblScore.setText("1000");
            lblScore.setFont(new Font("Arial", Font.BOLD, 20));
            rightHeaderPanel.add(lblScore);

            btnAchievements = new JButton();
            btnAchievements.setPreferredSize(new Dimension(32, 32));
            btnAchievements.setBackground(colorBg);
            btnAchievements.setBorderPainted(false);
            rightHeaderPanel.add(btnAchievements);
            loadImage(btnAchievements, "badge.png");

            btnAvatar = new JButton();
            btnAvatar.setPreferredSize(new Dimension(32, 32));
            btnAvatar.setBackground(colorBg);
            btnAvatar.setBorderPainted(false);
            rightHeaderPanel.add(btnAvatar);
            loadImage(btnAvatar, "user.png");

            headerPanel.add(rightHeaderPanel, BorderLayout.EAST);
            // End Right Header Panel

            this.add(headerPanel, BorderLayout.NORTH, SwingConstants.CENTER);
            // End Header Panel

            // Start Body Panel
            JPanel bodyPanel = new JPanel();
            bodyPanel.setBackground(colorBg);
            bodyPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
            bodyPanel.setLayout(new GridLayout(2, 1));

            // App
            JPanel appPanel = new JPanel();
            appPanel.setBackground(colorBg);
            appPanel.setLayout(new BorderLayout());

            JPanel appPanelName = new JPanel();
            appPanelName.setLayout(new FlowLayout());
            appPanelName.setBackground(Color.CYAN);
            appPanelName.setPreferredSize(new Dimension(screenWith - 40, 30));

            JLabel lblAppName = new JLabel("Các ứng dụng hiện có");
            lblAppName.setFont(new Font("Arial", Font.BOLD, 16));
            appPanelName.add(lblAppName);

            appPanel.add(appPanelName, BorderLayout.NORTH);

            JPanel appPanelBody = new JPanel();
            JScrollPane scrollPane = new JScrollPane(appPanelBody);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            for (int i = 0; i < 5; i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.setPreferredSize(new Dimension(150, 190));

                JButton jButton1 = new JButton("Hinh anh");
                jButton1.setPreferredSize(new Dimension(150, 150));
                panel.add(jButton1, BorderLayout.NORTH);

                JButton jButton2 = new JButton("Choi ngay");
                jButton2.setPreferredSize(new Dimension(150, 40));
                panel.add(jButton2, BorderLayout.SOUTH);

                appPanelBody.add(panel);
            }

            appPanelBody.setPreferredSize(new Dimension(780, 200));
            appPanel.add(scrollPane,BorderLayout.SOUTH);
            bodyPanel.add(appPanel);

            // Game
            JPanel gamePanel = new JPanel();
            gamePanel.setLayout(new BorderLayout());

            JPanel gamePanelName = new JPanel();
            gamePanelName.setLayout(new FlowLayout());
            gamePanelName.setBackground(Color.CYAN);
            gamePanelName.setPreferredSize(new Dimension(screenWith - 40, 30));

            JLabel lblGameName = new JLabel("Các trò chơi hiện có");
            lblGameName.setFont(new Font("Arial", Font.BOLD, 16));
            gamePanelName.add(lblGameName);

            gamePanel.add(gamePanelName, BorderLayout.NORTH);

            JPanel gamePanelBody = new JPanel();
            JScrollPane scrollPaneGame = new JScrollPane(gamePanelBody);
            scrollPaneGame.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            for (int i = 0; i < 5; i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.setPreferredSize(new Dimension(150, 190));

                JButton jButton1 = new JButton("Hinh anh");
                jButton1.setPreferredSize(new Dimension(150, 150));
                panel.add(jButton1, BorderLayout.NORTH);

                JButton jButton2 = new JButton("Choi ngay");
                jButton2.setPreferredSize(new Dimension(150, 40));
                panel.add(jButton2, BorderLayout.SOUTH);

                gamePanelBody.add(panel);
            }

            gamePanelBody.setPreferredSize(new Dimension(780, 200));
            gamePanel.add(scrollPaneGame,BorderLayout.SOUTH);
            bodyPanel.add(gamePanel);

            this.add(bodyPanel, BorderLayout.CENTER);
            // End Body Panel

            // Start Footer Panel
            JPanel footerPanel = new JPanel();
            footerPanel.setPreferredSize(new Dimension(screenWith, 30));
            footerPanel.setLayout(new BorderLayout());
            footerPanel.setBackground(colorBg);

            btnOption = new JButton();
            btnOption.setPreferredSize(new Dimension(32, 32));
            btnOption.setBackground(colorBg);
            btnOption.setBorderPainted(false);
            footerPanel.add(btnOption, BorderLayout.WEST);
            loadImage(btnOption, "settings.png");

            JLabel lblTime = new JLabel();
            lblTime.setText(new SimpleDateFormat("HH:mm a").format(date));
            lblTime.setFont(new Font("Arial", Font.BOLD, 20));
            lblTime.setHorizontalAlignment(SwingConstants.CENTER);
            footerPanel.add(lblTime, BorderLayout.CENTER);

            btnHelp = new JButton();
            btnHelp.setPreferredSize(new Dimension(32, 32));
            btnHelp.setBackground(colorBg);
            btnHelp.setBorderPainted(false);
            footerPanel.add(btnHelp, BorderLayout.EAST);
            loadImage(btnHelp, "question.png");

            this.add(footerPanel, BorderLayout.SOUTH);
            // End Footer Panel
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Logic
        btnMenu.addActionListener(i -> {
            openMenuBar();
        });
    }

    private void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < screenWith; i++) {
                    pnSlider.setSize(i, screenHeight);
                }
            }
        }).start();
    }

    // Add Img
    private void loadImage(JButton button, String image) throws IOException {
        button.setIcon(
                new ImageIcon(ImageIO.read(getClass().getResourceAsStream("icon/" + image))
                        .getScaledInstance(
                                button.getPreferredSize().width,
                                button.getPreferredSize().height,
                                Image.SCALE_SMOOTH
                        )
                )
        );
    }
}
