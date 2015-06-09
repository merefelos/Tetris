package application;


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

		Cell cell = new Cell(5,5);
		this.field.addCell(cell);

		cell = new Cell(10,5);
		this.field.addCell(cell);

		cell = new Cell(7,9);
		this.field.addCell(cell);

		cell = new Cell(0,0);
		this.field.addCell(cell);
	}

	Field field;
}
