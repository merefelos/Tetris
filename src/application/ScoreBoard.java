package application;

import application.events.LevelUpEvent;

import javax.swing.*;


/**
 * Created by Didzis on 22.06.2015..
 */
public class ScoreBoard
{
	public ScoreBoard()
	{
		this.statistics = new Statistics();
	}

	public void scorePoints(int lines, int points)
	{
		statistics.score += points;

		statistics.clearedLines(lines);

		this.oneLinesLabel.setText("" + statistics.oneLiners);
		this.twoLinesLabel.setText("" + statistics.twoLiners);
		this.threeLinesLabel.setText("" + statistics.threeLiners);
		this.fourLinesLabel.setText("" + statistics.fourLiners);
		this.scoreLabel.setText("" + statistics.score);
		this.levelLabel.setText("" + field.level);

		if (statistics.levelUpCounter > 5)
		{
			new LevelUpEvent(field).fire();
			statistics.levelUpCounter = 0;
		}
	}

	public Statistics statistics;

	public JPanel main;
	public JLabel scoreLabel;
	public JLabel oneLinesLabel;
	public JLabel twoLinesLabel;
	public JLabel threeLinesLabel;
	public JLabel fourLinesLabel;
	private JLabel levelLabel;

	public Field field;
}
