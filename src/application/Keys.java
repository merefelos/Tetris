

package application;


import application.events.*;

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
					new RotatePolyominoEvent(polyomino).fire();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				new HardDropEvent(polyomino.ownerField).fire();
			}
			else if (e.getKeyCode() == KeyEvent.VK_P)
			{
				if (this.paused)
				{
					new ResumeEvent().fire();
					this.paused = false;
				}
				else
				{
					new PauseEvent().fire();
					this.paused = true;
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				new GameOverEvent(polyomino.ownerField, polyomino.ownerField.scoreBoard.statistics.score).fire();
			}
		}
	}

	public MyEvent   event;
	public Polyomino polyomino = null;
	private boolean paused = false;
}
