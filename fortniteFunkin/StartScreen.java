package fortniteFunkin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class StartScreen extends GameObject {

	private static final Image IMG = Toolkit.getDefaultToolkit().getImage("backdrop.jpg");
	private boolean play = false;
	private static Font font = new Font("Serif Italic", Font.BOLD, 20);
	private static int speed = 2;
	private static double startTime = 0;
	private Sound the;
	
	public StartScreen(Handler handler){
		super(handler, 200, 200, null);
		the = new Sound();
	}

	@Override
	public void tick() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		if(KeyInput.getKey(KeyEvent.VK_1)) {
			startTime = 40+30;
			play = true;
		}
		if(KeyInput.getKey(KeyEvent.VK_2)) {
			startTime = 110+30;
			speed = 3;
			play = true;
		}
		if(KeyInput.getKey(KeyEvent.VK_3)) {
			startTime = 150+30;
			speed = 4;
			play = true;
		}
		if(KeyInput.getKey(KeyEvent.VK_4)) {
			startTime = 185+30;
			speed = 6;
			play = true;
		}
		if(KeyInput.getKey(KeyEvent.VK_SPACE)) {
			the.setPlay(true);
			the.playSound();
			System.exit(0); 
		}
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(IMG, getX(), getY(), getX() + 200, getY() + 500, 
//				750, 0, 1200, 1800, null);
		g.drawImage(IMG, 0, 0, 640, 580, 0, 0, 640*2, 1000, null);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Press 1 for easy, 2 for normal, 3 for hard, 4 for impossible", 10, 30);
		g.drawString("TO ENABLE ON BEAT ARROWS, PRESS SPACE, WAIT,", 10, 100);
		g.drawString("THEN IMMEDIATELY RERUN THE CODE(MAY TAKE AWHILE)", 10, 130);
	}
	
	public boolean isStart() {
		return play;
	}
	
	public void setStart(Boolean b) {
		play = b;
	}

	public int getSpeed() {
		return speed;
	}

	public double getStartTime() {
		return startTime;
	}
	
	
}
