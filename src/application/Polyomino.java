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
				if (this.canMove(DOWN))
				{
					for (int i = 0; i < this.cells.size(); i++)
					{
						this.cells.get(i).logicalY++;
					}
				}
				break;
			case LEFT:
				if (this.canMove(LEFT))
				{
					for (int i = 0; i < this.cells.size(); i++)
					{
						this.cells.get(i).logicalX--;
					}
				}
				break;
			case RIGHT:
				if (this.canMove(RIGHT))
				{
					for (int i = 0; i < this.cells.size(); i++)
					{
						this.cells.get(i).logicalX++;
					}
				}
				break;
			default:
				break;
		}
	}

	public boolean canMove(int direction)
	{
		boolean returnValue = true;

		switch (direction)
		{
			case Polyomino.DOWN:
				for (Cell cell : cells)
				{
					returnValue &= this.ownerField.canMoveDown(cell);
				}
				break;
			case Polyomino.LEFT:
				for (Cell cell : cells)
				{
					returnValue &= this.ownerField.canMoveLeft(cell);
				}
				break;
			case Polyomino.RIGHT:
				for (Cell cell : cells)
				{
					returnValue &= this.ownerField.canMoveRight(cell);
				}
				break;
		}

		return returnValue;
	}


	public List<Cell> cells = new ArrayList<Cell>();
	public static final int DOWN = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;

	Field ownerField;
}
