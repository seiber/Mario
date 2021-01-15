package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyWanderBounds extends Creature
{
	
	Rectangle boundingBox1 = new Rectangle();
	Rectangle boundingBox2 = new Rectangle();
	Rectangle boundingBox3 = new Rectangle();
	Rectangle boundingBox4 = new Rectangle();

	public EnemyWanderBounds(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
	
	}

	public void createBounds()
	{
		
			
		//bounding box where grinch can wander
		boundingBox1.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),70,70);
		boundingBox2.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),70,70);
		boundingBox3.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),400,70);
		boundingBox4.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),270,70);
	
	}

	

	public void tick() 
	{
		
		
	}

	
	public void render(Graphics g)
	{
	
				//start box 1
				g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),70,70);
				//g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),300,400);
				//end box 2
				g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),70,70);
				//box3
				g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),400,70);
				//box4
				g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),270,70);
				
		
	}

	
	public void die()
	{
		
		
	}
}
