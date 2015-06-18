package application;


import events.EventControlPanel;

import javax.swing.*;


/**
 * Created by Enifs.
 */

public class Launcher
{
	public static void main(String[] args)
	{
		Launcher launcher = new Launcher();
		launcher.run();
	}

	private void run()
	{
		MainUI ui = new MainUI();
		JFrame frame = new JFrame("TBT");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(ui.getRootPanel());
		frame.setVisible(true);
		frame.setSize(800, 600);

		ui.getRootPanel().addKeyListener(new Keys());
		ui.getRootPanel().grabFocus();
		field = (Field) ui.playground;

		Polyomino poly =new Polyomino();
		poly.cells.add(new Cell(5,5));
		poly.cells.add(new Cell(10,5));
		poly.cells.add(new Cell(7,9));
		poly.cells.add(new Cell(0,0));

		field.addPolyomino(poly);

		new EventControlPanel();
	}

	Field field;
}
