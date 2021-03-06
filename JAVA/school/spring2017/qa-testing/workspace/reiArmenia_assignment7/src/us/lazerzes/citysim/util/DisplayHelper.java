package us.lazerzes.citysim.util;

import us.lazerzes.citysim.driver.Driver;
import us.lazerzes.citysim.location.*;

public class DisplayHelper {

	public static void printCoffeeStatus(Driver d) {
		
		if(d.getCoffeeCount() == 0){
			System.out.println(String.format("Driver %d has not gotten any coffee.", d.getDriverID()));
		}else{
			System.out.println(String.format("Driver %d has gotten %d cup(s) of coffee.", d.getDriverID(), d.getCoffeeCount())); 
		}
		
	}
	
	public static void printMove(Driver d, GenericLocation old, GenericLocation via){
		System.out.println(String.format("Driver %d drove from %s to %s via %s", d.getDriverID(), old.getName(), d.getCurrentLocation().getName(), via.getName()));
	}


}
