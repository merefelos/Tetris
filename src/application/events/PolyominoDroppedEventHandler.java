package application.events;

import application.Cell;
import events.EventHandler;


/**
 * Created by Didzis on 18.06.2015..
 */
public class PolyominoDroppedEventHandler implements EventHandler<PolyominoDroppedEvent>
{
	@Override
	public void handleEvent(PolyominoDroppedEvent event)
	{
		event.field.keys.polyomino = null;

		boolean gameOver = false;

		for (Cell cell : event.field.activePolyomino.cells)
		{
			if (cell.logicalY < 0)
			{
				gameOver = true;
			}
		}

		if (gameOver)
		{
			new PauseEvent().fire();
			new GameOverEvent(event.field, event.field.scoreBoard.statistics.score).fire();
		}
		event.field.fallenCells.addAll(event.field.activePolyomino.cells);

		new CheckForFullLinesEvent(event.field).fire();
	}
}
