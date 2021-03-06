package us.lazerzes.citysim.location;

import us.lazerzes.citysim.util.Direction;

public class LocationStreet extends GenericLocation {

	protected boolean isOneWay;
	protected Direction flowDirection;
	
	public LocationStreet(int x, int y, String streetName, boolean oneWay, Direction flow){
		
		super(x, y, streetName);
		this.isOneWay = oneWay;
		this.flowDirection = flow;
		
	}
	
	public LocationStreet(LocationStreet another){
		super(another.getPosition().x, another.getPosition().y, another.getName());
		this.isOneWay = another.isOneWay;
		this.flowDirection = another.flowDirection;
	}
	
	@Override
	public boolean isOneWay(){
		return this.isOneWay;
	}
	
	@Override
	public Direction getDirection(){
		return this.flowDirection;
	}
	
	@Override
	public GenericLocation clone(){
		return new LocationStreet(this);
	}

}
