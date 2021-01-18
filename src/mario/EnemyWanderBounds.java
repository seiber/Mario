package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyWanderBounds extends Creature
{
	private int height,width;
	

	Rectangle boundingBox = new Rectangle();

	public EnemyWanderBounds(Handler handler, float x, float y, int width, int height)
	{
		
		super(handler, x, y, width, height);
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;

	
	}
	
	//bounding box where enemy can wander
	public void createBounds()
	{
		boundingBox.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
	
	}

	

	public void tick() 
	{
		
		
	}

	
	public void render(Graphics g)
	{
				//start box 1
			
				g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),width,height);
	}

	
	public void die()
	{
		
		
	}
}