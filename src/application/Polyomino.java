package application;


import application.events.PolyominoDroppedEvent;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Enifs.
 */

public class Polyomino
{
	public Polyomino(Field field, PolyominoFactory.Type type)
	{
		this.ownerField = field;
		this.cells = new ArrayList<Cell>();
		this.type = type;
	}


	public synchronized void move(int option)
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
				else // TODO: Complicate it!
				{
					this.ownerField.fallenCells.addAll(this.cells);
					new PolyominoDroppedEvent(this.ownerField).fire();
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

	public synchronized void rotateRight()
	{
		if (this.type.equals(PolyominoFactory.Type.i))
		{
			// If horizontal
			if (this.cells.get(0).logicalX == this.cells.get(3).logicalX)
			{
				this.cells.get(0).logicalX += 2;
				this.cells.get(0).logicalY += 2;
				this.cells.get(1).logicalX += 1;
				this.cells.get(1).logicalY += 1;
				this.cells.get(3).logicalX -= 1;
				this.cells.get(3).logicalY -= 1;
			}
			// If vertical
			else
			{
				this.cells.get(0).logicalX -= 2;
				this.cells.get(0).logicalY -= 2;
				this.cells.get(1).logicalX -= 1;
				this.cells.get(1).logicalY -= 1;
				this.cells.get(3).logicalX += 1;
				this.cells.get(3).logicalY += 1;
			}
		}
		else if (this.type.equals(PolyominoFactory.Type.o))
		{

		}
		else
		{
			this.cells.get(this.centerPiece);
			for (Cell cell : this.cells)
			{
				// Cell to the right of center
				if (cell.logicalX - 1 == this.cells.get(this.centerPiece).logicalX)
				{
					// Cell above center - shift down
					if (cell.logicalY + 1 == this.cells.get(this.centerPiece).logicalY)
					{
						cell.logicalY += 1;
					}
					// Cell below center - shift left
					else if (cell.logicalY - 1 == this.cells.get(this.centerPiece).logicalY)
					{
						cell.logicalX -= 1;
					}
					// Cell on same level as center - shift down
					else
					{
						cell.logicalY += 1;
					}
				}
				// Cell to the left of center
				else if (cell.logicalX + 1 == this.cells.get(this.centerPiece).logicalX)
				{
					// Cell above center - shift right
					if (cell.logicalY + 1 == this.cells.get(this.centerPiece).logicalY)
					{
						cell.logicalX += 1;
					}
					// Cell below center - shift up
					else if (cell.logicalY - 1 == this.cells.get(this.centerPiece).logicalY)
					{
						cell.logicalY -= 1;
					}
					// Cell on same level as center - shift up
					else
					{
						cell.logicalY -= 1;
					}
				}
				// Cell on same X as center
				else if (cell.logicalX == this.cells.get(this.centerPiece).logicalX)
				{
					// Cell above center - shift right
					if (cell.logicalY + 1 == this.cells.get(this.centerPiece).logicalY)
					{
						cell.logicalX += 1;
					}
					// Cell below center - shift left
					else if (cell.logicalY - 1 == this.cells.get(this.centerPiece).logicalY)
					{
						cell.logicalX -= 1;
					}
				}
			}
		}
	}

	public synchronized boolean canRotate()
	{
		boolean canToo = true;
		Polyomino polyomino = PolyominoFactory.polyominoClone(this);
		polyomino.rotateRight();
		canToo = this.ownerField.isLegit(polyomino);

		return canToo;
	}


	public void setColor(Color color)
	{
		for (Cell cell : cells)
		{
			cell.color = color;
		}
	}


	public              List<Cell> cells = new ArrayList<Cell>();
	public static final int        DOWN  = 0;
	public static final int        LEFT  = 1;
	public static final int        RIGHT = 2;

	public PolyominoFactory.Type type;
	public int                   centerPiece;

	Field ownerField;

}
