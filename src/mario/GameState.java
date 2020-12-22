package mario;

import java.awt.Graphics;

public class GameState extends State
{
	private Player player;
	
	public GameState()
	{
		player = new Player(100,100);
	}

	
	public void tick()
	{	
		player.tick();
	}

	
	public void render(Graphics g)
	{
		g.drawImage(Assets.tile, 0, 0, null);
		player.render(g);
		
	}


}
