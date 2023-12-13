package project.main.games.snake.view;
import project.main.games.snake.model.Game;
import project.main.games.snake.resource.Settings;

import java.awt.Image;

/**
 * Handle the menu of the game
 *
 */
public class Menu {
	/**
	 * Enum of the different values possible for the menu
	 *
	 */
	public static enum Display {
		CLICKTOPLAY(Settings.Images.CLICKTOPLAY),YOULOOSE(Settings.Images.YOULOOSE), NULL(null);
		public Image value;
		private Display(Settings.Images v) {
			if (v!=null) {
				value = v.value;
			}
			else {
				value=null;
			}
		}
	}
	//Timer of the "You loose" menu
	static final int TIMER_MAX_MENU = 150;
	static int timer = 0;
	
	public static Display menuDisplayed = Display.CLICKTOPLAY;
	
	/**
	 * Handle the event related to the menu (here, it's mainly for the YOULOOSE menu that doesn't stay a long 
	 * time on the screen
	 */
	public static void handleMenu() {
		if (menuDisplayed == Display.YOULOOSE) {
			timer++;
			if (TIMER_MAX_MENU<=timer) {
				timer = 0;
				menuDisplayed = Display.CLICKTOPLAY;
				Game.reinitialisation();
			}
		}
	}
	
}
