package levels;
/*-------------------Class For BackGround Images -------------------*/
import spaceShooter.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private BufferedImage bg;

    Background() {
        bg = LoadSave.GetSpriteAtlas("space2.jpg");
    }

    void render(Graphics g) {
        for (int i=0;i<Game.GAME_WIDTH;i+=bg.getWidth()) {
            for (int j=0;j<Game.GAME_HEIGHT;j+=bg.getHeight()) {
                g.drawImage(bg, i, j, null);
            }
        }
    }
}
