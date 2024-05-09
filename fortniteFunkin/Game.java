package fortniteFunkin;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game extends Canvas {
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private Handler handler;
	
	public Game() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		super();
		handler = new Handler();
		this.setFocusable(true);
		KeyInput keyInput = new KeyInput();
		MouseInput mouseInput = new MouseInput();
		this.addMouseListener(mouseInput);
		this.addKeyListener(keyInput);
		new Window(WIDTH, HEIGHT, "Fortnite", this);
	}
	
	
	public void run() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		//MAIN GAME LOOP
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(true){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}	
	}
	
	
	private void tick() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		handler.tick();
	}
	
	
	private void render() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		BufferStrategy bfs = this.getBufferStrategy();
		if(bfs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bfs.getDrawGraphics();
		
		handler.render(g);
		
		g.dispose();
		bfs.show();
	}

}
