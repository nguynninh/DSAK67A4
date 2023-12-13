package project.main.games.snake.controllers;

import project.main.games.snake.model.Game;
import project.main.games.snake.view.Menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * This class handles the way the player controls the game
 *
 */
public class Controller implements KeyListener {
	public enum Control {
		LEFT(37),UP(38),RIGHT(39),DOWN(40);
		public final int value;
		private Control(int val) {
			value = val;
		}
	}
	HashMap<Integer, Boolean> keyPressed = new HashMap<>();

	/**
	 * Constructor
	 */
	public Controller() {
		for (int i = 37;i<41;i++) {
			keyPressed.put(i, false);
		}
	}
	
	/**
	 * Change the press state of a key
	 * @param key, a number representing a key
	 * @param pressed, the value
	 */
	public void setPressState(int key, boolean pressed) {
		if (keyPressed.containsKey(key))
		keyPressed.put(key, pressed);
	}
	
	/**
	 * Return the state of the key
	 * @param key, a number representing a key
	 * @return a boolean telling if the key is currently pressed or not
	 */
	public boolean getStatePressed(int key) {
		return keyPressed.get(key);
	}

	/**
	 * Key pressed event
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (Menu.menuDisplayed == Menu.Display.CLICKTOPLAY) {
			Game.end = false;
			Menu.menuDisplayed = Menu.Display.NULL;
		}
		setPressState(e.getKeyCode(), true);
	}

	/**
	 * Key released event
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		setPressState(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
