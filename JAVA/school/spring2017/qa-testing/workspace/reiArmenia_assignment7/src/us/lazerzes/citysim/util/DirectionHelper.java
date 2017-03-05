package us.lazerzes.citysim.util;

import java.awt.Point;
import java.util.ArrayList;

import us.lazerzes.citysim.city.City;
import us.lazerzes.citysim.location.*;
import us.lazerzes.citysim.util.Direction;

public class DirectionHelper {

	public static ArrayList<GenericLocation> getSurrounding(GenericLocation currentLocation, City currentCity){
		
		ArrayList<GenericLocation> surrounding = new ArrayList<GenericLocation>();
		Point currentPoint = currentLocation.getPosition();
		
		if(currentCity.getLocationAt(currentPoint.x + 1, currentPoint.y).getPosition().x != -1){
			surrounding.add(currentCity.getLocationAt(currentPoint.x + 1, currentPoint.y));
		}
		
		if(currentCity.getLocationAt(currentPoint.x - 1, currentPoint.y).getPosition().x != -1){
			surrounding.add(currentCity.getLocationAt(currentPoint.x - 1, currentPoint.y));
		}
		
		if(currentCity.getLocationAt(currentPoint.x, currentPoint.y + 1).getPosition().x != -1){
			surrounding.add(currentCity.getLocationAt(currentPoint.x, currentPoint.y + 1));
		}
		
		if(currentCity.getLocationAt(currentPoint.x, currentPoint.y - 1).getPosition().x != -1){
			surrounding.add(currentCity.getLocationAt(currentPoint.x, currentPoint.y - 1));
		}
		
		
		if(surrounding.isEmpty()){
			return null;
		}
		
		return surrounding;
		
	}
	
	public static boolean isLegalMove(GenericLocation from, GenericLocation to){
		
		if(!(to instanceof LocationStreet)){
			return false;
		}
		
		if(to.isOneWay() && DirectionHelper.directionMoved(from, to) != to.getDirection()){
			return false;
		}
		
		if(to.getDirection().toInt() % 2 != DirectionHelper.directionMoved(from, to).toInt() % 2 ){
			return false;
		}
		
		return true;
		
	}
	
	public static Direction directionMoved(GenericLocation from, GenericLocation to){
		
		Point fPt = from.getPosition(), tPt = to.getPosition();
		int x = (fPt.x - tPt.x);
		int y = (fPt.y - tPt.y);
		
		if(x >= 1 && y == 0){ 
			return Direction.WEST;
		}else if(x <= -1 && y == 0){
			return Direction.EAST;
		}else if(x == 0 && y <= -1){
			return Direction.SOUTH;
		}else if(x == 0 && y >= 1){
			return Direction.NORTH;
		}
		
		return Direction.NORTH;
	}

}
