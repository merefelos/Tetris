package application.events;

import application.GameOverForm;
import events.EventHandler;


/**
 * Created by Didzis on 23.06.2015..
 */
public class GameOverEventHandler implements EventHandler<GameOverEvent>
{
	@Override
	public void handleEvent(GameOverEvent event)
	{
		GameOverForm gameOverForm = new GameOverForm(event.score);
		event.field.add(gameOverForm.main);
	}
}
