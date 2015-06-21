package application.events;

import application.Polyomino;
import events.EventHandler;


/**
 * Created by Didzis on 21.06.2015..
 */
public class HardDropEventHandler implements EventHandler<HardDropEvent>
{
	@Override
	public void handleEvent(HardDropEvent event)
	{
		while (event.field.activePolyomino.canMove(Polyomino.DOWN))
		{
			event.field.activePolyomino.move(Polyomino.DOWN);
		}
	}
}
