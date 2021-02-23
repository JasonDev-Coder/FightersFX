package sample;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	static AudioClip musicPlayer;
	static AudioClip soundsPLayer;
	Media song;
	private Music() {};
	public static void generateMusic(String music_path) {
		Media song=new Media(new File(music_path).toURI().toString());
		musicPlayer=new AudioClip(song.getSource());
		musicPlayer.setVolume(0.25);
		musicPlayer.play();
	}
	public static void generateSound(String music_path) {
		Media song=new Media(new File(music_path).toURI().toString());
		soundsPLayer=new AudioClip(song.getSource());
		soundsPLayer.setVolume(1);
		soundsPLayer.play();
	}
	public static void playPunch(){
		Media song=new Media(new File("src/sample/Sounds/Fighting/punch.wav").toURI().toString());
		soundsPLayer=new AudioClip(song.getSource());
		soundsPLayer.play();
	}
}
