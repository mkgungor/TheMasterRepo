package us.lazerzes.citysim.driver;

import java.util.ArrayList;

import us.lazerzes.citysim.CitySim;
import us.lazerzes.citysim.city.City;
import us.lazerzes.citysim.location.*;

public class Driver {

	protected int driverID;
	protected GenericLocation currentLocation;
	protected int coffeeCount;
	
	public Driver(int driverNumber){
		this.driverID = driverNumber;
		this.currentLocation = null;
		this.coffeeCount = 0;
	}
	
	public void spawn(City spawnCity){
		
		ArrayList<GenericLocation> possible = new ArrayList<GenericLocation>();
		
		for(int i = 0; i < spawnCity.getCitySize(); i++){
			if(spawnCity.getLocationAt(i) instanceof LocationBuilding){
				possible.add(spawnCity.getLocationAt(i));
			}
		}
		
		ArrayList<GenericLocation> toRemove = new ArrayList<GenericLocation>();
		
		for(GenericLocation l : possible){
			if(l.equals(null)){
				toRemove.add(l);
			}
		}
		
		possible.removeAll(toRemove);
		
		if(possible.isEmpty()){
			System.err.println(String.format("Unable to Spawn Driver #%d, there are no valid Spawn Locations!", this.driverID));
			System.exit(1);
		}else{
			int x = CitySim.ourRandom.getRandomNumber(possible.size());
			this.currentLocation = possible.get(x);
		}
		
	}
	
	public boolean checkCurrentPosition(){
		
		if(this.currentLocation instanceof LocationCityLimits){
			return false;
		}
		
		if(this.currentLocation.getName().equals("Coffee")){
			this.coffeeCount++;
		}
	
		return true;
	}
	
	public int getCoffeeCount(){
		return this.coffeeCount;
	}
	
	public int getDriverID(){
		return this.driverID;
	}
	
	public GenericLocation getCurrentLocation(){
		return this.currentLocation;
	}
	
	public void setCurrentLocation(GenericLocation newLocation){
		this.currentLocation = newLocation;
	}
	
}
