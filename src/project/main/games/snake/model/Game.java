package project.main.games.snake.model;

import java.util.LinkedList;
import java.util.List;

import project.main.games.snake.controllers.Controller;
import project.main.games.snake.model.Apple.Type;
import project.main.games.snake.resource.Settings;
import project.main.games.snake.resource.Settings.Direction;
import project.main.games.snake.view.Display;
import project.main.games.snake.view.Menu;

/**
 * The class game handles all the event happening inside the game such as the main loop of the game
 *
 */
public class Game {
	//Controller
	static Controller ctrl = new Controller();
	//Physical objects to remove from the game
	static List<Physical> toRemove = new LinkedList<>();
	//Physical objects to add into the game
	static List<Physical> toAdd = new LinkedList<>();
	//List of the components of the game
	static List<Physical> listComponents = new LinkedList<>();
	//Snake
	public static Player snake;
	//Tells if the game is ended or not
	public static boolean end=false;
	//score
	public static int score = 0;
	
	/**
	 * Main loop of the game. This function is enclenched every 5ms
	 */
	public static void loop() {
		if (!end) {
			//if the game hasn't ended yet, check if the player is trying to move the snake and add (or remove)
			//components into the game
			handleController();
			handleObjects();
		}
		//Handle the event of the different components of the game
		loopObjects();
		//Handle the menu
		Menu.handleMenu();
	}

	/**
	 * Handle the controls of the game (refering to class controller)
	 */
	public static void handleController() {
		if (ctrl.getStatePressed(Controller.Control.LEFT.value)) {
			snake.move(Direction.LEFT);
		}
		else if (ctrl.getStatePressed(Controller.Control.UP.value)) {
			snake.move(Direction.UP);
		}
		else if (ctrl.getStatePressed(Controller.Control.RIGHT.value)) {
			snake.move(Direction.RIGHT);
		}
		else if (ctrl.getStatePressed(Controller.Control.DOWN.value)) {
			snake.move(Direction.DOWN);
		}
	}
	
	/**
	 * Handle all the adding/removing event of the game
	 */
	public static void handleObjects() {
		for (Physical d : toRemove) {
			listComponents.remove(d);
		}
		toRemove.clear();
		for (Physical d : toAdd) {
			listComponents.add(d);
		}
		toAdd.clear();
	}
	
	/**
	 * Handle all the events of the components of the game (such as colliding)
	 */
	public static void loopObjects() {
		for (Physical d : listComponents) {
			d.calculCollision(listComponents);	
			d.loop();
		}
	}
	
	/**
	 * Reinitialisation of the game
	 */
	public static void reinitialisation() {
		//stop the game
		end=true;
		//Removing all the components
		listComponents.clear();
		//We clear the screen
		Display.clear();
		//Instantiation of a new game
		score=0;
		snake = new Player(120+Settings.DECALAGE_PERSO_CASE_X+Player.SIZE/2,60+Settings.DECALAGE_PERSO_CASE_Y-Player.SIZE/2);
		Apple pomme1 = new Apple(5,5, Apple.Type.NORMAL);
		add(snake);
		add(pomme1);
	}
	
	/**
	 * Remove a physical object from the game
	 * @param d, a physical object
	 */
	public static void remove(Physical d) {
		toRemove.add(d);
		//to also remove from the screen
		Display.remove(d);
	}
	
	/**Add a physical object into the game
	 * @param d
	 */
	public static void add(Physical d) {
		toAdd.add(d);
		//to add into the screen
		Display.add(d);
	}
	
	/**
	 * Add a physical object into the game at a specified index
	 * @param d
	 * @param index
	 */
	public static void add(Physical d,int index) {
		listComponents.add(index,d);
		Display.add(d);
	}
	
	/**
	 * Switch the state of the menu to loose state
	 */
	public static void beginLooseState() {
		Menu.menuDisplayed=Menu.Display.YOULOOSE;
	}
	
	/**
	 * Generation of a new apple at a random position of the screen
	 */
	public static void genereApple() {
		int casex = (int)(Settings.W*Math.random());
		int casey = (int)(((Settings.H-1)*Math.random())) + 1;
		
		Apple p = new Apple(casex,casey,Math.random()>=0.1?Type.NORMAL:Type.GOLDEN);
		
		Game.add(p,0);
	}	
	
	/**
	 * Return the list of the physical objects of the game
	 * @return A List<Physical> object
	 */
	public static List<Physical> getListePhysical() {
		return listComponents;
	}
	
	/**
	 * Return the controller of the game
	 * @return A Controller object
	 */
	public static Controller getController() {
		return ctrl;
	}
	
}
