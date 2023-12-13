package project.main.games.snake.model;

import java.util.List;

/**
 * An abstract physical object
 *
 */
public abstract class Physical {
	//position, velocity and size
	double x,y;
	double vx,vy = 0;
	double width, height;
		
	/**
	 * Constructor
	 * @param _x, the position according to the x axis
	 * @param _y, the position according to the y axis
	 */
	public Physical(double _x, double _y) {
		x=_x;
		y=_y;
	}
	
	/**
	 * Loop handling the event of the object. By default, add the velocity to the position
	 */
	public void loop() {
		x = getX() + vx;
		y = getY() + vy;
	}
	
	/**
	 * Return the position x of the object
	 * @return a double x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Return the position y of the object
	 * @return a double y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Return the width of the object
	 * @return an integer
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Return the height of the object
	 * @return an integer
	 */
	public double getHeight() {
		return height;
	};
	
	/**
	 * Give a different value to the velocity
	 * @param _vx, velocity according to the x axis
	 * @param _vy, velocity according to the y axis
	 */
	public void setSpeed(double _vx, double _vy) {
		vx=_vx;
		vy=_vy;
	}
	
	/**
	 * Remove the object from the game
	 */
	public void remove() {
		Game.remove(this);
	}
	
	/**
	 * Handle the collision between this object and a given list of physical objects
	 * @param objects
	 */
	public abstract void calculCollision(List<Physical> objects);
	
	/**
	 * Action happening when the object encounters the snake
	 * @param arg
	 * @return
	 */
	public int actionCollisionPerso(int arg) {
		return 0;
	}


}