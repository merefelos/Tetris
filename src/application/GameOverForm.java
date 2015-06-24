package application;

import javax.swing.*;


/**
 * Created by Didzis on 23.06.2015..
 */
public class GameOverForm
{
	public GameOverForm(int score)
	{
		this.score = score;
		this.scoreLabel.setText("" + score);
	}


	int score;
	private JLabel scoreLabel;
	public JPanel main;
}
