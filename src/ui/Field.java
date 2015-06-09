package ui;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Created by Enifs.
 */

public class Field extends JPanel
{
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

	private int width = 10;
	private int height = 20;

	ArrayList<Cell> cells = new ArrayList<Cell>();
}
