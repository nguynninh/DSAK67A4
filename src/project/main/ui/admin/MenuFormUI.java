package project.main.ui.admin;

import project.main.ui.loginform.LoginFormUI;

import javax.swing.*;
import java.awt.*;

public class MenuFormUI extends JPanel {
    public final int sizeWidth = 200;
    private final int sizeHeight = 700;

    // Hanh dông
    public JLabel jLabelLogo;
    public JLabel lblDashboard;
    public JLabel lblCustomer;
    public JLabel lblMessage;
    public JLabel lblPayHistory;
    public JLabel lblRepost;
    public JLabel lblthem;
    public JLabel lblAbout;
    public JLabel lblSetting;
    public JLabel lblLogout;

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
