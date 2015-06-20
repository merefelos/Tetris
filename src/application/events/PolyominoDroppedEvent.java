package application.events;

import application.Field;
import application.Polyomino;
import events.Event;


/**
 * Created by Didzis on 18.06.2015..
 */
public class PolyominoDroppedEvent extends Event
{
	public PolyominoDroppedEvent(Field field)
	{
		this.field = field;
		System.out.println("It is working!");
		this.setEventHandler(new PolyominoDroppedEventHandler());
	}

	Polyomino polyomino;
	Field field;
}
