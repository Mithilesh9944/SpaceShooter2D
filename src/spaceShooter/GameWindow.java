package spaceShooter;

/*-------------------- Visibility GameWindow -------------------*/

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;
	public GameWindow(GamePanel gamepanel) {
		jframe= new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamepanel);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);
		jframe.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowGainedFocus(WindowEvent e) {
				
				
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				gamepanel.getGame().getLevelManager().windowFocusLost();
				
			}
		});
	}
}
