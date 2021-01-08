package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MenuState extends State
{

	private UIManager uiManager;
	private ControlMenu controlMenu;
	
	Image icon;
	String audioFilePath = "Res/Textures/Music/ikson.wav";
	Sound player = new Sound();

	
	public MenuState(Handler handler) throws MalformedURLException
	{
		super (handler);
		
		uiManager = new UIManager(handler);
		controlMenu = new ControlMenu(handler);
		
		handler.getMouseManager().setUIManager(uiManager);
		//gif link
		icon = new ImageIcon(new URL("https://i.pinimg.com/originals/b0/45/68/b0456861e9dbf784217a3772748c6101.gif")).getImage();
		
		
		//music on button
		uiManager.addObject(new UIImageButton(735,450,50,50,Assets.music,new ClickListener() 
		{

			
			public void onClick() 
			{	
					player.play(audioFilePath);
					
					//Sound.audioClip.loop(5);

			}
		}));
		
		//music off button
		uiManager.addObject(new UIImageButton(735,500,50,50,Assets.music1,new ClickListener() 
		{

			
			public void onClick() 
			{
					Sound.audioClip.stop();
				
			}
		}));
		
		
		//start game button
		uiManager.addObject(new UIImageButton(270,200,100,100,Assets.start,new ClickListener() 
		{

			
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
	
				State.setState(handler.getGame().gameState);
				
			}}));
		
		//controls menu button
		uiManager.addObject(new UIImageButton(270,300,100,100,Assets.controls,new ClickListener() 
		{
				
			
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().controlState);
				
				
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
