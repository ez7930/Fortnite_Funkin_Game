package fortniteFunkin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyInput extends KeyAdapter {
	
	private static ArrayList<Integer> keysPressed;
	private static boolean press;
	
	public KeyInput(){
		keysPressed = new ArrayList<Integer>();
		press = false;
	}
	
	public void keyPressed(KeyEvent e){
		if(!press) {
			if(!keysPressed.contains(e.getKeyCode()))
				keysPressed.add(e.getKeyCode());
//			press = true;
		}
	}
	
	public void keyReleased(KeyEvent e){
		press = false;
		for(int i = keysPressed.size() - 1; i >= 0; i--) {
			if(keysPressed.get(i) == e.getKeyCode()) {
				keysPressed.remove(i);
			}
		}
	}
	
	public static ArrayList<Integer> getKeysPressed(){
		return keysPressed;
	}

	public static boolean getKey(int key){
		return keysPressed.contains(new Integer(key));
	}
	
	public static void clearKeys() {
		for(int i = keysPressed.size() - 1; i >= 0; i--) {
			keysPressed.remove(i);
		}
	}
}
