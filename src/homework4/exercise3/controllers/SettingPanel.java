package homework4.exercise3.controllers;

import homework4.exercise3.entity.BracketValidator;
import homework4.exercise3.logic.Caculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SettingPanel extends JFrame {
    //NAME APP
    private final String nameApp = "Máy tính";

    //SHOW SCREEN
    public final int screenWith = 340;
    public final int screenHeight = 510;


    //THREAD
    private Thread threadMain;

    //Entity
    private JButton option;
    private Label standard;
    private JButton history; // CTRL + H

    private JLabel screen;
    private JLabel screen2;

    private JButton[] keyKeyboard;
    private JButton keyDot;
    private JButton negative;

    private JButton[] keyOption;
    private JButton equalSign;

    private JButton delete;
    private JButton leftBracket;
    private JButton rightBracket;

    private JButton percent;
    private JButton reciprocal;
    private JButton square;
    private JButton sqrt;

    private JButton[] keySave;

    private Dimension sizeKeyboard;
    private Dimension sizeKeySave;
    private Dimension sizeShowScreen;
    private Dimension sizeKeyOption;

    public SettingPanel() {
        this.setName(nameApp);

        declare();

        addControllers();

        addActionListener();
    }

    public void addControllers() {
        JPanel jPanel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);

        jPanel.setLayout(boxlayout);
        jPanel.setBackground(Color.decode("#F2F2F2"));
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        jPanel.add(addKeyOption());

        jPanel.add(addShowScreen());

        jPanel.add(addKeySave());

        jPanel.add(addKeyboard());

        this.add(jPanel);
    }

    public void showWindowns() {
        this.setSize(screenWith, screenHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void declare() {
        sizeShowScreen = new Dimension(screenWith - 10, 80);
        sizeKeyOption = new Dimension(screenWith - 10, 50);

        option = new JButton("≡");
        standard = new Label("Standard");
        history = new JButton("↻");

        screen = new JLabel();
        screen2 = new JLabel();

        // Save
        String[] strSave = {"MC", "MR", "M+", "M-", "MS", "M>"};
        keySave = new JButton[strSave.length];
        sizeKeySave = new Dimension((screenWith - 10) / keySave.length, 20);
        for (int i = 0; i < keySave.length; i++)
            keySave[i] = createCustomButton(strSave[i], Color.decode("#F2F2F2"), sizeKeySave);

        // Number
        keyKeyboard = new JButton[10];
        sizeKeyboard = new Dimension(77, 47);
        for (int i = 0; i < keyKeyboard.length; i++) {
            keyKeyboard[i] = createCustomButton(i + "", Color.WHITE, sizeKeyboard);
        }
        keyDot = createCustomButton(".", Color.WHITE, sizeKeyboard);
        negative = createCustomButton("+/-", Color.WHITE, sizeKeyboard);

        //Option
        String[] strKeyOption = {"+", "-", "x", "÷"};
        keyOption = new JButton[strKeyOption.length];
        for (int i = 0; i < keyOption.length; i++) {
            keyOption[i] = createCustomButton(strKeyOption[i], Color.decode("#F2F6F7"), sizeKeyboard);
        }
        equalSign = createCustomButton("=", Color.decode("#60ACF8"), sizeKeyboard);

        delete = createCustomButton("DEL", Color.decode("#F2F6F7"), sizeKeyboard);
        leftBracket = createCustomButton("(", Color.decode("#F2F6F7"), sizeKeyboard);
        rightBracket = createCustomButton(")", Color.decode("#F2F6F7"), sizeKeyboard);

        percent = createCustomButton("%", Color.decode("#F2F6F7"), sizeKeyboard);
        reciprocal = createCustomButton("1/x", Color.decode("#F2F6F7"), sizeKeyboard);
        square = createCustomButton("x^2", Color.decode("#F2F6F7"), sizeKeyboard);
        sqrt = createCustomButton("x10^x", Color.decode("#F2F6F7"), sizeKeyboard);
    }

    private JPanel addKeyOption() {
        JPanel jpOptions = new JPanel();
        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(1);
        jpOptions.setBorder(null);
        jpOptions.setLayout(layout);
        jpOptions.setPreferredSize(sizeKeyOption);

        option.setBorder(null);
        history.setBorder(null);
        option.setFont(new Font("Arial", Font.BOLD, 22));
        history.setFont(new Font(null, Font.BOLD, 22));
        standard.setFont(new Font("Arial", Font.BOLD, 22));
        option.setBackground(Color.decode("#F2F2F2"));
        history.setBackground(Color.decode("#F2F2F2"));

        JPanel jpLeft = new JPanel();
        FlowLayout layoutLeft = new FlowLayout(FlowLayout.LEFT);
        jpLeft.setBorder(null);
        jpLeft.setLayout(layoutLeft);
        jpLeft.add(option);
        jpLeft.add(standard);
        jpOptions.add(jpLeft);

        JPanel jpRight = new JPanel();
        FlowLayout layoutRight = new FlowLayout(FlowLayout.RIGHT);
        jpRight.setBorder(null);
        jpRight.setLayout(layoutRight);
        jpRight.add(history);
        jpOptions.add(jpRight);

        return jpOptions;
    }


    private JPanel addShowScreen() {
        JPanel jpScreen = new JPanel();
        GridLayout layout = new GridLayout(2, 1);
        layout.setVgap(0);
        layout.setHgap(0);

        jpScreen.setLayout(layout);
        jpScreen.setBackground(Color.WHITE);
        jpScreen.setPreferredSize(sizeShowScreen);

        screen.setHorizontalAlignment(SwingConstants.LEFT);
        screen.setFont(new Font("Arial", Font.BOLD, 20));
        jpScreen.add(screen);

        screen2.setHorizontalAlignment(SwingConstants.RIGHT);
        screen2.setFont(new Font("Arial", Font.BOLD, 30));
        jpScreen.add(screen2);

        return jpScreen;
    }

    private JPanel addKeySave() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(1, keySave.length);

        panel.setLayout(layout);
        panel.setBackground(Color.decode("#F2F2F2"));
        panel.setPreferredSize(new Dimension(screenWith - 10, 20));

        for (JButton btn : keySave)
            panel.add(btn);

        return panel;
    }

    private JPanel addKeyboard() {
        JPanel btnInput = new JPanel();
        GridLayout layout = new GridLayout(6, 4);
        layout.setHgap(3);
        layout.setVgap(3);

        btnInput.setLayout(layout);
        btnInput.setBorder(null);

        btnInput.add(percent);
        btnInput.add(leftBracket);
        btnInput.add(rightBracket);
        btnInput.add(delete);

        btnInput.add(reciprocal);
        btnInput.add(square);
        btnInput.add(sqrt);
        btnInput.add(keyOption[3]);

        btnInput.add(keyKeyboard[7]);
        btnInput.add(keyKeyboard[8]);
        btnInput.add(keyKeyboard[9]);
        btnInput.add(keyOption[2]);

        btnInput.add(keyKeyboard[4]);
        btnInput.add(keyKeyboard[5]);
        btnInput.add(keyKeyboard[6]);
        btnInput.add(keyOption[1]);

        btnInput.add(keyKeyboard[1]);
        btnInput.add(keyKeyboard[2]);
        btnInput.add(keyKeyboard[3]);
        btnInput.add(keyOption[0]);

        btnInput.add(negative);
        btnInput.add(keyKeyboard[0]);
        btnInput.add(keyDot);
        btnInput.add(equalSign);

        return btnInput;
    }

    private JButton createCustomButton(String text, Color backgroundColor, Dimension size) {
        JButton button = new JButton(text);

        button.setBackground(backgroundColor);

        button.setPreferredSize(size);

        button.setBorder(null);

        return button;
    }

    private void addActionListener() {
        for (JButton btn : keyKeyboard) {
            btn.addActionListener(e -> addActionNumber(btn));
        }

        // +
        keyOption[0].addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty()) {
                screen.setText(keyOption[0].getText());
                return;
            }

            String charEnd = String.valueOf(text.charAt(text.length() - 1));
            if ("0123456789%()+-*x/÷".contains(charEnd))
                screen.setText(text + keyOption[0].getText());
        });

        // -
        keyOption[1].addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty()) {
                screen.setText(keyOption[1].getText());
                return;
            }

            String charEnd = String.valueOf(text.charAt(text.length() - 1));
            if ("0123456789%()+-*x/÷".contains(charEnd))
                screen.setText(text + keyOption[1].getText());
        });

        // x
        keyOption[2].addActionListener(e -> {
            String text = screen.getText();

            if (text.isEmpty())
                return;

            String charEnd = String.valueOf(text.charAt(text.length() - 1));
            if ("0123456789%)".contains(charEnd))
                screen.setText(text + keyOption[2].getText());
        });

        // ÷
        keyOption[3].addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty())
                return;

            String charEnd = String.valueOf(text.charAt(text.length() - 1));
            if ("0123456789%)".contains(charEnd))
                screen.setText(text + keyOption[3].getText());
        });

        // %
        percent.addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty())
                return;

            String charEnd = String.valueOf(text.charAt(text.length() - 1));
            if ("0123456789)".contains(charEnd))
                screen.setText(text + percent.getText());
        });

        // .
        keyDot.addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty())
                screen.setText("0.");
            else if ("0123456789".contains(String.valueOf(text.charAt(text.length() - 1))))
                screen.setText(text + ".");
        });

        // ^
        square.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty() && "0123456789)".contains(String.valueOf(text.charAt(text.length() - 1))))
                screen.setText(text + "^2");
        });

        // √ -> 10^x
        sqrt.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty() && "0123456789%)".contains(String.valueOf(text.charAt(text.length() - 1))))
                screen.setText(text + "x10^");
        });

        // 1/x or /x
        reciprocal.addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty())
                screen.setText("1/");
            else if ("0123456789".contains(String.valueOf(text.charAt(text.length() - 1))))
                screen.setText(text + "/");
        });

        delete.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty())
                screen.setText(text.substring(0, text.length() - 1));
        });

        leftBracket.addActionListener(e -> {
            String text = screen.getText();
            if (text.isEmpty() || !".".contains(String.valueOf(text.charAt(text.length() - 1))))
                screen.setText(text + leftBracket.getText());
        });

        rightBracket.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty() && !"^(.".contains(String.valueOf(text.charAt(text.length() - 1))))
                screen.setText(text + rightBracket.getText());
        });

        equalSign.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty() && "0123456789%)".contains(text.charAt(text.length() - 1) + "")) {
                screen.setText(screen.getText() + "=");

                BracketValidator bracket = new BracketValidator();
                bracket.addBracket('(', ')')
                        .addBracket('[', ']')
                        .addBracket('{', '}');
                if (!bracket.isValid(text)){
                    screen2.setText("Lỗi biểu thức!");
                    return;
                }

                Caculator caculator = new Caculator();
                caculator.input(screen.getText());
                caculator.infixToPostfix();
                double number = caculator.calculateValue();
                screen2.setText(
                        ((int) number == number) ?
                                String.valueOf(number).split("\\.")[0] :
                                String.valueOf(number)
                );
            }
        });
    }

    private void addActionNumber(JButton button) {
        String text = screen.getText();
        if (text.isEmpty()) {
            screen.setText(button.getText());
            return;
        }

        String charEnd = String.valueOf(text.charAt(text.length() - 1));
        if (isNumeric(charEnd) || "+-x÷/.^√()%".contains(charEnd)
        )
            screen.setText(text + button.getText());
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private void addActionOperation(JButton button) {
        button.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty() && isNumeric(text.charAt(text.length() - 1) + ""))
                screen.setText(text + button.getText());
        });
    }
}
