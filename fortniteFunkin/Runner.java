package fortniteFunkin;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Runner {

	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		Game game = new Game();

		game.run();
		
	}

}
