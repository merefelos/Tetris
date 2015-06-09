//
// Tom Sawyer Software
// Copyright 2007 - 2015
// All rights reserved.
//
// www.tomsawyer.com
//


package ui;


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

		this.x = x;
		this.y = y;
	}


	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
    		g.setColor(Color.GREEN);
			g.drawRect((30*x) + 1, (30*y) + 1,28,28);
		}

	public int x;
	public int y;
}
