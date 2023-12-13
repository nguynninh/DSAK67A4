package project.main.games.snake.resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Contains all the resources of the game
 */
public class Settings {
    //Background
    public static final int SIZE_CASE = 30;
    public static final int W = 15;
    public static final int H = 15;
    //Character
    public static final int DECALAGE_PERSO_CASE_X = 2;
    public static final int DECALAGE_PERSO_CASE_Y = SIZE_CASE - 2;
    //Eating event
    public static final int MAX_SIZE_BALLE_DELTA = 10;
    public static final int NON_EATING = 0;
    public static final int BEGIN_EATING = 1;
    public static final int EATING = 2;
    public static final int GROWTH = 30;

    //Apple
    public static final int DECALAGE_X_APPLE = 2;
    public static final int DECALAGE_SHADOW_APPLE = 8;
    public static final int APPLE_SIZE = 35;
    public static final int TIMER_APPLE_ANIMATION = 50;
    public static final int APPLE_INCREASE = 2;

    //Font
    public static Font f;

    //Enum
    public enum Direction {
        NONE(0), LEFT(-1), UP(-1), DOWN(1), RIGHT(1);
        int multiplier;

        private Direction(int mult) {
            multiplier = mult;
        }

        public Direction opposite() {
            switch (this) {
                case LEFT:
                    return RIGHT;
                case RIGHT:
                    return LEFT;
                case UP:
                    return DOWN;
                case DOWN:
                    return UP;
                default:
                    return NONE;
            }
        }

        public int getMultiplier() {
            return multiplier;
        }

        public int horizontalProjection() {
            if (this == UP || this == DOWN) {
                return 0;
            }
            return 1;
        }

        public int verticalProjection() {
            if (this == LEFT || this == RIGHT) {
                return 0;
            }
            return 1;
        }
    }

    public enum Colors {
        BACKGROUND(0xfbed93),
        BACKGROUND_DARKER(0xf5e581),
        MENU(0xc5b762),
        MENU_DARKER(0xb2a45e),
        SNAKE2(0x64f53a),
        SNAKE1(0x5ad04d),
        SNAKEEYEROUND(0x52e332),
        PUPILLE(0x162753),
        NASEAU(0x4bbb28),
        EYELID(0x3b991e),
        SHADOW(0xe6d986),
        TRANSPARENT_SHADOW(new Color(80, 55, 25, 40)),
        FONT(0xfff7c5),
        FONT_DARK(0xac9b4a);;

        public Color value;

        private Colors(int value) {
            this.value = new Color(value);
        }

        private Colors(Color value) {
            this.value = value;
        }
    }

    public enum Transparency {
        LOW(0.2f),
        NO_TRANSPARENCE(1.0f);

        public AlphaComposite value;

        private Transparency(float f) {
            this.value = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, f);
        }
    }

    public enum Images {
        APPLE("apple"), GOLDEN_APPLE("goldenapple"), MENU_APPLE("applemenu"), CLICKTOPLAY("clicktoplay"), YOULOOSE("youloose");
        public Image value;

        private Images(String name) {
            try {
                value = ImageIO.read(new File("src/project/main/games/snake/resource/image/" + name + ".png"));
            } catch (Exception e) {

            }
        }
    }

    /**
     * Generate a font
     */
    public static void genereFont() {
        try {
            f = Font.createFont(Font.PLAIN, Settings.class.getResourceAsStream("/font/zorque.regular.ttf")).deriveFont(20f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
