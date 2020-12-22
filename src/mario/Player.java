package mario;

import java.awt.Graphics;

public class Player extends Creature
{
	private Game game;
	
	public Player(Game game, float x, float y) 
	{
		super(x, y);
		this.game=game;
	}


	public void tick()
	{
		if(game.getKeyManager().up)
		{
			y-=3;
		}
		if(game.getKeyManager().down)
		{
			y+=3;
		}
		if(game.getKeyManager().left)
		{
			x-=3;
		}
		if(game.getKeyManager().right)
		{
			x+=3;
		}
		
	}

	
	public void render(Graphics g) 
	{
		//type casting x,y to ints from orginial protected floats that extended from Entity class.
		g.drawImage(Assets.santa1,(int)x,(int)y,null);
		
	}
	
	

}
