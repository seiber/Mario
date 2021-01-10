package mario;

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
	
	public void tick() 
	{
		//buttonBounds();
		//clicked();
			uiManager.tick();
	
	}

	
	public void render(Graphics g) 
	{
		//user controls
		//how to play
		//back button

		uiManager.render(g);
		//create rectangle around back button// check for clicks inside bounds
		//g.drawRect(33, 493, 80, 50);
		
		
	}

	
	
	
	
	
	
	//sets the back button bounds
		public void buttonBounds()
		{
			//rectangle.setBounds(30, 490, 80, 50);
		}
	
	//checking to see if the the mouse is in position and left mouse button is released around the back button
	public void clicked()
	{
		
		//if(rectangle.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY()))
		{
			//handler.getMouseManager().mouseReleased(e);
		}
	
	}

}
