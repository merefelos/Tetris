package application.events;

import application.Field;
import application.Polyomino;
import events.Event;


/**
 * Created by Didzis on 21.06.2015..
 */
public class SpawnPolyominoEvent extends Event
{
	public SpawnPolyominoEvent(Field field)
	{
		this.field = field;
		this.setEventHandler(new SpawnPolyominoEventHandler());
	}

	public Field field;
}
