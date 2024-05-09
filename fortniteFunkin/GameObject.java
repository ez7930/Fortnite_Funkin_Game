package fortniteFunkin;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public abstract class GameObject {
	
	private Handler handler;
	private int x, y;
	private Rectangle space;
	
	public GameObject(Handler handler, int x, int y, Rectangle space){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.space =space;
	}
	
	public abstract void tick() throws LineUnavailableException, IOException, UnsupportedAudioFileException;
	public abstract void render(Graphics g);

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getSpace() {
		return space;
	}

	public void setSpace(Rectangle space) {
		this.space = space;
	}
	
}
