package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.BulletsManager;
import spaceShooter.Game;
import utilz.LoadSave;
/*This Class is  Managing EnemyShip creation and Updation */
public class EnemyShip extends Entity {
	private BufferedImage enemyShip;

	private boolean moveToRight;
	private final BulletsManager bulletsManager;
	private float offset;

	public EnemyShip(float x, float y, int width, int height, boolean flag, BulletsManager bulletsManager) {
		super(x, y, width, height);
		enemyShip = LoadSave.GetSpriteAtlas(LoadSave.ENEMYSHIP_ATLUS);
		width = enemyShip.getWidth();
		height = enemyShip.getHeight();
		moveToRight = flag;
		this.bulletsManager = bulletsManager;
		offset = (float) Game.TILES_SIZE /2;
	}

	public void render(Graphics g) {
		g.drawImage(enemyShip, (int)(x+offset), (int)y, null);
	}
	/*-----This Method updating Movement of EnemyShip---------------*/
	public void update() {
		if (offset <= 0) {
			moveToRight = true;
		} else if (offset >= Game.TILES_SIZE){
			moveToRight = false;
		}

		if (moveToRight) {
			offset += 0.5f;
		} else {
			offset -= 0.5f;
		}

	}

	/* This Method Checking collision of 'Bullet' with 'EnemyShip'  */
	 public boolean handleAttack() {
		for (int i=0;i<bulletsManager.getBullets().size();i++) {
			int px = bulletsManager.getBullets().get(i).getX();
			int py = bulletsManager.getBullets().get(i).getY();
			if (px>=x && px<(x+enemyShip.getWidth()+offset) && py>=y && py<y+enemyShip.getHeight()) {
				bulletsManager.getBullets().remove(i);
				return true;
			}
		}
		return false;
	}

}
