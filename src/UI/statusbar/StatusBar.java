package UI.statusbar;

import SharedObject.IRenderable;
import constants.Constant;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameManager;
import sprite.player.Archer;
import sprite.player.Warrior;
import sprite.player.Wizard;

public class StatusBar implements IRenderable {
	public static final double BOX_HEIGHT = 60;
	public static final double HP_ATB_BAR_HEIGHT = 20;
	public static final double HP_BAR_WIDTH = 250;
	public static final double ATB_BAR_WIDHT = 300;
	public static final double HP_ATB_Y = 20;
	public static final double HP_X = 350;
	public static final double ATB_X = 700;

	private static final Color BACKGROUND_COLOR = Color.TURQUOISE;
	private static final Color HP_LEFT = Color.LAWNGREEN;
	private static final Color HP_DEPLETE = Color.RED;

	private static final Color ATB_COLOR = Color.DEEPSKYBLUE;
	private static final Color ATB_DEPLETE = Color.LIGHTGRAY;
	private static final Color BORDER_COLOR = Color.BLACK;

	private static final Font NAME_FONT = constants.Fonts.nameFont; // TEST

	private static double warriorHpWidth = 0;
	private static double warriorAtbWidth = 0;
	private static double wizardHpWidth = 0;
	private static double wizardAtbWidth = 0;
	private static double archerHpWidth = 0;
	private static double archerAtbWidth = 0;

	private static double warriorPosY;
	private static double wizardPosY;
	private static double archerPosY;

	protected int z;
	protected boolean visible, destroy;

	public StatusBar(int z) {
		this.warriorPosY = 584;
		this.wizardPosY = 646;
		this.archerPosY = 708;
		this.z = z;
		this.visible = true;
		this.destroy = false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		drawWarriorBox(gc);
		drawWizardBox(gc);
		drawArcherBox(gc);
	}

	public void drawWarriorBox(GraphicsContext gc) {
		// Draw Border and Background
		gc.setFill(BACKGROUND_COLOR);
		gc.fillRect(0, warriorPosY, Constant.SCREEN_WIDTH, BOX_HEIGHT);

		warriorHpWidth = HP_BAR_WIDTH * GameManager.getInstance().getWarrior().getCurrentHP() * 0.2
				/ GameManager.getInstance().getWarrior().getMAXHP() + 0.8 * warriorHpWidth;
		warriorAtbWidth = ATB_BAR_WIDHT * GameManager.getInstance().getWarrior().getCurrentATB() * 0.2
				/ GameManager.getInstance().getWarrior().getMAXATB() + 0.8 * warriorAtbWidth;
		gc.setStroke(BORDER_COLOR);

		// HP Bar
		gc.setFill(HP_DEPLETE);
		gc.fillRoundRect(HP_X, warriorPosY + HP_ATB_Y, HP_BAR_WIDTH, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(HP_LEFT);
		gc.fillRoundRect(HP_X, warriorPosY + HP_ATB_Y, warriorHpWidth, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(BORDER_COLOR);
		gc.strokeRoundRect(HP_X, warriorPosY + HP_ATB_Y, HP_BAR_WIDTH, HP_ATB_BAR_HEIGHT, 20, 20);

		// ATB Bar
		gc.setFill(ATB_DEPLETE);
		gc.fillRoundRect(ATB_X, warriorPosY + HP_ATB_Y, ATB_BAR_WIDHT, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(ATB_COLOR);
		gc.fillRoundRect(ATB_X, warriorPosY + HP_ATB_Y, warriorAtbWidth, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setLineWidth(2.0);
		gc.strokeRoundRect(ATB_X, warriorPosY + HP_ATB_Y, ATB_BAR_WIDHT, HP_ATB_BAR_HEIGHT, 20, 20);

		gc.setLineWidth(3.0);
		if (GameManager.getInstance().getTopQueue() instanceof Warrior) {
			gc.setStroke(Color.GOLD);
		} else
			gc.setStroke(Color.MEDIUMSEAGREEN);
		gc.strokeRect(0, warriorPosY, Constant.SCREEN_WIDTH, BOX_HEIGHT);

		// Text
		gc.setFill(BORDER_COLOR);
		gc.setFont(NAME_FONT);

		gc.fillText("Warrior", 30, warriorPosY + 38);
		gc.fillText(": HP", 280, warriorPosY + 38);
		gc.fillText("ATB", 620, warriorPosY + 38);
	}

	public void drawWizardBox(GraphicsContext gc) {
		// Draw Border and Background
		gc.setFill(BACKGROUND_COLOR);
		gc.fillRect(0, wizardPosY, Constant.SCREEN_WIDTH, BOX_HEIGHT);

		wizardHpWidth = HP_BAR_WIDTH * GameManager.getInstance().getWizard().getCurrentHP() * 0.2
				/ GameManager.getInstance().getWizard().getMAXHP() + 0.8 * wizardHpWidth;
		wizardAtbWidth = ATB_BAR_WIDHT * GameManager.getInstance().getWizard().getCurrentATB() * 0.2
				/ GameManager.getInstance().getWizard().getMAXATB() + 0.8 * wizardAtbWidth;
		gc.setStroke(BORDER_COLOR);

		// HP Bar
		gc.setFill(HP_DEPLETE);
		gc.fillRoundRect(HP_X, wizardPosY + HP_ATB_Y, HP_BAR_WIDTH, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(HP_LEFT);
		gc.fillRoundRect(HP_X, wizardPosY + HP_ATB_Y, wizardHpWidth, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(BORDER_COLOR);
		gc.strokeRoundRect(HP_X, wizardPosY + HP_ATB_Y, HP_BAR_WIDTH, HP_ATB_BAR_HEIGHT, 20, 20);

		// ATB Bar
		gc.setFill(ATB_DEPLETE);
		gc.fillRoundRect(ATB_X, wizardPosY + HP_ATB_Y, ATB_BAR_WIDHT, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(ATB_COLOR);
		gc.fillRoundRect(ATB_X, wizardPosY + HP_ATB_Y, wizardAtbWidth, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setLineWidth(2.0);
		gc.strokeRoundRect(ATB_X, wizardPosY + HP_ATB_Y, ATB_BAR_WIDHT, HP_ATB_BAR_HEIGHT, 20, 20);

		gc.setLineWidth(3.0);
		if (GameManager.getInstance().getTopQueue() instanceof Wizard) {
			gc.setStroke(Color.GOLD);
		} else
			gc.setStroke(Color.MEDIUMSEAGREEN);
		gc.strokeRect(0, wizardPosY, Constant.SCREEN_WIDTH, BOX_HEIGHT);

		// Text
		gc.setFill(BORDER_COLOR);
		gc.setFont(NAME_FONT);

		gc.fillText("Wizard", 30, wizardPosY + 38);
		gc.fillText(": HP", 280, wizardPosY + 38);
		gc.fillText("ATB", 620, wizardPosY + 38);
	}

	public void drawArcherBox(GraphicsContext gc) {
		// Draw Border and Background
		gc.setFill(BACKGROUND_COLOR);
		gc.fillRect(0, archerPosY, Constant.SCREEN_WIDTH, BOX_HEIGHT);

		archerHpWidth = HP_BAR_WIDTH * GameManager.getInstance().getArcher().getCurrentHP() * 0.2
				/ GameManager.getInstance().getArcher().getMAXHP() + 0.8 * archerHpWidth;
		archerAtbWidth = ATB_BAR_WIDHT * GameManager.getInstance().getArcher().getCurrentATB() * 0.2
				/ GameManager.getInstance().getArcher().getMAXATB() + 0.8 * archerAtbWidth;
		gc.setStroke(BORDER_COLOR);

		// HP Bar
		gc.setFill(HP_DEPLETE);
		gc.fillRoundRect(HP_X, archerPosY + HP_ATB_Y, HP_BAR_WIDTH, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(HP_LEFT);
		gc.fillRoundRect(HP_X, archerPosY + HP_ATB_Y, archerHpWidth, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(BORDER_COLOR);
		gc.strokeRoundRect(HP_X, archerPosY + HP_ATB_Y, HP_BAR_WIDTH, HP_ATB_BAR_HEIGHT, 20, 20);

		// ATB Bar
		gc.setFill(ATB_DEPLETE);
		gc.fillRoundRect(ATB_X, archerPosY + HP_ATB_Y, ATB_BAR_WIDHT, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setFill(ATB_COLOR);
		gc.fillRoundRect(ATB_X, archerPosY + HP_ATB_Y, archerAtbWidth, HP_ATB_BAR_HEIGHT, 20, 20);
		gc.setLineWidth(2.0);
		gc.strokeRoundRect(ATB_X, archerPosY + HP_ATB_Y, ATB_BAR_WIDHT, HP_ATB_BAR_HEIGHT, 20, 20);

		gc.setLineWidth(3.0);
		if (GameManager.getInstance().getTopQueue() instanceof Archer) {
			gc.setStroke(Color.GOLD);
		} else
			gc.setStroke(Color.MEDIUMSEAGREEN);
		gc.strokeRect(0, archerPosY, Constant.SCREEN_WIDTH, BOX_HEIGHT);

		// Text
		gc.setFill(BORDER_COLOR);
		gc.setFont(NAME_FONT);

		gc.fillText("Archer", 30, archerPosY + 38);
		gc.fillText(": HP", 280, archerPosY + 38);
		gc.fillText("ATB", 620, archerPosY + 38);
	}

	public int getZ() {
		return this.z;
	}

	public boolean isDestroyed() {
		return this.destroy;
	}

	public boolean isVisible() {
		return this.visible;
	}
}
