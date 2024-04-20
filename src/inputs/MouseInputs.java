package inputs;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.Menu;
import spaceShooter.Game;
import spaceShooter.GamePanel;

public class MouseInputs extends Menu implements MouseListener ,MouseMotionListener {

	private GamePanel gamePanel;
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel=gamePanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int xPos = e.getX();
		int yPos = e.getY();
		//For PlayButton
		if(xPos>= Game.GAME_WIDTH/3+height && xPos <=Game.GAME_WIDTH+width){
			if(yPos>=250 && yPos<= 300){
				Game.state = Game.gameState.GAME;
			}else if(yPos>=350 && yPos<=400){
				Help();
				System.exit(1);
			}else if(yPos>=450 && yPos<=500){
				System.exit(0);
			}

		}




		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
