package agh.cs.lab2;

public abstract class AbstractWorldMapElement {
	protected Position Pos;
	
	public AbstractWorldMapElement(Position Pos)
	{
		this.Pos = Pos;
	}
	
	@Override
	public int hashCode() {
		return Pos.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractWorldMapElement other = (AbstractWorldMapElement) obj;
		if (Pos == null) {
			if (other.Pos != null)
				return false;
		} else if (!Pos.equals(other.Pos))
			return false;
		return true;
	}

	public Position getPosition()
	{
		return this.Pos;
	}
}
