package agh.cs.lab2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
	public Map<Integer, Car> cars;

	public AbstractWorldMap() {
		cars = new LinkedHashMap<>();
	}

	@Override
	public boolean canMoveTo(Position position) {
		if (!this.isOccupied(position))
			return true;
		return false;
	}

	@Override
	public boolean add(Car car) {
		if (canMoveTo(car.getPosition())) {
			cars.put(car.hashCode(), car);
			return true;
		} else
			throw new IllegalArgumentException("Position " + car.getPosition().toString() + " is ocuppied");
	}

	@Override
	public void run(MoveDirection[] directions) {
		if (!cars.isEmpty()) {
			Iterator<Car> it = cars.values().iterator();
			for (MoveDirection d : directions) {
				if(it.hasNext()) {
					Car c = it.next();
					Position prev = new Position(c.getPosition().x,c.getPosition().y);
					c.move(d);
					if(!prev.equals(c.getPosition())){
						cars.remove(prev.hashCode());
						cars.put(c.hashCode(), c);
					}
				}
				else{
					it = cars.values().iterator();
					Car c = it.next();
					Position prev = new Position(c.getPosition().x,c.getPosition().y);
					c.move(d);
					if(!prev.equals(c.getPosition())){
						cars.remove(prev.hashCode());
						cars.put(c.hashCode(), c);
					}
				}
			}
		}
	}

	@Override
	public boolean isOccupied(Position position) {
		if (objectAt(position) == null)
			return false;
		return true;
	}

	@Override
	public Object objectAt(Position position) {
		return cars.get(position.hashCode());
	}

}
