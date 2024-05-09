package fortniteFunkin;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private boolean play = true;
	private Clip clip;
	
	
	public Sound (){}

	public void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		try{
			if(play)
			{
				
			    File file = new File("FortniteRap.wav");
			    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			    DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			    clip = (Clip) AudioSystem.getLine(info);
			    clip.open(ais);
			    clip.start();
			    
			}	
			else {
				File file = new File("FortniteRap.wav");
			    AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			    DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			    clip = (Clip) AudioSystem.getLine(info);
			    clip.open(ais);
			    clip.start(); 
				
			}
		} catch (Exception e){}
	}

	public void setPlay(Boolean b){
		play = b;
	}
	
	public void stop() {
		clip.stop();
		clip.close();
	}
	
}