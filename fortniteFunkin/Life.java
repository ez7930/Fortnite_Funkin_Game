package fortniteFunkin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Life extends GameObject {
	
	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("Heart_anterior_exterior_view.png");
	
	
	public Life(Handler handler, int x){
		super(handler, x, 10, null);
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.drawImage(IMG, getX(), getY(), 40, 60, null);
	}

}
