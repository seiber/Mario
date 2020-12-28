package mario;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Game extends JPanel implements Runnable
{
	

	//public static final int WIDTH=640, HEIGHT = WIDTH /12 * 9;
	private int width,height;
	public String title;
	private Thread thread;
	private boolean running=false;
	private Window window;
	private BufferStrategy bs;
	private Graphics g;
	
	public State gameState;
	public State menuState;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private GameCamera gameCamera;
	
	private Handler handler;
	
	
	
	
	
	public Game(String title, int width, int height)
	{
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
	}
	
	
	
	private void init()
	{
		
	
		window = new Window(title, width,height);
		window.getFrame().addKeyListener(keyManager); // adding a key listener to the jframe created above inside the bounds of that window to detect key presses
		//adding listeners to frame and canvas depending on which is focused
		window.getFrame().addMouseListener(mouseManager);
		window.getFrame().addMouseMotionListener(mouseManager);
		window.getCanvas().addMouseListener(mouseManager);
		window.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0,0);
	
		gameState = new GameState(handler);
		menuState= new MenuState(handler);
		
		State.setState(menuState);
		
	}
	
	
			
	private void tick()
	{
		keyManager.tick();
		//if our state is returning a state
		if (State.getState()!=null)
		{
			State.getState().tick();
		}
		
		
	}
	

	private void render()
	{

	
		bs = window.getCanvas().getBufferStrategy(); //creating buffers to display graphics to before the actual computer screen
		if (bs==null)
		{
			
		window.getCanvas().createBufferStrategy(3); //REMOVING  graphics flickering
			
			return;
		}
	
		g=bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);//clear screen
		
	
		
		
			//if our state is returning a state
				if (State.getState()!=null)
				{
					State.getState().render(g);
				}
		
		//g.drawImage(Assets.dirt, 10,10,null);
				
				
		bs.show();
		
		//bs.dispose(); //makes bufferstrategy return null
		
	}
	
	public void run()
	{
		init();
		
		int fps =60;
		double timePerTick=1000000000/fps;
		double delta =0;
		long now;
		long lastTime=System.nanoTime();
		long timer =0;
		int ticks=0;
		
		
		
		while (running)
		{
			now=System.nanoTime();
			delta += (now-lastTime)/ timePerTick;
			timer += now - lastTime;
			lastTime =now;
			
			
			if(delta>=1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000)
			{
				System.out.println("Ticks and frames: " + ticks);
				ticks=0;
				timer=0;
			}
			
		}
		stop();
	}
	
	
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public MouseManager getMouseManager()
	{
		
		return mouseManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public synchronized void start()
	{
		if (running)
			return; //goes back to previous code if game is already started
		
		running=true;
		thread = new Thread(this);
		thread.start(); // calls run method
	}
	
	public synchronized void stop()
	{
		if (!running)
		{
			return; //goes back to previous code if game is already stopped
		}
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
