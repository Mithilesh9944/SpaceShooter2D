package levels;

import java.awt.*;
import java.util.ArrayList;

import entities.EnemyShip;
import spaceShooter.Game;
import utilz.Constants;

public class EnemyManager {
	private ArrayList<EnemyShip> enemyShips;
	private ArrayList<Point> arrayCoordinates;
	private BulletsManager bulletsManager;
	
	private int currentState[][];
	
	EnemyManager(BulletsManager bulletsManager) {
		enemyShips = new ArrayList<>();
		arrayCoordinates = new ArrayList<>();
		this.bulletsManager = bulletsManager;
		currentState = new int[Constants.EnemyConstants.EnemyLvlOneGrid.length][Constants.EnemyConstants.EnemyLvlOneGrid[0].length];
		initializeArray();
	}


	/*-------------  --------------*/
	private void initializeArray() {
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
	
	public void update() {
		for (int i=0;i<enemyShips.size();i++) {
			if (enemyShips.get(i).handleAttack()) {
				enemyShips.remove(i);
				currentState[arrayCoordinates.get(i).x][arrayCoordinates.get(i).y] = 0;
			}
		}

		for (int i=0;i<enemyShips.size();i++) {
			enemyShips.get(i).update();
		}
	}
	
	public void render(Graphics g) {
		for (int i=0;i<enemyShips.size();i++) {
			enemyShips.get(i).render(g);
		}
	}
}
