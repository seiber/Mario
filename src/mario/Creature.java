package mario;

import java.util.Random;

public abstract class Creature extends Entity
{
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32; //pixel height/width
	private Random rand;
	

	protected float speed;
	protected float xMove, yMove;
	
	
	public Creature(Handler handler,float x, float y,int width, int height) 
	{
		super(handler,x, y,width,height);
			
		rand = new Random();
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
		
	}
	
	public void moveToBoundingBox()
	{
		x=400;
		y=500;
	//	move();
	}
	
	//creating random enemy movement patterns
	public void randMovement()
	{		
			//need to include negatives for up y movement and left x movement
			//xMove = rand.nextInt(1+1)-1;// max = 5; min = -5;
			//yMove = rand.nextInt(1+1)-1;// max = 30; min = -10;
		
		//if statment to keep randomizing until they both match up
			xMove=0.5f;
			yMove=0.5f;
			move();	
	}
	
	public void move()
	{
		if(!checkEntityCollisions(xMove,0f))
		moveX();
		if(!checkEntityCollisions(0f,yMove))
		moveY();
		
	}
	
	public void moveX()
	{
		//moving right
		if (xMove >0)
		{
			int tx = (int) (x+xMove + bounds.x + bounds.width) / Tile.TILEWIDTH; //divide by Tile.TILEWIDTH to go from pixels to tiles
		
			if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILEHEIGHT)&&//checking the upper right corner of character bounds while moving right 
					!collisionWithTile(tx,(int)(y+ bounds.y + bounds.height)/Tile.TILEHEIGHT))//checking the bottom right corner of character bounds while moving right 
			{
				x+=xMove;
			}
			
			else
			{
				x = tx * Tile.TILEWIDTH - bounds.x-bounds.width-1;
			}
		}
		//moving left
		else if (xMove <0)
		{
			int tx = (int) (x+xMove + bounds.x ) / Tile.TILEWIDTH; //divide by Tile.TILEWIDTH to go from pixels to tiles
			
			if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILEHEIGHT)&&//checking the upper left corner of character bounds while moving right 
					!collisionWithTile(tx,(int)(y+ bounds.y + bounds.height)/Tile.TILEHEIGHT))//checking the bottom left corner of character bounds while moving right 
			{
				x+=xMove;
			}
			else
			{
				x=tx * Tile.TILEWIDTH + Tile.TILEWIDTH;
				
			}
		}
	}

	public void moveY()
	{
		if (yMove < 0) // moving up
		{
			int ty = (int) (y + yMove+bounds.y)/Tile.TILEHEIGHT; // gets top edge of bounds
			if (!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH,ty)&&
					!collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH,ty))
			{
				y+=yMove;
			}
			else
			{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if (yMove >0) //moving down
		{
			int ty = (int) (y + yMove+bounds.y + bounds.height)/Tile.TILEHEIGHT; // gets lower edge of bounds
			if (!collisionWithTile((int)(x + bounds.x)/Tile.TILEWIDTH,ty)&&
					!collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILEWIDTH,ty))
			{
				y+=yMove;
			}
			else 
			{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height -1;
			}
		}
	}
	
	//check for solid tile collision such as a Stone tile
	protected boolean collisionWithTile(int x, int y)
	{
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	public float getxMove() 
	{
		return xMove;
	}


	public void setxMove(float xMove) 
	{
		this.xMove = xMove;
	}


	public float getyMove() 
	{
		return yMove;
	}


	public void setyMove(float yMove)
	{
		this.yMove = yMove;
	}


	public int getHealth()
	{
		return health;
	}


	public void setHealth(int health)
	{
		this.health = health;
	}


	public float getSpeed() 
	{
		return speed;
	}


	public void setSpeed(float speed) 
	{
		this.speed = speed;
	}

}
