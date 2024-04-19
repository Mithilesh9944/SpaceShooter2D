package spaceShooter;

/*----------------Class for HandLing GamePanel---------------*/
import java.awt.Dimension;
import static spaceShooter.Game.GAME_HEIGHT;
import static spaceShooter.Game.GAME_WIDTH;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyBoardinputs;
import inputs.MouseInputs;


public class GamePanel extends JPanel {
	private MouseInputs mouseinputs;
	private Game game;

	public GamePanel(Game game) {
		mouseinputs=new MouseInputs(this);
	    this.game=game;
		setPanelsize();
	
		addKeyListener(new KeyBoardinputs(this));
		addMouseListener(mouseinputs);
		addMouseMotionListener(mouseinputs);
	}

	private void setPanelsize() {
		Dimension size=new Dimension(GAME_WIDTH,GAME_HEIGHT);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
		System.out.println("size: "+GAME_WIDTH +" : "+ GAME_HEIGHT);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
		
	}

	public Game getGame() {
		return game;
	}
}
