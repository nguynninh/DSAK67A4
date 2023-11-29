package project.snake;

import java.awt.*;

public class SnakeEntity {
    public int[] xSnake;
    public int[] ySnake;
    public int thickness;

    public SnakeEntity(int maxScreenRow, int maxScreenCol) {
        xSnake = new int[maxScreenCol * maxScreenRow];
        ySnake = new int[maxScreenCol * maxScreenRow];
        thickness = 3;

        xSnake[0] = 2;
        ySnake[0] = 3;

        xSnake[1] = 2;
        ySnake[1] = 4;

        xSnake[2] = 2;
        ySnake[2] = 5;
    }

    private void follow() {
        for (int i = thickness - 1; i > 0; i--) {
            xSnake[i] = xSnake[i - 1];
            ySnake[i] = ySnake[i - 1];
        }
    }

    public void goUp(int maxScreenCol) {
        follow();
        ySnake[0]--;

        if (ySnake[0] < 0)
            ySnake[0] = maxScreenCol;
    }

    public void goDown(int maxScreenCol) {
        follow();
        ySnake[0]++;

        if (ySnake[0] > maxScreenCol)
            ySnake[0] = 0;
    }

    public void goLeft(int maxScreenRow) {
        follow();
        xSnake[0]--;

        if (xSnake[0] < 0)
            xSnake[0] = maxScreenRow;
    }

    public void goRight(int maxScreenRow) {
        follow();
        xSnake[0]++;

        if (xSnake[0] > maxScreenRow)
            xSnake[0] = 0;
    }

    public SnakeEntity[] getSnakeBody() {
        SnakeEntity[] snakeEntities = new SnakeEntity[thickness];

        for (int i = 0; i < thickness; i++)
            snakeEntities[i] = new SnakeEntity(xSnake[i], ySnake[i]);

        return snakeEntities;
    }

    public boolean isSnakeBody(int x, int y) {
        for (int i = 0; i < thickness; i++)
            if (xSnake[i] == x && ySnake[i] == y)
                return true;
        return false;
    }

    public void drawSnake(Graphics2D g2, int tileSize) {
        g2.setColor(Color.RED);
        for (int i = 0; i < thickness; i++) {
            g2.fillRect(xSnake[i] * tileSize + 1, ySnake[i] * tileSize + 1, tileSize - 2, tileSize - 2);
        }
    }
}
