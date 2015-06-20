package application;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;


public class Cell extends JPanel
{
	public Cell(int x, int y)
	{
		Dimension dimension = new Dimension(30, 30);
		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.setMaximumSize(dimension);
		this.setOpaque(false);

		this.logicalX = x;
		this.logicalY = y;
	}


	@Override
	public void paintComponent(Graphics g)
	{
		expectedActualX = (30* logicalX) + 1;
		expectedActualY = (30* logicalY) + 1;

		super.paintComponent(g);
    		g.setColor(Color.GREEN);
			g.fillRect((int) actualX, (int) actualY,28,28);

		this.adjustActualPosition();
	}


	private void adjustActualPosition()
	{
		double xDiff = expectedActualX - actualX;
		double yDiff = expectedActualY - actualY;

		xDiff /= 20;
		yDiff /= 20;


		if (Math.abs(xDiff) < 1)
		{
			actualX = expectedActualX;
		}
		else
		{
			actualX += xDiff;
		}

		if (Math.abs(yDiff) < 1)
		{
			actualY = expectedActualY;
		}
		else
		{
			actualY += yDiff;
		}
	}

	public boolean atExpectedPosition()
	{
		return actualX == expectedActualX && actualY == expectedActualY;
	}

	int expectedActualX = 0;
	int expectedActualY = 0;


	public int logicalX;
	public int logicalY;

	public double actualX = 50;
	public double actualY = 50;
}
