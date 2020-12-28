package mario;

import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State
{

	private UIManager uiManager;
	
	public MenuState(Handler handler)
	{
		super (handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObbject(new UIImageButton(270,200,100,100,Assets.btn_start,new ClickListener() {

			
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}}));
	}
	
	public void tick() 
	{	
		//System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		
		if (handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
		{
			State.setState(handler.getGame().gameState);
		}
		
		uiManager.tick();
	}

	
	public void render(Graphics g) 
	{
		uiManager.render(g);
		
		
		//Christmas hat as a mouse cursor in the menu state
		g.drawImage(Assets.santaHat, handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),55,55,null);
		
		//g.setColor(Color.red);
		//g.fillRect(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(), 50, 50);
	}

}
