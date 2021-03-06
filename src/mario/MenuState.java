package mario;




import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;


public class MenuState extends State
{

	private UIManager uiManager;
	
	
	Image icon;
	String audioFilePath = "Res/Textures/Music/ikson.wav";
	Sound player = new Sound();
	public static Thread t1;

	
	public MenuState(Handler handler) throws MalformedURLException
	{
		super (handler);
		
		uiManager = new UIManager(handler);
		t1 = new Thread(new Sound());
		handler.getMouseManager().setUIManager(uiManager);
		//gif link
		icon = new ImageIcon(new URL("https://i.pinimg.com/originals/b0/45/68/b0456861e9dbf784217a3772748c6101.gif")).getImage();
		
		
		//music on button
		uiManager.addObject(new UIImageButton(735,450,50,50,Assets.music,new ClickListener() 
		{

			
			public void onClick() 
			{	
				t1 = new Thread(new Sound());
				Sound.playCompleted=false;
		
				if(!t1.isAlive())
				{
					System.out.println("thread not alive, starting");
					System.out.println(t1.getState());
					t1.start();
					
				}	
			}
			
			}));
		
		//music off button
		uiManager.addObject(new UIImageButton(735,500,50,50,Assets.music1,new ClickListener() 
		{

			
			public void onClick() 
			{
					t1.interrupt();
					Sound.playCompleted=true;
									
			}
		}));
		
		
		//start game button
		uiManager.addObject(new UIImageButton(270,200,100,100,Assets.start,new ClickListener() 
		{

			
			public void onClick() 
			{
				//deactivates main menu mouse interaction
				handler.getMouseManager().setUIManager(null);
	
				State.setState(handler.getGame().setNewgameState(handler.getGame().gameState));
				
			}}));
		
		//controls menu button
		uiManager.addObject(new UIImageButton(270,300,100,100,Assets.controls,new ClickListener() 
		{
				
			
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
				//State.setState(handler.getGame().controlState);
				State.setState(handler.getGame().setNewcontrolState(handler.getGame().controlState));
				
				
				
			}}));
	
	
		
	
				//quit menu button
			uiManager.addObject(new UIImageButton(270,400,100,100,Assets.quit,new ClickListener() 
			{

				
				public void onClick() 
				{
					handler.getMouseManager().setUIManager(null);
					System.exit(1);
					
				}}));
			
		}
	
	
	public void tick() 
	{	
		//System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		
//		if (handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
//		{
//			State.setState(handler.getGame().gameState);
//		}
		
		
		uiManager.tick();
	}

	
	public void render(Graphics g) 
	{
		//start drawing Christmas background image at origin of screen
		g.drawImage(icon,0,0,null);

		uiManager.render(g);
	

		//Christmas hat as a mouse cursor in the menu state
		g.drawImage(Assets.santaHat, handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),55,55,null);
	
	}

}
