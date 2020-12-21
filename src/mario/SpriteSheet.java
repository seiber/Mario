package mario;

import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet=sheet;
		
	}
	
	//this method is going to crop the sprite sheet, into individual images that is capable of being loaded into our game
	public BufferedImage crop(int x, int y, int width, int height)
	{
		return sheet.getSubimage(x, y, width, height); 
	}

}
