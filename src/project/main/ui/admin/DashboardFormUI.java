package project.main.ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardFormUI extends JPanel {
    private final int sizeWidth = 1000;
    private final int sizeHeight = 700;

    //Hanh dong
    private MenuFormUI panelMenuOpen;
    private JPanel panelMenuClose;
    private JLabel lblMenu;

    public DashboardFormUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBackground(null);

        panelMenuOpen = new MenuFormUI();

        initComponents();

        actionListener();
    }

    private void initComponents() {
        panelMenuClose = new JPanel(new BorderLayout());
        panelMenuClose.setPreferredSize(new Dimension((int) (sizeWidth * 0.07), sizeHeight));
        panelMenuClose.setBackground(Color.GRAY);

        JPanel jPanelMenu = new JPanel();
        jPanelMenu.setPreferredSize(new Dimension((int) (sizeWidth * 0.1), (int) (sizeHeight * 0.1)));
        lblMenu = new JLabel(resizeImageIcon("menu.png", 25, 25));
        jPanelMenu.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        jPanelMenu.setBackground(null);
        jPanelMenu.add(lblMenu);
        panelMenuClose.add(jPanelMenu, BorderLayout.NORTH);

        JPanel navPanel = new JPanel(new GridLayout(7, 1));
        navPanel.setBackground(null);
        navPanel.setPreferredSize(new Dimension((int) (sizeWidth * 0.05), (int) (sizeHeight * 0.3)));
        navPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 90, 20));

        JLabel lblDashboard = new JLabel();
        lblDashboard.setIcon(resizeImageIcon("dashboard.png", 25, 25));
        lblDashboard.setFont(new Font("Arial", Font.BOLD, 16));
        lblDashboard.setForeground(Color.BLACK);
        JLabel lblCustomer = new JLabel();
        lblCustomer.setIcon(resizeImageIcon("group.png", 25, 25));
        lblCustomer.setFont(new Font("Arial", Font.BOLD, 16));
        lblCustomer.setForeground(Color.BLACK);
        JLabel lblMessage = new JLabel();
        lblMessage.setIcon(resizeImageIcon("comments.png", 25, 25));
        lblMessage.setFont(new Font("Arial", Font.BOLD, 16));
        lblMessage.setForeground(Color.BLACK);
        JLabel lblPayHistory = new JLabel();
        lblPayHistory.setIcon(resizeImageIcon("credit-card.png", 25, 25));
        lblPayHistory.setFont(new Font("Arial", Font.BOLD, 16));
        lblPayHistory.setForeground(Color.BLACK);
        JLabel lblRepost = new JLabel();
        lblRepost.setIcon(resizeImageIcon("retweet.png", 25, 25));
        lblRepost.setFont(new Font("Arial", Font.BOLD, 16));
        lblRepost.setForeground(Color.BLACK);
        JLabel lblthem = new JLabel();
        lblthem.setIcon(resizeImageIcon("settings-sliders.png", 25, 25));
        lblthem.setFont(new Font("Arial", Font.BOLD, 16));
        lblthem.setForeground(Color.BLACK);
        navPanel.add(new Label("____"));
        navPanel.add(lblDashboard);
        navPanel.add(lblCustomer);
        navPanel.add(lblMessage);
        navPanel.add(lblPayHistory);
        navPanel.add(lblRepost);
        navPanel.add(lblthem);
        panelMenuClose.add(navPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new GridLayout(4, 1));
        footerPanel.setPreferredSize(new Dimension((int) (sizeWidth * 0.05), (int) (sizeHeight * 0.3)));
        footerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 50, 20));

        JLabel lblAbout = new JLabel();
        lblAbout.setIcon(resizeImageIcon("info.png", 25, 25));
        lblAbout.setFont(new Font("Arial", Font.BOLD, 16));
        lblAbout.setForeground(Color.BLACK);
        JLabel lblSetting = new JLabel();
        lblSetting.setIcon(resizeImageIcon("settings.png", 25, 25));
        lblSetting.setFont(new Font("Arial", Font.BOLD, 16));
        lblSetting.setForeground(Color.BLACK);
        JLabel lblLogout = new JLabel();
        lblLogout.setIcon(resizeImageIcon("logout.png", 25, 25));
        lblLogout.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogout.setForeground(Color.BLACK);
        footerPanel.add(new Label("____"));
        footerPanel.add(lblAbout);
        footerPanel.add(lblSetting);
        footerPanel.add(lblLogout);

        footerPanel.setBackground(null);
        panelMenuClose.add(footerPanel, BorderLayout.SOUTH);

        add(panelMenuClose, BorderLayout.WEST);
    }

    private void actionListener() {
        lblMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(panelMenuClose);
                add(panelMenuOpen, BorderLayout.WEST);
                revalidate();
                repaint();
            }
        });

        panelMenuOpen.jLabelLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(panelMenuOpen);
                add(panelMenuClose, BorderLayout.WEST);
                revalidate();
                repaint();
            }
        });
    }

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(DashboardFormUI.class.getResource(imagePath));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dashboard Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DashboardFormUI dashboardFormUI = new DashboardFormUI();
            frame.getContentPane().add(dashboardFormUI);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

