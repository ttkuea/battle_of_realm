package skill;

import exception.CooldownException;

public abstract class Skill implements IUsable {
	private int maxCooldown, currentCooldown;
	private boolean isDisable;
	private boolean isSelected;

	private int targetNo;

	public abstract String getName();

	public abstract String getDescription();

	public Skill(int maxCooldown) {
		this.maxCooldown = maxCooldown;
		this.currentCooldown = 0;
		this.isDisable = false;
		this.isSelected = false;
	}

	// Getters
	public int getMaxCooldown() {
		return maxCooldown;
	}

	public int getCurrentCooldown() {
		return currentCooldown;
	}

	public boolean isDisable() {
		return isDisable;
	}

	public boolean isReady() throws CooldownException {
		if (currentCooldown == 0)
			return true;
		else {
			throw new CooldownException();
		}
	}

	@Override
	public boolean isSelected() {
		return isSelected;
	}

	public int getTargetNo() {
		return targetNo;
	}

	// Setters
	public void setOnCooldown() {
		currentCooldown = maxCooldown;
	}

	public void reduceCooldown() {
		currentCooldown--;
		if (currentCooldown < 0)
			currentCooldown = 0;
	}

	public void setMaxCooldown(int maxCooldown) {
		this.maxCooldown = maxCooldown;
	}

	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}

	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}

	public void setSelected(boolean selected) {
		this.isSelected = selected;
	}

	public void setTargetNo(int targetNo) {
		this.targetNo = targetNo;
	}

}
