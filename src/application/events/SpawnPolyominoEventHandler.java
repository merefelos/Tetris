package application.events;

import application.Polyomino;
import application.PolyominoFactory;
import events.Event;
import events.EventHandler;


/**
 * Created by Didzis on 21.06.2015..
 */
public class SpawnPolyominoEventHandler implements EventHandler<SpawnPolyominoEvent>
{
	@Override
	public void handleEvent(SpawnPolyominoEvent event)
	{
		Polyomino poly = PolyominoFactory.produceRandomPolyomino(event.field);

//		event.field.addPolyomino(poly);

		poly.shift(Polyomino.UP, 2);
		poly.shift(Polyomino.RIGHT, 4);

		try
		{
			Thread.sleep(1000/60);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		event.field.activePolyomino = poly;
		event.field.slideEvent.activePolyomino = poly;
		event.field.keys.polyomino = poly;

		Event.enable(MovePolyominoEvent.class);
		Event.enable(SlideEvent.class);
	}
}
