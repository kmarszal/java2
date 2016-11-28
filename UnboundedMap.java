package agh.cs.lab2;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class UnboundedMap extends AbstractWorldMap {
	public Map<Integer,Haystack> haymap;
	
	
	UnboundedMap(LinkedList<Haystack> haylist)
	{
		super();
		haymap = new LinkedHashMap<>();
		for(Haystack h : haylist)
		{
			haymap.put(h.hashCode(), h);
		}
	}
	
	public String toString()
	{
		int xmin;
		int xmax;
		int ymin;
		int ymax;
		if(!cars.isEmpty())
		{
			xmin = cars.values().iterator().next().getPosition().x;
			xmax = xmin;
			ymin = cars.values().iterator().next().getPosition().y;
			ymax = ymin;
		}
		else if(!haymap.isEmpty())
		{
			xmin = cars.values().iterator().next().getPosition().x;
			xmax = xmin;
			ymin = cars.values().iterator().next().getPosition().y;
			ymax = ymin;
		}
		else
		{
			xmin = 0;
			xmax = 0;
			ymin = 0;
			ymax = 0;
		}
		for(AbstractWorldMapElement e : cars.values())
		{
			if(xmin>e.getPosition().x)
			{
				xmin = e.getPosition().x;
			}
			if(xmax<e.getPosition().x)
			{
				xmax = e.getPosition().x;
			}
			if(ymin>e.getPosition().y)
			{
				ymin = e.getPosition().y;
			}
			if(ymax<e.getPosition().y)
			{
				ymax = e.getPosition().y;
			}
		}
		for(AbstractWorldMapElement e : haymap.values())
		{
			if(xmin>e.getPosition().x)
			{
				xmin = e.getPosition().x;
			}
			if(xmax<e.getPosition().x)
			{
				xmax = e.getPosition().x;
			}
			if(ymin>e.getPosition().y)
			{
				ymin = e.getPosition().y;
			}
			if(ymax<e.getPosition().y)
			{
				ymax = e.getPosition().y;
			}
		}
		return new MapVisualizer().dump(this,new Position(xmin,ymin),new Position(xmax,ymax));
	}

}
