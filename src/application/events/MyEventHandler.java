package application.events;

import events.EventHandler;


/**
 * Created by Didzis on 18.06.2015..
 */
public class MyEventHandler implements EventHandler<MyEvent>
{
	@Override
	public void handleEvent(MyEvent event)
	{
		System.out.println("My event happened");
	}
}
