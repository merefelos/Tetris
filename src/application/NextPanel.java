package application;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Didzis on 21.06.2015..
 */
public class NextPanel extends JPanel
{
	public NextPanel()
	{
		Dimension dimension = new Dimension(30 * 4, 30 * 4);

		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.setMaximumSize(dimension);

		this.setBackground(new Color(51, 0, 51));
	}


	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Cell cell : nextPolyomino.cells)
		{
			cell.paintComponent(g);
		}
	}


	public void setNextPolyomino(Polyomino nextPolyomino)
	{
		this.nextPolyomino = nextPolyomino;
	}


	public Polyomino getNextPolyomino()
	{
		return nextPolyomino;
	}


	public Polyomino nextPolyomino;
}
