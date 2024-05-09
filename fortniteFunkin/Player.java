package fortniteFunkin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends GameObject {
	
	private Color color;
	
	public Player(Handler handler){
		super(handler, Game.WIDTH / 2, Game.HEIGHT / 2, null);
		setSpace(new Rectangle(getX(), getY(), 50, 50));
		color = Color.BLUE;
	}
	
	public void tick(){
		if(KeyInput.getKey(KeyEvent.VK_UP))
			setY(getY() - 1);
		if(KeyInput.getKey(KeyEvent.VK_DOWN))
			setY(getY() + 1);
		if(KeyInput.getKey(KeyEvent.VK_LEFT))
			setX(getX() - 1);
		if(KeyInput.getKey(KeyEvent.VK_RIGHT))
			setX(getX() + 1);
		
		Point clicked = MouseInput.getClick();
		if(clicked != null){
			setX((int)clicked.getX());
			setY((int)clicked.getY());
		}
		
		setSpace(new Rectangle(getX(), getY(), 50, 50));
	}
	
	public void render(Graphics g){
		g.setColor(color);
		g.fillRect(getX(), getY(), 50, 50);
	}

}
