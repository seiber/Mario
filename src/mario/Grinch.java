package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Grinch extends Creature
{
	Rectangle boundingBox = new Rectangle();
	Rectangle grinch = new Rectangle();

	public Grinch(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		
		//creating grinch collision bounds
		bounds.x=16;
		bounds.y=32;
		bounds.width=20;
		bounds.height=32;
	}
	
	
	
	public void tick()
	{
		
			checkBounds();
			
	}
	
	
	public void createBounds()
	{
		//bounding box where grinch can wander
		boundingBox.setBounds(400,500,300,400);
				
		//our grinch character basically has an invisible rectangle surrounding him
		grinch.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
	}
	
	//checking the bounds to make sure grinch is in the correct location
	public int checkBounds()
	{	
		createBounds();
		
		// if the bonding box area and grinch intersect, grinch is in the proper wandering space
		if (boundingBox.contains(grinch))
		{
			//start walking with collision 
			
			randMovement();
		}
		
		//move to bounding box	
		else
		{		
				//move left
				if (xMove <0)
				{
					x++;
				}
	
			
				//move right
			if (xMove >0)
			{
				x++;
			}
		
			//moveToBoundingBox();
			System.out.println("not in bounds");
			
		}
		
		return 0;
		
	}
	
	public void render(Graphics g)
	{
			
		g.drawImage(Assets.grinch, (int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		g.drawRect(400,500,300,400);
		g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height);
		
	}



	
	public void die() 
	{
			System.err.println("Grinch down");
			handler.getWorld().getItemManager().addItem(Item.santaHat.createNew((int)x,(int)y));	
	}


	
}
