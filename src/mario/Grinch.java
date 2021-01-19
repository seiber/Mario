package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Grinch extends Creature
{
	
		
	private EnemyWanderBounds e1;
	private Rectangle grinch = new Rectangle();
	private boolean moveDown = true;
	
	

	public Grinch(Handler handler, float x, float y) 
	{
		super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		
		
		e1 = new EnemyWanderBounds(handler,400,500,400,200);
		
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
	
	//creating wandering box and grinch box
	public void createBounds()
	{
		//grinch box (getting x,y from where we create entity in world class)
		grinch.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
				
		//wandering box for grinch
		e1.createBounds();			
	}
	
	//checking the bounds to make sure grinch is in the correct location
	public void checkBounds()
	{	
			createBounds();
			System.out.println(grinch.getBounds());
			
		// if the bonding box area and grinch intersect, grinch is in the proper wandering space
		if (e1.boundingBox.contains(grinch))
		{
		
			//wander
		
		 if (x <= 769)
			{
			 
				x++;
				moveDown=false;
			}
			
			if(x >= 768 || x >= 769)
			{
					moveDown=true;
				
			}
		if(moveDown=true)
			{
				y++;
			}
			System.out.println("in bounds");
		}
	
		
		else
		{
			//x--;
			moveToBoundingBox();
		}
	}
	
	


	public void render(Graphics g)
	{
		
		//grinch
		g.drawImage(Assets.grinch, (int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		//grinch rectangle
		g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height);
		//testing box
		e1.render(g);
		
	}



	public void die() 
	{
			System.err.println("Grinch down");
			handler.getWorld().getItemManager().addItem(Item.santaHat.createNew((int)x,(int)y));	
	}

}
