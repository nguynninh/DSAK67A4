package project.main.ui.admin;

import project.main.ui.loginform.LoginFormUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuFormUI extends JPanel {
    public final int sizeWidth = 200;
    private final int sizeHeight = 700;

    // Hanh dông
    public JLabel jLabelLogo;
    private JLabel lblDashboard;
    private JLabel lblCustomer;
    private JLabel lblMessage;
    private JLabel lblPayHistory;
    private JLabel lblRepost;
    private JLabel lblthem;
    private JLabel lblAbout;
    private JLabel lblSetting;
    private JLabel lblLogout;

    public MenuFormUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBackground(Color.WHITE);

        initComponents();

        actionListener();
    }

    private void initComponents() {
        JPanel logoPanel = new JPanel(new CardLayout());
        jLabelLogo = new JLabel(resizeImageIcon("logo.png", sizeWidth, (int) (sizeHeight * 0.15)), JLabel.CENTER);
        logoPanel.setPreferredSize(new Dimension(sizeWidth, (int) (sizeHeight * 0.15)));
        logoPanel.add(jLabelLogo);
        add(logoPanel, BorderLayout.NORTH);

        JPanel navPanel = new JPanel(new GridLayout(7, 1));
        navPanel.setBackground(Color.WHITE);
        navPanel.setPreferredSize(new Dimension(sizeWidth, (int) (sizeHeight * 0.3)));
        navPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 90, 20));

        lblDashboard = new JLabel("Bảng điều kiển");
        lblDashboard.setIcon(resizeImageIcon("dashboard.png", 25, 25));
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 16));
        lblDashboard.setForeground(Color.BLACK);
        lblCustomer = new JLabel("Người dùng");
        lblCustomer.setIcon(resizeImageIcon("group.png", 25, 25));
        lblCustomer.setFont(new Font("Arial", Font.BOLD, 16));
        lblCustomer.setForeground(Color.BLACK);
        lblMessage = new JLabel("Tin nhắn");
        lblMessage.setIcon(resizeImageIcon("comments.png", 25, 25));
        lblMessage.setFont(new Font("Arial", Font.BOLD, 16));
        lblMessage.setForeground(Color.BLACK);
        lblPayHistory = new JLabel("Lịch sử");
        lblPayHistory.setIcon(resizeImageIcon("credit-card.png", 25, 25));
        lblPayHistory.setFont(new Font("Arial", Font.BOLD, 16));
        lblPayHistory.setForeground(Color.BLACK);
        lblRepost = new JLabel("Đồng bộ");
        lblRepost.setIcon(resizeImageIcon("retweet.png", 25, 25));
        lblRepost.setFont(new Font("Arial", Font.BOLD, 16));
        lblRepost.setForeground(Color.BLACK);
        lblthem = new JLabel("Thêm");
        lblthem.setIcon(resizeImageIcon("settings-sliders.png", 25, 25));
        lblthem.setFont(new Font("Arial", Font.BOLD, 16));
        lblthem.setForeground(Color.BLACK);
        navPanel.add(new Label("___________________________________"));
        navPanel.add(lblDashboard);
        navPanel.add(lblCustomer);
        navPanel.add(lblMessage);
        navPanel.add(lblPayHistory);
        navPanel.add(lblRepost);
        navPanel.add(lblthem);
        add(navPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new GridLayout(4, 1));
        footerPanel.setPreferredSize(new Dimension(sizeWidth, (int) (sizeHeight * 0.3)));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 50, 20));

        lblAbout = new JLabel("Giới thiệu");
        lblAbout.setIcon(resizeImageIcon("info.png", 25, 25));
        lblAbout.setFont(new Font("Arial", Font.BOLD, 16));
        lblAbout.setForeground(Color.BLACK);
        lblSetting = new JLabel("Cài đặt");
        lblSetting.setIcon(resizeImageIcon("settings.png", 25, 25));
        lblSetting.setFont(new Font("Arial", Font.BOLD, 16));
        lblSetting.setForeground(Color.BLACK);
        lblLogout = new JLabel("Đăng xuất");
        lblLogout.setIcon(resizeImageIcon("logout.png", 25, 25));
        lblLogout.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogout.setForeground(Color.BLACK);
        footerPanel.add(new Label("___________________________________"));
        footerPanel.add(lblAbout);
        footerPanel.add(lblSetting);
        footerPanel.add(lblLogout);

        footerPanel.setBackground(Color.WHITE);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void actionListener() {
        lblLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        null,
                        "Bạn có chắc chắn muốn đăng xuất?",
                        "Xác nhận đăng xuất",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    performLogout();
                }
            }
        });

    }

    private void performLogout() {
        LoginFormUI loginFormUI = new LoginFormUI();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblLogout);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(loginFormUI);
        frame.pack();
        frame.repaint();
    }

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(MenuFormUI.class.getResource(imagePath));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dashboard Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MenuFormUI menuFormUI = new MenuFormUI();
            frame.getContentPane().add(menuFormUI);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
