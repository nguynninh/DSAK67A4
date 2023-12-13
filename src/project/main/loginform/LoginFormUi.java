package project.main.loginform;

import org.mindrot.bcrypt.BCrypt;
import project.main.SettingPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFormUi extends JPanel {
    private int sizeWidth = SettingPanel.screenWith + 150;
    private int sizeHeight = SettingPanel.screenHeight;
    private final Font fontTitle = new Font("Aria", Font.BOLD, 20);

    // Thong tin
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JCheckBox checkBoxRemember;
    private JButton buttonLogin;
    private boolean isShowPassword = true;

    public LoginFormUi() {
        setLayout(new GridLayout(1, 2));
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBorder(BorderFactory.createEmptyBorder(60, 50, 60, 50));
        setBackground(Color.GRAY);

        initComponents();

        actionListener();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel(new FlowLayout());
        JLabel labelTitle = new JLabel("Đăng nhập hệ thống");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitle.setForeground(new Color(-16131626));
        jPanel1.add(labelTitle);

        JPanel jPanel2 = new JPanel();
        BoxLayout boxLayout = new BoxLayout(jPanel2, BoxLayout.Y_AXIS);
        jPanel2.setLayout(boxLayout);

        JPanel jPanelUS = new JPanel(new BorderLayout());
        JLabel labelUsername = new JLabel("Username");
        labelUsername.setIcon(new ImageIcon(LoginFormUi.class.getResource("email.png")));
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelUS.add(labelUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldUsername.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanelUS.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jPanel2.add(jPanelUS, BorderLayout.WEST);
        jPanel2.add(textFieldUsername);

        JPanel jPanel3 = new JPanel();
        BoxLayout boxLayout2 = new BoxLayout(jPanel3, BoxLayout.Y_AXIS);
        jPanel3.setLayout(boxLayout2);

        JPanel jPanel3T = new JPanel(new BorderLayout());
        JLabel labelPassword = new JLabel("Password");
        labelPassword.setIcon(new ImageIcon(LoginFormUi.class.getResource("padlock.png")));
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanel3T.add(labelPassword, BorderLayout.WEST);

        JLabel jblShow = new JLabel(new ImageIcon(LoginFormUi.class.getResource("show.png")));
        jblShow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isShowPassword) {
                    jblShow.setIcon(new ImageIcon(LoginFormUi.class.getResource("hide.png")));
                    passwordField.setEchoChar((char) 0);
                } else {
                    jblShow.setIcon(new ImageIcon(LoginFormUi.class.getResource("show.png")));
                    passwordField.setEchoChar('*');
                }
                isShowPassword = !isShowPassword;
            }
        });
        jPanel3T.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel3T.add(jblShow, BorderLayout.EAST);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanel3.add(jPanel3T);
        jPanel3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jPanel3.add(passwordField);

        JPanel jPanel4 = new JPanel(new BorderLayout());

        JPanel jPanel4T = new JPanel(new BorderLayout());
        checkBoxRemember = new JCheckBox("Lưu lại lịch sửa đăng nhập");
        jPanel4T.add(checkBoxRemember, BorderLayout.WEST);

        JLabel lblQuenPass = new JLabel("Quên mật khẩu?");
        lblQuenPass.setForeground(Color.BLUE);
        jPanel4T.add(lblQuenPass, BorderLayout.EAST);

        JPanel jPanel4S = new JPanel(new FlowLayout());
        buttonLogin = new JButton("Đăng nhập");
        buttonLogin.setPreferredSize(new Dimension(200, 40));
        jPanel4S.add(buttonLogin);
        jPanel4.add(jPanel4T, BorderLayout.NORTH);
        jPanel4.add(jPanel4S, BorderLayout.SOUTH);

        JPanel jPanel5 = new JPanel(new GridLayout(2, 1, 2, 0));
        jPanel5.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JPanel jPanel5T = new JPanel(new FlowLayout());
        JLabel jblOr = new JLabel("------- Or -------");
        jPanel5T.add(jblOr);
        jPanel5.add(jPanel5T);

        JPanel jPanel5S = new JPanel(new FlowLayout());
        JLabel lblCA = new JLabel("Bạn chưa có tài khoản?");
        JLabel lblCreateAcc = new JLabel("Tạo tài khoản");
        lblCreateAcc.setForeground(Color.BLUE);
        jPanel5S.add(lblCA);
        jPanel5S.add(lblCreateAcc);
        jPanel5.add(jPanel5S);

        JPanel panelLeft = new JPanel(new GridLayout(6, 1));
        panelLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, -60, 20));

        panelLeft.add(jPanel1);
        panelLeft.add(jPanel2);
        panelLeft.add(jPanel3);
        panelLeft.add(jPanel4);
        panelLeft.add(jPanel5);

        add(panelLeft);

        JPanel panelRight = new JPanel(new CardLayout());
        panelRight.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(LoginFormUi.class.getResource("bgLogin.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        panelRight.add(imageLabel);
        add(panelRight);
    }

    private void actionListener() {
        buttonLogin.addActionListener(i -> {
            String username = textFieldUsername.getText();
            String password = String.valueOf(passwordField.getPassword());
            boolean saveAccount = checkBoxRemember.isSelected();

            System.out.println("Username: " + username);
            System.out.println("Password: " + BCrypt.hashpw(password, BCrypt.gensalt(12)));
            System.out.println("Save Account: "+ saveAccount);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LoginFormUi loginFormUi = new LoginFormUi();
            frame.getContentPane().add(loginFormUi);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
