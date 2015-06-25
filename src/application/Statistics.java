package application;

/**
 * Created by Didzis on 22.06.2015..
 */
public class Statistics
{
	public void clearedLines(int lines)
	{
		switch (lines)
		{
			case 1:
				this.oneLiners++;
				break;
			case 2:
				this.twoLiners++;
				break;
			case 3:
				this.threeLiners++;
				break;
			case 4:
				this.fourLiners++;
				break;
		}

		this.linesCleared += lines;
		this.levelUpCounter += lines;
	}


	int clearingStrike = 0;

	int fourLiners = 0;
	int threeLiners = 0;
	int twoLiners = 0;
	int oneLiners = 0;
	int linesCleared = 0;

	public int score = 0;

	public int levelUpCounter;
}
