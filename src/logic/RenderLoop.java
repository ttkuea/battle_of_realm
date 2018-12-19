package logic;

import java.util.ArrayList;
import java.util.Iterator;

import SharedObject.IRenderable;
import SharedObject.RenderableHolder;
import constants.Constant;
import constants.Images;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Main;
import sprite.HealthEntity;
import sprite.enemy.Enemy;
import sprite.player.Archer;
import sprite.player.Warrior;
import sprite.player.Wizard;
import utilities.QueueExitAnimation;

public class RenderLoop {
	private static RenderLoop instance = new RenderLoop();
	
	private Timeline renderLoop;
	
	public RenderLoop() {
		System.out.println("Sang LEAW");
		KeyFrame kf = new KeyFrame(Duration.seconds(1./60), e->{
			render(Main.getGameScreen().getGc());
		});
		renderLoop = new Timeline(kf);
		renderLoop.setCycleCount(Timeline.INDEFINITE);
		renderLoop.play();
	}
	
	public void render(GraphicsContext gc) {
		ArrayList<IRenderable> tmp = RenderableHolder.getInstance().getEntities();
		for (int i = 0; i < tmp.size(); ++i) {
			if (tmp.get(i).isVisible() && !tmp.get(i).isDestroyed()) {
				tmp.get(i).draw(gc);
			}
		}
		ArrayList<Integer> anim = GameManager.getInstance().getAnimList();
		double pos = 0;
		Iterator<HealthEntity> it = GameManager.getInstance().getTurnQueue().iterator();
		for (int i=0; i<anim.size(); i++) {
			pos += anim.get(i);
			HealthEntity next = it.next();
			gc.drawImage(next.getIdleImagesList().get(0), pos, 450, Constant.queueIconSize, Constant.queueIconSize);
			pos += Constant.queueGridSize;
		}
		pos = 0;
		ArrayList<QueueExitAnimation> exitAnim = GameManager.getInstance().getExitAnimList();
		for (QueueExitAnimation fp: exitAnim) {
			pos += fp.xPos;
			HealthEntity character = fp.character;
			gc.drawImage(character.getIdleImagesList().get(0), fp.xPos, 450+fp.yPos, Constant.queueIconSize, Constant.queueIconSize);
			pos += Constant.queueGridSize;
		}
	}
	
	public void call() {
		System.out.println("Call RenderLoop");
	}

	public static RenderLoop getInstance() {
		return instance;
	}
	
	
	
}
