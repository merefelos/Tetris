package application.events;

import application.Polyomino;
import events.Event;


/**
 * Created by Didzis on 18.06.2015..
 */
public class RotatePolyominoEvent extends Event
{
	public RotatePolyominoEvent(Polyomino polyomino)
	{
		this.polyomino = polyomino;

		this.setEventHandler(new RotatePolyominoEventHandler());
	}

	Polyomino polyomino;
}
