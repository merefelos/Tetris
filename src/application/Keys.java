

package application;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Keys extends KeyAdapter
{
	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			System.out.println("Up");
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			System.out.println("Down");
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			System.out.println("Left");
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			System.out.println("Right");
		}
		else
		{
			System.out.println("!!!");
		}
	}
}
