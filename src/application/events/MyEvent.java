package application.events;

import events.Event;


/**
 * Created by Didzis on 18.06.2015..
 */
public class MyEvent extends Event
{
	public MyEvent()
	{
		this.setEventHandler(new MyEventHandler());
	}
}
