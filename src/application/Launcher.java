package application;


import application.events.MyEvent;
import application.events.RepaintFrameEvent;
import application.events.SlideEvent;
import events.EventControlPanel;

import javax.swing.*;
import java.awt.*;


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
		frame.setSize(800, 800);

		field = (Field) ui.playground;

		Polyomino poly = new Polyomino(field);
		poly.cells.add(new Cell(1, 1));
		poly.cells.add(new Cell(1, 0));
		poly.cells.add(new Cell(0, 1));
		poly.cells.add(new Cell(0, 0));

		field.addPolyomino(poly);

		field.activePolyomino = poly;

		new EventControlPanel();

		EventControlPanel.registerRegularEvent(new SlideEvent(1000, new RepaintFrameEvent(field), poly));

		ui.getRootPanel().addKeyListener(new Keys(poly));
		ui.getRootPanel().grabFocus();
	}

	Field field;
}
