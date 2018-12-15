package skill;

import java.util.ArrayList;

import sprite.HealthEntity;

public class SplashSkill extends Skill {
	private HealthEntity owner;

	public SplashSkill(int maxCooldown, HealthEntity owner) {
		super(maxCooldown);
		this.owner = owner;
	}

	public void useAll(ArrayList<HealthEntity> targets) {
		for (int i = 0; i < targets.size(); ++i) {
			use(targets.get(i));
			System.out.println("Target " + i + " ->" + targets.get(i).getCurrentHP() + "/" + targets.get(i).getMAXHP());
		}
	}

	public String getName() {
		return "Splash Attack";
	}

	public String getDescription() {
		return "Attack all target, with flat damage";
	}

	@Override
	public void use(HealthEntity target) {
		if (!target.isDead())
			owner.attack(target);
		else
			System.out.println("He is Dead by splash");
	}

}
