package particle;

import SharedObject.IRenderable;
import constants.Images;
import javafx.scene.canvas.GraphicsContext;

public class NormalParticle implements IRenderable {

	private int visibleTick = 0;
	private int maxVisibleTick = 4;

	private int x;
	private int y;

	public NormalParticle(int x, int y) {
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
			visibleTick++;
			gc.drawImage(Images.normalParticle, x, y);
		}
	}

}
