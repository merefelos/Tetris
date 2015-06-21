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
		event.field.keys.polyomino = null;
		event.field.fallenCells.addAll(event.field.activePolyomino.cells);

		new CheckForFullLinesEvent(event.field).fire();

		new SpawnPolyominoEvent(event.field).fire();
	}
}
