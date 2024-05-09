package fortniteFunkin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class GreyArrows extends GameObject {
	
	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("download.png");
	
	
	public GreyArrows(Handler handler){
		super(handler, 0, 0, null);
		setSpace(new Rectangle(getX(), getY(), 300, 55));
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		//Displays the 4 grey arrows
		g.drawImage(IMG, getX(), getY()+12, getX()+50, getY()+62, 0, 5, 60, 70, null);
		g.drawImage(IMG, getX()+67, getY()+12, getX()+117, getY()+62, 65, 5, 125, 70, null);
		g.drawImage(IMG, getX()+135, getY()+12, getX()+185, getY()+62, 125, 5, 185, 70, null);
		g.drawImage(IMG, getX()+202, getY()+12, getX()+252, getY()+62, 190, 5, 250, 70, null);
	}

}
