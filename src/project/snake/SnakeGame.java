package project.snake;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SnakeGame extends JPanel implements Runnable {
    //PRIVATE SETTING
    private final int originalTileSize = 16; // kích thước ảnh
    private final int scale = 3; // Độ phóng đại
    private final int tileSize = originalTileSize * scale; // Thực thể trong game

    public final int maxScreenCol = 16; // Màn hỉnh vs thực thể là 1
    public final int maxScreenRow = 16; // Màn hỉnh vs thực thể là 1
    private final int screenWith = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;
    private long timeGame;

    //THREAD AND FPS
    private Thread gameThread;
    private final double FPS = 1;

    // KEY
    private final KeyHandler keyHandler;

    // ENTITY
    private final BaitEntity baitEntity;
    private final SnakeEntity snakeEntity;
    public EDirectionSnake directionSnake;

    //Random
    private Random random;

    public SnakeGame() {
        this.setPreferredSize(new Dimension(screenWith, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        baitEntity = new BaitEntity(6, 6, 100);
        snakeEntity = new SnakeEntity(maxScreenRow, maxScreenCol);
        directionSnake = EDirectionSnake.UP;

        keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        random = new Random();

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        if (snakeEntity.xSnake[0] == baitEntity.xBait ||
                snakeEntity.ySnake[0] == baitEntity.yBait) {
            baitEntity.spamBait(snakeEntity, random, maxScreenRow, maxScreenCol);
            snakeEntity.thickness++;
        }

        switch (directionSnake) {
            case UP -> snakeEntity.goUp(maxScreenCol);
            case DOWN -> snakeEntity.goDown(maxScreenCol);
            case LEFT -> snakeEntity.goLeft(maxScreenRow);
            case RIGHT -> snakeEntity.goRight(maxScreenRow);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        paintBg(g2);
        baitEntity.drawBait(g2, tileSize);
        snakeEntity.drawSnake(g2, tileSize);

        g2.dispose();
    }

    private void paintBg(Graphics2D g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i < maxScreenRow; i++) {
            for (int j = 0; j < maxScreenCol; j++) {
                g.fillRect(i * tileSize + 1, j * tileSize + 1, tileSize - 2, tileSize - 2);
            }
        }
    }
}
