package fortniteFunkin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
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
	private ArrayList<Double> beatVals;
	
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
		currColor = Color.WHITE;
		brugSum = 0;
		winTimer = 0;
		spawnIndex = 0;
		isImmune = false;
		brubBoolean = false;
		
		//Beat vals
		beatVals = new ArrayList<Double>();
		
		FileReader fr = new FileReader("beatVals.txt"); 
        BufferedReader br = new BufferedReader(fr);
        
        String beatsStr = br.readLine();
        
        beatVals.add(Double.parseDouble((beatsStr.substring(0, beatsStr.indexOf(",")))));
        
        for(int i=0; i<beatsStr.length()-1; i++) {
        	if(beatsStr.substring(i, i+1).equals(",")) {
        		beatVals.add(Double.parseDouble(beatsStr.substring(i+1, (beatsStr.substring(i+1).indexOf(",") + i + 1) )));
        	}
        }
        
        System.out.print(beatVals);
	}

	public void tick() throws LineUnavailableException, IOException, UnsupportedAudioFileException{

		if(endScreen.isEnd() == false && startScreen.isStart()) {
			for(Arrow a : arrows)
				a.tick();

			if(currTick >= brugSum) {
				if(beatVals.get(spawnIndex) < 15 || beatVals.get(spawnIndex+1) < 15) {
					arrow.setIsAlternating(true);
				}
				else {
					arrow.setIsAlternating(false);
				}
				arrows.add(new Arrow(this));
				arrows.get(arrows.size()-1).setSpawnCode(beatVals.get(spawnIndex));
				brugSum = Math.round((brugSum + beatVals.get(spawnIndex))*10.0)/10.0;
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

			
			if(KeyInput.getKey(KeyEvent.VK_LEFT) || KeyInput.getKey(KeyEvent.VK_DOWN) || KeyInput.getKey(KeyEvent.VK_UP) || KeyInput.getKey(KeyEvent.VK_RIGHT)) {
				int arrowPos = 0;
				if(KeyInput.getKey(KeyEvent.VK_DOWN)) {
					arrowPos = (int)((Game.WIDTH/2.0-50) * 0.25);
				}
				else if(KeyInput.getKey(KeyEvent.VK_UP)) {
					arrowPos = (int)((Game.WIDTH/2.0-50) * 0.5);
				}
				else if(KeyInput.getKey(KeyEvent.VK_RIGHT)) {
					arrowPos = (int)((Game.WIDTH/2.0-50) * 0.75);
				}
				boolean hit = false;
				for(int i = 0; i < arrows.size(); i++) {
					if(arrows.get(i).getSpace().intersects(grayArrows.getSpace()) && arrows.get(i).getX() == arrowPos) {
						hit = true;
						arrows.remove(i);
						currColor = Color.GREEN;
						KeyInput.clearKeys();
						jonesy.nextJonesy();
						break;
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
		if(beatVals.get(spawnIndex) == 999999) {
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
		if(winTimer > 500) {
			winScreen.render(g);
		}
	}

}