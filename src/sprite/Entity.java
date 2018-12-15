package sprite;

import SharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	protected double x, y;
	protected int z;
	protected boolean visible, destroy;
	protected int renderTick;

	public Entity(int z, double x, double y) {
		this.x = x;
		this.y = y;
		this.z = z;
		visible = true;
		destroy = false;
		this.renderTick = 0;
	}

	// Getters and Setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isDestroyed() {
		return destroy;
	}

	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}

	// Get Render tick
	public int getRenderTick() {
		return renderTick;
	}

}
