package application.events;

import application.Field;
import events.Event;
import events.regularevents.RegularEvent;


/**
 * Created by Didzis on 20.06.2015..
 */
public class CheckForFullLinesEvent extends Event
{
	public CheckForFullLinesEvent(Field field)
	{
		this.field = field;

		this.setEventHandler(new CheckForFullLinesEventHandler());
	}

	public final Field field;
}
