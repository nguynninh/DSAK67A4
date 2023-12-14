package project.main.ui.register;

import project.main.SettingPanel;
import project.main.ui.loginform.LoginFormUI;
import project.main.user.User;
import project.main.user.UserService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFormUI extends JPanel {
    private final int sizeWidth = SettingPanel.screenWith + 150;
    private final int sizeHeight = SettingPanel.screenHeight;
    private UserService service = UserService.getInstance();

    // Thong tin
    private JTextField textFieldFullname;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JPasswordField retypePasswordField;
    private JTextField textFieldEmail;
    private JCheckBox checkBoxRemember;
    private JButton buttonLogin;
    private JLabel lblQuenPass;
    private JLabel lblLoginAcc;

    // Hoạt động kiểm tra
    private boolean isShowPassword = true;
    private boolean isShowPasswordRetype = true;
    private final boolean[] isCheck = new boolean[5];

    public RegisterFormUI() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setBorder(BorderFactory.createEmptyBorder(60, 40, 60, 40));
        setBackground(Color.GRAY);

        initComponents();

        actionListener();
    }

    // PRIVATE
    private void initComponents() {
        JPanel panelLeft = new JPanel(new CardLayout());
        panelLeft.setPreferredSize(new Dimension(300, panelLeft.getHeight()));
        panelLeft.setBorder(null);
        ImageIcon imageIcon = new ImageIcon(RegisterFormUI.class.getResource("bgRegister.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        panelLeft.add(imageLabel);
        add(panelLeft, BorderLayout.WEST);

        JPanel jPanel1 = new JPanel(new FlowLayout());
        JLabel labelTitle = new JLabel("Đăng ký tài khoản");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitle.setForeground(new Color(-16131626));
        jPanel1.add(labelTitle);

        JPanel jPanel2 = new JPanel(new GridLayout(1, 2, 20, 0));

        JPanel jPanelFullName = new JPanel();
        BoxLayout boxLayout = new BoxLayout(jPanelFullName, BoxLayout.Y_AXIS);
        jPanelFullName.setLayout(boxLayout);

        JPanel jPanelFN = new JPanel(new BorderLayout());
        JLabel labelFullname = new JLabel("Họ tên của bạn");
        labelFullname.setIcon(new ImageIcon(RegisterFormUI.class.getResource("id-card.png")));
        labelFullname.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelFN.add(labelFullname);

        textFieldFullname = new JTextField();
        textFieldFullname.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldFullname.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanelFN.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jPanelFullName.add(jPanelFN, BorderLayout.WEST);
        jPanelFullName.add(textFieldFullname);
        jPanel2.add(jPanelFullName);

        JPanel jPanelUsername = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(jPanelUsername, BoxLayout.Y_AXIS);
        jPanelUsername.setLayout(boxLayout1);

        JPanel jPanelUS = new JPanel(new BorderLayout());
        JLabel labelUsername = new JLabel("Tên tài khoản");
        labelUsername.setIcon(new ImageIcon(RegisterFormUI.class.getResource("user.png")));
        labelUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelUS.add(labelUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldUsername.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanelUS.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jPanelUsername.add(jPanelUS, BorderLayout.WEST);
        jPanelUsername.add(textFieldUsername);
        jPanel2.add(jPanelUsername);

        JPanel jPanel3 = new JPanel(new GridLayout(1, 2, 20, 0));

        JPanel jPanelPassword = new JPanel();
        BoxLayout boxLayout2 = new BoxLayout(jPanelPassword, BoxLayout.Y_AXIS);
        jPanelPassword.setLayout(boxLayout2);

        JPanel jPanelPasswordT = new JPanel(new BorderLayout());
        JLabel labelPassword = new JLabel("Nhập mật khẩu");
        labelPassword.setIcon(new ImageIcon(RegisterFormUI.class.getResource("padlock.png")));
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelPasswordT.add(labelPassword, BorderLayout.WEST);

        JLabel jblShow = new JLabel(new ImageIcon(RegisterFormUI.class.getResource("show.png")));
        jblShow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isShowPassword) {
                    jblShow.setIcon(new ImageIcon(RegisterFormUI.class.getResource("hide.png")));
                    passwordField.setEchoChar((char) 0);
                } else {
                    jblShow.setIcon(new ImageIcon(RegisterFormUI.class.getResource("show.png")));
                    passwordField.setEchoChar('*');
                }
                isShowPassword = !isShowPassword;
            }
        });
        jPanelPasswordT.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanelPasswordT.add(jblShow, BorderLayout.EAST);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanelPassword.add(jPanelPasswordT);
        jPanelPassword.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jPanelPassword.add(passwordField);
        jPanel3.add(jPanelPassword);

        JPanel jPanelRetypePassword = new JPanel();
        BoxLayout boxLayoutRetype2 = new BoxLayout(jPanelRetypePassword, BoxLayout.Y_AXIS);
        jPanelRetypePassword.setLayout(boxLayoutRetype2);

        JPanel jPanelRetypePasswordT = new JPanel(new BorderLayout());
        JLabel labelRetypePassword = new JLabel("Nhập lại MK");
        labelRetypePassword.setIcon(new ImageIcon(RegisterFormUI.class.getResource("padlock.png")));
        labelRetypePassword.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelRetypePasswordT.add(labelRetypePassword, BorderLayout.WEST);

        JLabel jblShowRetype = new JLabel(new ImageIcon(RegisterFormUI.class.getResource("show.png")));
        jblShowRetype.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isShowPasswordRetype) {
                    jblShowRetype.setIcon(new ImageIcon(RegisterFormUI.class.getResource("hide.png")));
                    retypePasswordField.setEchoChar((char) 0);
                } else {
                    jblShowRetype.setIcon(new ImageIcon(RegisterFormUI.class.getResource("show.png")));
                    retypePasswordField.setEchoChar('*');
                }
                isShowPasswordRetype = !isShowPasswordRetype;
            }
        });
        jPanelRetypePasswordT.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanelRetypePasswordT.add(jblShowRetype, BorderLayout.EAST);

        retypePasswordField = new JPasswordField();
        retypePasswordField.setEchoChar('*');
        retypePasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        retypePasswordField.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanelRetypePassword.add(jPanelRetypePasswordT);
        jPanelRetypePassword.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jPanelRetypePassword.add(retypePasswordField);
        jPanel3.add(jPanelRetypePassword);

        JPanel jPanel4 = new JPanel();
        BoxLayout boxLayoutEmail = new BoxLayout(jPanel4, BoxLayout.Y_AXIS);
        jPanel4.setLayout(boxLayoutEmail);

        JPanel jPanelEmail = new JPanel(new BorderLayout());
        JLabel labelEmail = new JLabel("Email / Số điện thoại");
        labelEmail.setIcon(new ImageIcon(LoginFormUI.class.getResource("email.png")));
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        jPanelEmail.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldEmail.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        jPanelEmail.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        jPanel4.add(jPanelEmail, BorderLayout.WEST);
        jPanel4.add(textFieldEmail);

        JPanel jPanel5 = new JPanel(new BorderLayout());

        JPanel jPanel5S = new JPanel(new FlowLayout());
        buttonLogin = new JButton("Đăng ký");
        buttonLogin.setPreferredSize(new Dimension(200, 40));
        buttonLogin.setEnabled(false);
        jPanel5S.add(buttonLogin);
        jPanel5.add(jPanel5S, BorderLayout.SOUTH);

        JPanel jPanel6 = new JPanel(new GridLayout(2, 1, 2, 0));
        jPanel6.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        JPanel jPanel6T = new JPanel(new FlowLayout());
        JLabel jblOr = new JLabel("------- Or -------");
        jPanel6T.add(jblOr);
        jPanel5.add(jPanel6T);

        JPanel jPanel6S = new JPanel(new FlowLayout());
        JLabel lblCA = new JLabel("Bạn đã có tài khoản?");
        lblLoginAcc = new JLabel("Đang nhập ngay ");
        lblLoginAcc.setForeground(Color.BLUE);
        jPanel6S.add(lblCA);
        jPanel6S.add(lblLoginAcc);
        jPanel6.add(jPanel6S);

        JPanel panelRight = new JPanel(new GridLayout(6, 1));
        panelRight.setBorder(BorderFactory.createEmptyBorder(20, 20, -20, 20));

        panelRight.add(jPanel1);
        panelRight.add(jPanel2);
        panelRight.add(jPanel3);
        panelRight.add(jPanel4);
        panelRight.add(jPanel5);
        panelRight.add(jPanel6);

        add(panelRight);


        extractedFullname();
        extractedUsername();
        extractedEmail();
        extractedPassword();
        extractedRetypePassword();
        extractedIsCheck();
    }

    private void actionListener() {
        textFieldFullname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                extractedFullname();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                extractedFullname();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
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

        textFieldEmail.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                extractedEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                extractedEmail();
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
        retypePasswordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                extractedRetypePassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                extractedRetypePassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        buttonLogin.addActionListener(i -> {
            String fullname = textFieldFullname.getText();
            String username = textFieldUsername.getText();
            String email = textFieldEmail.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (service.addUser(new User(
                    fullname,
                    username,
                    password,
                    email
            ))) {
                JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
                LoginFormUI loginFormUi = new LoginFormUI();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblLoginAcc);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(loginFormUi);
                frame.pack();
                frame.repaint();
            }
            else JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        });

        lblLoginAcc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFormUI loginFormUi = new LoginFormUI();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(lblLoginAcc);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(loginFormUi);
                frame.pack();
                frame.repaint();
            }
        });
    }


    private void extractedFullname() {
        String[] text = textFieldFullname.getText().trim().split(" "); // Trim to remove leading and trailing spaces
        if (text.length >= 2) {
            textFieldFullname.setBackground(null);
            isCheck[0] = true;
        } else {
            textFieldFullname.setBackground(new Color(227, 114, 114));
            isCheck[0] = false;
        }

        extractedIsCheck();
    }

    private void extractedUsername() {
        String text = textFieldUsername.getText().trim();
        if (text.matches("[a-zA-Z0-9]{4,}")) {
            textFieldUsername.setBackground(null);
            isCheck[1] = true;
        } else {
            textFieldUsername.setBackground(new Color(227, 114, 114));
            isCheck[1] = false;
        }

        extractedIsCheck();
    }

    private void extractedEmail() {
        String text = textFieldEmail.getText();
        if (isValidEmail(text) || isValidPhoneNumber(text)) {
            textFieldEmail.setBackground(null);
            isCheck[2] = true;
        } else {
            textFieldEmail.setBackground(new Color(227, 114, 114));
            isCheck[2] = false;
        }

        extractedIsCheck();
    }

    private void extractedPassword() {
        if (passwordField.getPassword().length < 1) {
            passwordField.setBackground(new Color(227, 114, 114));
            isCheck[3] = false;
        } else {
            passwordField.setBackground(null);
            isCheck[3] = true;
        }

        extractedIsCheck();
    }

    private void extractedRetypePassword() {
        if (!Arrays.equals(passwordField.getPassword(), retypePasswordField.getPassword()) ||
                retypePasswordField.getPassword().length == 0) {
            retypePasswordField.setBackground(new Color(227, 114, 114));
            isCheck[4] = false;
        } else {
            retypePasswordField.setBackground(null);
            isCheck[4] = true;
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
            JFrame frame = new JFrame("Register Form Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            RegisterFormUI loginFormUi = new RegisterFormUI();
            frame.getContentPane().add(loginFormUi);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

