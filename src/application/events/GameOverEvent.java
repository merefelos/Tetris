package application.events;

import application.Field;
import events.Event;

import javax.swing.*;


/**
 * Created by Didzis on 23.06.2015..
 */
public class GameOverEvent extends Event
{
	public GameOverEvent(Field field, int score)
	{
		this.field = field;
		this.score = score;
		this.setEventHandler(new GameOverEventHandler());
	}

	public Field field;
	int score;
}
