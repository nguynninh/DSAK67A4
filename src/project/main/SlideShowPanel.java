package project.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class SlideShowPanel extends JPanel implements Runnable {
    private final int screenWidth = 220;
    private final int screenHeight = 500;

    private final Thread storeThread;

    // Date
    private Date date;

    private Color colorBg = Color.WHITE;

    //Button
    private JButton btnExit;
    private JButton btnHome;
    private JButton btnAccount;
    private JButton bthBill;
    private JButton btnStatistical;

    private JButton btnHelp;
    private JButton bthIntroduce;
    private JButton btnLogout;

    public SlideShowPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(colorBg);
        this.setDoubleBuffered(true);
        date = new Date();

        storeThread = new Thread(this);
        storeThread.start();
    }

    @Override
    public void run() {
        try {
            this.setLayout(new BorderLayout());
            this.setBackground(colorBg);
            this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
            topPanel.setSize(screenWidth - 20, 150);

            btnExit = new JButton();
            btnExit = new JButton();
            btnExit.setPreferredSize(new Dimension(32, 32));
            btnExit.setBackground(colorBg);
            btnExit.setBorderPainted(false);
            topPanel.add(btnExit, BorderLayout.EAST);
            loadImage(btnExit, "reject.png");

            JLabel lblWelcome = new JLabel();
            lblWelcome.setText("Chào Buổi " + getWel());
            lblWelcome.setFont(new Font("Arial", 0, 16));
            lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
            topPanel.add(lblWelcome);

            JLabel lblName = new JLabel();
            lblName.setText("Giai thuat JAVA");
            lblName.setFont(new Font("Arial", Font.BOLD, 20));
            lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
            topPanel.add(lblName);
//
            JLabel line1 = new JLabel("_________________________");
            line1.setAlignmentX(Component.CENTER_ALIGNMENT);
            topPanel.add(line1);

            this.add(topPanel, BorderLayout.NORTH);

//            // Center
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
            centerPanel.setBackground(colorBg);

            btnHome = new JButton("Trang chủ");
            btnHome.setPreferredSize(new Dimension(screenWidth, 40));
            btnHome.setFont(new Font("Arial", Font.BOLD, 20));
            btnHome.setBackground(Color.GRAY);
            btnHome.setBorderPainted(false);
            btnHome.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(btnHome);

            btnAccount = new JButton("Tài khoản");
            btnAccount.setPreferredSize(new Dimension(screenWidth, 40));
            btnAccount.setFont(new Font("Arial", Font.BOLD, 16));
            btnAccount.setBackground(colorBg);
            btnAccount.setBorderPainted(false);
            btnAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(btnAccount);

            bthBill = new JButton("Giao dịch");
            bthBill.setPreferredSize(new Dimension(screenWidth, 40));
            bthBill.setFont(new Font("Arial", Font.BOLD, 16));
            bthBill.setBackground(colorBg);
            bthBill.setBorderPainted(false);
            bthBill.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(bthBill);

            btnStatistical = new JButton("Thống kê");
            btnStatistical.setPreferredSize(new Dimension(screenWidth, 32));
            btnStatistical.setFont(new Font("Arial", Font.BOLD, 16));
            btnStatistical.setBackground(colorBg);
            btnStatistical.setBorderPainted(false);
            btnStatistical.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(btnStatistical);

            this.add(centerPanel, BorderLayout.CENTER);

            // Footer
            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
            bottomPanel.setSize(screenWidth - 20, 150);
            bottomPanel.setBackground(colorBg);

            JLabel line2 = new JLabel("_________________________");
            line2.setAlignmentX(Component.CENTER_ALIGNMENT);
            bottomPanel.add(line2);

            btnHelp = new JButton("Trợ giúp");
            btnHelp.setPreferredSize(new Dimension(screenWidth, 32));
            btnHelp.setBackground(colorBg);
            btnHelp.setBorderPainted(false);
            btnHelp.setAlignmentX(Component.CENTER_ALIGNMENT);
            bottomPanel.add(btnHelp);

            bthIntroduce = new JButton("Giới thiệu");
            bthIntroduce.setPreferredSize(new Dimension(screenWidth, 32));
            bthIntroduce.setBackground(colorBg);
            bthIntroduce.setBorderPainted(false);
            bthIntroduce.setAlignmentX(Component.CENTER_ALIGNMENT);
            bottomPanel.add(bthIntroduce);

            btnLogout = new JButton("Đăng xuất");
            btnLogout.setPreferredSize(new Dimension(screenWidth, 32));
            btnLogout.setBackground(colorBg);
            btnLogout.setBorderPainted(false);
            btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
            bottomPanel.add(btnLogout);

            this.add(bottomPanel, BorderLayout.SOUTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnHome.addActionListener(i -> {
            btnHome.setBackground(Color.GRAY);
            bthBill.setBackground(colorBg);
            btnAccount.setBackground(colorBg);
            btnStatistical.setBackground(colorBg);

            btnHome.setFont(new Font("Arial", Font.BOLD, 20));
            setDefaultFontSize(bthBill);
            setDefaultFontSize(btnAccount);
            setDefaultFontSize(btnStatistical);
        });

        btnAccount.addActionListener(i -> {
            btnHome.setBackground(colorBg);
            bthBill.setBackground(colorBg);
            btnAccount.setBackground(Color.GRAY);
            btnStatistical.setBackground(colorBg);

            btnAccount.setFont(new Font("Arial", Font.BOLD, 20));
            setDefaultFontSize(btnHome);
            setDefaultFontSize(bthBill);
            setDefaultFontSize(btnStatistical);
        });

        bthBill.addActionListener(i -> {
            btnHome.setBackground(colorBg);
            bthBill.setBackground(Color.GRAY);
            btnAccount.setBackground(colorBg);
            btnStatistical.setBackground(colorBg);

            bthBill.setFont(new Font("Arial", Font.BOLD, 20));
            setDefaultFontSize(btnHome);
            setDefaultFontSize(btnAccount);
            setDefaultFontSize(btnStatistical);
        });

        btnStatistical.addActionListener(i -> {
            btnHome.setBackground(colorBg);
            bthBill.setBackground(colorBg);
            btnAccount.setBackground(colorBg);
            btnStatistical.setBackground(Color.GRAY);

            btnStatistical.setFont(new Font("Arial", Font.BOLD, 20));
            setDefaultFontSize(btnHome);
            setDefaultFontSize(bthBill);
            setDefaultFontSize(btnAccount);
        });
    }

    private void setDefaultFontSize(JButton btnHome) {
        btnHome.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private String getWel() {
        if (date.getHours() >= 0 && date.getHours() <= 10)
            return "Sáng";
        else if (date.getHours() > 10 && date.getHours() <= 14)
            return "Trưa";
        else if (date.getHours() > 14 && date.getHours() <= 17)
            return "Chiều";
        else
            return "Tối";
    }

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
