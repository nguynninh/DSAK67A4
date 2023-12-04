package project.main.games.gamesnake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private SnakeGame snakeGame;

    public KeyHandler(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W)
            snakeGame.directionSnake = EDirectionSnake.UP;
        if (code == KeyEvent.VK_S)
            snakeGame.directionSnake = EDirectionSnake.DOWN;
        if (code == KeyEvent.VK_A)
            snakeGame.directionSnake = EDirectionSnake.LEFT;
        if (code == KeyEvent.VK_D)
            snakeGame.directionSnake = EDirectionSnake.RIGHT;

        if (code == KeyEvent.VK_UP)
            snakeGame.directionSnake = EDirectionSnake.UP;
        if (code == KeyEvent.VK_DOWN)
            snakeGame.directionSnake = EDirectionSnake.DOWN;
        if (code == KeyEvent.VK_LEFT)
            snakeGame.directionSnake = EDirectionSnake.LEFT;
        if (code == KeyEvent.VK_RIGHT)
            snakeGame.directionSnake = EDirectionSnake.RIGHT;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
