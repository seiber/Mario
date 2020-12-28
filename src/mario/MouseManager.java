package mario;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener
{

	private boolean leftPressed, rightPressed;
	private int mouseX,mouseY;
	
	public MouseManager()
	{
		
	}
	
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	public void mouseDragged(MouseEvent e) 
	{
			
	}


	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	
	public void mouseClicked(MouseEvent e) 
	{
			
	}

	
	public void mousePressed(MouseEvent e)
	{
		//left mouse button
		if (e.getButton()== MouseEvent.BUTTON1)
		{
			leftPressed = true;
			System.out.println("left press");
		}
		//right mouse button
		else if (e.getButton()==MouseEvent.BUTTON3)
		{
			rightPressed = true;
		}
	}

	
	public void mouseReleased(MouseEvent e)
	{
				//left mouse button
				if (e.getButton()== MouseEvent.BUTTON1)
				{
					leftPressed = false;
				}
				//right mouse button
				else if (e.getButton()==MouseEvent.BUTTON3)
				{
					rightPressed = false;
				}	
	}


	public void mouseEntered(MouseEvent e) 
	{
		
	}


	public void mouseExited(MouseEvent e) 
	{
		
	}
		
	
	
}
