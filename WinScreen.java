package fortniteFunkin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class WinScreen extends GameObject {

	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("WinScreen.jpg");
	private static Font font = new Font("Serif Italic", Font.BOLD, 30);
	private static Font font1 = new Font("Monospaced Bold Ital", Font.PLAIN, 15);
	private int FinalScore;
	
	public WinScreen(Handler handler){
		super(handler, 200, 200, null);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(IMG, 0, 0, 640, 480, 0, 0, 284, 160, null);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Your Score: " + getFinalScore() + " ", 205, 40);
		g.setFont(font1);
	}
	
	public int getFinalScore() {
		return FinalScore;
	}
	public void setFinalScore(int s) {
		FinalScore = s;
	}
}
