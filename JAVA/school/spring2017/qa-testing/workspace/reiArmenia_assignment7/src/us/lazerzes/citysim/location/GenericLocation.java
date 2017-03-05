package us.lazerzes.citysim.location;

import java.awt.Point;

import us.lazerzes.citysim.util.Direction;

public class GenericLocation{
	
	protected Point locationPosition;
	protected String locationName;
	
	public GenericLocation(int x, int y){
		locationPosition = new Point(x,y);
		locationName = String.format("%d.%d", x, y);
	}
	
	public GenericLocation(int x, int y, String name){
		locationPosition = new Point(x,y);
		locationName = name;
	}
	
	public GenericLocation(GenericLocation another){
		
		this.locationPosition = new Point(another.locationPosition);
		this.locationName = new String(another.locationName);
		
	}
	
	public Point getPosition(){
		return this.locationPosition;
	}
	
	public String getName(){
		return this.locationName;
	}
	
	public boolean isOneWay(){
		return false;
	}
	
	public Direction getDirection(){
		return null;
	}
	
	public GenericLocation clone(){
		return new GenericLocation(this);
	}
	
}
