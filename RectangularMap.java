package agh.cs.lab2;

public class RectangularMap extends AbstractWorldMap {
	public int width;
	public int height;
	
	public RectangularMap(int width, int height)
	{
		super();
		this.height = height;
		this.width = width;
	}
	
	@Override
	public boolean canMoveTo(Position pos)
	{
		if (!this.isOccupied(pos) && pos.smaller(new Position(width,height)) && pos.larger(new Position(0,0)))
			return true;
			return false;
	}
	
	public String toString()
	{
		return new MapVisualizer().dump(this, new Position(0,0), new Position(width,height));
	}

}
