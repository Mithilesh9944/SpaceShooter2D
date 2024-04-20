package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//Class for load the images.....
public class LoadSave {
	
	public static final String UI_BACK_G = "bg.png";
	public static final String  UI_TABLE = "menu_background.png";
	public static final String  UI_BUTTON= "button_atlas.png";
	public static final String BACKG_ATLUS= "black.png";
	public static final String BULLETS_ATLUS= "bullet - Copy.png";
	public static final String ENEMYSHIP_ATLUS = "greenbat.png";
	public static final String MAIN_PLAYER = "player.png";

	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage imgs=null;

		InputStream it=LoadSave.class.getResourceAsStream("/"+fileName);
		try {
			 imgs = ImageIO.read(it);
			}
		 catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				it.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return imgs;
	}

}