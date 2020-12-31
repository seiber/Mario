package mario;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width=32,height=32;//width/height of spritesheet images
	
	
	public static BufferedImage tree,dirtTile,santaHat,christmasTree,stoneTile,snowTile,snowTree,present;
	public static BufferedImage [] player_down,player_right,player_left,player_up, btn_start, attack_right,idle;
	public static BufferedImage inventoryScreen;
	
	
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		
		inventoryScreen =(ImageLoader.loadImage("/textures/inventorysheet.png"));
		
		
		
		//Sprite attack animations
		attack_right = new BufferedImage[2];
		attack_right[0] = sheet.crop(320, 0, width, height);
		attack_right[1] = sheet.crop(352, 0, width, height);
		
		//Sprite animations
		
		idle = new BufferedImage[3];
		idle[0] = sheet.crop(0, 0, width, height);
		idle[1] = sheet.crop(32, 0, width, height);
		idle[2] = sheet.crop(64, 0, width, height);
		
		player_down = new BufferedImage[2];
		player_down[0] = sheet.crop(448, 0, width, height);
		player_down[1] = sheet.crop(480, 0, width, height);
		
		player_left = new BufferedImage[2];
		player_left[0] = sheet.crop(128, 0, width, height);
		player_left[1] = sheet.crop(160, 0, width, height);
		
		player_right = new BufferedImage[2];
		player_right[0] = sheet.crop(192, 0, width, height);
		player_right[1] = sheet.crop(224, 0, width, height);
		
		player_up = new BufferedImage[2];
		player_up[0] = sheet.crop(256, 0, width, height);
		player_up[1] = sheet.crop(288, 0, width, height);
		
		//button animations
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(384, 0, width, height);
		btn_start[1] = sheet.crop(416, 0, width, height);
		
		
		
		//crops an image from spritesheet, increment x value by 32 to grab different sprites
		santaHat = sheet.crop(96, 0, width, height);	
		christmasTree = sheet.crop(512, 0, width, height);
		dirtTile = sheet.crop(544, 0, width, height);
		stoneTile = sheet.crop(576, 0, width, height);
		snowTile = sheet.crop(608, 0, width, height);
		snowTree = sheet.crop(640, 0, width, height);
		present = sheet.crop(672, 0, width, height);
		
		//inventory sprite sheet
		//inventoryScreen = sheet.crop(32, 0, width, height);
		
	}
	
	
	
	
	
}
