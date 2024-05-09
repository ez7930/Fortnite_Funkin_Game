package fortniteFunkin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Jonesy extends GameObject {
	
	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("jonesy.png");
	private static final Image IMG1 = Toolkit.getDefaultToolkit().getImage("jonesyPos1.png");
	private static final Image IMG2 = Toolkit.getDefaultToolkit().getImage("jonesyPos2.png");
	private static final Image IMG3 = Toolkit.getDefaultToolkit().getImage("jonesyPos3.png");
	private static final Image IMG4 = Toolkit.getDefaultToolkit().getImage("jonesyPos4.png");
	private static final Image IMG5 = Toolkit.getDefaultToolkit().getImage("jonesyMistake.png");
	private static int counter = 0;
	
	public Jonesy(Handler handler){
		super(handler, 220, 80, null);
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		if(counter == 0) {
			g.drawImage(IMG, getX(), getY(), getX() + 450, getY() + 600, 
					450, 0, 1600, 1800, null);
		}
		if(counter == 1) {
			g.drawImage(IMG1, getX(), getY(), getX() + 450, getY() + 600, 
					450, 0, 1600, 1800, null);
		}
		if(counter == 2) {
			g.drawImage(IMG2, getX(), getY(), getX() + 450, getY() + 600, 
					450, 0, 1600, 1800, null);
		}
		if(counter == 3) {
			g.drawImage(IMG3, getX(), getY(), getX() + 450, getY() + 600, 
					450, 0, 1600, 1800, null);
		}
		if(counter == 4) {
			g.drawImage(IMG4, getX(), getY(), getX() + 450, getY() + 600, 
					450, 0, 1600, 1800, null);
		}
		if(counter == 5) {
			g.drawImage(IMG5, getX(), getY(), getX() + 450, getY() + 600, 
					450, 0, 1600, 1800, null);
		}
	}
	
	public void nextJonesy() {
		counter++;
		if(counter>4) {
			counter = 1;
		}
	}
	
	public void mistake() {
		counter = 5;
	}

}
