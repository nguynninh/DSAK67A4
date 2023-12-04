package project.main.games.sukudo.ui;

import project.main.games.sukudo.logic.SudokuSolver;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuUI extends JFrame {
    public int[][] sudoku;
    private JButton[] buttons;
    private JTextField[][] sudokuCells;

    //Entity
    private SudokuSolver solver;

    public SudokuUI() {
        setTitle("Sudoku UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(840, 600);
//        sudoku = new int[9][9];
        sudoku = new int[][]{
                {0, 0, 0, 6, 0, 0, 4, 0, 0},
                {7, 0, 0, 0, 0, 3, 6, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 1, 8, 0, 0, 0, 3},
                {0, 0, 0, 3, 0, 6, 0, 4, 5},
                {0, 4, 0, 2, 0, 0, 0, 6, 0},
                {9, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 1, 0, 0}
        };
        solver = new SudokuSolver();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 0, 60));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 10));
        buttons = new JButton[5];
        String[] option = new String[]{"Undo", "Easy", "Medium", "Hard", "Custom"};
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton(option[i]);
            buttons[i].setPreferredSize(new Dimension(100, 30));
            buttonPanel.add(buttons[i]);
        }
        add(buttonPanel, BorderLayout.EAST);

        JPanel sudokuPanel = new JPanel();
        sudokuPanel.setLayout(new GridLayout(3, 3, 5, 5));
        sudokuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        sudokuCells = new JTextField[9][9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                JPanel groupPanel = new JPanel();
                groupPanel.setLayout(new GridLayout(3, 3, 2, 2));
                for (int i = row * 3; i < (row + 1) * 3; i++) {
                    for (int j = col * 3; j < (col + 1) * 3; j++) {
                        String text = String.valueOf(sudoku[i][j] != 0 ? sudoku[i][j] : "");
                        sudokuCells[i][j] = new JTextField(text);
                        sudokuCells[i][j].setFont(new Font("Aria", Font.BOLD, 60));
                        sudokuCells[i][j].setHorizontalAlignment(JTextField.CENTER);
                        final int finalI = i, finalJ = j;
                        sudokuCells[i][j].getDocument().addDocumentListener(new DocumentListener() {
                            @Override
                            public void insertUpdate(DocumentEvent e) {
                                String userInput = sudokuCells[finalI][finalJ].getText();
                                try {
                                    int number = Integer.parseInt(userInput);
                                    System.out.println("Người dùng đã nhập số: " + number);

                                    if (number >= 1  && number <= 9)
                                        changedUpdate(e);
                                } catch (NumberFormatException ex) {
                                    // Xử lý nếu đầu vào không phải là số
                                    System.out.println("Người dùng nhập không phải là số.");
                                    changedUpdate(e);
                                }
                            }

                            @Override
                            public void removeUpdate(DocumentEvent e) {

                            }

                            @Override
                            public void changedUpdate(DocumentEvent e) {

                            }
                        });
                        if (!text.isEmpty())
                            sudokuCells[i][j].setEnabled(false);

                        groupPanel.add(sudokuCells[i][j]);
                    }
                }

                sudokuPanel.add(groupPanel);
            }
        }
        add(sudokuPanel, BorderLayout.CENTER);

        JButton solveButton = new JButton("Solve Sudoku");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm mã giải Sudoku ở đây nếu cần
                if (solver.solve(sudoku)) {
                    JOptionPane.showMessageDialog(SudokuUI.this, "Đã giải thành công");

                    for (int i = 0; i < 9; i++)
                        for (int j = 0; j < 9; j++)
                            sudokuCells[i][j].setText(String.valueOf(sudoku[i][j]));

                } else
                    JOptionPane.showMessageDialog(SudokuUI.this, "Xin lỗi tôi không thể giải");
            }
        });
        add(solveButton, BorderLayout.SOUTH);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SudokuUI();
            }
        });
    }
}
