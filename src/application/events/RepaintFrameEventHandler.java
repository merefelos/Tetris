package application.events;

import events.Event;
import events.EventHandler;


/**
 * Created by Didzis on 18.06.2015..
 */
public class RepaintFrameEventHandler implements EventHandler <RepaintFrameEvent>
{
	@Override
	public void handleEvent(RepaintFrameEvent event)
	{
		synchronized (event.frame)
		{
			event.frame.revalidate();
			event.frame.repaint();
		}
	}
}
