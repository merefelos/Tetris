package application;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Anna on 20/06/2015.
 */
public class PolyominoFactory
{
	public static Polyomino produceRandomPolyomino(Field field)
	{
		Type[] list = Type.values();
		Random random = new Random(System.currentTimeMillis());
		int theRandom = random.nextInt(list.length);
		Type type = list[theRandom];

		Polyomino poly = new Polyomino(field, type);

		switch (type)
		{
			case i:
				poly.cells.add(new Cell(0, 0));
				poly.cells.add(new Cell(0, 1));
				poly.cells.add(new Cell(0, 2));
				poly.cells.add(new Cell(0, 3));
				break;
			case o:
				poly.cells.add(new Cell(1, 1));
				poly.cells.add(new Cell(1, 0));
				poly.cells.add(new Cell(0, 1));
				poly.cells.add(new Cell(0, 0));
				break;
			case t:
				poly.centerPiece = 1;
				poly.cells.add(new Cell(0, 0));
				poly.cells.add(new Cell(1, 0));
				poly.cells.add(new Cell(2, 0));
				poly.cells.add(new Cell(1, 1));

				break;
			case l:
				poly.centerPiece = 1;
				poly.cells.add(new Cell(0, 0));
				poly.cells.add(new Cell(0, 1));
				poly.cells.add(new Cell(0, 2));
				poly.cells.add(new Cell(1, 2));
				break;
			case rl:
				poly.centerPiece = 1;
				poly.cells.add(new Cell(1, 0));
				poly.cells.add(new Cell(1, 1));
				poly.cells.add(new Cell(1, 2));
				poly.cells.add(new Cell(0, 2));
				break;
			case s:
				poly.centerPiece = 1;
				poly.cells.add(new Cell(0, 0));
				poly.cells.add(new Cell(0, 1));
				poly.cells.add(new Cell(1, 1));
				poly.cells.add(new Cell(1, 2));
				break;
			case rs:
				poly.centerPiece = 2;
				poly.cells.add(new Cell(1, 0));
				poly.cells.add(new Cell(1, 1));
				poly.cells.add(new Cell(0, 1));
				poly.cells.add(new Cell(0, 2));
				break;
		}

		poly.setColor(new ColorScheme().get(poly.type));

		return poly;
	}

	public static Polyomino polyominoClone(Polyomino polyomino)
	{
		Polyomino poly = new Polyomino(polyomino.ownerField, polyomino.type);
		for (Cell cell : polyomino.cells)
		{
			poly.cells.add(new Cell(cell.logicalX, cell.logicalY));
		}
		return poly;
	}

	public enum Type
	{
		i, o, t, l, rl, s, rs
	}

	private static class ColorScheme extends HashMap<Type, Color>
	{
		public ColorScheme()
		{
			this.put(Type.s, Color.blue);
			this.put(Type.o, Color.red);
			this.put(Type.t, Color.WHITE);
			this.put(Type.i, Color.GREEN);
			this.put(Type.l, Color.cyan);
			this.put(Type.rl, Color.yellow);
			this.put(Type.rs, Color.magenta);
		}
	}
}
