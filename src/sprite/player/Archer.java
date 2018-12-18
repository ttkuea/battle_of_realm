package sprite.player;

import java.util.ArrayList;
import java.util.Collections;

import constants.Images;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import skill.NormalAttack;
import skill.Skill;
import skill.SplashSkill;
import skill.UltiSkill;
import sprite.HealthEntity;

public class Archer extends HealthEntity {
	private ArrayList<Image> idleImagesList; // 0

	private ArrayList<Image> atkImagesList; // 1

	private ArrayList<Image> skillImagesList; // 2

	private ArrayList<Image> ultiImagesList; // 3

	private ArrayList<Image> skillIconList;

	private ArrayList<Skill> skillList;

	private int state = 0;
	private int animationCounter = 1;
	private int renderTick = 0;

	public Archer(int z, double x, double y, int maxHP, int atk, int def, int spd, double criRate, String name) {
		super(z, x, y, maxHP, atk, def, spd, criRate, name);
		idleImagesList = new ArrayList<Image>();
		atkImagesList = new ArrayList<Image>();
		skillImagesList = new ArrayList<Image>();
		ultiImagesList = new ArrayList<Image>();

		skillList = new ArrayList<Skill>();
		skillIconList = new ArrayList<>();
		updateImageList();
		updateSkillList();
	}

	public void updateImageList() {
		Collections.addAll(idleImagesList, constants.Images.archerIdle2, constants.Images.archerIdle3);

		Collections.addAll(atkImagesList, constants.Images.archerAtk1, constants.Images.archerAtk2,
				constants.Images.archerAtk3, Images.archerIdle1);

		Collections.addAll(skillImagesList, Images.archerSkill, Images.archerAtk1, Images.archerAtk2, Images.archerAtk3,
				Images.archerIdle1);

		Collections.addAll(ultiImagesList, Images.archerUlti1, Images.archerUlti2, Images.archerUlti3,
				Images.archerAtk1, Images.archerAtk2, Images.archerAtk3, Images.archerIdle1);

	}

	public void updateSkillList() {
		Collections.addAll(skillIconList, constants.Images.archerNormalIcon, constants.Images.archerSkillIcon,
				constants.Images.archerUltiIcon);
		Collections.addAll(skillIconList, Images.archerNormalCD, Images.archerSkillCD, Images.archerUltiCD);
		NormalAttack skill1 = new NormalAttack(0, this);
		SplashSkill skill2 = new SplashSkill(4, this);
		UltiSkill skill3 = new UltiSkill(5, this);
		Collections.addAll(skillList, skill1, skill2, skill3);
	}


	@Override
	public void draw(GraphicsContext gc) {
		renderTick++;
		if (!isDead()) {
			switch (state) {
			case 0:
				gc.drawImage(idleImagesList.get(renderTick % 60 * idleImagesList.size() / 60), this.x, this.y);
				break;
			case 1:
				if (animationCounter != 60) {
					gc.drawImage(atkImagesList.get(animationCounter % 60 * atkImagesList.size() / 60), this.x, this.y);
					animationCounter++;
				} else {
					this.state = 0;
					animationCounter = 1;
				}
				break;
			case 2:
				if (animationCounter != 70) {
					gc.drawImage(skillImagesList.get(animationCounter % 60 * skillImagesList.size() / 60), this.x,
							this.y);
					animationCounter++;
				} else {
					this.state = 0;
					animationCounter = 1;
				}
				break;
			case 3:
				if (animationCounter != 70) {
					gc.drawImage(ultiImagesList.get(animationCounter % 60 * ultiImagesList.size() / 60), this.x,
							this.y);
					animationCounter++;
				} else {
					this.state = 0;
					animationCounter = 1;
				}
				break;
			}
		}
	}

	@Override
	public ArrayList<Image> getSkillIcon() {
		return skillIconList;
	}

	@Override
	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	
	public ArrayList<Image> getIdleImagesList() { // for rendering icom
		return idleImagesList;
	}

	public void updateStat(int[] stats) {
		this.setMAXHP(stats[0]);
		this.setCurrentHP(stats[0]);
		this.setAtk(stats[1]);
		this.setDefense(stats[2]);
		this.setSpeed(stats[3]);
		this.setCriticalRate(stats[4]);
		this.setCurrentATB(0);

		for (Skill s : skillList) {
			s.setCurrentCooldown(0);
		}
	}

}
