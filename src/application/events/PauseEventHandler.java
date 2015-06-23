package application.events;

import events.Event;
import events.EventHandler;


/**
 * Created by Didzis on 23.06.2015..
 */
public class PauseEventHandler implements EventHandler<PauseEvent>
{
	@Override
	public void handleEvent(PauseEvent event)
	{
		Event.disable(SlideEvent.class);
		Event.disable(RotatePolyominoEvent.class);
		Event.disable(MovePolyominoEvent.class);
		Event.disable(HardDropEvent.class);
	}
}
