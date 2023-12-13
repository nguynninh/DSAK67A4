package project.main;

import homework4.exercise3.controllers.CaculatorPanel;
import project.main.games.game2048.game.Game;
import project.main.games.game2048.ui.GamePanel;
import project.main.games.snake.view.Window;
import project.main.games.sudoku.ui.SudokuUI;
import project.main.games.tictactoe.TicTacToe;

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
    private final String nameStore = "Cửa hàng trò chơi";
    private final String imageStore = "icon/logo.png";
    public static final int screenWith = 700;
    public static final int screenHeight = 600;

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

    // App and Game

    public SettingPanel() {
        this.setPreferredSize(new Dimension(screenWith, screenHeight));
        this.setBackground(colorBg);
        this.setDoubleBuffered(true);
        this.setName(nameStore);
        date = new Date();

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
            loadImage(btnMenu, "icon/menu.png");

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
            loadImage(btnAchievements, "icon/badge.png");

            btnAvatar = new JButton();
            btnAvatar.setPreferredSize(new Dimension(32, 32));
            btnAvatar.setBackground(colorBg);
            btnAvatar.setBorderPainted(false);
            rightHeaderPanel.add(btnAvatar);
            loadImage(btnAvatar, "icon/user.png");

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
            JPanel calulatorPanel = new JPanel();
            calulatorPanel.setLayout(new BorderLayout());
            calulatorPanel.setPreferredSize(new Dimension(150, 190));

            JButton imgCalulator = new JButton();
            imgCalulator.setPreferredSize(new Dimension(150, 150));
            imgCalulator.setBackground(colorBg);
            imgCalulator.setBorderPainted(false);
            calulatorPanel.add(imgCalulator, BorderLayout.NORTH);
            loadImage(imgCalulator, "apps/caculator/logo.png");

            JButton playCaculator = new JButton("Vào ngay");
            playCaculator.setPreferredSize(new Dimension(150, 40));
            calulatorPanel.add(playCaculator, BorderLayout.SOUTH);
            playCaculator.addActionListener(i -> {
                System.out.println("Đang khởi động máy tính ....");
                Thread thread = new Thread(() -> new CaculatorPanel().showWindowns());

//                thread.setDaemon(true);

                thread.start();
            });

            appPanelBody.add(calulatorPanel);

            // Facebook
            JPanel fbPanel = new JPanel();
            fbPanel.setLayout(new BorderLayout());
            fbPanel.setPreferredSize(new Dimension(150, 190));

            JButton imgFB = new JButton();
            imgFB.setPreferredSize(new Dimension(150, 150));
            imgFB.setBackground(colorBg);
            imgFB.setBorderPainted(false);
            fbPanel.add(imgFB, BorderLayout.NORTH);
            loadImage(imgFB, "apps/pr2/logo.png");

            JButton playFB = new JButton("Vào ngay");
            playFB.setPreferredSize(new Dimension(150, 40));
            fbPanel.add(playFB, BorderLayout.SOUTH);

            appPanelBody.add(fbPanel);

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
            Object[] game2048 = createBannerGame("Game 2048", "game2048/logo.png");
            gamePanelBody.add((Component) game2048[0]);
            ((JButton) game2048[2]).addActionListener(i->{
                    System.out.println("Đang khởi động " + "Game 2048" + " ....");
                    Thread thread = new Thread(() -> {
                        GamePanel panel = new GamePanel();
                        Game game = new Game(panel);
                        panel.setGame(game);
                    });

                    thread.start();
            });

            // Rắn ăn mồi
            Object[] gameSnake = createBannerGame("Rắn ăn mồi", "snake/logo.png");
            gamePanelBody.add((Component) gameSnake[0]);
            ((JButton) gameSnake[2]).addActionListener(i->{
                    System.out.println("Đang khởi động " + "Rắn ăn mồi" + " ....");
                    Thread thread = new Thread(() -> {
                        new Window();
                    });

                    thread.start();
            });

            // TicTacToe
            Object[] gameTicTacToe = createBannerGame("TicTacToe", "tictactoe/logo.png");
            gamePanelBody.add((Component) gameTicTacToe[0]);
            ((JButton) gameTicTacToe[2]).addActionListener(i->{
                    System.out.println("Đang khởi động " + "TicTacToe" + " ....");
                    Thread thread = new Thread(() -> new TicTacToe());
                    thread.start();
            });

            // Sukudo
            Object[] gameSukudo = createBannerGame("Sudoku", "sudoku/logo.png");
            gamePanelBody.add((Component) gameSukudo[0]);
            ((JButton) gameSukudo[2]).addActionListener(i->{
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
            loadImage(btnOption, "icon/settings.png");

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
            loadImage(btnHelp, "icon/question.png");

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
                new ImageIcon(ImageIO.read(getClass().getResourceAsStream(image))
                        .getScaledInstance(
                                button.getPreferredSize().width,
                                button.getPreferredSize().height,
                                Image.SCALE_SMOOTH
                        )
                )
        );
    }

    /**
     *
     * @param name
     * @param img
     * @return Object[] - JPanel, btnImg, btnPlay
     * @throws IOException
     */
    private Object[] createBannerGame(String name, String img) throws IOException {
        JPanel panelGame = new JPanel();
        panelGame.setLayout(new BorderLayout());
        panelGame.setPreferredSize(new Dimension(150, 190));

        JButton btnImg = new JButton();
        btnImg.setPreferredSize(new Dimension(150, 150));
        btnImg.setBackground(colorBg);
        btnImg.setBorderPainted(false);
        panelGame.add(btnImg, BorderLayout.NORTH);
        loadImage(btnImg, "games/" + img);

        JButton playGame = new JButton("Choi ngay");
        playGame.setPreferredSize(new Dimension(150, 40));
        panelGame.add(playGame, BorderLayout.SOUTH);

        return new Object[]{panelGame, btnImg, playGame};
    }

}
