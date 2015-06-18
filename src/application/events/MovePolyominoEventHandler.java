package application.events;

import events.EventHandler;


/**
 * Created by Didzis on 18.06.2015..
 */
public class MovePolyominoEventHandler implements EventHandler<MovePolyominoEvent>
{
	@Override
	public void handleEvent(MovePolyominoEvent event)
	{
		event.polyomino.move(event.direction);
	}
}
