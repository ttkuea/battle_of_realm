package constants;

import javafx.scene.media.AudioClip;

public class SFX {
	public static final AudioClip cursorMove = new AudioClip(ClassLoader.getSystemResource("SFX/cursorMove.mp3").toString());
	public static final AudioClip startSFX = new AudioClip(ClassLoader.getSystemResource("SFX/StartSFX.mp3").toString());
	public static final AudioClip hitSFX = new AudioClip(ClassLoader.getSystemResource("SFX/HitSFX.mp3").toString());
	public static final AudioClip ultiSFX = new AudioClip(ClassLoader.getSystemResource("SFX/UltiSFX.mp3").toString());
}
