package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Player extends Creature
{

	private Animation animDown,animLeft,animRight,animUp,attackRight,idle;
	
	//attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) 
	{
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x=16;
		bounds.y=32;
		bounds.width=20;
		bounds.height=32;

			//in miliseconds 500 = half sec
			//movement animations
		
		animUp =new Animation(400,Assets.player_up);
		animDown = new Animation(400,Assets.player_down);
		animLeft = new Animation(300, Assets.player_left);
		animRight = new Animation(300,Assets.player_right);
		idle = new Animation(500,Assets.idle);
		//attacking animations (arrow keys)
		attackRight = new Animation(500,Assets.attack_right);
		inventory = new Inventory(handler);
		
	
	}


	public void tick()
	{
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		attackRight.tick();
		idle.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		checkAttacks();
		inventory.tick();
	}
	
	
	private void checkAttacks()
	{
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if (attackTimer < attackCooldown)
		{
			return;
		}
		//attack rectangle
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		
		
		if (handler.getKeyManager().aUp)
		{
			ar.x = cb.x + cb.width /2 - arSize/2;
			ar.y = cb.y - arSize;
		}
		else if(handler.getKeyManager().aDown)
		{
			ar.x = cb.x + cb.width /2 - arSize/2;
			ar.y = cb.y + cb.height;
		}
		else if (handler.getKeyManager().aLeft)
		{
			ar.x =cb.x - arSize;
			ar.y = cb.y + cb.height /2 -arSize /2;
		}
		else if (handler.getKeyManager().aRight)
		{
			ar.x =cb.x + cb.width;
			ar.y = cb.y + cb.height /2 -arSize /2;
		}
		else
		{
			return;
		}
		
		attackTimer = 0;
		
		for (Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			//excluding the player from the entity list to just continue if the entity is our player, so we dont damage ourselves
			if (e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar))
			{
				e.hurt(1);
				return;
			}
		}
	}
	
	private void getInput()
	{
		xMove=0;
		yMove=0;
		
		
		if(handler.getKeyManager().up)
		{
			yMove=-speed;
		}
		
		if(handler.getKeyManager().down)
		{
			yMove=speed;
		}
		
		if(handler.getKeyManager().left)
		{
			xMove=-speed;
		}
		if(handler.getKeyManager().right)
		{
			xMove=speed;
		}
	
	}

	
	public void render(Graphics g) 
	{
		//type casting x,y to ints from orginial protected floats that extended from Entity class.
	
	
		g.drawImage(getCurrentAnimationFrame(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width, height, null);
		inventory.render(g);
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width,bounds.height);
		
		
	}
	
	public Inventory getInventory() 
	{
		return inventory;
	}


	public void setInventory(Inventory inventory) 
	{
		this.inventory = inventory;
	}


	private BufferedImage getCurrentAnimationFrame()
	{
		if (xMove < 0)
		{
			return animLeft.getCurrentFrame();
		}
		
		else if (handler.getKeyManager().aRight)
		{
			return attackRight.getCurrentFrame();
		}
		else if (xMove > 0)
		{
			return animRight.getCurrentFrame();
		}
		else if (yMove < 0)
		{
			return animUp.getCurrentFrame();
		}
		else if(handler.getKeyManager().down)
		{
			return animDown.getCurrentFrame();
		}
		else
		{
			return idle.getCurrentFrame();
		}
		
		//return animDown.getCurrentFrame();
	}



	public void die() 
	{
		System.out.println("die");
		
	}
	
	

}
