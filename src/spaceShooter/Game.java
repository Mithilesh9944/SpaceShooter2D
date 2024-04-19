package spaceShooter;
/* Mainly In this Class We're Creating Game Loop.
 * And Deciding Size of Game's Height , Width.
 * This class will 
 * */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.LevelManager;
import utilz.LoadSave;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamepanel;
	private Thread gameThread;

	private final int FPS_SET=120;
	private final int UPS_SET=200;

	private LevelManager levelManager;
	private BufferedImage backGroundImage;
	
	public static final int TILES_DEFAULT_SIZE=80;
	public static final float SCALE=1.0f;
	public static final int TILES_IN_WIDTH=12;
	public static final int TILES_IN_HEIGHT=10;
	public static final int TILES_SIZE=(int)(TILES_DEFAULT_SIZE*SCALE);
	public static final int GAME_WIDTH=TILES_SIZE*TILES_IN_WIDTH;
	public static final int GAME_HEIGHT=TILES_SIZE*TILES_IN_HEIGHT;

	public Game() {
		initClasses();
		gamepanel=new GamePanel(this);
		gameWindow=new GameWindow(gamepanel);

		gamepanel.requestFocus();

		startGameLoop();
	}
	private void initClasses() {
		levelManager=new LevelManager(this);
	}

	private void startGameLoop() {
		gameThread=new Thread(this);
		gameThread.start();
	}

	public void run() {
		double timePerFrame=1000000000.0/FPS_SET;
		double timePerUpdate=1000000000.0/UPS_SET;
	
		long previousTime=System.nanoTime();
		int frames=0;
		int Updates=0;
		long lastcheck=System.currentTimeMillis();
		double deltaU=0;
		double deltaF=0;

		while(true) {
			long currentTime=System.nanoTime();
			deltaU+=(currentTime-previousTime)/timePerUpdate;
			deltaF+=(currentTime-previousTime)/timePerFrame;
			previousTime=currentTime;
			if(deltaU>=1) {
				update();
				Updates++;
				deltaU--;
			}

			if(deltaF>=1) {
				gamepanel.repaint();
				frames++;
				deltaF--;
			}
			
			if(System.currentTimeMillis()-lastcheck>=1000) {
				lastcheck=System.currentTimeMillis();
				System.out.println("FPS:"+frames+"  |  UPS:"+Updates);
				frames=0;
				Updates=0;
			}
		}
	}

	private void update() {
		levelManager.update();
	}
	public void render(Graphics g) {
		levelManager.draw(g);
	}
	public LevelManager getLevelManager() {
		return levelManager;
	}
}
