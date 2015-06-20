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

		return returnValue;
	}


	public boolean canMoveRight(Cell cell)
	{
		boolean returnValue = true;

		if (cell.logicalX == this.width - 1)
		{
			returnValue = false;
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

		return returnValue;
	}

	public Polyomino spawnPolyomino()
	{
		Polyomino poly = new Polyomino(this);
		poly.cells.add(new Cell(1, 1));
		poly.cells.add(new Cell(1, 0));
		poly.cells.add(new Cell(0, 1));
		poly.cells.add(new Cell(0, 0));

		this.addPolyomino(poly);

		this.activePolyomino = poly;

		return poly;
	}


	private int width  = 10;
	private int height = 20;

	ArrayList<Cell> visibleCells = new ArrayList<Cell>();
	ArrayList<Cell> fallenCells = new ArrayList<Cell>();

	public Polyomino activePolyomino;
	public SlideEvent slideEvent;
	public Keys keys;
}
