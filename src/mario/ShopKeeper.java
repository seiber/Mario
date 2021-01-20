package mario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ShopKeeper extends Creature
{
	private Animation idle;

	public ShopKeeper(Handler handler, float x, float y,int width, int height)
	{
	
		super(handler, x, y,width,height);
		idle = new Animation(500, Assets.shopKeeper);
		bounds.x=16;
		bounds.y=32;
		bounds.width=58;
		bounds.height=58;
	}


	public void tick() 
	{
		idle.tick();
	}

	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(),(int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		
	}
	
	
	//rotating shop keepers idle animation
	private BufferedImage getCurrentAnimationFrame()
	{
		return idle.getCurrentFrame();
	}
	
	public void die() 
	{
		
	}

}
