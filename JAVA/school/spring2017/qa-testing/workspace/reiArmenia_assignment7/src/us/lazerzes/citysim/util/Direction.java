package us.lazerzes.citysim.util;

import java.awt.Point;

public enum Direction {

	NORTH(1, 0, -1),
	SOUTH(3, 0, 1),
	EAST(2, 1, 0),
	WEST(4, -1, 0);
	
	private final int enumValue;
	private final Point enumPoint;
	
	private Direction(int val, int x, int y){
		
		enumValue = val;
		enumPoint = new Point(x, y);
		
	}
	
	public int toInt(){
		return enumValue;
	}
	
	public Point getGridMovement(){
		return new Point(enumPoint);
	}
	
}
