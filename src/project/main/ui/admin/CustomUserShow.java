package project.main.ui.admin;

import project.main.user.User;
import project.main.user.UserService;

import javax.swing.*;
import java.awt.*;

public class CustomUserShow extends JPanel {
    private final int sizeWidth = 610;
    private final int sizeHeight = 55;
    private UserService userService = UserService.getInstance();
    public JLabel lblEditor;
    public JLabel lblRemove;

    public CustomUserShow(User user) {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBackground(new Color(220, 210, 202));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(2, 10, 5, 10)));

        initComponents(user);

        actionListener(user);
    }

    private void initComponents(User user) {
        if (user != null) {
            JPanel jPanelFN = new JPanel(new BorderLayout());
            jPanelFN.setPreferredSize(new Dimension(150, sizeHeight - 10));
            JLabel jLabelFullname = new JLabel(user.getFullname());
            jLabelFullname.setFont(new Font("Arial", Font.PLAIN, 14));
            jLabelFullname.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            jPanelFN.add(jLabelFullname, BorderLayout.WEST);
            add(jPanelFN);

            JPanel jPanelEmail = new JPanel(new BorderLayout());
            jPanelEmail.setPreferredSize(new Dimension(250, sizeHeight - 10));
            JLabel jLabelEmail = new JLabel(user.getEmail().toLowerCase());
            jLabelEmail.setFont(new Font("Arial", Font.PLAIN, 14));
            jPanelEmail.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            jPanelEmail.add(jLabelEmail, BorderLayout.WEST);
            add(jPanelEmail);

            JPanel jPanelSS = new JPanel(new BorderLayout());
            jPanelSS.setPreferredSize(new Dimension(70, sizeHeight - 10));
            JLabel jLabelScores = new JLabel(user.getScores() + "");
            jLabelScores.setFont(new Font("Arial", Font.PLAIN, 14));
            jLabelScores.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
            jPanelSS.add(jLabelScores, BorderLayout.WEST);
            add(jPanelSS);

            JPanel jPanel = new JPanel();
            BoxLayout boxLayout = new BoxLayout(jPanel, BoxLayout.X_AXIS);
            jPanel.setLayout(boxLayout);
            jPanel.setPreferredSize(new Dimension(90, sizeHeight - 10));
            jPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, -30, 0));

            JPanel jPanelEditor = new JPanel(new FlowLayout());
            lblEditor = new JLabel(DashboardFormUI.resizeImageIcon("edit.png", 25, 25));
            jPanelEditor.add(lblEditor);
            jPanel.add(jPanelEditor);

            JPanel jPanelRemove = new JPanel(new FlowLayout());
            lblRemove = new JLabel(DashboardFormUI.resizeImageIcon("remove.png", 25, 25));
            jPanelRemove.add(lblRemove);
            jPanel.add(jPanelRemove);

            add(jPanel);
        }
    }

    private void actionListener(User user) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dashboard Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CustomUserShow dashboardFormUI = new CustomUserShow(new User("Nguyenvanninh2004pt@gmail.com", "123456", "Nguyễn Văn Ninh"));
            frame.getContentPane().add(dashboardFormUI);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
