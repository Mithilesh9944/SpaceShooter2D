package inputs;

import java.awt.event.KeyEvent;

import spaceShooter.GamePanel;
import java.awt.event.KeyListener;

public class KeyBoardinputs implements KeyListener {

	 private GamePanel gamePanel;
	 public KeyBoardinputs(GamePanel gamePanel) {
		 this.gamePanel=gamePanel;
	 }

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			   gamePanel.getGame().getLevelManager().getPlayer().setUp(true);
			   break;
	    case KeyEvent.VK_A:
	    	   gamePanel.getGame().getLevelManager().getPlayer().setLeft(true);
	    	   break;
        case KeyEvent.VK_S:
        	   gamePanel.getGame().getLevelManager().getPlayer().setDown(true);
        	   break;
        case KeyEvent.VK_D:
	            gamePanel.getGame().getLevelManager().getPlayer().setRight(true);
		        break;
        case KeyEvent.VK_SPACE:
        		gamePanel.getGame().getLevelManager().getPlayer().handleShoot();
        		break;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			   gamePanel.getGame().getLevelManager().getPlayer().setUp(false);
			   break;
	    case KeyEvent.VK_A:
	    	   gamePanel.getGame().getLevelManager().getPlayer().setLeft(false);
	    	   break;
        case KeyEvent.VK_S:
        	   gamePanel.getGame().getLevelManager().getPlayer().setDown(false);
        	   break;
        case KeyEvent.VK_D:
            gamePanel.getGame().getLevelManager().getPlayer().setRight(false);
	        break;
        case KeyEvent.VK_SPACE:
    		gamePanel.getGame().getLevelManager().getPlayer().handleShoot();
    		break;
       
		}
	}
}
