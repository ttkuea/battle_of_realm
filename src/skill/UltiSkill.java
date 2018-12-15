package skill;

import sprite.HealthEntity;

public class UltiSkill extends Skill {
	private HealthEntity owner;

	public UltiSkill(int maxCooldown, HealthEntity owner) {
		super(maxCooldown);
		this.owner = owner;
	}

	@Override
	public void use(HealthEntity target) {
		if (!target.isDead()) {
			target.takeDamage((int) (owner.getAtk() * (1 + (owner.getCriticalRate() / 100))));
			System.out.println("Ulti Deal " + (target.getMAXHP() - target.getCurrentHP()) + "->" + target.getCurrentHP()
					+ "/" + target.getMAXHP());
		} else {
			System.out.println("He is Dead, why you hitting him again?");
		}
	}

	@Override
	public String getName() {
		return "Ultimate Skill";
	}

	@Override
	public String getDescription() {
		return "Damages an enemy with greatly bonus damage";
	}
}
