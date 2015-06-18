package application;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Created by Enifs.
 */

public class Field extends JPanel
{
	public void addPolyomino(Polyomino polyomino)
	{
		this.cells.addAll(polyomino.cells);
	}


	public void addCell(Cell cell)
	{
		this.cells.add(cell);
	}


	@Override
	public void paintComponents(Graphics g)
	{
		super.paintComponents(g);
	}


	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.green);
		for (Cell cell : cells)
		{
			cell.paintComponent(g);
		}
	}


	public void draw(Graphics g)
	{
//		g.setColor(Color.green);
//		g.drawRect(50, 50, 50, 50);
	}

	public boolean canMoveDown(Cell cell)
	{
		boolean returnValue = true;

		if (cell.y == this.height - 1)
		{
			returnValue = false;
		}

		return returnValue;
	}


	public boolean canMoveRight(Cell cell)
	{
		boolean returnValue = true;

		if (cell.x == this.width - 1)
		{
			returnValue = false;
		}

		return returnValue;
	}


	public boolean canMoveLeft(Cell cell)
	{
		boolean returnValue = true;

		if (cell.x == 0)
		{
			returnValue = false;
		}

		return returnValue;
	}


	private int width = 10;
	private int height = 20;

	ArrayList<Cell> cells = new ArrayList<Cell>();
	public Polyomino activePolyomino;
}
