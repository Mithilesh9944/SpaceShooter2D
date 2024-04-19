package entities;


import static utilz.Constants.PlayerConstants.IDLE;

import static utilz.Constants.PlayerConstants.RUNNING;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.BulletsManager;
import spaceShooter.Game;
import utilz.LoadSave;

public class Player extends Entity {


	//by Using Concept of abstraction-----> We declared Variables as private.
	private BufferedImage imgMain,img,subImg,smoke;
	private int PlayerAction=IDLE;
	private boolean up,down,right,left,flag;
	
	private BufferedImage[][] animation;
	private int aniTick,aniIndex,aniSpeed=10;
	private float playerSpeed = 4.0f;

	private BulletsManager bulletsManager;

	private boolean canShoot;
	private int bulletCooldown;
	private final int COOLDOWN = 50;
	
	
	
	
	public Player(float x, float y, int width, int height, BulletsManager bulletsManager) {
		super(x,y,width, height);
		loadAnimation();

		this.bulletsManager = bulletsManager;

		canShoot = true;
		bulletCooldown = 0;
		imgMain = LoadSave.GetSpriteAtlas(LoadSave.MAIN_PLAYER);
		
	}
	/*--------------------- Updating On Game Loop----------------------*/
	public void update() {
		updatePos();
		//updateHitbox();
		updateAnimationTick();
		setAnimation();
	    
		// updating position of bullets
		if (bulletCooldown == 0) {
			canShoot = true;
		} else {
			bulletCooldown--;
		}
	}
	
	
	//-----------For Rendering Main Rocket/Bullet-----------------//
	
	
	public void render(Graphics g) {
	 //  drawHitbox(g);
		g.drawImage(imgMain, (int)x, (int)y, imgMain.getHeight(),imgMain.getWidth(), null);//PlayerRocket
	  //g.drawImage(animation[PlayerAction][aniIndex], (int)x+29, (int)y+66, 45,60,null);//
	}

	//---------------------- For Update Rocket BackSide Fire By Indexing----------------//
  	public void updateAnimationTick() {
	aniTick++;
	if(aniTick>=aniSpeed) {
		aniTick=0;
		aniIndex++;
		if(aniIndex>=3)
			aniIndex =1;
		}
	}
  	
	private void setAnimation() {
		PlayerAction=RUNNING;
	}
		
	 // Class's Method ---->Player Rockets Positions of where it can't Move..
	private void updatePos() {
		if(!left && !right && !up && !down)
			return;
		if(left && !right) {
			x-=playerSpeed;
		}
		else if(right && !left) {
			x+=playerSpeed;
		}
		if(up && !down) {
			y-=playerSpeed;
		}
		else if(down && !up) {
			y+=playerSpeed;
		}

		/* ---------------Method For  Rocket Positions Updation/Limitation ---------------*/
		if(x<0)
			x=0;
		else if (x> Game.GAME_WIDTH-imgMain.getWidth())
			x= Game.GAME_WIDTH-imgMain.getWidth();
		if(y<600)
			y=600;
		else if (y> Game.GAME_HEIGHT-imgMain.getHeight())
			y = Game.GAME_HEIGHT-imgMain.getHeight();
		
	}

		

	/*---------------Animation of Rocket BackSide Fire ---------------------*/
	private void loadAnimation() {
		smoke=LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLUS);
		animation = new BufferedImage[2][3];
		for(int i=0;i<animation.length;i++) {
			for(int j=0;j<animation[i].length;j++) {
				animation[i][j]= smoke.getSubimage(j*190, i*200, 190, 200);
			}
		}
	}
	
	/*------------- Bullet Reload-----------------*/
	public void handleShoot() {
		if (canShoot) {
			bulletsManager.addBullet(x, y);
			canShoot = false;
			bulletCooldown = COOLDOWN;
		}
	}
	
	
	public void resetDirBooleans() {
		left=false;
		right=false;
		up=false;
		down=false;
	}
	
	/*-------------------Setter'S and Getter's--------------------------*/
	public Boolean getUp() {
		return up;
	}

	public void setUp(Boolean up) {
		this.up = up;
	}

	public Boolean getDown() {
		return down;
	}

	public void setDown(Boolean down) {
		this.down = down;
	}

	public Boolean getRight() {
		return right;
	}

	public void setRight(Boolean right) {
		this.right = right;
	}

	public Boolean getLeft() {
		return left;
	}

	public void setLeft(Boolean left) {
		this.left = left;
	}
}