package us.lazerzes.citysim.util;

import java.util.ArrayList;
import java.util.Random;

import us.lazerzes.citysim.city.City;
import us.lazerzes.citysim.driver.Driver;
import us.lazerzes.citysim.location.*;

public class IterationHelper {
	
	public static void iteration(Driver d, City city, Random random){
		
		boolean running = true;
		
		while(running){
			
			GenericLocation cur = d.getCurrentLocation(), via, end;
			ArrayList<GenericLocation> possibles = DirectionHelper.getSurrounding(cur, city);
			
			if(possibles.equals(null)){
				System.err.println(String.format("Program was unable to find any surrounding locations for %s -- Ending Program!", cur.getName()));
				System.exit(1);
			}
			
			ArrayList<GenericLocation> removes = new ArrayList<GenericLocation>();
			for(GenericLocation l : possibles){
				if(!(l instanceof LocationStreet)){
					removes.add(l);
				}else if(!DirectionHelper.isLegalMove(cur, l)){
					removes.add(l);
				}
			}
			
			possibles.removeAll(removes);
			
			if(possibles.isEmpty()){
				System.err.println(String.format("Program was unable to find any legal moves for Driver %d -- Ending Program!", d.getDriverID()));
				System.exit(1);
			}
			
			int gen = random.nextInt(possibles.size());
			via = possibles.get(gen);
			
			Direction dirMoved = DirectionHelper.directionMoved(cur, via);
			
			end = city.getLocationAt(via.getPosition().x + dirMoved.getGridMovement().x, via.getPosition().y + dirMoved.getGridMovement().y);
			
			if(end.equals(null)){
				System.err.println(String.format("Whoops! Driver %d may have driven off the world! The map may not have been initialized properly! -- Ending Program!", d.getDriverID()));
				System.exit(1);
			}
			
			d.setCurrentLocation(end);
			DisplayHelper.printMove(d, cur, via);
			
			if(!d.checkCurrentPosition()){
				System.out.println(String.format("Driver %d has left the city and gone to %s! Thanks for visiting Driver %d!", d.getDriverID(), d.getCurrentLocation().getName(), d.getDriverID()));
				running = false;
			}
			
		}
		
	}
	
}
