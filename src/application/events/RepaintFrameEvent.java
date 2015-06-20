package application.events;

import events.Event;

import events.regularevents.RegularEvent;
import javax.swing.*;


/**
 * Created by Didzis on 18.06.2015..
 */
public class RepaintFrameEvent extends RegularEvent
{
	public RepaintFrameEvent(long frequency, JPanel frame)
	{
		super(frequency);
		this.frame = frame;
		this.setEventHandler(new RepaintFrameEventHandler());
	}

	JPanel frame;
}
