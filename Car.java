package agh.cs.lab2;

public class Car extends AbstractWorldMapElement{
	private MapDirection Direction;
	private IWorldMap Map;
	
	public String toString() {
		switch (Direction){
		case North:
			return "N";
		case East:
			return "E";
		case South:
			return "S";
		case West:
			return "W";
		default:
			return "";
		}
	}

	public Car() {
		super(new Position(2,2));
		this.Direction = MapDirection.North;
	}

	public Car(IWorldMap map)
	{
		super(new Position(2,2));
		this.Map = map;
		this.Direction = MapDirection.North;
	}
	
	public Car(IWorldMap map, int x, int y)
	{
		super(new Position(x,y));
		this.Map = map;
		this.Direction = MapDirection.North;
	}
		
	public void move(MoveDirection direction) {
		if (direction.equals(MoveDirection.Right)) {
			this.Direction = this.Direction.Previous();
		}
		if (direction.equals(MoveDirection.Left)) {
			this.Direction = this.Direction.Next();
		}
		if (direction.equals(MoveDirection.Forward)) {
			switch (this.Direction) {
			case North: {
				Position newpos = new Position(this.Pos.x, this.Pos.y + 1);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			case South: {
				Position newpos = new Position(this.Pos.x, this.Pos.y - 1);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			case East: {
				Position newpos = new Position(this.Pos.x - 1, this.Pos.y);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			case West: {
				Position newpos = new Position(this.Pos.x + 1, this.Pos.y);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			}
		} if(direction.equals(MoveDirection.Backward)) {
			switch (this.Direction) {
			case North: {
				Position newpos = new Position(this.Pos.x, this.Pos.y - 1);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			case South: {
				Position newpos = new Position(this.Pos.x, this.Pos.y + 1);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			case East: {
				Position newpos = new Position(this.Pos.x + 1, this.Pos.y);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			case West: {
				Position newpos = new Position(this.Pos.x - 1, this.Pos.y);
				if (Map.canMoveTo(newpos))
					this.Pos = newpos;
				break;
			}
			}
		}
	}
}