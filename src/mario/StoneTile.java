package mario;

import java.awt.image.BufferedImage;

public class StoneTile extends Tile
{

	public StoneTile(int id) 
	{
		super(Assets.stoneTile, id);
		
	}
	@Override
	public boolean isSolid()//makes it so character cannot walk on a solid entity
	{
		return true;
	}

}
