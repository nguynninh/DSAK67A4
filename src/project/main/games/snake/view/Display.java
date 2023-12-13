package project.main.games.snake.view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;

import project.main.games.snake.model.Apple;
import project.main.games.snake.model.Physical;
import project.main.games.snake.model.Player;
import project.main.games.snake.resource.Settings;

/**
 * An object displayable into the screen
 */
public class Display {
    //Hashmap linking the display object to their physical reference
    static HashMap<Physical, Display> displayableMap = new HashMap<>();

    //reference of the object
    Physical reference;
    //displayable used to draw the object
    Displayable display;
    //Animated used to animate the object
    Animated animation = () -> {
    };

    //Animation related variables
    int timerAnim;
    int timer = 0;
    int delta = 2;

    //FOR THE EATING ANIMATION OF THE SNAKE
    int animEat = -1;
    int speedAnimEat = 5;
    double speedEating;

    //Position and size
    double x, y;
    int w, h;

    /**
     * Constructor
     *
     * @param _ref
     * @param _display
     * @param anim
     * @param _timerAnim
     * @param _x
     * @param _y
     * @param _w
     * @param _h
     */
    public Display(Physical _ref, Displayable _display, Animated anim, int _timerAnim, int _x, int _y, int _w, int _h) {
        reference = _ref;
        display = _display;
        animation = anim;
        timerAnim = _timerAnim;
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }

    /**
     * Constructor
     *
     * @param _ref
     * @param _display
     * @param anim
     * @param _timerAnim
     */
    public Display(Physical _ref, Displayable _display, Animated anim, int _timerAnim) {
        reference = _ref;
        display = _display;
        animation = anim;
        timerAnim = _timerAnim;
    }

    /**
     * Constructor
     *
     * @param _ref
     * @param _display
     */
    public Display(Physical _ref, Displayable _display) {
        reference = _ref;
        display = _display;
        w = (int) _ref.getWidth();
        h = (int) _ref.getHeight();
    }

    /**
     * Animation loop of the object
     */
    public void animationLoop() {
        animation.handleAnimation();
    }

    /**
     * Change the displayable used to display the object
     *
     * @param d
     */
    public void setDisplayable(Displayable d) {
        this.display = d;
    }

    /**
     * Change the animated object used to display the object
     *
     * @param a
     */
    public void setAnimation(Animated a) {
        this.animation = a;
    }

    /**
     * Display the object
     *
     * @param g
     */
    public void display(Graphics2D g) {
        display.display(g);
    }

    /**
     * Add a display object into the displayable's list object of the game
     *
     * @param p
     */
    public static void add(Physical p) {
        Display d = createDisplayCopy(p);
        displayableMap.put(p, d);
    }

    /**
     * Remove a display object from the displayable list object of the game
     *
     * @param p
     */
    public static void remove(Physical p) {
        displayableMap.remove(p);
    }

    /**
     * Create a displayable object from a Physical object reference
     *
     * @param p
     * @return
     */
    public static Display createDisplayCopy(Physical p) {
        if (p.getClass() == Apple.class) {
            //Display of an apple object

            //We choose which image we want to display
            final Image img;
            switch (((Apple) p).getType()) {
                case NORMAL:
                    img = Settings.Images.APPLE.value;
                    break;
                case GOLDEN:
                    img = Settings.Images.GOLDEN_APPLE.value;
                    break;
                default:
                    img = null;
            }

            final Display d = new Display(p, (g) -> {
            }, () -> {
            }, Settings.TIMER_APPLE_ANIMATION, (int) p.getX(), (int) p.getY(), Settings.APPLE_SIZE, Settings.APPLE_SIZE);
            //We draw a shadow and then the image of the apple
            d.setDisplayable((g) -> {
                g.setColor(Settings.Colors.TRANSPARENT_SHADOW.value);
                g.fillOval((int) p.getX() + Settings.DECALAGE_X_APPLE + Settings.DECALAGE_SHADOW_APPLE, (int) p.getY() + Settings.DECALAGE_SHADOW_APPLE, (int) p.getWidth() / 2, (int) p.getHeight() / 2);
                g.drawImage(img, (int) d.x + Settings.DECALAGE_X_APPLE, (int) d.y, d.w, d.h, null);
            });
            //We set the animation (the apple gets bigger and then smaller)
            d.setAnimation(() -> {
                d.timer++;
                if (d.timer >= d.timerAnim) {
                    d.timer = 0;
                    d.delta *= -1;
                }
                if (d.timer % (d.timerAnim / Settings.APPLE_INCREASE) == 0) {
                    d.w = d.w + d.delta;
                    d.h = d.h + d.delta;
                    d.x = d.x - d.delta / 2;
                    d.y = d.y - d.delta / 2;
                }
            });
            return d;
        } else if (p.getClass() == Player.class) {
            final Player snake = (Player) p;
            final Display d = new Display(p, (g) -> {
            }, () -> {
            }, Settings.TIMER_APPLE_ANIMATION, (int) p.getX(), (int) p.getY(), Settings.APPLE_SIZE, Settings.APPLE_SIZE);
            Animated anim = () -> {
                switch (snake.getEatingState()) {
                    case Settings.BEGIN_EATING:
                        d.setAnimEat(10);
                        d.speedEating = (double) Settings.MAX_SIZE_BALLE_DELTA / (snake.getLength() * snake.getLength() / 4);
                        d.speedAnimEat = snake.getLength() / 80 == 0 ? 1 : (snake.getLength() / 80 >= 4 ? 4 : snake.getLength() / 80);
                        snake.setEatingState(Settings.EATING);
                        break;
                    case Settings.EATING:
                        d.animEat = (d.animEat + d.speedAnimEat);
                        if (d.animEat >= snake.getLength()) {
                            snake.growth(Settings.GROWTH);
                            snake.setEatingState(Settings.NON_EATING);
                            d.animEat = -1;
                        }
                        break;

                }
            };
            //The displaying of the snake requires the use of a lot of functions, so all is handled in an other class DisplaySnakeMethod
            Displayable dsnake = (g) -> {
                DisplaySnakeMethod.display(g, snake.getLastPositionX(), snake.getLastPositionY(), snake.getLength(), snake.getListLength(), d.animEat, snake.isDead(), d.speedEating);
            };
            d.setDisplayable(dsnake);
            d.setAnimation(anim);
            return d;
        }

        return null;
    }

    //SNAKE ANIMATION
    public void setAnimEat(int value) {
        animEat = value;
    }

    public void setSpeedEating(double value) {
        speedEating = value;
    }

    /**
     * Remove all the physical objects
     */
    public static void clear() {
        displayableMap = new HashMap<>();
    }
}
