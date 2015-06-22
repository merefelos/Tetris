package application.events;

import application.Field;
import events.Event;


/**
 * Created by Didzis on 22.06.2015..
 */
public class LevelUpEvent extends Event
{
	public LevelUpEvent(Field field)
	{
		this.field = field;
		this.setEventHandler(new LevelUpEventHandler());
	}

	public Field field;
}
