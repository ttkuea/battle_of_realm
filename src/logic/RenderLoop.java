package logic;

import java.util.ArrayList;

import SharedObject.IRenderable;
import SharedObject.RenderableHolder;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;
import main.Main;

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
	}
	
	public void call() {
		System.out.println("Call RenderLoop");
	}

	public static RenderLoop getInstance() {
		return instance;
	}
	
	
	
}
