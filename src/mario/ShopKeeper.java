package mario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ShopKeeper extends Creature
{
	private Animation idle;
	private EnemyWanderBounds e1;
	private Player player;

	public ShopKeeper(Handler handler, float x, float y,int width, int height)
	{
	
		super(handler, x, y,width,height);
		player = new Player(handler, x, y);
		idle = new Animation(500, Assets.shopKeeper);
		bounds.x=16;
		bounds.y=32;
		bounds.width=58;
		bounds.height=58;
		e1 = new EnemyWanderBounds(handler,(int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
		
	}

	//check to see if player is in shop keeper trade range
	public void checkRange()
	{
		player.getR().setBounds(1130,450,64,64);
		e1.createBounds();
		if(e1.boundingBox.contains(player.getR()));
		{
			
			System.out.println(player.getR()+" " + e1.boundingBox);
			//System.out.println("player in range");
		}
		
	}

	public void tick() 
	{
		checkRange();
		idle.tick();
	}

	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(),(int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		e1.render(g);
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
