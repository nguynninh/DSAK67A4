package project.main.games.gamesnake;

import java.awt.*;
import java.util.Random;

public class BaitEntity {
    public int xBait;
    public int yBait;
    public int scores;

    public BaitEntity(int xBait, int yBait, int scores) {
        this.xBait = xBait;
        this.yBait = yBait;
        this.scores = scores;
    }

    public BaitEntity spamBait(SnakeEntity snakeEntities, Random rd, int maxScreenRow, int maxScreenCol) {
        do {
            xBait = rd.nextInt(maxScreenRow);
            yBait = rd.nextInt(maxScreenCol);
        } while (snakeEntities.isSnakeBody(xBait, yBait));

        return this;
    }

    public void drawBait(Graphics2D g2, int tileSize) {
        g2.setColor(Color.YELLOW);
        g2.fillRect(xBait * tileSize + 1, yBait * tileSize + 1, tileSize - 2, tileSize - 2);
    }
}
