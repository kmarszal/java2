package agh.cs.lab2;

import java.util.LinkedList;

public class CarSystem {

	public static void main(String[] args) {
		try {
			MoveDirection[] directions = new OptionsParser().parse(args);
			LinkedList<Haystack> haylist = new LinkedList<>();
			haylist.add(new Haystack(new Position(-9, -8)));
			haylist.add(new Haystack(new Position(-8, -9)));
			haylist.add(new Haystack(new Position(7, 7)));
			haylist.add(new Haystack(new Position(3, 6)));
			haylist.add(new Haystack(new Position(2, 0)));
			IWorldMap map = new UnboundedMap(haylist);
			map.add(new Car(map, 2, 2));
			map.add(new Car(map, 3, 3));
			map.run(directions);
			System.out.println(map.toString());
		} catch (IllegalArgumentException ex)
		{
			System.out.println(ex);
		}
	}

}
