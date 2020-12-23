package mario;

import java.awt.image.BufferedImage;

public class RockTile extends Tile
{

	public RockTile(int id)
	{
		super(Assets.tree,id);
		
	}
	
	@Override
	public boolean isSolid()//makes it so character cannot walk on a solid entity
	{
		return true;
	}
}
