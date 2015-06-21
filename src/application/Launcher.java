package application;


import application.events.RepaintFrameEvent;
import application.events.SlideEvent;
import application.events.SpawnPolyominoEvent;
import events.EventControlPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

		Polyomino poly = field.spawnPolyomino();

//		new SpawnPolyominoEvent(field).fire();

		Timer timer = new Timer(1000/60, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				field.repaint();
			}
		});

		timer.setRepeats(true);
		timer.start();

		new EventControlPanel();

//		EventControlPanel.registerRegularEvent(new RepaintFrameEvent(1000/16, field));
		field.slideEvent = new SlideEvent(1000, poly);
		EventControlPanel.registerRegularEvent(field.slideEvent);

		field.keys = new Keys(poly);
		ui.getRootPanel().addKeyListener(field.keys);
		ui.getRootPanel().grabFocus();
	}

	Field field;
}
