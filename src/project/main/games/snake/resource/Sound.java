package project.main.games.snake.resource;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

@SuppressWarnings("deprecation")
/**Handle all the sound related events
 * @author mdxs7
 *
 */
public enum Sound {
	COIN("coin"),COLLISION("collision"),COLLISIONPAD("collisionpad");
	AudioClip value;
	/**
	 * Constructor
	 * @param str, the path of the song file
	 */
	private Sound(String str) {
		URL url = Sound.class.getResource("/"+str+".wav");
		value = Applet.newAudioClip(url);
	}
	
	/**
	 * Play a song
	 */
	public void play() {
		value.play();
	}
	
}