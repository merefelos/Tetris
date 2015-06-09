import events.EventControlPanel;
import events.sample.HelloWorldEvent;
import events.sample.Sample;
import ui.Cell;
import ui.MainUI;

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

		Cell cell = new Cell();
		ui.playground.add(cell.main);
	}
}
