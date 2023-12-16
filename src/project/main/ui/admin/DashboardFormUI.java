package project.main.ui.admin;

import project.main.ui.loginform.LoginFormUI;
import project.main.user.User;
import project.main.user.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DashboardFormUI extends JPanel {
    private final int sizeWidth = 1000;
    private final int sizeHeight = 700;
    private UserService userService = UserService.getInstance();
    public String userLogin;

    //Hanh dong
    private MenuFormUI panelMenuOpen;
    private JPanel panelMenuClose;
    private JPanel panelContent;
    private JLabel lblMenu;
    private JLabel lblRepost;
    private JLabel lblLogout;
    private JPanel panelUser;
    private JPanel jPanelUB;

    public DashboardFormUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBackground(null);

        panelMenuOpen = new MenuFormUI();

        initComponents();

        actionListener();
    }

    public DashboardFormUI(String userLogin) {
        this();
        this.userLogin = userLogin;
    }

    private void initComponents() {
        panelMenuClose = new JPanel(new BorderLayout());
        panelMenuClose.setPreferredSize(new Dimension((int) (sizeWidth * 0.07), sizeHeight));
        panelMenuClose.setBackground(Color.WHITE);

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
        JLabel lblCustomer = new JLabel();
        lblCustomer.setIcon(resizeImageIcon("group.png", 25, 25));
        JLabel lblMessage = new JLabel();
        lblMessage.setIcon(resizeImageIcon("comments.png", 25, 25));
        JLabel lblPayHistory = new JLabel();
        lblPayHistory.setIcon(resizeImageIcon("credit-card.png", 25, 25));
        lblRepost = new JLabel();
        lblRepost.setIcon(resizeImageIcon("retweet.png", 25, 25));

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
        lblLogout = new JLabel();
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

        //Panel Right
        panelContent = extractedContentPanel(panelContent);
        add(panelContent, BorderLayout.EAST);
    }

    private JPanel extractedContentPanel(JPanel panel) {
        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension((int) (sizeWidth * 0.93), sizeHeight));
        panel.setBackground(new Color(233, 221, 213));

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setPreferredSize(new Dimension((int) (sizeWidth - sizeWidth * 0.07), (int) (sizeHeight * 0.08)));
        panelTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel panelTopLeft = new JPanel(new FlowLayout());
        JTextField jTextFieldSearch = new JTextField();
        jTextFieldSearch.setText("Bạn muốn tìm gì?");
        jTextFieldSearch.setPreferredSize(new Dimension(new Dimension(300, (int) (sizeHeight * 0.05))));
        jTextFieldSearch.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2)
                , BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        jTextFieldSearch.setFont(new Font("Arial", Font.PLAIN + Font.ITALIC, 14));
        jTextFieldSearch.setForeground(Color.BLACK);

        JLabel jLabelSearch = new JLabel(resizeImageIcon("search.png", 32, 32));
        jLabelSearch.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        panelTopLeft.add(jTextFieldSearch);
        panelTopLeft.add(jLabelSearch);
        panelTop.add(panelTopLeft, BorderLayout.WEST);

        JPanel panelTopRight = new JPanel(new FlowLayout());
        JLabel jLabelAvatar = new JLabel("Chào Admin");
        jLabelAvatar.setIcon(resizeImageIcon("avatar.png", 32, 32));
        jLabelAvatar.setFont(new Font("Arial", Font.BOLD, 16));
        jLabelAvatar.setForeground(Color.BLACK);

        JLabel jLabelNnotifi = new JLabel(resizeImageIcon("notification-bell.png", 32, 32));
        jLabelNnotifi.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        JLabel jLabelEmail = new JLabel(resizeImageIcon("mail.png", 32, 32));
        jLabelEmail.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        panelTopRight.add(jLabelNnotifi);
        panelTopRight.add(jLabelEmail);
        panelTopRight.add(jLabelAvatar);
        panelTop.add(panelTopRight, BorderLayout.EAST);
        panel.add(panelTop, BorderLayout.NORTH);

        JPanel jPanelBottom = new JPanel(new BorderLayout());
        jPanelBottom.setPreferredSize(new Dimension((int) (sizeWidth - sizeWidth * 0.07), (int) (sizeHeight * 0.92)));

        JPanel panelOverview = new JPanel(new GridLayout(1, 3, 40, 0));
        panelOverview.setPreferredSize(new Dimension((int) (sizeWidth - sizeWidth * 0.07), (int) (sizeHeight * 0.3)));
        panelOverview.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelOverview.setBackground(null);
        extractedPanelOverview(panelOverview, "group.png", "Customer", "Số nguời: " + getSized(), "Đang trên đà phát triển mạnh");
        extractedPanelOverview(panelOverview, "group.png", "Customer", "Số nguời: " + getSized(), "Đang trên đà phát triển mạnh");
        extractedPanelOverview(panelOverview, "group.png", "Customer", "Số nguời: " + getSized(), "Đang trên đà phát triển mạnh");
        jPanelBottom.add(panelOverview, BorderLayout.NORTH);

        JPanel panelNav = new JPanel(new BorderLayout());
        panelNav.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panelNav.setPreferredSize(new Dimension((int) (sizeWidth - sizeWidth * 0.07), (int) (sizeHeight * 0.62)));

        panelUser = new JPanel(new BorderLayout());
        panelUser.setPreferredSize(new Dimension(600, (int) (sizeHeight * 0.62)));
        panelUser.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(0, 0, 0, 0)));

        JPanel jPanelUT = new JPanel(new BorderLayout());
        jPanelUT.setPreferredSize(new Dimension(600, 40));
        JPanel jPanelUTL = new JPanel(new FlowLayout());
        JLabel jLabelUTL = new JLabel("Data User");
        jLabelUTL.setIcon(resizeImageIcon("data.png", 28, 28));
        jLabelUTL.setFont(new Font("Arial", Font.BOLD, 18));
        jLabelUTL.setForeground(Color.BLACK);
        jPanelUTL.add(jLabelUTL);
        jPanelUT.add(jPanelUTL, BorderLayout.WEST);
        panelUser.add(jPanelUT, BorderLayout.NORTH);

        jPanelUB = new JPanel();
        jPanelUB.setBorder(BorderFactory.createEmptyBorder(10, -10, -10, -10));
        jPanelUB.setLayout(new BoxLayout(jPanelUB, BoxLayout.Y_AXIS));
        jPanelUB.setPreferredSize(new Dimension(600, (int) (sizeHeight * 0.62 - sizeHeight * 0.06)));
        addListMenuFromUi(jPanelUB);
        panelUser.add(jPanelUB, BorderLayout.SOUTH);

        panelNav.add(panelUser, BorderLayout.WEST);

        JPanel panelNotifi = new JPanel();
        panelNotifi.setPreferredSize(new Dimension(330, (int) (sizeHeight * 0.62)));
        panelNotifi.setBackground(Color.YELLOW);

        panelNav.add(panelNotifi, BorderLayout.EAST);

        jPanelBottom.add(panelNav, BorderLayout.SOUTH);

        panel.add(jPanelBottom, BorderLayout.SOUTH);
        return panel;
    }


    private void extractedPanelOverview(JPanel panelOverview, String img, String name, String value, String comment) {
        JPanel jPanelLeftOv = new JPanel(new GridLayout(4, 1));
        jPanelLeftOv.setBackground(new Color(220, 210, 202));
        jPanelLeftOv.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        JPanel jPanelLOv1 = new JPanel(new BorderLayout());
        jPanelLOv1.setBackground(null);
        JLabel jLabelLOv1 = new JLabel(resizeImageIcon(img, 48, 48));
        jPanelLOv1.add(jLabelLOv1, BorderLayout.WEST);
        jPanelLeftOv.add(jPanelLOv1);
        JLabel jLabelLOv2 = new JLabel(name);
        jLabelLOv2.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelLeftOv.add(jLabelLOv2);
        JLabel jLabelLOv3 = new JLabel(value);
        jLabelLOv3.setFont(new Font("Arial", Font.BOLD, 24));
        jPanelLeftOv.add(jLabelLOv3);
        JLabel jLabelLOv4 = new JLabel(comment);
        jLabelLOv4.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        jPanelLeftOv.add(jLabelLOv4);
        panelOverview.add(jPanelLeftOv);
    }

    private void actionListener() {
        lblMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(panelMenuClose);
                add(panelMenuOpen, BorderLayout.WEST);
                panelContent.setPreferredSize(new Dimension(sizeWidth - panelMenuOpen.sizeWidth, sizeHeight));
                revalidate();
                repaint();
            }
        });

        lblRepost.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadRepaintPanelContent();
            }
        });

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

        panelMenuOpen.jLabelLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                remove(panelMenuOpen);
                add(panelMenuClose, BorderLayout.WEST);
                panelContent.setPreferredSize(new Dimension((int) (sizeWidth * 0.93), sizeHeight));
                revalidate();
                repaint();
            }
        });

        panelMenuOpen.lblRepost.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadRepaintPanelContent();
            }
        });

        panelMenuOpen.lblLogout.addMouseListener(new MouseAdapter() {
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

    private int getSized() {
        List<User> userList = userService.getAllUsers();

        int count = 0;
        for (User user : userList) {
            if (!user.isEmpty())
                count++;
        }

        return count;
    }

    private void addListMenuFromUi(JPanel jPanel) {
        List<User> userList = userService.getAllUsers().reversed();
        for (int i = 0; i < Math.min(userList.size(), 6); i++) {
            if (!userList.get(i).isEmpty()) {
                CustomUserShow cs = new CustomUserShow(userList.get(i));
                int finalI = i;
                cs.lblEditor.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        loadRepaintPanelContent();
                    }
                });
                cs.lblRemove.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        userService.softDeleteUser(userList.get(finalI).getId());

                        loadRepaintPanelContent();
                    }
                });
                jPanel.add(cs);
            }
        }
        if (userList.size() < 6)
            for (int i = 0; i < 6 - userList.size(); i++) {
                jPanel.add(new CustomUserShow(null));
            }
    }

    private void loadRepaintPanelContent() {
        remove(panelContent);
        panelContent = extractedContentPanel(panelContent);
        add(panelContent, BorderLayout.EAST);

        revalidate();
        repaint();
    }

    private void performLogout() {
        LoginFormUI loginFormUI = new LoginFormUI();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblLogout);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(loginFormUI);
        frame.pack();
        frame.repaint();
    }

    public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
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

