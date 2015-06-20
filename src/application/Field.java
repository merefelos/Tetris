package application;


import application.events.PolyominoDroppedEvent;
import application.events.SlideEvent;

import java.awt.*;
import java.util.ArrayList;

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
		this.visibleCells.addAll(polyomino.cells);
	}


	public void addCell(Cell cell)
	{
		this.visibleCells.add(cell);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.green);
		for (Cell cell : visibleCells)
		{
			cell.paintComponent(g);
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
			if (cell.logicalX < 0 || cell.logicalY < 0 ||
					cell.logicalX > this.width || cell.logicalY > this.width)
			{
				returnValue = false;
				break;
			}
		}

		return returnValue;
	}

	private int width  = 10;
	private int height = 20;

	ArrayList<Cell> visibleCells = new ArrayList<Cell>();
	ArrayList<Cell> fallenCells  = new ArrayList<Cell>();

	public Polyomino  activePolyomino;
	public SlideEvent slideEvent;
	public Keys       keys;
}
