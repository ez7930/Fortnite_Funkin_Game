package fortniteFunkin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Background extends GameObject {
	
	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("Background.jpg");
	
	
	public Background(Handler handler){
		super(handler, 300, 100, null);
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.drawImage(IMG, 0, 0, Game.WIDTH, Game.HEIGHT, 0, 0, 640, 480, null);
	}

}
