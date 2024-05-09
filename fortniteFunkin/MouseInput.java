package fortniteFunkin;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	private static Point clicked;
	
	public MouseInput(){
		clicked = null;
	}
	
	public static Point getClick(){
		Point point = clicked;
		clicked = null;
		return point;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		clicked = e.getPoint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
