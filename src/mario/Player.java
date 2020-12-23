package mario;

import java.awt.Graphics;

public class Player extends Creature
{
	private Game game;
	
	public Player(Game game, float x, float y) 
	{
		super(x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.game=game;
	}


	public void tick()
	{
		getInput();
		move();
	}
	
	private void getInput()
	{
		xMove=0;
		yMove=0;
		
		
		if(game.getKeyManager().up)
		{
			yMove=-speed;
		}
		
		if(game.getKeyManager().down)
		{
			yMove=speed;
		}
		
		if(game.getKeyManager().left)
		{
			xMove=-speed;
		}
		if(game.getKeyManager().right)
		{
			xMove=speed;
		}
	}

	
	public void render(Graphics g) 
	{
		//type casting x,y to ints from orginial protected floats that extended from Entity class.
		g.drawImage(Assets.santa1,(int)x,(int)y, width, height, null);
		//g.drawImage(Assets.dirt,(int)x,(int)y, width, height, null);
		
	}
	
	

}
