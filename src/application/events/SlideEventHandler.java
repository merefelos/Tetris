package application.events;

import application.Polyomino;
import events.EventHandler;
import events.regularevents.RegularEvent;


/**
 * Created by Didzis on 18.06.2015..
 */
public class SlideEventHandler implements EventHandler<SlideEvent>
{
	@Override
	public void handleEvent(SlideEvent event)
	{
		new MovePolyominoEvent(Polyomino.DOWN, event.activePolyomino).fire();
	}
}
