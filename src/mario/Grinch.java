package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Grinch extends Creature
{
	
		
	private EnemyWanderBounds e1;
	private Rectangle grinch = new Rectangle();
	
	

	public Grinch(Handler handler, float x, float y) 
	{
		super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		
		e1 = new EnemyWanderBounds(handler,400,500,400,200);
		e1.createBounds();
		
		//grinch wander range
		grinch.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
		
		
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
	
	//checking the bounds to make sure grinch is in the correct location
	public void checkBounds()
	{	
	
				//wander box
				e1.createBounds();
				System.out.println(e1.getCollisionBounds(x, y));
	
		// if the bonding box area and grinch intersect, grinch is in the proper wandering space
		if (e1.boundingBox.contains(grinch))
		{	//wander
			//y-=65;
			x++;
			System.out.println("in bounds");
		}
		
	
//		else
//		{
//			moveToBoundingBox();
//		}
	}
	
	


	public void render(Graphics g)
	{
		
		//grinch
		g.drawImage(Assets.grinch, (int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		//grinch rectangle
		g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height);
		
		e1.render(g);
		//e2.render(g);
		
	}



	public void die() 
	{
			System.err.println("Grinch down");
			handler.getWorld().getItemManager().addItem(Item.santaHat.createNew((int)x,(int)y));	
	}

}
