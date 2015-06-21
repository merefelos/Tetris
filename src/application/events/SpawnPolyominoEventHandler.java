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
		Polyomino nextPoly = event.field.nextPanel.getNextPolyomino();
		Polyomino poly = PolyominoFactory.produceRandomPolyomino(event.field);

		event.field.nextPanel.setNextPolyomino(poly);

		nextPoly.shift(Polyomino.UP, 2);
		nextPoly.shift(Polyomino.RIGHT, 4);

		try
		{
			Thread.sleep(1000/60);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		event.field.activePolyomino = nextPoly;
		event.field.slideEvent.activePolyomino = nextPoly;
		event.field.keys.polyomino = nextPoly;

		Event.enable(MovePolyominoEvent.class);
		Event.enable(SlideEvent.class);
	}
}
