

package application;


import application.events.MovePolyominoEvent;
import application.events.MyEvent;
import application.events.RotatePolyominoEvent;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Keys extends KeyAdapter
{
	public Keys(Polyomino polyomino)
	{
		this.polyomino = polyomino;
		this.event = event;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);

		if (polyomino != null)
		{
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				new MovePolyominoEvent(Polyomino.DOWN, polyomino).fire();
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				new MovePolyominoEvent(Polyomino.LEFT, polyomino).fire();
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				new MovePolyominoEvent(Polyomino.RIGHT, polyomino).fire();
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				if (polyomino.canRotate())
				{
					//polyomino.rotateRight();
					new RotatePolyominoEvent(polyomino).fire();
				}
			}
			else
			{
				System.out.println("!!!");
			}
		}
	}

	public MyEvent   event;
	public Polyomino polyomino = null;
}
