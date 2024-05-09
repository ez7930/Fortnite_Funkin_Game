package fortniteFunkin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Score extends GameObject {
	
	private int score;
	private static Font font = new Font("Serif Italic", Font.BOLD, 20);
	
	public Score(Handler handler){
		super(handler, 200, 200, null);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(font);
		g.drawString("SCORE: " + score, 280, 40);
	}
	
	public int getScore() {
		return score;
	}
	
	public void incrementScore() {
		score++;
	}
	
	public void decreaseScore() {
		score--;
	}
	
	public void changeScore(int x) {
		score = x;
	}
	
	
}
