package mario;

import java.awt.Graphics;

public class GameState extends State
{
	private Player player;
	private World world;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler,"res/textures/Worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,100,100);
		
		//game.getGameCamera().move(0,0);
	}

	
	public void tick()
	{	world.tick();
		player.tick();
		//game.getGameCamera().move(1, 1);
	}

	
	public void render(Graphics g)
	{
		world.render(g);
		//g.drawImage(Assets.tile, 0, 0, null);
		player.render(g);
		//Tile.tiles[0].render(g, 0, 0);
		
	}


}
