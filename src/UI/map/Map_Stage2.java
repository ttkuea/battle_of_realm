package UI.map;

import java.util.ArrayList;
import java.util.Collections;

import constants.Images;
import javafx.scene.canvas.GraphicsContext;
import sprite.HealthEntity;
import sprite.enemy.Enemy;

public class Map_Stage2 extends Map {
	private ArrayList<HealthEntity> enemies;
	private Enemy e1 = new Enemy(1, 690, 50,  50, 25, 5, 13, 10, "Enemy 1", Images.lavaIdles, Images.lavaAtks);
	private Enemy e2 = new Enemy(1, 850, 180, 60, 28, 5, 13, 10, "Enemy 2", Images.griffinIdles, Images.griffinAtks);
	private Enemy e3 = new Enemy(1, 710, 330, 50, 25, 7, 11, 10, "Enemy 3", Images.lavaIdles, Images.lavaAtks);

	public Map_Stage2() {
		super(constants.Images.stage2BG, 2);
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
