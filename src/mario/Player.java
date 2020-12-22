package mario;

import java.awt.Graphics;

public class Player extends Creature
{

	public Player(float x, float y) 
	{
		super(x, y);
		
	}


	public void tick()
	{
		
		
	}

	
	public void render(Graphics g) 
	{
		//type casting x,y to ints from orginial protected floats that extended from Entity class.
		g.drawImage(Assets.santa1,(int)x,(int)y,null);
		
	}
	
	

}
