package UI.map;

import java.util.ArrayList;
import java.util.Collections;

import constants.Images;
import javafx.scene.canvas.GraphicsContext;
import sprite.HealthEntity;
import sprite.enemy.Enemy;

public class Map_Stage5 extends Map {
	private ArrayList<HealthEntity> enemies;
	private Enemy e1 = new Enemy(1, 690, 50, 120,  40, 11, 21, 10, "Enemy 1", Images.badWizardIdles, Images.badWizardAtks);
	private Enemy e2 = new Enemy(1, 850, 180, 120, 40, 11, 24, 10, "Enemy 2", Images.dragonIdles, Images.dragonAtks);
	private Enemy e3 = new Enemy(1, 710, 330, 120, 40, 11, 21, 10, "Enemy 3", Images.badWizardIdles,
			Images.badWizardAtks);

	public Map_Stage5() {
		super(constants.Images.stage5BG, 5);
		enemies = new ArrayList<>();

		Collections.addAll(enemies, e1, e2, e3);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(mapImage, 0, 0);
		for (int i = 0; i < enemies.size(); ++i) {
			if (!enemies.get(i).isDead()) {
				enemies.get(i).draw(gc);
			}
		}
	}

	@Override
	public ArrayList<HealthEntity> getEnemies() {
		// TODO Auto-generated method stub
		return enemies;
	}
}
