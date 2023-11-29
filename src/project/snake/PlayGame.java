package project.snake;

import javax.swing.*;

public class PlayGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Snake Game");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame();
        jFrame.add(snakeGame);
        jFrame.pack();

        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
