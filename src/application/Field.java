package application;


import application.events.PolyominoDroppedEvent;
import application.events.SlideEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import javax.swing.*;


/**
 * Created by Enifs.
 */

public class Field extends JPanel
{
	public Field(boolean isDoubleBuffered)
	{
		super(isDoubleBuffered);

		Dimension dimension = new Dimension(300, 600);

		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.setMaximumSize(dimension);
	}


	public void addPolyomino(Polyomino polyomino)
	{
//		this.visibleCells.addAll(polyomino.cells);
	}


	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		try
		{
			g.setColor(Color.green);
			for (Cell cell : fallenCells)
			{
				cell.paintComponent(g);
			}

			for (Cell cell : activePolyomino.cells)
			{
				cell.paintComponent(g);
			}

			int i = this.activePolyomino.centerPiece;
			Cell centerCell = this.activePolyomino.cells.get(i);

			g.setColor(Color.DARK_GRAY);

// enable these two lines two mark center piece
//			g.fillOval(centerCell.expectedActualX + 12, centerCell.expectedActualY + 12, 4, 4);
//			g.fillOval((int) centerCell.actualX + 12, (int) centerCell.actualY + 12, 4, 4);

		} catch (Exception e)
		{
			System.out.println("Error");
		}
	}


	public boolean canMoveDown(Cell cell)
	{
		boolean returnValue = true;

		if (cell.logicalY == this.height - 1)
		{
			returnValue = false;
		}
		for (Cell fallenCell : fallenCells)
		{
			if (fallenCell.logicalX == cell.logicalX && fallenCell.logicalY == (cell.logicalY + 1))
			{
				returnValue = false;
			}
		}

		return returnValue;
	}


	public boolean canMoveRight(Cell cell)
	{
		boolean returnValue = true;

		if (cell.logicalX == this.width - 1)
		{
			returnValue = false;
		}
		for (Cell fallenCell : fallenCells)
		{
			if (fallenCell.logicalX == (cell.logicalX + 1) && fallenCell.logicalY == cell.logicalY)
			{
				returnValue = false;
			}
		}

		return returnValue;
	}


	public boolean canMoveLeft(Cell cell)
	{
		boolean returnValue = true;

		if (cell.logicalX == 0)
		{
			returnValue = false;
		}
		for (Cell fallenCell : fallenCells)
		{
			if (fallenCell.logicalX == (cell.logicalX - 1) && fallenCell.logicalY == cell.logicalY)
			{
				returnValue = false;
			}
		}

		return returnValue;
	}


	public Polyomino spawnPolyomino()
	{
		Polyomino poly = PolyominoFactory.produceRandomPolyomino(this);

		this.addPolyomino(poly);

		poly.shift(Polyomino.UP, 2);
		poly.shift(Polyomino.RIGHT, 4);

		this.activePolyomino = poly;

		return poly;
	}


	public boolean isLegit(Polyomino polyomino)
	{
		boolean returnValue = true;

		for (Cell cell : polyomino.cells)
		{
			for (Cell fallenCell : fallenCells)
			{
				if (fallenCell.logicalX == cell.logicalX && fallenCell.logicalY == cell.logicalY)
				{
					returnValue = false;
					break;
				}
			}
			if (cell.logicalX < 0 ||
					cell.logicalX >= this.width || cell.logicalY >= this.height)
			{
				returnValue = false;
			}
		}

		return returnValue;
	}


	public int width = 10;
	private int height = 20;

	public LinkedHashSet<Cell> fallenCells = new LinkedHashSet<Cell>();

	public Polyomino activePolyomino;
	public SlideEvent slideEvent;
	public Keys keys;

	public NextPanel nextPanel;
}
