package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//Class for load the images.....
public class LoadSave {
	/*We are Loading image's name into String Variable.we Declared as "Static & final so that it can be directly accessed and Can't be changed further  "*/
	public static final String UI_BACK_G = "bg.png";
	public static final String  UI_TABLE = "menu_background.png";
	public static final String  UI_BUTTON= "button_atlas.png";
	public static final String BACKG_ATLUS= "black.png";
	public static final String BULLETS_ATLUS= "bullet - Copy.png";
	public static final String ENEMYSHIP_ATLUS = "greenbat.png";
	public static final String MAIN_PLAYER = "player.png";


	/*Method to Upload */
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage imgs=null;

		/*InputStream--> is used to obtain an InputStream for reading a resource file from the classpath.*/

		InputStream it=LoadSave.class.getResourceAsStream("/"+fileName);

		/*ImageIO.read().--> This code block is attempting to read an image from the InputStream obtained earlier. */
		try {
			 imgs = ImageIO.read(it);
			}
		 catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			/*this block is used to catch any IOException that might occur during the closing of the stream.*/
			try {
				it.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return imgs;
	}

}