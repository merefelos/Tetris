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


public class Cell
{
	public JPanel main;


	private void createUIComponents()
	{
		this.main = new Panel();
	}

	private class Panel extends JPanel
	{
		public Panel()
		{
			Dimension dimension = new Dimension(30, 30);
			this.setPreferredSize(dimension);
			this.setMinimumSize(dimension);
			this.setMaximumSize(dimension);
			this.setOpaque(false);
		}


		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			g.setColor(Color.GREEN);
			g.drawRect(1,1,28,28);
		}
	}

	public int x;
	public int y;
}
