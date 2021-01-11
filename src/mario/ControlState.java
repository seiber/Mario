package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class ControlState extends State
{
		//private Rectangle rectangle;
		private UIManager uiManager;
	
	
	public ControlState(Handler handler) 
	{
		super(handler);
		
		uiManager = new UIManager(handler);
		
		//rectangle = new Rectangle();
		
	
		handler.getMouseManager().setUIManager(uiManager);
		
		
		
		uiManager.addObject(new UIImageButton(30,490,80,50,Assets.back,new ClickListener() 
		{	
			
			public void onClick() 
			{	
				

				State.setState(handler.getGame().setNewmenuState(handler.getGame().menuState));
				
			}
			
	}));
	}
	
	
	public void drawUserControls(Graphics g)
	{
		String movement = "Character movement: (w,a,s,d)";
		String attack = "Attacks: HOLD (left arrow) to throw a left punch, (right arrow) to throw a snowball";
		String inventory = "Inventory: press (e) to toggle, and use (up) or (down) arrow keys to scroll through the inventory";
		String gamePlay = "How to play: Collect items from killing trees, or Grinch (make sure you are close enough to the target!)";
		
		g.setColor(Color.MAGENTA);
		g.drawString(gamePlay, 230, 200);
		g.drawString(movement, 230, 250);
		g.drawString(attack, 230, 300);
		g.drawString(inventory, 230, 350);
	
		
	}
	
	public void tick() 
	{

			uiManager.tick();
	}

	
	public void render(Graphics g) 
	{
		uiManager.render(g);
		drawUserControls(g);
	}

}
