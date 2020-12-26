package mario;

import java.awt.Graphics;

public class Tree extends StaticEntity
{

	public Tree(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT *2);
		
	}

	public void tick()
	{
		
		
	}


	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int)(x-handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height, null);
	}

}
