package mario;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static BufferedImage santa1,santa2,tile,tree,grass,dirt;
	private static final int width=32,height=32;//width/height of spritesheet images
	
	
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		//crops an image from spritesheet, increment x value by 32 to grab different sprites
		santa1 = sheet.crop(0, 0, width, height);
		santa2 = sheet.crop(32, 0, width, height);
		tile = sheet.crop(64, 0, width, height);
		tree = sheet.crop(96, 0, width, height);
		grass = sheet.crop(128, 0, width, height);
		dirt = sheet.crop(160, 0, width, height);
		
	}
	
	
	
	
	
}
