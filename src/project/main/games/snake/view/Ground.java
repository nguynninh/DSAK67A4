package project.main.games.snake.view;

import project.main.games.snake.resource.Settings;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Handle all the visual event related to the ground
 *
 */
public class Ground {
	//timer used for the shaking event
	public static final int TIMER_SHAKING = 40;
	public static int timer = 1;
	//image of the background
	public static BufferedImage imgTerrain;
	//direction
	public static Settings.Direction direction_shaking = Settings.Direction.UP;
	//deplacement of the background when the ground is shaking
	static double step = 1;
	//position of the background
	public static double decalage_shaking_x = 0;
	public static double decalage_shaking_y = 0;
	
	/**
	 * Generation of the background
	 * @param size_case, the size of a case of the screen
	 * @param w, the number of case according to the x axis
	 * @param h, the number of case according to the y axis
	 */
	public static void generateTerrain(int size_case, int w, int h) {
		imgTerrain = new BufferedImage(size_case*w, size_case*h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D)imgTerrain.getGraphics();
		
		g.setColor(Settings.Colors.BACKGROUND.value);
		g.fillRect(0, 0, w*size_case, h*size_case);
		for (int i = 0; i<w; i++) {
			for (int j = 0; j<h; j++) {
				if ((i+j)%2==0) {
					g.setColor(Settings.Colors.BACKGROUND_DARKER.value);
					g.fillRect(i*size_case, j*size_case, size_case, size_case);	
				}
			}
		}
	}
	
	/**
	 * Initiate the shaking
	 * @param direction, the direction of the shaking
	 */
	public static void begin_shaking(Settings.Direction direction) {
		timer=1;
		direction_shaking = direction;
	}
	
	/**
	 * Make the ground shake
	 */
	public static void shake() {
		//if timer==0, it means that the snake hasn't encounter the wall yet. Otherwise, the ground must be shaking
		if (timer!=0) {
			timer++;
			//we change the position of the background according to the direction of the shaking
			decalage_shaking_x += direction_shaking.horizontalProjection()*step;
			decalage_shaking_y += direction_shaking.verticalProjection()*step;
			//inverse the step every 10 times
			if (timer%10 == 0) {
				step*=-1.0;
			}
			//end the shaking event, reinitialize the position
			if (timer>=TIMER_SHAKING) {
				timer=0;
				decalage_shaking_x = 0;
				decalage_shaking_y = 0;
			}
		}
	}
	
}
