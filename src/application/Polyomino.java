package application;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Enifs.
 */

public class Polyomino
{
	public Polyomino(Field field)
	{
		this.ownerField = field;
		this.cells = new ArrayList<Cell>();
	}


	public void move(int option)
	{
		switch (option)
		{
			case DOWN:
				for (int i = 0; i < this.cells.size(); i++)
				{
					if (this.ownerField.canMoveDown(this.cells.get(i)))
					{
						this.cells.get(i).y++;
					}
				}
				break;
			case LEFT:
				for (int i = 0; i < this.cells.size(); i++)
				{
					if (this.ownerField.canMoveLeft(this.cells.get(i)))
					{
						this.cells.get(i).x--;
					}
				}
				break;
			case RIGHT:
				for (int i = 0; i < this.cells.size(); i++)
				{
					if (this.ownerField.canMoveRight(this.cells.get(i)))
					{
						this.cells.get(i).x++;
					}
				}
				break;
			default:
				for (int i = 0; i < this.cells.size(); i++)
				{
					this.cells.set(i, new Cell(this.cells.get(i).getX(), this.cells.get(i).getY() - 30));
				}
				break;
		}
	}


	public List<Cell> cells = new ArrayList<Cell>();
	public static final int DOWN = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;

	Field ownerField;
}
