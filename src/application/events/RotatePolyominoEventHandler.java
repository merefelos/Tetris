package application.events;

import events.EventHandler;


/**
 * Created by Didzis on 18.06.2015..
 */
public class RotatePolyominoEventHandler implements EventHandler<RotatePolyominoEvent>
{
	@Override
	public void handleEvent(RotatePolyominoEvent event)
	{
		event.polyomino.rotateRight();
	}
}
