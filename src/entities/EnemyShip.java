package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.BulletsManager;
import levels.LevelManager;
import spaceShooter.Game;
import spaceShooter.GamePanel;
import utilz.LoadSave;
/*This Class is  Managing EnemyShip creation and Updation */
public class EnemyShip extends Entity {
	private BufferedImage enemyShip;
	private boolean moveToRight;
	private final BulletsManager bulletsManager;
	private float xOffset,yOffset,enemySpeed;

	public EnemyShip(float x, float y, int width, int height, boolean flag, BulletsManager bulletsManager) {
		super(x, y, width, height);
		enemyShip = LoadSave.GetSpriteAtlas(LoadSave.ENEMYSHIP_ATLUS);
		width = enemyShip.getWidth();
		height = enemyShip.getHeight();
		moveToRight = flag;
		this.bulletsManager = bulletsManager;
		xOffset = (float) Game.TILES_SIZE /2;
		enemySpeed =0.05f;

	}

	public void render(Graphics g) {
		//drawHitbox(g);
		g.drawImage(enemyShip, (int)(x+xOffset), (int)(y+yOffset),enemyShip.getWidth(),enemyShip.getHeight(), null);
	}
	/*-----This Method updating Movement of EnemyShip---------------*/
	public void update() {
		if (xOffset <= 0) {
			moveToRight = true;
		} else if (xOffset >= Game.TILES_SIZE){
			moveToRight = false;
		}

		if (moveToRight) {
			xOffset += 0.5f;
		} else {
			xOffset -= 0.5f;
		}
		// enemyShip Updation in YDirection
			//yOffset += enemySpeed;
	}

	/* This Method Checking collision of 'Bullet' with 'EnemyShip'  */
	 public boolean handleAttack() {
		for (int i=0;i<bulletsManager.getBullets().size();i++) {
			int px = bulletsManager.getBullets().get(i).getX();
			int py = bulletsManager.getBullets().get(i).getY();
			if (px>=x && px<(x+enemyShip.getWidth()+xOffset) && py>=y && py<y+enemyShip.getHeight()) {
				bulletsManager.getBullets().remove(i);
				return true;
			}
		}
		return false;
	}

}
