package project.main.ui.client;

import homework4.exercise3.controllers.CaculatorPanel;
import project.main.apps.busmaps.busStation.Main;
import project.main.games.game2048.game.Game;
import project.main.games.game2048.ui.GamePanel;
import project.main.games.snake.view.Window;
import project.main.games.sudoku.ui.SudokuUI;
import project.main.games.tictactoe.TicTacToe;
import project.main.user.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SettingPanel extends JPanel implements Runnable {
    //Map for app
    Map<String, Object> searchingApp = new HashMap<>();
    //PRIVATE SETTING
    public static final String nameStore = "Cửa hàng trò chơi";
    private final String imageStore = "logo.png";
    public static final int screenWith = 700;
    public static final int screenHeight = 600;

    //THREAD
    private final Thread storeThread;

    // Date
    private Date date;
    private Color colorBg = Color.WHITE;
    private SlideShowPanel pnSlider;
    private User user;

    //Button
    private JButton btnMenu;
    private JButton btnAchievements;
    private JButton btnAvatar;
    private JButton btnOption;
    private JButton btnHelp;

    // App and Game

    public SettingPanel(User user) {
        this.setPreferredSize(new Dimension(screenWith, screenHeight));
        this.setBackground(colorBg);
        this.setDoubleBuffered(true);
        this.setName(nameStore);
        date = new Date();

        this.user = user;
        pnSlider = new SlideShowPanel();

        storeThread = new Thread(this);
        storeThread.setDaemon(false);
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
            lblScore.setText(user.getScores() + "");
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
            bodyPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
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

            // Caculator
            Object[] calulator = getPanelApplication("caculator/logo.png");
            ((JButton) calulator[1]).addActionListener(i -> {
                System.out.println("Đang khởi động Máy tính ....");
                Thread thread = new Thread(()
                        -> new CaculatorPanel().showWindowns());
                thread.start();
            });
            appPanelBody.add((JPanel) calulator[0]);

            // Bus
            Object[] bus = getPanelApplication("busmaps/logo.png");
            ((JButton) bus[1]).addActionListener(i -> {
                System.out.println("Đang khởi động Máy tính ....");
                Thread thread = new Thread(()
                        -> {
                    Main main = new Main();
                    main.setVisible(true);
                });
                thread.start();
            });
            appPanelBody.add((JPanel) bus[0]);

            for (int i = 0; i < 4; i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.setPreferredSize(new Dimension(150, 190));

                JButton jButton1 = new JButton("Hinh anh");
                jButton1.setPreferredSize(new Dimension(150, 150));
                panel.add(jButton1, BorderLayout.NORTH);

                JButton jButton2 = new JButton("Vào ngay");
                jButton2.setPreferredSize(new Dimension(150, 40));
                panel.add(jButton2, BorderLayout.SOUTH);

                appPanelBody.add(panel);
            }

            appPanelBody.setPreferredSize(new Dimension(780, 200));
            appPanel.add(scrollPane, BorderLayout.SOUTH);
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


            // Game 2048
            Object[] game2048 = getPanelGame("game2048/logo.png");
            gamePanelBody.add((Component) game2048[0]);
            ((JButton) game2048[1]).addActionListener(i -> {
                System.out.println("Đang khởi động Game 2048...");
                Thread thread = new Thread(() -> {
                    GamePanel panel = new GamePanel();
                    Game game = new Game(panel);
                    panel.setGame(game);
                });

                thread.start();
            });

            // Rắn ăn mồi
            Object[] gameSnake = getPanelGame("snake/logo.png");
            gamePanelBody.add((Component) gameSnake[0]);
            ((JButton) gameSnake[1]).addActionListener(i -> {
                System.out.println("Đang khởi động " + "Rắn ăn mồi" + " ....");
                Thread thread = new Thread(() -> {
                    new Window();
                });

                thread.start();
            });

            // TicTacToe
            Object[] gameTicTacToe = getPanelGame("tictactoe/logo.png");
            gamePanelBody.add((Component) gameTicTacToe[0]);
            ((JButton) gameTicTacToe[1]).addActionListener(i -> {
                System.out.println("Đang khởi động " + "TicTacToe" + " ....");
                Thread thread = new Thread(() -> new TicTacToe());
                thread.start();
            });

            // Sukudo
            Object[] gameSukudo = getPanelGame("sudoku/logo.png");
            gamePanelBody.add((Component) gameSukudo[0]);
            ((JButton) gameSukudo[1]).addActionListener(i -> {
                System.out.println("Đang khởi động " + "Sudoku" + " ....");
                Thread thread = new Thread(() -> new SudokuUI());
                thread.start();
            });

            for (int i = 0; i < 1; i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.setPreferredSize(new Dimension(150, 190));

                JButton jButton1 = new JButton("Hinh anh");
                jButton1.setPreferredSize(new Dimension(150, 150));
                jButton1.setBackground(colorBg);
                jButton1.setBorderPainted(false);
                panel.add(jButton1, BorderLayout.NORTH);

                JButton jButton2 = new JButton("Choi ngay");
                jButton2.setPreferredSize(new Dimension(150, 40));
                panel.add(jButton2, BorderLayout.SOUTH);

                gamePanelBody.add(panel);
            }

            gamePanelBody.setPreferredSize(new Dimension(780, 200));
            gamePanel.add(scrollPaneGame, BorderLayout.SOUTH);
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

    private Object[] getPanelApplication(String imageStore) throws IOException {
        return getjPanel("apps/" + imageStore, "Bắt đầu");
    }

    private Object[] getPanelGame(String imageStore) throws IOException {
        return getjPanel("games/" + imageStore, "Chơi ngay");
    }

    private Object[] getjPanel(String folder, String btn2Name) throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(150, 190));

        JButton img = new JButton();
        img.setPreferredSize(new Dimension(150, 150));
        img.setBackground(colorBg);
        img.setBorderPainted(false);
        panel.add(img, BorderLayout.NORTH);
        loadLogo(img, folder);

        JButton play = new JButton(btn2Name);
        play.setPreferredSize(new Dimension(150, 40));
        panel.add(play, BorderLayout.SOUTH);
        return new Object[]{panel, play};
    }

    private void loadLogo(JButton button, String image) throws IOException {
        button.setIcon(
                new ImageIcon(ImageIO.read(SettingPanel.class.getResource("../../" + image))
                        .getScaledInstance(
                                button.getPreferredSize().width,
                                button.getPreferredSize().height,
                                Image.SCALE_SMOOTH
                        )
                )
        );
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
                new ImageIcon(ImageIO.read(SettingPanel.class.getResource(image))
                        .getScaledInstance(
                                button.getPreferredSize().width,
                                button.getPreferredSize().height,
                                Image.SCALE_SMOOTH
                        )
                )
        );
    }

}
