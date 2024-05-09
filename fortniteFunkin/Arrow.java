package fortniteFunkin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Arrow extends GameObject {
	
	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("download.png");
	private static int pos = (int)((Game.WIDTH/2-50) * ((int)(Math.random() * 4)/4.0));
	private static int speed = 0;
	private static boolean isAlternating = false;
	private static int brugPos = 0;
	private double spawnCode, sumCode;
	
	
	public Arrow(Handler handler){
		super(handler, pos, Game.HEIGHT, null);
		
		setSpace(new Rectangle(getX(), getY(), 50, 50));
		
		if(!isAlternating) {
			pos = (int)((Game.WIDTH/2-50) * ((int)(Math.random() * 4)/4.0));
		}
		else {
			pos = (int)((Game.WIDTH/2-50)*(brugPos/4.0));
			brugPos++;
			if(brugPos > 3) {
				brugPos = 0;
			}
		}
	}

	@Override
	public void tick() {
		setY(getY() - speed);
		setSpace(new Rectangle(getX(), getY(), 50, 50));
	}

	@Override
	public void render(Graphics g) {
		if(getX() == 0) {
			g.drawImage(IMG, getX(), getY(), getX() + 50, getY() + 50, 
					0, 70, 60, 130, null);
		}
		else if(getX() == (int)((Game.WIDTH/2.0-50) * 0.25)) {
			g.drawImage(IMG, getX(), getY(), getX() + 50, getY() + 50, 
					65, 70, 125, 130, null);
		}
		else if(getX() == (int)((Game.WIDTH/2.0-50) * 0.50)) {
			g.drawImage(IMG, getX(), getY(), getX() + 50, getY() + 50, 
					125, 70, 185, 130, null);
		}
		else if(getX() == (int)((Game.WIDTH/2.0-50) * 0.75)) {
			g.drawImage(IMG, getX(), getY(), getX() + 50, getY() + 50, 
					190, 70, 250, 130, null);
		}
	}
	
	public void adjustSpeed(int s) {
		speed += s;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public double getSpawnCode() {
		return spawnCode;
	}
	
	public double getSumCode() {
		return sumCode;
	}
	
	public void setIsAlternating(boolean b) {
		isAlternating = b;
	}
	
	public void setSpawnCode(double s) {
		spawnCode = s;
	}
	
	public void setSumCode(double s) {
		sumCode = s;
	}
}
