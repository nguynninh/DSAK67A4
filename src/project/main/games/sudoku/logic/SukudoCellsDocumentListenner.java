package project.main.games.sudoku.logic;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SukudoCellsDocumentListenner implements DocumentListener {
    private JTextField[][] sudokuCells;
    private int i;
    private int j;

    public SukudoCellsDocumentListenner(JTextField[][] sudokuCells, int i, int j) {
        this.sudokuCells = sudokuCells;
        this.i = i;
        this.j = j;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        String userInput = sudokuCells[i][j].getText();
        try {
            int number = Integer.parseInt(userInput);
            System.out.println("Người dùng đã nhập số: " + number);

            boolean value = isValid(sudokuCells, i, j);

            if (number >= 1 && number <= 9)
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

    public boolean isValid(JTextField[][] sudokuCells, final int row, final int col) {
        // Kiểm tra hàng
        for (int i = 0; i < 9; i++) {
            if (sudokuCells[row][i].getText().equals(sudokuCells[row][col].getText()) && i != col ) {
                sudokuCells[row][i].setBackground(Color.RED);
                sudokuCells[row][col].setBackground(Color.BLUE);
            } else {
                sudokuCells[row][i].setBackground(Color.WHITE);
                sudokuCells[row][col].setBackground(Color.WHITE);
            }
        }

        // Kiểm tra cột
        for (int i = 0; i < 9; i++) {
            if (sudokuCells[i][col].getText().equals(sudokuCells[row][col].getText()) && i != row) {
                sudokuCells[i][col].setBackground(Color.RED);
                sudokuCells[row][col].setBackground(Color.BLUE);
            } else {
                sudokuCells[i][col].setBackground(Color.WHITE);
                sudokuCells[row][col].setBackground(Color.WHITE);
            }
        }

        // Kiểm tra ô 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudokuCells[startRow + i][startCol + j].getText().equals(sudokuCells[row][col].getText())) {
                    sudokuCells[startRow + i][startCol + j].setBackground(Color.RED);
                    sudokuCells[row][col].setBackground(Color.BLUE);
                }else {
                    sudokuCells[startRow + i][startCol + j].setBackground(Color.WHITE);
                    sudokuCells[row][col].setBackground(Color.WHITE);
                }
            }
        }

        return true; // Nếu không có giá trị trùng, trả về true
    }
}
