package application.events;

import events.Event;
import events.EventHandler;
import events.regularevents.RegularEvent;


/**
 * Created by Didzis on 23.06.2015..
 */
public class ResumeEventHandler implements EventHandler<ResumeEvent>
{
	@Override
	public void handleEvent(ResumeEvent event)
	{

		Event.enable(SlideEvent.class);
		Event.enable(RotatePolyominoEvent.class);
		Event.enable(MovePolyominoEvent.class);
		Event.enable(HardDropEvent.class);
		Event.enable(PolyominoDroppedEvent.class);
		Event.enable(SpawnPolyominoEvent.class);
	}
}
