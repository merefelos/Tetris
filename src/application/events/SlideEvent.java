package application.events;

import application.Polyomino;
import events.Event;
import events.regularevents.RegularEvent;


/**
 * Created by Didzis on 18.06.2015..
 */
public class SlideEvent extends RegularEvent
{
	public SlideEvent(long frequency, Polyomino activePolyomino)
	{
		super(frequency);
		this.activePolyomino = activePolyomino;

		this.setEventHandler(new SlideEventHandler());
	}

	Polyomino activePolyomino;
}
