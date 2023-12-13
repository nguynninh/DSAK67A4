package project.main.games.snake.view;

import project.main.games.snake.model.Game;
import project.main.games.snake.resource.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Window of the game
 *
 */
public class Window extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	//difference between the real size of the windows and the screen game
	public static int differenceHeight;
	public static int differenceWidth;
	//Camera of the game
	public static Camera drawing;

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Window f = new Window();
	}
	
	/**
	 * Constructor of the window
	 */
	public Window() {
		//Initialize the window and call the functions for the initialization
		super();
//		Settings.genereFont();
		Ground.generateTerrain(Settings.SIZE_CASE, Settings.W, Settings.H);
		configureCamera();
		getDifferencesDimension();
		setGraphicsWindow();
		setEvenementiel();
		setLocationRelativeTo(null);
		Game.reinitialisation();
		Thread t = new Thread(this);
		t.start();
	}
	
	public void setGraphicsWindow() {
		//This function is used for the graphics of the window
		this.setVisible(true);
		this.setSize(Settings.W*Settings.SIZE_CASE+differenceWidth,Settings.H*Settings.SIZE_CASE+differenceHeight);
		this.setResizable(false);
		this.setTitle("Snake Game");
		Image icon = Toolkit.getDefaultToolkit().getImage("Graphics/icone.png");  
		this.setIconImage(icon);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This function finds the differences between the real size of the window and the size of the screen game
	 */
	public void getDifferencesDimension() {
		//To find the decalage between the real size of the window and the size of the screen
		differenceWidth = getSize().width - drawing.getSize().width;
		differenceHeight = getSize().height - drawing.getSize().height;
	}
	
	/**
	 * Add the event handler to the game
	 */
	public void setEvenementiel() {
		//Creation of the evenementiel (keylistener for the game)
		this.addKeyListener(Game.getController());
	}
	
	/**
	 * Configure the content of the camera
	 */
	public void configureCamera() {
		//Configure the content of the JFrame
		drawing = new Camera();
        this.setContentPane(drawing);
    	setVisible(true);
	}
	
	/**
	 * Begins the loop of the game
	 */
	public void run() {
		while (true) {
			try {
				Game.loop();
				drawing.repaint();
				Thread.sleep(5);
			}
			catch (Exception e) {
				
			}
		}
	}

}