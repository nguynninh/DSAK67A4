package project.main.games.snake.resource;

import project.main.games.snake.resource.Settings.Direction;

import java.awt.*;

/**
 * Calcul class of the game
 *
 */
public class Calculs {
	/**
	 * Create a value according to a direction and an axis. For example, if we add the value delta in the direction RIGHT,
	 * to something that is in the direction HORIZONTAL (so LEFT or RIGHT), we will get value + delta.
	 * If the direction was VERTICAL, we would just get value, and if the adding direction was LEFT, we would get value-delta.
	 * This function is used to diminuate the number of lines of the program
	 * @param d, the direction
	 * @param sens, the direction in the sens horizontal or vertical
	 * @param value
	 * @param delta, the number we want to add to the value according to a certain direction
	 * @return
	 */
	public static int addByDirection(Settings.Direction d, Direction sens, int value, int delta) {
		if (d==sens || d==sens.opposite() ) {
			switch (d) {
			case LEFT :
			case UP :
				return value - delta;
			case RIGHT :
			case DOWN :
				return value + delta;
			default :
				return value;
			}
		}
		return value;
	}
	
	/**
	 * Create a value according to a direction. mx and my are used to tell if the orientation has a sense (so if LEFT and
	 * RIGHT for example are considered as the same thing or not). 
	 * @param d
	 * @param x1
	 * @param deltaX
	 * @param deltaY
	 * @param mx, an integer equals to -1 or 1
	 * @param my, an integer equals to -1 or 1
	 * @return
	 */
	public static double addByDirection(Direction d, double value, int deltaX, int deltaY, int mx, int my) {
		switch (d) {
		case LEFT :
			return value + mx*deltaX;
		case UP :
			return value + my*deltaY;
		case RIGHT :
			return value + deltaX;
		case DOWN :
			return value + deltaY;
		default :
			return value;
		}
	}
	
	/**
	 * Calculate a color from a gradient according to a position into a segment
	 * @param length
	 * @param part
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Color calculColorGradient(int length, int part, Color c1, Color c2) {
		int r1 = c1.getRed();
		int b1 = c1.getBlue();
		int v1 = c1.getGreen();
		int r2 = c2.getRed();
		int b2 = c2.getBlue();
		int v2 = c2.getGreen();
		int nr = (int)(r1 + ((double)part/(double)length)*(r2-r1));
		int nb = (int)(b1 + ((double)part/(double)length)*(b2-b1));
		int nv = (int)(v1 + ((double)part/(double)length)*(v2-v1));
		return new Color(nr,nv,nb);
	}
	
	/**
	 * Check if two points are located on the same case of the grid
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static boolean calculCollision(int x1, int y1, int x2, int y2) {
		int nx1 = (int)x1/Settings.SIZE_CASE;
		int nx2 = (int)x2/Settings.SIZE_CASE;
		int ny1 = (int)y1/Settings.SIZE_CASE;
		int ny2 = (int)y2/Settings.SIZE_CASE;
		
		if (nx1 == nx2 && ny1 == ny2) {
			return true;
		}
		return false;
	}
	
	/**
	 * Tells if the points is located on a case belonging to the segment formed by the two other cases
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return
	 */
	public static boolean calculCollision(int x1, int y1, int x2, int y2, int x3, int y3) {
		int nx1 = (int)x1/Settings.SIZE_CASE;		
		int ny1 = (int)y1/Settings.SIZE_CASE;
		
		int nx2 = (int)x2/Settings.SIZE_CASE;		
		int ny2 = (int)y2/Settings.SIZE_CASE;
		int nx3 = (int)x3/Settings.SIZE_CASE;		
		int ny3 = (int)y3/Settings.SIZE_CASE;

		if ((nx1 == nx2 && (ny1 <= ny2 && ny3<=ny1)) || (nx1 == nx2 && (ny1 >= ny2 && ny3>=ny1))) {
			return true;
		}
		if ((ny1 == ny2 && (nx1 <= nx2 && nx3<=nx1)) || (ny1 == ny2 && (nx1 >= nx2 && nx3>=nx1))) {
			return true;
		}
		
		return false;
	}
}
