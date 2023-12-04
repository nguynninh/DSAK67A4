package project.main.games.game2048.ui;

import project.main.games.game2048.game.Game;
import project.main.games.game2048.input.Keyboard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class GamePanel extends Canvas implements Runnable {
    public static final int WIDTH = 400, HEIGHT = 400;
    public static float scale = 1.6f;

    public JFrame frame;
    public JLabel label;
    public Thread thread;
    public Keyboard key;
    public Game game;
    public boolean running = false;

    public static BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public void setGame(Game game) {
        this.game = game;
    }

    public GamePanel() {
        setPreferredSize(new Dimension((int) (HEIGHT * scale), (int) (WIDTH * scale)));
        frame = new JFrame();
        game = new Game();
        key = new Keyboard();
        addKeyListener(key);


        label = new JLabel("Total: " + game.getTotal());
        label.setFont(new Font("Verdana", Font.PLAIN, 30));
        label.setForeground(Color.YELLOW);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBackground(Color.PINK);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(this);


        frame.setResizable(false);
        frame.setTitle("Game 2048");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        start();

    }

    public void updateTotalLabel() {
        label.setText("Total: " + game.getTotal());
    }

    public void start() {
        running = true;
        thread = new Thread(this, "loopThread");
        thread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double nanoSecondUpdater = 100000000.0 / 60.0;
        double updateToPerform = 0.0;
        int frames = 0;
        int updates = 0;
        requestFocus();
        while (running) {
            long currentTime = System.nanoTime();
            updateToPerform += (currentTime - lastTime) / nanoSecondUpdater;
            if (updateToPerform >= 1) {
                update();
                updates++;
                updateToPerform--;
            }
            lastTime = currentTime;

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                frame.setTitle("Game 2048: " + updates + " updates, " + frames + " frames");
                updates = 0;
                frames = 0;
                timer += 1000;
            }
        }
    }

    public void update() {
        game.update();
        key.update();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        game.render();

        Graphics2D graphics2D = (Graphics2D) bs.getDrawGraphics();
        graphics2D.drawImage(image,
                0,
                0,
                (int) (HEIGHT * scale),
                (int) (WIDTH * scale),
                null);
        game.renderText(graphics2D);
        graphics2D.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        GamePanel panel = new GamePanel();
        Game game = new Game(panel);
        panel.setGame(game);
    }
}