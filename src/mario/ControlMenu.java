package mario;

import java.awt.Graphics;

public class ControlMenu extends State
{

	
	
	public ControlMenu(Handler handler) 
	{
		super(handler);
		
		
	}
	


	public void tick() 
	{
		
			
	
	}

	
	public void render(Graphics g) 
	{
		//user controls
		//how to play
		
		//back button
		
		//create rectangle around back button// check for clicks inside bounds
		g.drawImage(Assets.back,55,55,null);
		
		
	}

}
