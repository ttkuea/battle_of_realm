package UI.map;

import java.util.ArrayList;

import SharedObject.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sprite.HealthEntity;

public abstract class Map implements IRenderable {
	protected Image mapImage;
	protected int mapNumber;

	protected boolean visible, destroy;

	public Map(Image mapImage, int mapNumber) {
		this.mapImage = mapImage;
		this.visible = true;
		this.destroy = false;
	}

	// Abstract
	public abstract ArrayList<HealthEntity> getEnemies();

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(mapImage, 0, 0);
	}

	@Override
	public boolean isDestroyed() {
		return this.destroy;
	}

	@Override
	public boolean isVisible() {
		return this.visible;
	}

	// Getters and Setters
	public Image getMapImage() {
		return mapImage;
	}

	public void setMapImage(Image mapImage) {
		this.mapImage = mapImage;
	}

	public int getMapNumber() {
		return mapNumber;
	}

	public void setMapNumber(int mapNumber) {
		this.mapNumber = mapNumber;
	}
}
