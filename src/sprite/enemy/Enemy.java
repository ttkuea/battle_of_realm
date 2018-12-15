package sprite.enemy;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import skill.NormalAttack;
import skill.Skill;
import sprite.HealthEntity;

public class Enemy extends HealthEntity {
	private ArrayList<Image> idleImagesList;
	private ArrayList<Image> atkImagesList;

	private ArrayList<Skill> skillList;

	private int animationCounter = 1;
	private int renderTick = 0;
	private int state = 0;

	private double hpWidth = 100;

	public Enemy(int z, double x, double y, int maxHP, int atk, int def, int spd, double criRate, String name,
			ArrayList<Image> idleImagesList, ArrayList<Image> atkImagesList) {
		super(z, x, y, maxHP, atk, def, spd, criRate, name);
		this.idleImagesList = idleImagesList;
		this.atkImagesList = atkImagesList;
		skillList = new ArrayList<>();

		updateSkillList();
	}

	public void updateSkillList() {
		NormalAttack skill1 = new NormalAttack(0, this);
		Collections.addAll(skillList, skill1);
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
			}

			hpWidth = 100 * getCurrentHP() * 0.2 / getMAXHP() + 0.8 * hpWidth;

			gc.setFill(Color.RED);
			gc.fillRoundRect(getX() - 5, getY() - 15, 100, 10, 5, 5);
			gc.setFill(Color.LAWNGREEN);
			gc.fillRoundRect(getX() - 5, getY() - 15, hpWidth, 10, 5, 5);
			gc.setStroke(Color.GRAY);
			gc.strokeRoundRect(getX() - 5, getY() - 15, 100, 10, 5, 5);
		}
	}

	@Override
	public ArrayList<Image> getSkillIcon() {
		return null;
	}

	@Override
	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public void setState(int state) {
		this.state = state;
	}
}
