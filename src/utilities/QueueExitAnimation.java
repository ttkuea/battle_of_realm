package utilities;

import sprite.HealthEntity;

public class QueueExitAnimation {
	public HealthEntity character;
	public double xPos; 
	public double yPos; // relative to base line
	
	public QueueExitAnimation(HealthEntity character, double xPos, double yPos) {
		super();
		this.character = character;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	
}
