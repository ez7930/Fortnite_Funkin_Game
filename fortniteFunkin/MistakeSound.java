package fortniteFunkin;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MistakeSound {
	private boolean play = true;
	
	public MistakeSound (){}

	public void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		try{
			if(play)
			{
				
			    File file = new File("scream6.wav");
			    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			    DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			    Clip clip = (Clip) AudioSystem.getLine(info);
			    clip.open(ais);
			    clip.start();
			
			}	
			else {
				File file = new File("scream6.wav");
			    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			    DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			    Clip clip = (Clip) AudioSystem.getLine(info);
			    clip.open(ais);
			    clip.start(); 
				
			}
		} catch (Exception e){}
	}

	public void setPlay(Boolean b){
		play = b;
	}
	
}