package logic;

import SharedObject.RenderableHolder;
import javafx.scene.input.MouseEvent;
import main.Main;
import particle.NormalParticle;
import particle.UltiParticle;
import particle.WizardHealParticle;
import particle.WizardSkill1Particle;
import particle.WizardSkill2Particle;
import skill.HealSkill;
import skill.NormalAttack;
import skill.Skill;
import skill.SplashSkill;
import skill.UltiSkill;
import sprite.HealthEntity;
import sprite.player.Wizard;
import utilities.AudioPlayer;

public class MouseHandler {
	private GameManager gm;
	private HealthEntity currentTurn;
	private Skill currentSkill;

	public MouseHandler(GameManager gm) {
		this.gm = gm;
	}

	public void handleClick(MouseEvent e) {
		int x = (int) e.getX();
		int y = (int) e.getY();

		if (gm.isSelectSkill()) {
			currentSkill = Main.getGameScreen().getCurrentTurn().getSkillList().get(Main.getGameScreen().getSkillNo() - 1);
			currentTurn = Main.getGameScreen().getCurrentTurn();
			int targetNo = getTarget(x, y);

			if (targetNo >= 0 && targetNo <= 2) {
				System.out.println("Use skill to " + targetNo);
				if (!gm.getFriend(targetNo).isDead()) {
					currentTurn.setState(Main.getGameScreen().getSkillNo());
	
					if (currentSkill instanceof SplashSkill && !(currentTurn instanceof Wizard)) {
						((SplashSkill) currentSkill).useAll(gm.getFriends());
						if (!gm.getFriends().get(0).isDead())
							RenderableHolder.getInstance().add(new NormalParticle(getPos(0)[0], getPos(3)[1]));
						if (!gm.getFriends().get(1).isDead())
							RenderableHolder.getInstance().add(new NormalParticle(getPos(1)[0], getPos(4)[1]));
						if (!gm.getFriends().get(2).isDead())
							RenderableHolder.getInstance().add(new NormalParticle(getPos(2)[0], getPos(5)[1]));
						
						AudioPlayer.getInstance().playHitSound();
					}
	
					else if (currentSkill instanceof SplashSkill && currentTurn instanceof Wizard) {
						((SplashSkill) currentSkill).useAll(gm.getFriends());
						if (!gm.getFriends().get(0).isDead())
							RenderableHolder.getInstance().add(new WizardSkill2Particle(getPos(0)[0], getPos(3)[1]));
						if (!gm.getFriends().get(1).isDead())
							RenderableHolder.getInstance().add(new WizardSkill2Particle(getPos(1)[0], getPos(4)[1]));
						if (!gm.getFriends().get(2).isDead())
							RenderableHolder.getInstance().add(new WizardSkill2Particle(getPos(2)[0], getPos(5)[1]));
						
						AudioPlayer.getInstance().playSkill2Sound();
					}
	
					if (currentSkill instanceof NormalAttack && !(currentTurn instanceof Wizard)) {
						currentSkill.use(gm.getFriend(targetNo));
						RenderableHolder.getInstance().add(new NormalParticle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playHitSound();
					}
	
					else if (currentSkill instanceof NormalAttack && currentTurn instanceof Wizard) {
						currentSkill.use(gm.getFriend(targetNo));
						RenderableHolder.getInstance().add(new WizardSkill1Particle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playHitSound();
					}
	
					if (currentSkill instanceof UltiSkill) {
						currentSkill.use(gm.getFriend(targetNo));
						RenderableHolder.getInstance().add(new UltiParticle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playUltiSound();
					}
	
					if (currentSkill instanceof HealSkill) {
						currentSkill.use(gm.getFriend(targetNo));
						RenderableHolder.getInstance().add(new WizardHealParticle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playHealSound();
					}
					
					currentSkill.setOnCooldown();
	
					gm.setSelectSkill(false);
					gm.nextQueue();
					currentTurn.setCurrentATB(0);
					currentTurn.setInQueue(false);
				}
			} else if (targetNo >= 3 && targetNo <= 5) {
				System.out.println("Use skill to " + targetNo);
				if (!gm.getEnemy(targetNo-3).isDead()) {
					currentTurn.setState(Main.getGameScreen().getSkillNo());
					if (currentSkill instanceof SplashSkill && !(currentTurn instanceof Wizard)) {
						((SplashSkill) currentSkill).useAll(gm.getEnemies());
						if (!gm.getEnemies().get(0).isDead())
							RenderableHolder.getInstance().add(new NormalParticle(getPos(3)[0], getPos(3)[1]));
						if (!gm.getEnemies().get(1).isDead())
							RenderableHolder.getInstance().add(new NormalParticle(getPos(4)[0], getPos(4)[1]));
						if (!gm.getEnemies().get(2).isDead())
							RenderableHolder.getInstance().add(new NormalParticle(getPos(5)[0], getPos(5)[1]));
						
						AudioPlayer.getInstance().playHitSound();
					}
	
					else if (currentSkill instanceof SplashSkill && currentTurn instanceof Wizard) {
						((SplashSkill) currentSkill).useAll(gm.getEnemies());
						if (!gm.getEnemies().get(0).isDead())
							RenderableHolder.getInstance().add(new WizardSkill2Particle(getPos(3)[0], getPos(3)[1]));
						if (!gm.getEnemies().get(1).isDead())
							RenderableHolder.getInstance().add(new WizardSkill2Particle(getPos(4)[0], getPos(4)[1]));
						if (!gm.getEnemies().get(2).isDead())
							RenderableHolder.getInstance().add(new WizardSkill2Particle(getPos(5)[0], getPos(5)[1]));
						
						AudioPlayer.getInstance().playSkill2Sound();
					}
	
					if (currentSkill instanceof NormalAttack && !(currentTurn instanceof Wizard)) {
						currentSkill.use(gm.getEnemy(targetNo - 3));
						RenderableHolder.getInstance().add(new NormalParticle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playHitSound();
					}
	
					else if (currentSkill instanceof NormalAttack && currentTurn instanceof Wizard) {
						currentSkill.use(gm.getEnemy(targetNo - 3));
						RenderableHolder.getInstance().add(new WizardSkill1Particle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playHitSound();
					}
	
					if (currentSkill instanceof UltiSkill) {
						currentSkill.use(gm.getEnemy(targetNo - 3));
						RenderableHolder.getInstance().add(new UltiParticle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playUltiSound();
					}
	
					if (currentSkill instanceof HealSkill) {
						currentSkill.use(gm.getEnemy(targetNo - 3));
						RenderableHolder.getInstance().add(new WizardHealParticle(getPos(targetNo)[0], getPos(targetNo)[1]));
						
						AudioPlayer.getInstance().playHealSound();
					}
					
					currentSkill.setOnCooldown();
					
					gm.setSelectSkill(false);
					currentTurn.setCurrentATB(0);
					currentTurn.setInQueue(false);
					gm.nextQueue();
				}
			}
		}

	}

	public int getTarget(int x, int y) {
		if (isInClickBox(250, 50, 350, 150, x, y))
			return 0;
		if (isInClickBox(60, 180, 160, 280, x, y))
			return 1;
		if (isInClickBox(230, 330, 330, 430, x, y))
			return 2;

		if (isInClickBox(690, 50, 790, 150, x, y))
			return 3;
		if (isInClickBox(850, 180, 950, 280, x, y))
			return 4;
		if (isInClickBox(710, 330, 810, 430, x, y))
			return 5;

		return -1;
	}

	public int[] getPos(int targetNo) {
		int[] f1 = { 250, 50 };
		int[] f2 = { 60, 180 };
		int[] f3 = { 230, 330 };
		int[] e1 = { 690, 50 };
		int[] e2 = { 850, 180 };
		int[] e3 = { 710, 330 };

		int[] defaultArr = { 0, 0 };
		switch (targetNo) {
			case 0:
				return f1;
			case 1:
				return f2;
			case 2:
				return f3;
			case 3:
				return e1;
			case 4:
				return e2;
			case 5:
				return e3;
		}
		return defaultArr;
	}

	public boolean isInClickBox(int x1, int y1, int x2, int y2, int mouseX, int mouseY) {
		if ((x1 < mouseX && mouseX < x2) && (y1 < mouseY && mouseY < y2))
			return true;
		return false;
	}
}
