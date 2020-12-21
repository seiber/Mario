package mario;

import javax.swing.JFrame; 
import java.awt.*;

public class Window extends Canvas
{
	private JFrame frame;
	private int width,height;
	private String title;
	private Canvas canvas;
		
	public Window(String title,int width, int height)
	{
		this.width=width;
		this.height=height;
		this.title=title;
		
		createDisplay();
				
	}
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//frame.add(game);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(height,width));
		canvas.setMaximumSize(new Dimension(height,width));
		canvas.setMinimumSize(new Dimension(height,width));
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}