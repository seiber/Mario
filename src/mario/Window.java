package mario;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame; 


public class Window extends Canvas
{
	private JFrame frame;
	private int width,height;
	private String title;
	private Canvas canvas;
		
	public Window(String title,int height,int width)
	{
		this.height=height;
		this.width=width;
		this.title=title;
		createDisplay();
				
	}
	
	private void createDisplay()
	{
		
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		
	
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(height,width));
		canvas.setMaximumSize(new Dimension(height,width));
		canvas.setMinimumSize(new Dimension(height,width));
		canvas.setFocusable(false);//focus on the specific jframe, allows keypresses to have response after you click on the game screen
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas()
	{
		
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	
	
	
	
	
	
	
	
}