package levels;
/*
  This class is Managing EnemyShip's positions , collision with bullet .
*/
import java.awt.*;
import java.util.ArrayList;

import entities.EnemyShip;
import spaceShooter.Game;
import utilz.Constants;

public class EnemyManager {
	private ArrayList<EnemyShip> enemyShips;//Container for EnemyShip.
	private ArrayList<Point> arrayCoordinates;//Container for Coordinates.
	private BulletsManager bulletsManager;
	private int maxLevel= 2;
	private  int currentLevelEnemy ;
	private int LevelOneCountDown =18;//LevelOneCountDown.
	private int LevelTwoCountDown = 23;
	private int currentState[][];//for current Executing Level.

	/*----------Object Instantiation----------*/
	EnemyManager(BulletsManager bulletsManager) {
		enemyShips = new ArrayList<>();
		arrayCoordinates = new ArrayList<>();
		this.bulletsManager = bulletsManager;
		LevelOne();
	}


	/*-------------Level -1 --------------*/
	private void LevelOne() {
		currentLevelEnemy=LevelOneCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlOneGrid.length][Constants.EnemyConstants.EnemyLvlOneGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlOneGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlOneGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlOneGrid[i-1][j-1] == 1) {
					currentState[i-1][j-1] = Constants.EnemyConstants.EnemyLvlOneGrid[i-1][j-1];
					if (i%2 == 0) {
						EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 0, 0, true, bulletsManager);
						enemyShips.add(e);
						arrayCoordinates.add(new Point(i-1, j-1));
					} else {
						EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 0, 0, false, bulletsManager);
						enemyShips.add(e);
						arrayCoordinates.add(new Point(i-1, j-1));
					}
				}
			}
		}
	}
	private void LevelTwo() {
		currentLevelEnemy=LevelTwoCountDown;
		currentState = new int[Constants.EnemyConstants.EnemyLvlTwoGrid.length][Constants.EnemyConstants.EnemyLvlTwoGrid[0].length];
		for (int i=1;i<=Constants.EnemyConstants.EnemyLvlTwoGrid.length;i++) {
			for (int j=1;j<=Constants.EnemyConstants.EnemyLvlTwoGrid[0].length;j++) {
				if (Constants.EnemyConstants.EnemyLvlTwoGrid[i-1][j-1] == 1) {
					currentState[i-1][j-1] = Constants.EnemyConstants.EnemyLvlTwoGrid[i-1][j-1];
					EnemyShip e = new EnemyShip(Game.TILES_SIZE*j, Game.TILES_SIZE*i, 0, 0, true, bulletsManager);

					enemyShips.add(e);
					arrayCoordinates.add(new Point(i-1, j-1));
				}
			}
		}
	}
	
	public void update() {
		for (int i=0;i<enemyShips.size();i++) {
			if (enemyShips.get(i).handleAttack()) {
				enemyShips.remove(i);//
				currentLevelEnemy-=1;//Count Down For current State.
				if( currentLevelEnemy==0){ updateLevel(); }
				currentState[arrayCoordinates.get(i).x][arrayCoordinates.get(i).y] = 0;

			}
		}

		for (int i=0;i<enemyShips.size();i++) {
			enemyShips.get(i).update();
		}
	}

	private void updateLevel() {
		if(--maxLevel==0){System.exit(0);}
		else LevelTwo();
	}

	public void render(Graphics g) {
		for (int i=0;i<enemyShips.size();i++) {
			enemyShips.get(i).render(g);
		}
	}
}
