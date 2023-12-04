package project.main.games.game2048.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public static boolean[] keys = new boolean[120];

    public static boolean[] lastKeys = new boolean[120];

    public void update() {
        System.arraycopy(keys, 0, lastKeys, 0, keys.length);
    }

    public static boolean keyDown(int key) {
        return keys[key] && !lastKeys[key];
    }

    public static boolean keyUp(int key) {
        return !keys[key] && lastKeys[key];
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
