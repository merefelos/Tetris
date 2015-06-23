package application.events;

import application.Cell;
import events.Event;
import events.EventHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Didzis on 20.06.2015..
 */
public class CheckForFullLinesEventHandler implements EventHandler<CheckForFullLinesEvent>
{
	@Override
	public void handleEvent(CheckForFullLinesEvent event)
	{
		Event.disable(SlideEvent.class);
		Event.disable(MovePolyominoEvent.class);
		Event.disable(PolyominoDroppedEvent.class);

		ArrayList<Cell> checkedCells = new ArrayList<Cell>();

		Map<Integer, ArrayList<Cell>> map = new HashMap<Integer, ArrayList<Cell>>();
		Map<Cell, Integer> moveMap = new HashMap<Cell, Integer>();

		int clearedLineCounter = 0;

//		synchronized (event.field)
		{
			for (int i = -5; i < 20; i++)
			{
				map.put(i, new ArrayList<Cell>());
			}

			for (Cell fallenCell : event.field.fallenCells)
			{
				map.get(fallenCell.logicalY).add(fallenCell);
			}

			for (int i = 0; i < 20; i++)
			{
				List<Cell> currentLevel = map.get(i);

				if (currentLevel.size() >= event.field.width)
				{
					event.field.fallenCells.removeAll(currentLevel);
					clearedLineCounter++;

					for (Cell checkedCell : checkedCells)
					{
						if (moveMap.get(checkedCell) != null)
						{
							moveMap.put(checkedCell, moveMap.get(checkedCell) + 1);
						}
						else
						{
							moveMap.put(checkedCell, 1);
						}
					}
				}
				else
				{
					checkedCells.addAll(currentLevel);
				}
			}

			for (Cell cell : checkedCells)
			{
				if (moveMap.containsKey(cell))
				{
					cell.logicalY += moveMap.get(cell);
				}
			}
		}

		if (clearedLineCounter > 0)
		{
			new ScorePointsEvent(event.field, clearedLineCounter).fire();
		}

		new SpawnPolyominoEvent(event.field).fire();
	}
}
