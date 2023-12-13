package project.main.games.snake.model;

import project.main.games.snake.resource.Calculs;
import project.main.games.snake.resource.Settings;
import project.main.games.snake.resource.Settings.Direction;
import project.main.games.snake.resource.Sound;
import project.main.games.snake.view.Ground;

import java.util.LinkedList;
import java.util.List;

/**
 * Physical object representing a snake
 *
 */
public class Player extends Physical {	
	static final int SIZE = (int)(20*(Settings.SIZE_CASE/30.0));
	static final int bonus = 30;
		
	//speed of the snake
	int speedSnake = 1;
	int length = (int)(100*(Settings.SIZE_CASE/30.0));
	
	int eating = Settings.NON_EATING;

	//Position of the head and the tail respectively
	int lastPositionX;
	int lastPositionY;
	int FirstPositionX;
	int FirstPositionY;
	
	boolean removeFirst=false;
	boolean removeLast=false;
	
	//current direction of the snake
	Direction move = Direction.NONE;
	//list of the "members" composing the snake
	LinkedList<Length> listLength =  new LinkedList<>();
	boolean eyeClosed = false;
	
	//end
	static final int TIMER_END = 10;
	int timer_end = 0;
	
	/**
	 * Constructor
	 * @param _x, position x of the snake according to the x axis
	 * @param _y, position y of the snake according to the y axis
	 */
	public Player(double _x, double _y) {
		super(_x, _y);
		lastPositionX = (int)_x;
		lastPositionY = (int)_y;
		FirstPositionX = (int)_x+getLength()+SIZE/2;
		FirstPositionY = (int)_y-SIZE/2;
		listLength.add(new Length(Direction.RIGHT, getLength()));
		// TODO Auto-generated constructor stub
	}

	/**
	 * Make the snake grow when it eats an apple
	 * @param value, the length added to the initial length
	 */
	public void growth(int value) {
		if (!Game.end) {
			lastPositionX = Calculs.addByDirection(listLength.get(0).getDirection(), Direction.LEFT, lastPositionX, -value);
			lastPositionY = Calculs.addByDirection(listLength.get(0).getDirection(), Direction.UP, lastPositionY, -value);
			listLength.get(0).length+=value;
			length = getLength() + value;
		}
	}
	
	/**
	 * Loop handling the event related to the snake
	 */
	@Override 
	public void loop() {
		//Check which variation of the loop we have to use
		if (Game.end) {
			loopEnd();
		}
		else {
			loopNormal();
		}
	}

	/**
	 * End loop of the game
	 */
	public void loopEnd() {
		check_movement();

		//if needed we remove the beginning of the tail (if the movement is ending)
		if (removeFirst==true) {
			listLength.remove(0);
			removeFirst=false;
		}
		if (removeLast==true) {
			listLength.remove(listLength.size()-1);
			removeLast=false;
		}
		
		if (timer_end>=1) {
			timer_end++;
			//make the snake move in its opposing direction
			moveSnake(speedSnake);
			if (timer_end>=TIMER_END) {			
				//the snake is dead, we switch to the "you loose state" of the menu"
				eyeClosed = true;
				Game.beginLooseState();
				timer_end = 0;
				speedSnake=1;
			}
		}

	}

	/**
	 * Usual loop of the game
	 */
	public void loopNormal() {
		//check if the player want to do a movement
		check_movement();
		
		//Remove the last part of the tail if needed
		if (removeFirst==true) {
			listLength.remove(0);
			removeFirst=false;
		}

		moveSnake(speedSnake);
	}
	
	/**
	 * Handle the movement of the "length" components of the snake
	 * @param direction
	 */
	public void coordinate(int direction) {
		//We just have to move the last part and the first part of the snake (the tail and the head) to give
		//the illusion that the snake is moving. If the snake is moving forwards, 
		//the first length (the tail) is becoming smaller and the last length (the head) is becoming 
		//taller.
		
		if (listLength.size()!=1) {
			listLength.get(listLength.size()-1).loop(Length.ADD*direction);
			listLength.get(0).loop(Length.SUB*direction);
		}
	}
	
	/**
	 * Change the value of the position of the head
	 * @param speed
	 */
	public void moveHead(int speed) {
		FirstPositionX = Calculs.addByDirection(listLength.get(listLength.size()-1).getDirection(), Direction.LEFT, FirstPositionX, speed);
		FirstPositionY = Calculs.addByDirection(listLength.get(listLength.size()-1).getDirection(), Direction.UP, FirstPositionY, speed);
	}

	/**
	 * Change the value of the position of the tail
	 * @param speed
	 */
	public void moveTail(int speed) {
		lastPositionX = Calculs.addByDirection(listLength.get(0).getDirection(), Direction.LEFT, lastPositionX, speed);
		lastPositionY = Calculs.addByDirection(listLength.get(0).getDirection(), Direction.UP, lastPositionY, speed);
	}
	
	/**
	 * Move the snake according to its current direction and to its current speed
	 * @param speed, if speed>0, the snake is moving forward in its current direction, otherwise the snake is moving backwards
	 */
	public void moveSnake(int speed) {
		coordinate(speed>0?1:-1);
		moveHead(speed);
		moveTail(speed);
	}
	
	/**
	 * If the player is wanting to move the snake into an other direction, check when it's time to turn the snake in the wanted direction
	 */
	public void check_movement() {
		//we want the snake to be always on the case of the grid, so the position of the head have to always
		//be a multiple of Settings.SIZE_CASE (there is a small decalage to simplify the displaying so it's
		//not exactly a multiple but that's the main idea)
		
		//this boolean tells if the snake can do its movement or not
		boolean go = false;
		switch (move) {
		case LEFT:
		case RIGHT:
			if ((FirstPositionY)%Settings.SIZE_CASE==Settings.DECALAGE_PERSO_CASE_X) {
				go = true;
			}
			break;
		case UP:
		case DOWN:
			if ((FirstPositionX)%Settings.SIZE_CASE==Settings.DECALAGE_PERSO_CASE_Y) {
				go = true;
			}
			break;
		default :
			break;
		}
		if (go) {
			//the snake can do the movement. 
			//we firstly decrease the length of the tail (we simulate the moving of the snake so that the length
			//stays exactly the same)
			
				listLength.get(0).length-=speedSnake;
				moveTail(speedSnake);
				//we add a new length component which will now represent the head
				listLength.add(new Length(move, speedSnake));
				//we move the head
				moveHead(speedSnake);
				//now, there are no more movement to do 
				move=Direction.NONE;
		}

	}
	
	/**
	 * Requesting of a movement by the player
	 * @param direction
	 */
	public void move(Direction direction) {
		//if the player wants the snake to turn to 90�, we change the value of move so that when the player will
		//be exactly on a case, the snake will turn by 90� (see function above)
		if (listLength.get(listLength.size()-1).getDirection() != direction && listLength.get(listLength.size()-1).getDirection()!=direction.opposite()) {
			//we play a sound
			Sound.COLLISION.play();
			move = direction;
		}
	}
	
	/**Handle the collision event between the player and the physical objects of the game
	 */
	@Override
	public void calculCollision(List<Physical> objects) {
		for (Physical d : objects) {
			if (d.getClass()!=Player.class) {
				int centrumFpx = FirstPositionX-SIZE/2;
				int centrumFpy = FirstPositionY+SIZE/2;
				//we check if the head of the player is on the same case than the given object
				if (Calculs.calculCollision(centrumFpx, centrumFpy, (int)(d.x+d.width/2), (int)(d.y+d.height/2))) {
					//action between the snake and the object that is not a snake
					d.actionCollisionPerso(0);
					//ATTENTION 
					//the eating animation begins
					eating = Settings.BEGIN_EATING;
				}
			}
			else {
				collisionSnakeItSelf();
			}
		}

		collisionSnakeWalls();
	}
	
	/**
	 * Collision between the snake and itself
	 */
	public void collisionSnakeItSelf() {
		//we want to check the collision between the snake and its head
		Direction direction = listLength.get(listLength.size()-1).getDirection();
		int centrumFpx = Calculs.addByDirection(direction, Direction.LEFT, FirstPositionX-SIZE/2, SIZE/2);
		int centrumFpy = Calculs.addByDirection(direction, Direction.UP, FirstPositionY+SIZE/2, SIZE/2);
		
		//for each length component of the snake except its head, we check if the case containing the head
		//is contained in the length. If it's so, there is a collision
		
		int lastpX = lastPositionX;
		int lastpY =  lastPositionY;
		int newpX = lastPositionX;
		int newpY =  lastPositionY;
		
		//number of length
		int numtotal = listLength.size()-1;
		//current num checked
		int num = -1;
		
		for (Length l : listLength) {
			num++;
			//gets the coordinates of the border of the length component
			newpX = Calculs.addByDirection(l.getDirection(), Direction.LEFT, lastpX, l.length);
			newpY = Calculs.addByDirection(l.getDirection(), Direction.UP, lastpY, l.length);
		
			//collision between the length segment and the head
			if (Calculs.calculCollision(centrumFpx, centrumFpy, lastpX, lastpY, newpX, newpY) && numtotal-1>num) {
				//the snake collides with itself
				loose();
			}
			//gets the coordinates of the first border in order to calcultate the border of the next segments
			lastpX=newpX;
			lastpY=newpY;
		}
	}
	
	/**
	 * Collision between the snake and the walls
	 */
	public void collisionSnakeWalls() {	
		if (FirstPositionX>=Settings.W*Settings.SIZE_CASE) {
			Ground.begin_shaking(Direction.LEFT);
			loose();
		}
		else if (FirstPositionX<=SIZE) {
			Ground.begin_shaking(Direction.LEFT);
			loose();
		}
		else if (FirstPositionY>=Settings.H*Settings.SIZE_CASE-SIZE) {
			Ground.begin_shaking(Direction.UP);
			loose();
		}
		else if (FirstPositionY<=Settings.SIZE_CASE) {
			Ground.begin_shaking(Direction.DOWN);
			loose();
		}
	}
	
	/**
	 * Enclenched when the snake collides with something
	 */
	public void loose() {
		Game.end = true;
		timer_end=1;
		speedSnake=-1;
		Sound.COLLISIONPAD.play();
	}

	/**
	 * Change the eating state
	 * @param value
	 */
	public void setEatingState(int value) {
		eating = value;
	}
	
	/**
	 * Return the eating state
	 * @return
	 */
	public int getEatingState() {
		return eating;
	}
	
	/**
	 * Return the length of the snake
	 * @return an integer length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Return the list of the length components of the snake
	 * @return a linkedlist<length> 
	 */
	public LinkedList<Length> getListLength() {
		return listLength;
	}
	
	/**
	 * Return the x position of the head
	 * @return an integer
	 */
	public int getLastPositionX() {
		return lastPositionX;
	}

	/**
	 * Return the y position of the head
	 * @return
	 */
	public int getLastPositionY() {
		return lastPositionY;
	}

	/**
	 * Return the x position of the tail
	 * @return
	 */
	public int getFirstPositionX() {
		return FirstPositionX;
	}

	/**
	 * Return the y position of the tail
	 * @return
	 */
	public int getFirstPositionY() {
		return FirstPositionY;
	}

	/**
	 * Return the life state of the snake
	 * @return true if the snake is dead, false otherwise
	 */
	public boolean isDead() {
		return eyeClosed;
	}

	/**
	 * Subclass length, a segment which composes the snake
	 *
	 */
	public class Length {
		//constant which determines if we want to increase/decrease the length
		static final int SUB = -1;
		static final int ADD = 1;
		
		//direction of the segment
	    Direction direction;
	    //length of the segment
		int length;
		
		/**
		 * Constructor of the class
		 * @param _direction, the direction of the length
		 * @param _length, the length of the length
		 */
		public Length(Direction _direction, int _length) {
			direction = _direction;
			length = _length;
		}
		
		/**
		 * Handle the event of the length
		 * @param arg
		 */
		public void loop(int arg) {
			if (arg==SUB) {
				length-=Math.abs(speedSnake);
			}
			else if (arg==ADD) {
				length+=Math.abs(speedSnake);
			}
			//if the length is null, it will be removed. It's always the first length (so the tail)
			//that will be removed
			if (length<=0) {
				if (speedSnake>0) {
					removeFirst=true;
				}
				else {
					//the only moment when the snake is going backwards is when it dies. we want the head to be
					//in the same direction than the one the user wanted the snake to go, so the length of the head part
					//can't be null (otherwise the head would be disconnected from the rest of the body)
					//we don't remove any length in the process
					length=11;
				}
			}
		}

		/**
		 * Return the direction of the length
		 * @return a Direction
		 */
		public Direction getDirection() {
			return direction;
		}
		
		/**
		 * Return the length of the length
		 * @return an integer
		 */
		public int getLength() {
			return length;
		}
	}

}
