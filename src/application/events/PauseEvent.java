package application.events;

import events.Event;


/**
 * Created by Didzis on 23.06.2015..
 */
public class PauseEvent extends Event
{
	public PauseEvent()
	{
		this.setEventHandler(new PauseEventHandler());
	}
}
