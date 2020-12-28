package mario;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width=32,height=32;//width/height of spritesheet images
	
	
	public static BufferedImage santa1,santa2,tile,tree,grass,dirt,santaFemale,santaLeft,santaRight,santaUp;
	public static BufferedImage [] player_down,player_right,player_left,player_up;
	
	
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		
		player_down = new BufferedImage[2];
		player_down[0] = sheet.crop(192, 0, width, height);
		player_down[1] = sheet.crop(192, 0, width, height);
		
		player_right = new BufferedImage[2];
		player_right[0] = sheet.crop(256, 0, width, height);
		player_right[1] = sheet.crop(256, 0, width, height);
		
		player_left = new BufferedImage[2];
		player_left[0] = sheet.crop(224, 0, width, height);
		player_left[1] = sheet.crop(224, 0, width, height);
		
		player_up = new BufferedImage[2];
		player_up[0] = sheet.crop(288, 0, width, height);
		player_up[0] = sheet.crop(288, 0, width, height);
		
		
		
		//crops an image from spritesheet, increment x value by 32 to grab different sprites
		santa1 = sheet.crop(0, 0, width, height);
		santa2 = sheet.crop(32, 0, width, height);
		tile = sheet.crop(64, 0, width, height);
		tree = sheet.crop(96, 0, width, height);
		grass = sheet.crop(128, 0, width, height);
		dirt = sheet.crop(160, 0, width, height);
		santaFemale = sheet.crop(192, 0, width, height);
		santaLeft = sheet.crop(224, 0, width, height);
		santaRight = sheet.crop(256, 0, width, height);
		santaUp = sheet.crop(288, 0, width, height);
		
		
	}
	
	
	
	
	
}
