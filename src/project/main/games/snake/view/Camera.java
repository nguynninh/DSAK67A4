package project.main.games.snake.view;


import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import project.main.games.snake.model.Game;
import project.main.games.snake.resource.Settings;
import project.main.games.snake.resource.Settings.Colors;

/**
 * Camera of the game
 */
public class Camera extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Draw the different components into the screen
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		//Handle the shaking event of the ground (which happens if the player encounters a wall)
		Ground.shake();
		//Draw the background
		g2d.drawImage(Ground.imgTerrain, (int)Ground.decalage_shaking_x-Settings.SIZE_CASE,(int)Ground.decalage_shaking_y, null);
		g2d.drawImage(Ground.imgTerrain, Ground.imgTerrain.getWidth() + (int)Ground.decalage_shaking_x -2*Settings.SIZE_CASE,(int)Ground.decalage_shaking_y, null);

		//Draw the display objects
		for (Display d : Display.displayableMap.values()) {
			d.animationLoop();
			d.display(g2d);
		}
		
		//Draw the menu
		g2d.setColor(Colors.MENU.value);
		g2d.fillRect(0,0,Settings.W*Settings.SIZE_CASE, (int)(1*Settings.SIZE_CASE));
		g2d.setColor(Colors.MENU_DARKER.value);
		g2d.fillRect(0,(int)(1*Settings.SIZE_CASE)-2,Settings.W*Settings.SIZE_CASE, 2);
		g2d.setColor(Colors.TRANSPARENT_SHADOW.value);
		g2d.fillRect(0, (int)(1*Settings.SIZE_CASE),Settings.W*Settings.SIZE_CASE, 5);
		g2d.drawImage(Settings.Images.MENU_APPLE.value,(int)2,(int)4,(int)28,(int)22,null);
		g2d.setColor(Settings.Colors.FONT_DARK.value);
		g.setFont(Settings.f);
		g.drawString(String.valueOf(Game.score), 32,23);
		g2d.setColor(Settings.Colors.FONT.value);
		g.drawString(String.valueOf(Game.score), 32,21);
		//Draw the menu message
		g.drawImage(Menu.menuDisplayed.value, 0,0,null);
		
	}

	
}
