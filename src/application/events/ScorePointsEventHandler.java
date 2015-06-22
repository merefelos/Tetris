package application.events;

import events.EventHandler;


/**
 * Created by Didzis on 22.06.2015..
 */
public class ScorePointsEventHandler implements EventHandler<ScorePointsEvent>
{
	@Override
	public void handleEvent(ScorePointsEvent event)
	{
		event.field.scoreBoard.scorePoints(event.numberOfLines, this.calculatePoints(event));
	}


	private int calculatePoints(ScorePointsEvent event)
	{
		int points = 0;

		int linesModifier = 0;

		switch (event.numberOfLines)
		{
			case 1:
				linesModifier = 40;
				break;
			case 2:
				linesModifier = 100;
				break;
			case 3:
				linesModifier = 300;
				break;
			case 4:
				linesModifier = 1200;
				break;
		}

		points = linesModifier * (event.field.level + 1);

		return points;
	}
}
