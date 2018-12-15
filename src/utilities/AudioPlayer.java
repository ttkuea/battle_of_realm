package utilities;

import constants.SFX;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioPlayer {
	public static AudioPlayer instance = new AudioPlayer();

	private MediaPlayer startBGM;
	private MediaPlayer worldmapBGM;
	private MediaPlayer battleBGM;
	private MediaPlayer bossBGM;
	private MediaPlayer victoryBGM;
	private MediaPlayer gameOverBGM;

	private MediaPlayer skill2SFX;
	private MediaPlayer healSFX;

	public static AudioPlayer getInstance() {
		return instance;
	}

	public AudioPlayer() {
		startBGM = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/StartBGM.mp3").toString()));
		startBGM.setCycleCount(MediaPlayer.INDEFINITE);
		startBGM.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				startBGM.seek(Duration.ZERO);
				startBGM.play();
			}
		});

		worldmapBGM = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/WorldmapBGM.mp3").toString()));
		worldmapBGM.setCycleCount(MediaPlayer.INDEFINITE);
		worldmapBGM.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				worldmapBGM.seek(Duration.ZERO);
				worldmapBGM.play();
			}
		});

		battleBGM = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/BattleMusicBGM.mp3").toString()));
		battleBGM.setCycleCount(MediaPlayer.INDEFINITE);
		battleBGM.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				battleBGM.seek(Duration.ZERO);
				battleBGM.play();
			}
		});

		bossBGM = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/BossBGM.mp3").toString()));
		bossBGM.setCycleCount(MediaPlayer.INDEFINITE);
		bossBGM.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				bossBGM.seek(Duration.ZERO);
				bossBGM.play();
			}
		});

		victoryBGM = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/FanFare.mp3").toString()));
		victoryBGM.setStartTime(Duration.seconds(5));
		victoryBGM.setCycleCount(MediaPlayer.INDEFINITE);
		victoryBGM.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				victoryBGM.seek(Duration.seconds(5));
				victoryBGM.play();
			}
		});

		gameOverBGM = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/GameOver.mp3").toString()));
		gameOverBGM.setCycleCount(MediaPlayer.INDEFINITE);
		gameOverBGM.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				gameOverBGM.seek(Duration.ZERO);
				gameOverBGM.play();
			}
		});

		skill2SFX = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/Skill2.mp3").toString()));
		skill2SFX.setStopTime(Duration.seconds(1));

		healSFX = new MediaPlayer(new Media(ClassLoader.getSystemResource("SFX/HealSFX.mp3").toString()));
		healSFX.setStopTime(Duration.seconds(0.54));
	}

	public void playStartBGM() {
		startBGM.play();
	}

	public void pauseStartBGM() {
		startBGM.stop();
	}

	public void playWorldBGM() {
		worldmapBGM.play();
	}

	public void pauseWorldBGM() {
		worldmapBGM.pause();
	}

	public void playBattleBGM() {
		battleBGM.play();
	}

	public void pauseBattleBGM() {
		battleBGM.stop();
	}

	public void playBossBGM() {
		bossBGM.play();
	}

	public void pauseBossBGM() {
		bossBGM.pause();
	}

	public void playVictoryBGM() {
		victoryBGM.play();
	}

	public void pauseVictoryBGM() {
		victoryBGM.stop();
	}

	public void playGameOverBGM() {
		gameOverBGM.play();
	}

	public void pauseGameOverBGM() {
		gameOverBGM.stop();
	}

	public void playCursorSound() {
		Thread t = new Thread(() -> {
			SFX.cursorMove.play();
		});
		t.start();
	}

	public void playStartSound() {
		Thread t = new Thread(() -> {
			SFX.startSFX.play();
		});
		t.start();
	}

	public void playHitSound() {
		Thread t = new Thread(() -> {
			SFX.hitSFX.play();
		});
		t.start();
	}

	public void playUltiSound() {
		Thread t = new Thread(() -> {
			SFX.ultiSFX.play();
		});
		t.start();
	}

	public void playHealSound() {
		Thread t = new Thread(() -> {
			healSFX.play();
		});
		t.start();
	}

	public void playSkill2Sound() {
		Thread t = new Thread(() -> {
			skill2SFX.play();
		});
		t.start();
	}

}
