package application.events;

import application.Cell;
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
		ArrayList<Cell> checkedCells = new ArrayList<Cell>();

		Map<Integer, ArrayList<Cell>> map = new HashMap<Integer, ArrayList<Cell>>();

		for (int i = 0; i < 20; i++)
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

			if (currentLevel.size() == event.field.width)
			{
				event.field.fallenCells.removeAll(currentLevel);

				System.out.println("Removed Line " + i);

				for (Cell checkedCell : checkedCells)
				{
					checkedCell.logicalY++;
				}
			}
			else
			{
				checkedCells.addAll(currentLevel);
			}
		}
	}
}
