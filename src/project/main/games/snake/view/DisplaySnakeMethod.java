package project.main.games.snake.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.util.LinkedList;

import project.main.games.snake.model.Player;
import project.main.games.snake.model.Player.Length;
import project.main.games.snake.resource.Calculs;
import project.main.games.snake.resource.Settings;
import project.main.games.snake.resource.Settings.Colors;
import project.main.games.snake.resource.Settings.Direction;

/**
 * This class contains all the methods used to display the snake
 *
 */
public class DisplaySnakeMethod {
	static final int SIZE = (int)(20*(Settings.SIZE_CASE/30.0));
	static final int border = (int)(0*(Settings.SIZE_CASE/30.0));
	static final int eyeSize = (int)(8*(Settings.SIZE_CASE/30.0));
	static final int eyeRoundSize = (int)(5*(Settings.SIZE_CASE/30.0));
	static final int pupilSize = (int)(4*(Settings.SIZE_CASE/30.0));
	static final int refletSize = (int)(2*(Settings.SIZE_CASE/30.0));
	static final int directionSize = (int)(3*(Settings.SIZE_CASE/30.0));
	static final int space_eye = (int)(0*(Settings.SIZE_CASE/30.0));
	static final int distance_eye = (int)(5*(Settings.SIZE_CASE/30.0));
	static final int lengthshadow = (int)(6*(Settings.SIZE_CASE/30.0));
	static final double distance_naseau = 3*(Settings.SIZE_CASE/30.0);
	static final int dist2nas = (int)(5*(Settings.SIZE_CASE/30.0));
	static final int distreflecteye = (int)(2*(Settings.SIZE_CASE/30.0));
	
	/**
	 * This function draw the snake into the screen
	 * @param g, Graphics2D
	 * @param tpx, position x of the tail
	 * @param tpy, position y of the tail
	 * @param lengthSnake, total length of the snake
	 * @param listlength, list of the length of the snake
	 * @param animeat, state of the eating animation
	 * @param eyeclosed, tells if the eyes should be closed or not
	 * @param speedEating
	 */
	public static void display(Graphics2D g, int tpx, int tpy, int lengthSnake, LinkedList<Player.Length> listlength, int animeat, boolean eyeclosed, double speedEating) {
		setBrush(g);
		//Firstly, we draw the shadow
		g.setColor(Settings.Colors.SHADOW.value);
		double[] result = drawBody(false,lengthshadow,lengthSnake,tpx,tpy,listlength,g,animeat,eyeclosed, speedEating);
		drawEyeBall(g,(int)result[0],(int)result[2],(int)result[1],(int)result[3], lengthshadow);
		//Now, we draw the snake
		drawBody(true,0,lengthSnake,tpx,tpy,listlength,g,animeat,eyeclosed, speedEating);
		g.setColor(Settings.Colors.SNAKEEYEROUND.value);
		drawEyeBall(g,(int)result[0],(int)result[2],(int)result[1],(int)result[3], 0);
		drawEyes(g,(int)result[0],(int)result[2],(int)result[1],(int)result[3],(int)result[4],(int)result[5],eyeclosed);
	}

	/**
	 * Set the brush
	 * @param g
	 */
	public static void setBrush(Graphics2D g) {
		BasicStroke st2 = (new BasicStroke(SIZE-border*2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		g.setStroke(st2);
	}
	
	/**
	 * Calculate the color of the gradient that should be used to draw the snake
	 * @param action
	 * @param g
	 * @param lpDrawX, position x of the beginning of the last segment
	 * @param lpDrawY, position y of the beginning of the last segment
	 * @param lengthSnake, length of the snake
	 * @param lengthAct, length of the snake already "handled" by the algorithm
	 * @param l, a length component
	 * @param npDrawX, position x of the end of the last segment
	 * @param npDrawY, position y of the end of the last segment
	 */
	public static void changeColor(boolean action, Graphics2D g, int lpDrawX, int lpDrawY, int lengthSnake, int lengthAct, Length l, int npDrawX, int npDrawY) {
		if (action) {
			GradientPaint gp = new GradientPaint(lpDrawX, lpDrawY, Calculs.calculColorGradient(lengthSnake, lengthAct-l.getLength(), Colors.SNAKE1.value, Colors.SNAKE2.value), npDrawX, npDrawY,
					Calculs.calculColorGradient(lengthSnake, lengthAct, Colors.SNAKE1.value, Colors.SNAKE2.value), true);
			g.setPaint(gp);
		}
	}
	
	/**
	 * Draw the body of the snake
	 * @param changeColor tell if the function need to handle the color properties or not
	 * @param lns, width of the shadow
	 * @param lengthSnake, length of the snake
	 * @param tailPositionX, position x of the tail
	 * @param tailPositionY, position y of the tail
	 * @param listLength, list of the length components
	 * @param g, Graphics2D
	 * @param animeat, state of the eating animation
	 * @param eyeclosed, tells if the eyes are closed or not
	 * @param speedEating
	 * @return
	 */
	public static double[] drawBody(boolean changeColor, int lns, int lengthSnake, int tailPositionX, int tailPositionY, LinkedList<Player.Length> listLength, Graphics2D g, int animeat, boolean eyeclosed, double speedEating) {
		int lpDrawX = tailPositionX;
		int lpDrawY =  tailPositionY;
		int npDrawX = tailPositionX;
		int npDrawY =  tailPositionY;

		int lengthAct = 0;
		for (Length l : listLength) {
			//We get the position of the extremities of the segment represented by the length l
			lengthAct+=l.getLength();
			npDrawX = Calculs.addByDirection(l.getDirection(), Direction.LEFT, lpDrawX, l.getLength());
			npDrawY = Calculs.addByDirection(l.getDirection(), Direction.UP, lpDrawY, l.getLength());
			//We change the color if needed
			changeColor(changeColor,g,lpDrawX,lpDrawY,lengthSnake,lengthAct,l,npDrawX,npDrawY);
			//We draw the line
			g.drawLine((int)lpDrawX, (int)lpDrawY+lns, (int)(npDrawX), (int)(npDrawY)+lns);
			//If needed, we display the eating animation
			if (animeat!=-1 && lengthAct-l.getLength()<=lengthSnake-animeat && lengthSnake-animeat<=lengthAct) {
				displayAnimEat(lns, lengthAct,l.getLength(),lengthSnake, lpDrawX, lpDrawY, npDrawX, npDrawY,g,speedEating,animeat);
			}
			//actualise the variables position of lpDraw in order to calculate the position of the extremities of the next segment
			lpDrawX=npDrawX;
			lpDrawY=npDrawY;
		}
		
		//Calcul of values in order to execute the next displaying functions
		Direction d = listLength.get(listLength.size()-1).getDirection();
		double xb=Calculs.addByDirection(d, npDrawX, -distance_eye,-(eyeSize+space_eye),-1,1);
		double yb=Calculs.addByDirection(d, npDrawY, -(eyeSize+space_eye),-distance_eye,1,-1);
		double x2b=Calculs.addByDirection(d, npDrawX, -distance_eye,(eyeSize+space_eye),-1,1);
		double y2b=Calculs.addByDirection(d, npDrawY, (eyeSize+space_eye),-distance_eye,1,-1);
		int dirX = Calculs.addByDirection(d,Direction.LEFT,0,directionSize);
		int dirY = Calculs.addByDirection(d,Direction.UP,0,directionSize);
		
		return new double[] {xb,yb,x2b,y2b,dirX,dirY};

	}

	/**
	 * Draw the eye balls of the snake
	 * @param g, Graphics
	 * @param xb, position x of the center of the first eye
	 * @param x2b, position x of the center of the second eye
	 * @param yb, position y of the center of the first eye
	 * @param y2b, position y of the center of the second eye
	 * @param lns, length of the shadow
	 */
	public static void drawEyeBall(Graphics2D g, int xb, int x2b, int yb, int y2b, int lns) {
		g.fillOval((int)xb-eyeSize,(int)yb-eyeSize+lns,eyeSize*2,eyeSize*2);
		g.fillOval((int)x2b-eyeSize,(int)y2b-eyeSize+lns,eyeSize*2,eyeSize*2);
	}
	
	/**
	 * Draw the eyes of the snake
	 * @param g, Graphics
	 * @param xb, position x of the center of the first eye
	 * @param x2b, position x of the center of the second eye
	 * @param yb, position y of the center of the first eye
	 * @param y2b, position y of the center of the second eye
	 * @param dirX, direction x of the nasels
	 * @param dirY, direction y of the nasels 
	 * @param eyeclosed, tell if the eyes are closed
	 */
	public static void drawEyes(Graphics2D g, int xb, int x2b,int yb, int y2b, int dirX, int dirY, boolean eyeclosed) {
		if (!eyeclosed) {
			g.setColor(Color.white);
			g.fillOval((int)xb-eyeRoundSize,(int)yb-eyeRoundSize,eyeRoundSize*2,eyeRoundSize*2);
			g.fillOval((int)x2b-eyeRoundSize,(int)y2b-eyeRoundSize,eyeRoundSize*2,eyeRoundSize*2);
			g.setColor(Settings.Colors.PUPILLE.value);
			g.fillOval((int)xb+dirX-pupilSize,(int)yb+dirY-pupilSize,pupilSize*2,pupilSize*2);
			g.fillOval((int)x2b+dirX-pupilSize,(int)y2b+dirY-pupilSize,pupilSize*2,pupilSize*2);
			g.setColor(Color.white);
			g.fillOval((int)xb+dirX,(int)yb+dirY-refletSize,refletSize,refletSize);
			g.fillOval((int)x2b+dirX,(int)y2b+dirY-refletSize,refletSize,refletSize);
		}
		else {
			g.setColor(Settings.Colors.EYELID.value);
			g.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
			g.drawLine((int)xb-eyeSize/2, (int)yb-eyeSize/2, (int)xb+eyeSize/2, (int)yb+eyeSize/2);
			g.drawLine((int)xb+eyeSize/2, (int)yb-eyeSize/2, (int)xb-eyeSize/2, (int)yb+eyeSize/2);
			g.drawLine((int)x2b-eyeSize/2, (int)y2b-eyeSize/2, (int)x2b+eyeSize/2, (int)y2b+eyeSize/2);
			g.drawLine((int)x2b+eyeSize/2, (int)y2b-eyeSize/2, (int)x2b-eyeSize/2, (int)y2b+eyeSize/2);
		}
		g.setColor(Settings.Colors.NASEAU.value);
		g.fillOval((int)xb+(int)(dirX*distance_naseau)+(dirY==0?0:dist2nas),(int)yb+(int)(dirY*distance_naseau)+(dirX==0?0:dist2nas),1*2,1*2);
		g.fillOval((int)x2b+(int)(dirX*distance_naseau)+(dirY==0?0:-dist2nas),(int)y2b+(int)(dirY*distance_naseau)+(dirX==0?0:-dist2nas),1*2,1*2);

	}

	/**
	 * 
	 * @param lns, length of the shadow
	 * @param lengthTot, length of the length component
	 * @param lengthAct, number representing the position of the food
	 * @param lengthSnake, length
	 * @param x1, position x of the first extremity of the segment
	 * @param y1, position y of the first extremity of the segment
	 * @param x2, position x of the second extremity of the segment
	 * @param y2, position y of the second extremity of the segment
	 * @param g, Graphics
	 * @param speedEating
	 * @param animeat, state of the animation
	 */
	public static void displayAnimEat(int lns, int lengthTot, int lengthAct, int length, int x1, int y1, int x2, int y2, Graphics2D g, double speedEating, int animeat) {
		int sizeball = SIZE + (int)(animeat*(length-animeat)*speedEating);
		int dy = lns;
		int dx = 0;
		
		if (y1==y2) {
			dy+=-sizeball/2;
		}
		if (x1==x2) {
			dx+=-sizeball/2;
		}		
		
		g.fillOval((int)(x2+(x1-x2)*((double)(lengthTot-(length-animeat))/(double)(lengthAct)))+dx, (int)(y2+(y1-y2)*((double)(lengthTot-(length-animeat))/(double)(lengthAct)))+lns+dy, sizeball, sizeball);
			
	}
}
