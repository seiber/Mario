package mario;

import java.awt.Graphics;

public abstract class Entity 
{
	//classes that extend this class can use these variables
	protected float x,y;
	
	public Entity( float x, float y)
	{
		this.x=x;
		this.y=y;
	}
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
			
}
