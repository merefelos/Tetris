package application.events;

import application.Field;
import events.Event;


/**
 * Created by Didzis on 22.06.2015..
 */
public class ScorePointsEvent extends Event
{
	public ScorePointsEvent(Field field, int numberOfLines)
	{
		this.field = field;
		this.numberOfLines = numberOfLines;
		this.setEventHandler(new ScorePointsEventHandler());
	}


	int numberOfLines;
	public Field field;
}
