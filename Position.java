package agh.cs.lab2;

public class Position {
	public final int x;
	public final int y;
	public Position(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public String toString()
	{
		return new String("(" + x + "," + y + ")");
	}
	
	public boolean smaller(Position other)
	{
		return this.x<=other.x && this.y<=other.y;
	}
	
	public boolean larger(Position other)
	{
		return this.x>=other.x && this.y>=other.y;
	}
	
	public Position add(Position other)
	{
		return new Position(this.x+other.x,this.y+other.y);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}
