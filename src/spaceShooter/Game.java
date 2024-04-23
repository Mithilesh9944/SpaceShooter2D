package spaceShooter;
/*      Mainly In this Class We're Creating Game Loop.
 *      And Deciding Size of Game's Height , Width.
 *      This class will.
  */
import java.awt.*;
import java.awt.image.BufferedImage;

import UI.Menu;
import UI.Resume;
import levels.LevelManager;
import utilz.LoadSave;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamepanel;
	private Thread gameThread;
	private LevelManager levelManager;
	private BufferedImage backGroundImage;
	private Menu menu;
	private Resume resume;



	private final int FPS_SET=120;//Frames Per Second To Render Images.
	private final int UPS_SET=200;//Update Per Second To Update Game Entities.




	/*-------------Instance Variables for Deciding Game Window-------------*/
	public static final int TILES_DEFAULT_SIZE=80;//One Tiles Size.
	public static final float SCALE=1.04f;//Scales
	public static final int TILES_IN_WIDTH=12;// Each Tiles width
	public static final int TILES_IN_HEIGHT=10;// Each Tiles Height.
	public static final int TILES_SIZE=(int)(TILES_DEFAULT_SIZE*SCALE);//Actual Size of Tiles.
	public static final int GAME_WIDTH=TILES_SIZE*TILES_IN_WIDTH;// Game Window Width.
	public static final int GAME_HEIGHT=TILES_SIZE*TILES_IN_HEIGHT;//Game Window Height.



	/*
		----------------Enum for Game States---------------
	 enum --->	Java, an enum, short for enumeration, is a special data type used to define a set of named constants.
	          	These constants represent a fixed number of possible values for a variable.
	          	enum is a special 'class' that represents a group of constants (enumerated values).
	*/
	public enum gameState{MENU, GAME,RESUME,NEXT};//Constants for Game Modes.
	public static gameState state = gameState.MENU;//Initially Game Mode is MENU.

	/*--------------------Constructor---------------------*/
	public Game() {
		initClasses();// For instantiating Objects.
		gamepanel=new GamePanel(this);//To Make GamePanel
		gameWindow=new GameWindow(gamepanel);//To create GameWindow
		gamepanel.requestFocus();//focus of Game Panel.

		startGameLoop();// Starting Game Loop.
	}

	private void initClasses() {
		backGroundImage = LoadSave.GetSpriteAtlas(LoadSave.UI_BACK_G);// For Menu BackGround.
		menu = new Menu();//To Load Menu UI.
		resume = new Resume();
		levelManager=new LevelManager(this);// Calling Other Functionality of Game Which is Next of Our Game-Flow.
	}

	/*-----------------Creating & Starting Thread For Game---------------*/
	private void startGameLoop() {
		gameThread=new Thread(this);//Creating Object of Thread
		gameThread.start();//Starting & Creating Thread.
	}


	/*-------------Game Loop-------------*/
	public void run() {
		double timePerFrame=1000000000.0/FPS_SET;//Frame Per Second---->120fps
		double timePerUpdate=1000000000.0/UPS_SET;//Update Per Second---->200ups.
	
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

	/*--------------Update Method, Which is responsible for all updates in Game-------*/
	private void update() {
		//Condition Checking for Game State.
		if (state == gameState.GAME) {
			levelManager.update();//levelManager Which is Resposible for All other Steps of Game.
		} else if (state == gameState.RESUME) {

		}
	}

	/*render() ---> often relates to graphical user interfaces (GUIs) and involves drawing components or graphics onto the screen....*/
	/*Note----> drawing is a part of rendering, but rendering involves a broader set of processes beyond just drawing individual elements.*/
	public void render(Graphics g) {
		g.drawImage(backGroundImage,0,0,null);//drawIng UI BackGroundImage.
		//Condition is For Game States,According to Condition it'll call render()/draw() of that class
		if(state == gameState.GAME) {
			levelManager.draw(g);//Calling LevelManagers Draw(g) to render.
		}else if (state == gameState.MENU){
			menu.render(g);//Calling Menu render(g)

		}else if(state==gameState.RESUME){
			resume.render(g);
		}

	}

	/*------------Encapsulations (private fields with public getters/setter)---------------*/
	public LevelManager getLevelManager() {
		return levelManager;
	}
}
