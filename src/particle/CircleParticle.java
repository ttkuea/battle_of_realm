package particle;

import SharedObject.IRenderable;
import constants.Images;
import javafx.scene.canvas.GraphicsContext;

public class CircleParticle implements IRenderable {
	private int visibleTick = 0;
	private int maxVisibleTick = 10;

	private int x;
	private int y;

	public CircleParticle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isVisible() {
		return visibleTick < maxVisibleTick;
	}

	public boolean isExpired() {
		return visibleTick >= maxVisibleTick;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return visibleTick >= maxVisibleTick;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void draw(GraphicsContext gc) {
		if (isVisible()) {
			gc.save();
			gc.setGlobalAlpha(1-visibleTick/10.);
			visibleTick++;
			gc.drawImage(Images.circleParticle, x, y);
			gc.restore();
		}
	}
}
