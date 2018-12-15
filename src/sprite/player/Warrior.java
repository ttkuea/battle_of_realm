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

public class Warrior extends HealthEntity {
	private ArrayList<Image> idleImagesList; // 0

	private ArrayList<Image> atkImagesList; // 1

	private ArrayList<Image> skillImagesList; // 2

	private ArrayList<Image> ultiImagesList; // 3

	private ArrayList<Image> skillIconList;

	private ArrayList<Skill> skillList;

	private int state = 0;
	private int animationCounter = 1;
	private int renderTick = 0;

	public Warrior(int z, double x, double y, int maxHP, int atk, int def, int spd, double criRate, String name) {
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
		Collections.addAll(idleImagesList, constants.Images.warriorIdle1, constants.Images.warriorIdle2,
				constants.Images.warriorIdle3);

		Collections.addAll(atkImagesList, constants.Images.warriorIdle1, constants.Images.warriorAtk1,
				constants.Images.warriorAtk2, Images.warriorIdle1);

		Collections.addAll(skillImagesList, Images.warriorIdle1, Images.warriorSkill1, Images.warriorSkill2,
				Images.warriorSkill3, Images.warriorSkill4, Images.warriorSkill5);

		Collections.addAll(ultiImagesList, Images.warriorIdle1, Images.warriorUlti, Images.warriorIdle1);
	}

	public void updateSkillList() {
		Collections.addAll(skillIconList, constants.Images.warriorNormalIcon, constants.Images.warriorSkillIcon,
				constants.Images.warriorUltiIcon);
		Collections.addAll(skillIconList, Images.warriorNormalCD, Images.warriorSkillCD, Images.warriorUltiCD);
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
				if (animationCounter != 70) {
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
