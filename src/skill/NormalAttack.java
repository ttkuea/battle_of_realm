package skill;

import sprite.HealthEntity;

public class NormalAttack extends Skill{
	private HealthEntity owner;
	
	public NormalAttack(int maxCooldown, HealthEntity owner){
		super(maxCooldown);
		this.owner = owner;
	}
	
	@Override
	public void use(HealthEntity target) {
		if (!target.isDead()) {
			this.owner.attack(target);
			System.out.println("Normal Deal "+ (target.getMAXHP()-target.getCurrentHP()) + "->" + target.getCurrentHP() + "/" + target.getMAXHP());
			setOnCooldown();
		}else {
			System.out.println("Why should you attack him");
		}
	}

	@Override
	public String getName() {
		return "Normal Attack";
	}

	@Override
	public String getDescription() {
		return "Attacks a target";
	}
}
