package application.events;

import application.Polyomino;
import events.EventHandler;


/**
 * Created by Didzis on 18.06.2015..
 */
public class PolyominoDroppedEventHandler implements EventHandler<PolyominoDroppedEvent>
{
	@Override
	public void handleEvent(PolyominoDroppedEvent event)
	{
		Polyomino polyomino = event.field.spawnPolyomino();
		event.field.slideEvent.activePolyomino = polyomino;
		event.field.keys.polyomino = polyomino;

		new CheckForFullLinesEvent(event.field).fire();
	}
}
