package skill;

import sprite.HealthEntity;

public class HealSkill extends Skill {
	private HealthEntity owner;

	public HealSkill(int maxCooldown, HealthEntity owner) {
		super(maxCooldown);
		this.owner = owner;
	}

	@Override
	public void use(HealthEntity target) {
		int healPoint = (int) (target.getMAXHP() * 0.3);
		if (!target.isDead()) {
			target.heal(healPoint);
			System.out.println("Heal " + target.getName() + "->" + target.getCurrentHP() + "/" + target.getMAXHP());
			setOnCooldown();
		} else {
			System.out.println("He is dead, Why should you heal him");
		}
	}

	@Override
	public String getName() {
		return "Heal Skill";
	}

	@Override
	public String getDescription() {
		return "Heals a target";
	}

}
