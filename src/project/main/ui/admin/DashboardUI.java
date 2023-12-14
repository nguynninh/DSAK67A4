package project.main.ui.admin;

import project.main.user.UserService;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JPanel {
    private final int sizeWidth = 1000;
    private final int sizeHeight = 700;
    private UserService userService = UserService.getInstance();

    public DashboardUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBackground(Color.WHITE);

        initComponents();

        actionListener();
    }

    private void initComponents() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.GREEN);
        leftPanel.setPreferredSize(new Dimension((int) (sizeWidth * 0.2), sizeHeight));
        add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLUE);
        rightPanel.setPreferredSize(new Dimension((int) (sizeWidth * 0.8), sizeHeight));
        add(rightPanel, BorderLayout.EAST);
    }

    private void actionListener() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dashboard Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DashboardUI dashboardUI = new DashboardUI();
            frame.getContentPane().add(dashboardUI);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
