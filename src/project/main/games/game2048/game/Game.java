package project.main.games.game2048.game;

import project.main.games.game2048.entity.NumberObject;
import project.main.games.game2048.graphics.Renderer;
import project.main.games.game2048.input.Keyboard;
import project.main.games.game2048.ui.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private GamePanel gamePanel;
    public static List<NumberObject> numbers;
    public static boolean moving = false, hasMoved = true, sthMoving = false;
    public static int dir = 0;
    public static int total = 0;
    private final Random random = new Random();

    public Game(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    public Game() {
        init();
    }

    public void init() {
        numbers = new ArrayList<>();
        moving = false;
        hasMoved = true;
        sthMoving = false;
        spawn();
    }

    public void update() {
        if (Keyboard.keyUp(KeyEvent.VK_R)) {
            init();
        }
        for (NumberObject object : numbers) {
            object.update();
        }
        checkForValueIncrease();
        movingLogic();
        gamePanel.updateTotalLabel();
    }

    public int getTotal() {
        return total;
    }

    private void checkForValueIncrease() {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i == j) continue;
                if (numbers.get(i).x == numbers.get(j).x && numbers.get(i).y == numbers.get(j).y && !numbers.get(i).remove && !numbers.get(j).remove) {
                    numbers.get(j).remove = true;
                    numbers.get(i).value *= 2;
                    total += numbers.get(i).value;
                    numbers.get(i).createSprite();
                }
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).remove) {
                numbers.remove(i);
            }
        }
    }

    private void movingLogic() {
        sthMoving = false;
        for (NumberObject object : numbers) {
            if (object.moving) {
                sthMoving = true;
                break;
            }
        }
        if (!sthMoving) {
            moving = false;
            for (NumberObject object : numbers) {
                object.hasMoved = false;
            }
        }

        if (!moving && hasMoved) {
            spawn();
            hasMoved = false;
        }

        if (!moving && !hasMoved) {
            if (Keyboard.keyDown(KeyEvent.VK_A)) {
                hasMoved = true;
                moving = true;
                dir = 0;
            } else if (Keyboard.keyDown(KeyEvent.VK_D)) {
                hasMoved = true;
                moving = true;
                dir = 1;
            } else if (Keyboard.keyDown(KeyEvent.VK_W)) {
                hasMoved = true;
                moving = true;
                dir = 2;
            } else if (Keyboard.keyDown(KeyEvent.VK_S)) {
                hasMoved = true;
                moving = true;
                dir = 3;
            }
        }
    }

    private void spawn() {
        if (numbers.size() == 16) return;
        boolean available = false;
        int x = 0, y = 0;
        while (!available) {
            x = random.nextInt(4);
            y = random.nextInt(4);
            boolean isAvailable = true;
            for (NumberObject object : numbers) {
                if (object.x / 100 == x && object.y / 100 == y) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) available = true;
        }
        numbers.add(new NumberObject(x * 100, y * 100));
    }

    public void render() {
        Renderer.renderBackground();
        for (NumberObject object : numbers) {
            object.render();
        }

        System.arraycopy(Renderer.pixels, 0, GamePanel.pixels, 0, GamePanel.pixels.length);
    }

    public void renderText(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setFont(new Font("Verdana", Font.PLAIN, 80));
        graphics2D.setColor(Color.BLACK);


        for (NumberObject o : numbers) {
            String s = o.value + "";
            int sw = (int) (graphics2D.getFontMetrics().stringWidth(s) / 2 / GamePanel.scale);
            graphics2D.drawString(s, (int) (o.x + o.width / 2 - sw) * GamePanel.scale, (int) (o.y + o.height / 2 + 18) * GamePanel.scale);
        }
    }

}
