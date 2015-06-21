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
		this.actualX = (30* 5) + 1;
		this.actualY = (30* -3) + 1;
		this.expectedActualX = (30* 5) + 1;
		this.expectedActualY = (30* -3) + 1;
	}


	@Override
	public void paintComponent(Graphics g)
	{
		if (logicalY > -1)
		{
			expectedActualX = (30* logicalX) + 1;
			expectedActualY = (30* logicalY) + 1;

			super.paintComponent(g);
			g.setColor(color);
			g.fillRect((int) actualX, (int) actualY, 28, 28);
			g.drawRect((int) expectedActualX, (int) expectedActualY, 28,28);
			this.adjustActualPosition();
		}
	}


	private void adjustActualPosition()
	{
		int xDiff = (int) (expectedActualX - actualX);
		int yDiff = (int) (expectedActualY - actualY);

		int xi = 5;
		int yi = 5;

		if (Math.abs(xDiff) < xi)
		{
			xi = xDiff;
		}

		if (Math.abs(yDiff) < yi)
		{
			yi = yDiff;
		}
//		xDiff /= Math.abs(xDiff);
//		yDiff /= Math.abs(yDiff);

		if (xDiff < 0)
		{
			xDiff = -xi;
		}
		else if (xDiff == 0)
		{
			xDiff = 0;
		}
		else
		{
			xDiff = xi;
		}

		if (yDiff < 0)
		{
			yDiff = -yi;
		}
		else if (yDiff == 0)
		{
			yDiff = 0;
		}
		else
		{
			yDiff = yi;
		}

			actualX += xDiff;
			actualY += yDiff;
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

	public Color color;
}
