package application.events;

import application.Polyomino;
import events.Event;


/**
 * Created by Didzis on 18.06.2015..
 */
public class MovePolyominoEvent extends Event
{
	public MovePolyominoEvent(int direction, Polyomino polyomino)
	{
		this.direction = direction;
		this.polyomino = polyomino;

		this.setEventHandler(new MovePolyominoEventHandler());
	}

	int direction;
	Polyomino polyomino;
}
