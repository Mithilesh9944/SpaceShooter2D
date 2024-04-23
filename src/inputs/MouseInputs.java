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
			if(yPos>= playButton.getY() && yPos<= playButton.getY()+height){
				Game.state = Game.gameState.GAME;
			}else if(yPos>=helpButton.getY() && yPos<= helpButton.getY()+height){
				Help();
				System.exit(1);
			}else if(yPos>=quitButton.getY() && yPos<= quitButton.getY()+height && Game.state==Game.gameState.MENU){
				System.exit(0);
			}else if(yPos>=quitButton.getY() && yPos<= quitButton.getY()+height && Game.state==Game.gameState.RESUME){
				Game.state =Game.gameState.MENU;
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
