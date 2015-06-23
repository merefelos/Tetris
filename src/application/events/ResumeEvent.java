package application.events;


import events.Event;


/**
 * Created by Didzis on 23.06.2015..
 */
public class ResumeEvent extends Event
{
	public ResumeEvent()
	{
		this.setEventHandler(new ResumeEventHandler());
	}
}
