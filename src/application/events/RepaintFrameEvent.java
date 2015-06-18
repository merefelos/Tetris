package application.events;

import events.Event;

import javax.swing.*;


/**
 * Created by Didzis on 18.06.2015..
 */
public class RepaintFrameEvent extends Event
{
	public RepaintFrameEvent(JPanel frame)
	{
		this.frame = frame;
		this.setEventHandler(new RepaintFrameEventHandler());
	}

	JPanel frame;
}
