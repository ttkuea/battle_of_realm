package skill;

import sprite.HealthEntity;

public interface IUsable {
	public void use(HealthEntity target);
	public boolean isSelected();
	
	public String getName();
	public String getDescription();
}
