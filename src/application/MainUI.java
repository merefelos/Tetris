/**
 * Created by Enifs.
 */

package application;

import javax.swing.*;


public class MainUI
{

	public JPanel getRootPanel()
	{
		return rootPanel;
	}

	private JPanel rootPanel;

	public JPanel playground;
	public JPanel nextPanel;


	private void createUIComponents()
	{
		this.playground = new Field(true);
		this.nextPanel = new NextPanel();
	}
}
