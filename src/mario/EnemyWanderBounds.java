package mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyWanderBounds extends Creature
{
	private int height,width;
	

	Rectangle boundingBox1 = new Rectangle();
	Rectangle boundingBox2 = new Rectangle();
	Rectangle boundingBox3 = new Rectangle();
	Rectangle boundingBox4 = new Rectangle();

	public EnemyWanderBounds(Handler handler, float x, float y, int width, int height)
	{
		
		super(handler, x, y, width, height);
		this.width=width;
		this.height=height;
	
	}
	
	//bounding box where enemy can wander
	public void createBounds(float x, float y, int width, int height)
	{
		
			
		

		boundingBox1.setBounds((int)x,(int)y,width,height);
		//boundingBox2.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),470,500);
		//boundingBox2.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),70,70);
//		boundingBox3.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),400,70);
//		boundingBox4.setBounds((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),270,70);
	
	}

	

	public void tick() 
	{
		
		
	}

	
	public void render(Graphics g)
	{
	
				//start box 1
				g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),70,70);
			
			
				//end box 2
				//g.drawRect(400,500,500,70);
				
				//box3
				//g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),10,10);
				
				//box4
				//g.drawRect((int)(x-handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),25,25);
				
		
	}

	
	public void die()
	{
		
		
	}
}