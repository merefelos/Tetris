package application.events;

import events.EventHandler;


/**
 * Created by Didzis on 22.06.2015..
 */
public class LevelUpEventHandler implements EventHandler<LevelUpEvent>
{
	@Override
	public void handleEvent(LevelUpEvent event)
	{
		event.field.level++;
		event.field.increaseSpeed();
	}
}
