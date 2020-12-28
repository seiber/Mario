package mario;

import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State
{

	public MenuState(Handler handler)
	{
		super (handler);
	}
	
	public void tick() 
	{	
		//System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		
		if (handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
		{
			State.setState(handler.getGame().gameState);
		}
	}

	
	public void render(Graphics g) 
	{
		//Christmas hat as a mouse cursor in the menu state
		
		g.setColor(Color.red);
		g.fillRect(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(), 50, 50);
	}

}
