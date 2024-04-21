package UI;

import spaceShooter.Game;

import java.awt.Graphics;
import java.awt.*;


public class Menu {
    protected int height =50;//Height of Box
    protected int width =200;
    protected Rectangle playButton = new Rectangle(Game.GAME_WIDTH/3+50, 250,width,height);
    protected Rectangle helpButton = new Rectangle(Game.GAME_WIDTH/3+50, 350,width,height);
    protected Rectangle quitButton = new Rectangle(Game.GAME_WIDTH/3+50, 450,width,height);
   public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
       Font font = new Font("arial", Font.BOLD, 50);
       g.setFont(font);
       g.setColor(Color.white);
       g.drawString("SpaceShooter2d",Game.GAME_WIDTH/4,100);

       Font font1 = new Font("arial", Font.BOLD,30);
       g.setFont(font1);
       g.drawString("Play", playButton.x+playButton.x/5,playButton.y+40);

        Font font2 = new Font("arial", Font.BOLD,30);
        g.setFont(font2);
        g.drawString("Help", helpButton.x+helpButton.x/5,helpButton.y+40);

        Font font3 = new Font("arial", Font.BOLD,30);
        g.setFont(font3);
        g.drawString("Quit", quitButton.x+quitButton.x/5,quitButton.y+40);

        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);


    }

    protected void Help(){
        System.out.println("\n----------------Thank You------------\n");
    }



}
