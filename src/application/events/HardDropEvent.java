package application.events;

import application.Field;
import events.Event;


/**
 * Created by Didzis on 21.06.2015..
 */
public class HardDropEvent extends Event
{
	public HardDropEvent(Field field)
	{
		this.field = field;
		this.setEventHandler(new HardDropEventHandler());
	}

	Field field;
}
