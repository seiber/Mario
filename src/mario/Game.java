package mario;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game extends Canvas implements Runnable
{
	

	//public static final int WIDTH=640, HEIGHT = WIDTH /12 * 9;
	public int width,height;
	public String title;
	private Thread thread;
	private boolean running=false;
	private Window window;
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage testImage;
	
	public Game(String title, int width, int height)
	{
		this.width=width;
		this.height=height;
		this.title=title;
	}
	
	private void init()
	{
		window = new Window(title, width,height);
		testImage = ImageLoader.loadImage("/textures/Tree.png");
	}
	private void tick()
	{
		
	}
	
	private void render()
	{
		bs = window.getCanvas().getBufferStrategy(); //creating buffers to display graphics to before the actual computer screen
		if (bs==null)
		{
			window.getCanvas().createBufferStrategy(1);
			return;
		}
		
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);//clear screen
		
		//render our tree image
		g.drawImage(testImage,20,20,null);
	
		bs.show();
		bs.dispose();
		
	}
	
	public void run()
	{
		init();
		
		while (running)
		{
			tick();
			render();
			
		}
		stop();
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
