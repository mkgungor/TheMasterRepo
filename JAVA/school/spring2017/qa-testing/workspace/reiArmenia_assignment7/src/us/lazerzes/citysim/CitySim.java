package us.lazerzes.citysim;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import us.lazerzes.citysim.city.City;
import us.lazerzes.citysim.driver.Driver;
import us.lazerzes.citysim.test.CitySimTest;
import us.lazerzes.citysim.util.DisplayHelper;
import us.lazerzes.citysim.util.IterationHelper;
import us.lazerzes.citysim.util.RandGen;

public class CitySim {

	public static String gameTitle = "CitySim9003";
	public static String author = "Rei Armenia";
	
	public static RandGen ourRandom = new RandGen();
	
	public static void main(String[] args) {
		
		if(args.length > 0){
			try{
				long seed = (long) Integer.parseInt(args[0]);
				ourRandom.setSeed(seed);
			}catch (NumberFormatException e){
				System.err.println("The argument entered was not an interger! Time will be used instead!");
			}
		}
		
		
		System.out.println(String.format("::%s:: by %s", gameTitle, author));
		City mainCity = new City();
		
		mainCity.loadDefaultMap();
		System.out.println(String.format("City :: %s has Finished Loading!", mainCity.getCityName()));
		
		System.out.println("------------------------");
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		for(int i = 0; i < 5; i++){
			Driver d = new Driver(i);
			d.spawn(mainCity);
			d.checkCurrentPosition();
			drivers.add(d);
		}
		
		for(Driver d : drivers){
			
			IterationHelper.iteration(d, mainCity);
			DisplayHelper.printCoffeeStatus(d);
			System.out.println("------------------------");
		}
		
		System.out.println("------------------------");
		System.out.println("The Program has ended! The final coffee count was:");
		for(Driver d : drivers){
			DisplayHelper.printCoffeeStatus(d);
		}
		System.out.println("------------------------");
		
		//Tests!
		 Result result = JUnitCore.runClasses(CitySimTest.class);
		 for(Failure failure : result.getFailures( )) {
			 System.out.println(failure.toString( ));
		 }
		 System.out.printf("All test cases passed: %b\n", result.wasSuccessful( ));   
		
		System.out.println("------------------------");
		System.out.println("Press ENTER to Continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

}
