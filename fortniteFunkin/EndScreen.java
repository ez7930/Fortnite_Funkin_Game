package fortniteFunkin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class EndScreen extends GameObject {

	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("GameoverScreen.jpg");
	private static Font font = new Font("Serif Italic", Font.BOLD, 30);
	private static Font font1 = new Font("Monospaced Bold Ital", Font.PLAIN, 15);
	private boolean end = false;
	private int FinalScore;
	
	public EndScreen(Handler handler){
		super(handler, 200, 200, null);
	}

	@Override
	public void tick() {
		if(KeyInput.getKey(KeyEvent.VK_SPACE)) {
			System.exit(0);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(IMG, 0, 0, 640, 480, 0, 0, 300, 168, null);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Your Score: " + getFinalScore() + " ", 205, 40);
		g.setFont(font1);
		g.drawString("Press Space to Close", 235, 60);
		
		
	}
	
	public int getFinalScore() {
		return FinalScore;
	}
	
	public void setFinalScore(int s) {
		FinalScore = s;
	}
	public boolean isEnd() {
		return end;
	}
	
	public void setEnd(Boolean b) {
		end = b;
	}
}
