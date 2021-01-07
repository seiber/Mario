package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public class MenuState extends State
{

	private UIManager uiManager;
	
	private int count =0;
	Image icon;
	String audioFilePath = "Res/Textures/Music/ikson.wav";
	Sound player = new Sound();

	
	public MenuState(Handler handler) throws MalformedURLException
	{
		super (handler);
		
		uiManager = new UIManager(handler);
		
		
		handler.getMouseManager().setUIManager(uiManager);
		//gif link
		icon = new ImageIcon(new URL("https://i.pinimg.com/originals/b0/45/68/b0456861e9dbf784217a3772748c6101.gif")).getImage();
		
		
		//music on or off state		
		uiManager.addObject(new UIImageButton(400,200,100,100,Assets.music,new ClickListener() 
		{

			
			public void onClick() 
			{
				
					
					player.play(audioFilePath);
					
			
		        //State.setState(handler.getGame().gameState);
			}
			
		
		}));
		
		
		
		//start game buttons
		uiManager.addObject(new UIImageButton(270,200,100,100,Assets.btn_start,new ClickListener() 
		{

			
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
	
				State.setState(handler.getGame().gameState);
				
			}}));
		
		//option menu button
		uiManager.addObject(new UIImageButton(500,500,100,100,Assets.attack_left,new ClickListener() 
		{

			
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().optionState);
				
			}}));
	}
	
	
//	public void startMusic()
//	{
//		
//		if (count == 0)
//		{
//			player.play(audioFilePath);
//			
//		}
//		count++;
//		
//		
//		
//	}
	
	
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
	
	
		
		//g.setColor(Color.red);
		//g.fillRect(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(), 50, 50);
	}

}
