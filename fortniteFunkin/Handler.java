package fortniteFunkin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Handler {

	private Player player;
	private ArrayList<Arrow> arrows;
	private Arrow arrow;
	private Jonesy jonesy;
	private StartScreen startScreen;
	private GreyArrows grayArrows; 
	private ArrayList<Life> lives;
	private Score score;
	private Sound music;
	private Background background;
	private EndScreen endScreen;
	private MistakeSound mistakeSound;
	private WinScreen winScreen;
	
	private Color currColor;
	private double currTick;
	private int spawnIndex;
	private boolean isMusic;
	private boolean isImmune;
	private int immunityTimer;
	private double[] beatVals;
	
	private double brugSum;
	private boolean brubBoolean;
	private int winTimer;
	
	
	public Handler() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		isMusic = true;
		music = new Sound();
		mistakeSound  = new MistakeSound();
		endScreen = new EndScreen(this);
		background = new Background(this);
		player = new Player(this);
		arrows = new ArrayList<Arrow>();
		arrow = new Arrow(this);
		jonesy = new Jonesy(this);
		grayArrows = new GreyArrows(this);
		startScreen = new StartScreen(this);
		winScreen = new WinScreen(this);
		score = new Score(this);
		lives = new ArrayList<Life>();
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		lives.add(new Life(this, 400));
		lives.add(new Life(this, 460));
		lives.add(new Life(this, 520));
		lives.add(new Life(this, 580));
		currColor = Color.WHITE;
		brugSum = 0;
		winTimer = 0;
		spawnIndex = 0;
		isImmune = false;
		brubBoolean = false;
		
		//Beat vals
		beatVals = new double[] {71.7, 78.3, 74.7, 74.7, 76.2, 75.3, 75.3, 74.7, 75.9, 77.7, 74.7, 74.7, 19.8, 19.8, 37.8, 73.2, 73.8, 78.9, 37.2, 17.4, 18.9, 76.2, 72.9, 76.8, 38.7, 37.8, 39.9, 33.9, 38.7, 38.4, 37.8, 38.7, 36.9, 38.7, 38.7, 35.4, 37.2, 37.8, 39, 37.8, 37.2, 38.7, 36.9, 37.8, 36.9, 40.5,
				36.9,37.2,35.7,39.9,36.9,38.4,37.8,36.3,37.8,39,34.5,42.3,74.4,75,77.4,37.8,40.2,35.7,38.7,36.3,37.2,38.4,17.7,19.2,19.8,18.9,36.9,46.2,46.2,19.2,37.8,76.8,36.9,38.7,36.9,38.7,20.7,18.9,36.9,44.4,13.8,15.9,19.8,19.2,36.3,37.2,36.9,36.9,38.4,38.4,
				37.8,37.2,36.9,38.7,38.4,36.9+39.3,37.2+36.9,37.8,37.2,37.5,35.4,42.3,35.4,37.8,38.4,38.4,36.9,36.3,39.3,37.2,38.4,37.5,37.2,37.2,39.9,39.3,36.3,17.4,38.4,21.9,19.5,18.3,34.5,21,17.7,36.9,73.8,58.8,57,19.8,16.8,18.3,21,39,36,38.4,37.8,36.9,
				38.4,37.2,35.7,41.4,34.2,19.8,20.4,18.9,20.7,35.7,35.7,38.7,36.9,37.5,36.3,38.7,39,39.9+10,35.7,9.3+9.0+30+7.2,11.7,33.9,39.3,36.3,41.7,37.2,38.4,38.4,38.7,35.7,37.8,36.3,36.9,38.4,39.3,37.2,37.8,17.4,20.7,37.2,35.7,36.9,42.3,35.4,39.9,16.8,20.4,20.4,18.3,36.9,20.4,16.8,17.7,20.4,19.8,16.8,35.7,21.3,16.8,18.9,17.4,18.3,18.3,40.8,17.7,17.7,18.3,19.8,21.3,13.8,42.3,40.2,34.8,37.2,37.2,38.4,38.4,36.3,19.2,7.8,10.8,33.9,40.2,38.7,37.2,38.4,37.2,40.2,37.2,34.8,16.8,19.8,18.9,19.8,38.7,35.7,34.2,40.8,
				39.9,35.7,38.7,19.2,17.4,39.3,35.4,40.8,36.9,36.9,37.2,39.3,18.9,18.3,19.8,36.9,17.7,21.3,8.4,44.4,20.4,38.7,18.3,18.3,10.5,26.4,20.4,18.9,36.3,19.8,26.7,28.2,19.2,17.4,39.9,17.4,21.3,17.4,18.9,18.3,54.3,21.9,73.8,19.8,39.9,18.3,73.8,18.9,38.7,17.4,72.9,20.4,39.3,19.2,73.8,19.8,37.2,37.8,37.8,21.3,17.7,19.2,18.3,19.2,18.3,17.7,18.9,18.3,36.9,19.2,17.7,18.9,18.3,19.5,18.9,21.9,18.9,19.2,16.2,19.8,17.7,18.3,19.2,20.4,31.8,24.3,18.3,18.3,17.4,19.8,21.3,18.9,18.3,6.9,10.8,18.3,17.4,16.8,19.2,19.2,
				21.3,10,21.3,18.3,17.4,6.9,11.7,18.3,18.9,17.7,19.2,8.4,10.2,9.3,9.9,8.4,9.9,9,10.8,18.3,17.7,20.7,18.9,17.4,8.4,9.9,8.7,8.7,9.3,10.8,18.3,19.2,17.7,21.9,19.2,17.7,17.4,16.8,20.4,18.9,20.4,17.4,18.3,8.7,8.4,20.4,16.8,19.2,23.4,6.9+10.8,6.3,12.3,16.5,7.5,12.9,17.4,9.9,8.7,18.9,18.9,18.3,18.9,18.3,16.8,18.9,9,12.3,8.4,28.8,20.4,17.4,15,20.4,7.8,8.4,10.2,15.9,15.9,20.4,16.2,19.8,20.4,18.9,19.8,18,19.8,17.7,20.4,18.9,16.8,7.2,10.2,39,9.3,8.4,7.8,20.4, 21.01,
				999999, 999999};
	}

	public void tick() throws LineUnavailableException, IOException, UnsupportedAudioFileException{

		if(endScreen.isEnd() == false && startScreen.isStart()) {
			for(Arrow a : arrows)
				a.tick();

			if(currTick >= brugSum) {
				if(beatVals[spawnIndex] < 15 || beatVals[spawnIndex+1] < 15) {
					arrow.setIsAlternating(true);
				}
				else {
					arrow.setIsAlternating(false);
				}
				arrows.add(new Arrow(this));
				arrows.get(arrows.size()-1).setSpawnCode(beatVals[spawnIndex]);
				brugSum = Math.round((brugSum + beatVals[spawnIndex])*10.0)/10.0;
				spawnIndex++;


			}
			
			if(immunityTimer >= 60) {
				isImmune = false;
				immunityTimer = 0;
			}


			if(currColor == Color.GREEN || currColor == Color.RED) {
				currColor = Color.WHITE;
			}


			for(int i = arrows.size() - 1; i >= 0; i--){

				//Deducts points for not letting an Arrow pass the GreyArrows
				if(arrows.get(i).getY()<-30) {
					lives.remove(lives.size()-1);
					isImmune = true;
					mistakeSound.playSound();
					jonesy.mistake();
					for(int a = arrows.size()-1; a>= 0; a--) {
						arrows.remove(a);
					}
					currColor = Color.RED;
					isImmune = true;
				}

			}

			
			if(KeyInput.getKey(KeyEvent.VK_LEFT)) {
				boolean hit = false;
				for(int i = arrows.size()-1; i >= 0; i--) {
					if(arrows.get(i).getSpace().intersects(grayArrows.getSpace()) && arrows.get(i).getX() == 0) {
						hit = true;
						arrows.remove(i);
						currColor = Color.GREEN;
						KeyInput.clearKeys();
						jonesy.nextJonesy();
					}
				}
				if(hit) {
					score.incrementScore();
				}
				else if(!isImmune){
					lives.remove(lives.size()-1);
					isImmune = true;
					mistakeSound.playSound();
					jonesy.mistake();
					for(int a = arrows.size()-1; a>= 0; a--) {
						arrows.remove(a);
					}
					KeyInput.clearKeys();
				}
			}
			if(KeyInput.getKey(KeyEvent.VK_DOWN)) {
				boolean hit = false;
				for(int i = arrows.size()-1; i >= 0; i--) {
					if(arrows.get(i).getSpace().intersects(grayArrows.getSpace()) && arrows.get(i).getX() == (int)((Game.WIDTH/2.0-50) * 0.25)) {
						hit = true;
						arrows.remove(i);
						KeyInput.clearKeys();
						jonesy.nextJonesy();
					}
				}
				if(hit) {
					score.incrementScore();
				}
				else if(!isImmune){
					lives.remove(lives.size()-1);
					isImmune = true;
					mistakeSound.playSound();
					jonesy.mistake();
					for(int a = arrows.size()-1; a>= 0; a--) {
						arrows.remove(a);
					}
					KeyInput.clearKeys();
				}
			}
			if(KeyInput.getKey(KeyEvent.VK_UP)) {
				boolean hit = false;
				for(int i = arrows.size()-1; i >= 0; i--) {
					if(arrows.get(i).getSpace().intersects(grayArrows.getSpace()) && arrows.get(i).getX() == (int)((Game.WIDTH/2.0-50) * 0.5)) {
						hit = true;
						arrows.remove(i);
						currColor = Color.GREEN;
						KeyInput.clearKeys();
						jonesy.nextJonesy();
					}
				}
				if(hit) {
					score.incrementScore();
				}
				else if(!isImmune){
					lives.remove(lives.size()-1);
					isImmune = true;
					mistakeSound.playSound();
					jonesy.mistake();
					for(int a = arrows.size()-1; a>= 0; a--) {
						arrows.remove(a);
					}
					KeyInput.clearKeys();
				}
			}
			if(KeyInput.getKey(KeyEvent.VK_RIGHT)) {
				boolean hit = false;
				for(int i = arrows.size()-1; i >= 0; i--) {
					if(arrows.get(i).getSpace().intersects(grayArrows.getSpace()) && arrows.get(i).getX() == (int)((Game.WIDTH/2.0-50) * 0.75)) {
						hit = true;
						arrows.remove(i);
						currColor = Color.GREEN;
						KeyInput.clearKeys();
						jonesy.nextJonesy();
					}
				}
				if(hit) {
					score.incrementScore();
				}
				else if(!isImmune){
					lives.remove(lives.size()-1);
					isImmune = true;
					mistakeSound.playSound();
					jonesy.mistake();
					for(int a = arrows.size()-1; a>= 0; a--) {
						arrows.remove(a);
					}
					KeyInput.clearKeys();
				}
			}
			currTick++;
			if(lives.size() <= 0) {
				endScreen.setEnd(true);
			}
			if(isImmune) {
				immunityTimer++;
			}
			endScreen.setFinalScore(score.getScore());
			winScreen.setFinalScore(score.getScore());
		}
		else if(endScreen.isEnd() == true){
			endScreen.tick();
			music.stop();
		}
		else if (startScreen.isStart() == false) {
			startScreen.tick();
		}
		if(beatVals[spawnIndex] == 999999) {
			winTimer++;
		}
		
	}



	public void render(Graphics g) throws LineUnavailableException, IOException, UnsupportedAudioFileException{

		g.setColor(currColor);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		if(endScreen.isEnd() == false && startScreen.isStart() == true) {
			if(brubBoolean == false) {
				brugSum = startScreen.getStartTime();
				arrow.adjustSpeed(startScreen.getSpeed());
				brubBoolean = true;
			}
			
			if(isMusic) {
				music.setPlay(true);
				music.playSound();
				isMusic = false;
			}
			background.render(g);
			grayArrows.render(g);
//			player.render(g);
			for(Arrow a : arrows)
				a.render(g);
			jonesy.render(g);
			score.render(g);
			for(Life l : lives) {
				l.render(g);
			}
			
		}
		
		if(startScreen.isStart() == false) {
			startScreen.render(g);
		}
		
		if(lives.size() <= 0) {
			endScreen.render(g);
		}
		if(winTimer > 180) {
			winScreen.render(g);
		}
	}

}