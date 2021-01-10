package mario;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width=32,height=32;//width/height of spritesheet images
	
	
	public static BufferedImage tree,dirtTile,santaHat,christmasTree,stoneTile,snowTile,snowTree,present,grinch,inventoryScreen,creature,musicOn,musicOff;
	public static BufferedImage [] player_down,player_right,player_left,player_up,start, attack_right,attack_left,idle,music,music1,controls,quit,back;
	public static Font font28;
	
	
	
	public static void init()
	{
		
		font28 = FontLoader.loadFont("Res/textures/fonts/slkscr.ttf",28);
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/creaturespritesheet.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/musicspritesheet.png"));
		inventoryScreen =(ImageLoader.loadImage("/textures/inventoryspritesheet.png"));
	
		
		
		//music start button
		music = new BufferedImage[2];
		music[0] = sheet3.crop(0, 0, width, height);
		music[1] = sheet3.crop(0, 0, width, height);
		
		//music stop
		music1 = new BufferedImage[2];
		music1[0] = sheet3.crop(32, 0, width, height);
		music1[1] = sheet3.crop(32, 0, width, height);
		
		
		//back button
		back = new BufferedImage[2];
		back[0] = sheet.crop(896, 0, width, height);
		back[1] = sheet.crop(928, 0, width, height);
		
		//creature animations
		grinch = sheet2.crop(0, 0, width, height);
		
		
		
		//Sprite attack animations
		attack_right = new BufferedImage[2];
		attack_right[0] = sheet.crop(320, 0, width, height);
		attack_right[1] = sheet.crop(352, 0, width, height);
		
		attack_left = new BufferedImage[2];
		attack_left[0] = sheet.crop(704, 0, width, height);
		attack_left[1] = sheet.crop(736, 0, width, height);
		
		//Sprite movement animations
		
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
		
					//buttons
		
					//start button
		start = new BufferedImage[2];
		start[0] = sheet.crop(384, 0, width, height);
		start[1] = sheet.crop(416, 0, width, height);
		
					//control button
		controls = new BufferedImage[2];
		controls[0] = sheet.crop(768, 0, width, height);
		controls[1] = sheet.crop(800, 0, width, height);
				
					//quit button
		quit = new BufferedImage[2];
		quit[0] = sheet.crop(832, 0, width, height);
		quit[1] = sheet.crop(864, 0, width, height);
		
		
				
		
		
		
		//crops an image from spritesheet, increment x value by 32 to grab different sprites
		santaHat = sheet.crop(96, 0, width, height);	
		christmasTree = sheet.crop(512, 0, width, height);
		dirtTile = sheet.crop(544, 0, width, height);
		stoneTile = sheet.crop(576, 0, width, height);
		snowTile = sheet.crop(608, 0, width, height);
		snowTree = sheet.crop(640, 0, width, height);
		present = sheet.crop(672, 0, width, height);
		
		
		
	}
	
	
	
	
	
}
