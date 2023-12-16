package project.main.ui.loginform;

import org.mindrot.bcrypt.BCrypt;
import project.main.ui.client.SettingPanel;
import project.main.ui.admin.DashboardFormUI;
import project.main.ui.forgotpass.ForgotPasswordUI;
import project.main.ui.register.RegisterFormUI;
import project.main.user.UserService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFormUI extends JPanel {
    private final int sizeWidth = SettingPanel.screenWith + 150;
    private final int sizeHeight = SettingPanel.screenHeight;
    private UserService userService = UserService.getInstance();

    // Thong tin
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JCheckBox checkBoxRemember;
    private JButton buttonLogin;
    private JLabel lblQuenPass;
    private JLabel lblCreateAcc;

    // Lưu thông tin
    private Properties userProperties;
    public final String PROPERTIES_FILE_PATH;

    // Hoạt động kiểm tra
    private boolean isShowPassword = true;
    private final boolean[] isCheck = new boolean[2];

    public LoginFormUI() {
        setLayout(new GridLayout(1, 2));
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBorder(BorderFactory.createEmptyBorder(60, 50, 60, 50));
        setBackground(Color.GRAY);

        userProperties = new Properties();
//        URL resourceUrl = LoginFormUI.class.getResource("../database/user.properties");
//        System.out.println(resourceUrl.getPath());
//        PROPERTIES_FILE_PATH = resourceUrl.getPath();
        PROPERTIES_FILE_PATH = "src\\project\\main\\database\\user.properties";
        loadUserProperties();

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
        labelUsername.setIcon(new ImageIcon(LoginFormUI.class.getResource("email.png")));
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelUS.add(labelUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setText(userProperties.getProperty("username"));
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
        labelPassword.setIcon(new ImageIcon(LoginFormUI.class.getResource("padlock.png")));
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanel3T.add(labelPassword, BorderLayout.WEST);

        JLabel jblShow = new JLabel(new ImageIcon(LoginFormUI.class.getResource("show.png")));
        jblShow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isShowPassword) {
                    jblShow.setIcon(new ImageIcon(LoginFormUI.class.getResource("hide.png")));
                    passwordField.setEchoChar((char) 0);
                } else {
                    jblShow.setIcon(new ImageIcon(LoginFormUI.class.getResource("show.png")));
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

        lblQuenPass = new JLabel("Quên mật khẩu?");
        lblQuenPass.setForeground(Color.BLUE);
        jPanel4T.add(lblQuenPass, BorderLayout.EAST);

        JPanel jPanel4S = new JPanel(new FlowLayout());
        buttonLogin = new JButton("Đăng nhập");
        buttonLogin.setPreferredSize(new Dimension(200, 40));
        buttonLogin.setEnabled(false);
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
        lblCreateAcc = new JLabel("Tạo tài khoản");
        lblCreateAcc.setForeground(Color.BLUE);
        jPanel5S.add(lblCA);
        jPanel5S.add(lblCreateAcc);
        jPanel5.add(jPanel5S);

        JPanel panelLeft = new JPanel(new GridLayout(5, 1));
        panelLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        panelLeft.add(jPanel1);
        panelLeft.add(jPanel2);
        panelLeft.add(jPanel3);
        panelLeft.add(jPanel4);
        panelLeft.add(jPanel5);

        add(panelLeft);

        JPanel panelRight = new JPanel(new CardLayout());
        panelRight.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(LoginFormUI.class.getResource("bgLogin.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        panelRight.add(imageLabel);
        add(panelRight);

        extractedUsername();
        extractedPassword();
        extractedIsCheck();
    }

    private void actionListener() {
        textFieldUsername.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                extractedUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                extractedUsername();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                extractedPassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                extractedPassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        buttonLogin.addActionListener(i -> {
            String username = textFieldUsername.getText();
            String password = String.valueOf(passwordField.getPassword());
            boolean saveAccount = checkBoxRemember.isSelected();

            if (userService.loginUser(username, password)) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại", "Lỗi Email\\SDT hoặc Mật khẩu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (userService.getUsers(username).getRoleToInt() > 1) {
                if (saveAccount) saveUserProperties(username, password);

                DashboardFormUI dashboardFormUI = new DashboardFormUI();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(buttonLogin);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(dashboardFormUI);
                frame.pack();
                frame.repaint();
            } else if (userService.getUsers(username).getRoleToInt() == 1) {
                if (saveAccount) saveUserProperties(username, password);

                SettingPanel playStore = new SettingPanel();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(buttonLogin);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(playStore);
                frame.pack();
                frame.repaint();
            } else JOptionPane.showMessageDialog(null, "Tài khoản của bạn đã bị khóa");
        });

        lblQuenPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ForgotPasswordUI forgotPassPanel = new ForgotPasswordUI();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblQuenPass);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(forgotPassPanel);
                frame.pack();
                frame.repaint();
            }
        });

        lblCreateAcc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFormUI registerFormUI = new RegisterFormUI();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblCreateAcc);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(registerFormUI);
                frame.pack();
                frame.repaint();
            }
        });
    }

    private void loadUserProperties() {
        try (InputStream input = new FileInputStream(PROPERTIES_FILE_PATH)) {
            if (input != null) {
                userProperties = new Properties();
                userProperties.load(input);
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveUserProperties(String username, String password) {
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE_PATH)) {
            Properties userProperties = new Properties();
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

            userProperties.setProperty("username", username);
            userProperties.setProperty("password", hashedPassword);

            userProperties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void extractedUsername() {
        String text = textFieldUsername.getText();
        if (isValidEmail(text) || isValidPhoneNumber(text)) {
            textFieldUsername.setBackground(null);
            isCheck[0] = true;
        } else {
            textFieldUsername.setBackground(new Color(227, 114, 114));
            isCheck[0] = false;
        }

        extractedIsCheck();
    }

    private void extractedPassword() {
        if (passwordField.getPassword().length < 1) {
            passwordField.setBackground(new Color(227, 114, 114));
            isCheck[1] = false;
        } else {
            passwordField.setBackground(null);
            isCheck[1] = true;
        }

        extractedIsCheck();
    }

    private void extractedIsCheck() {
        for (boolean is : isCheck)
            if (!is) {
                buttonLogin.setEnabled(false);
                return;
            }
        buttonLogin.setEnabled(true);
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");

        if (digitsOnly.length() == 9 || digitsOnly.length() == 10) {
            if (digitsOnly.length() == 10 && digitsOnly.startsWith("0"))
                digitsOnly = digitsOnly.substring(1);
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LoginFormUI loginFormUi = new LoginFormUI();
            frame.getContentPane().add(loginFormUi);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
