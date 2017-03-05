package us.lazerzes.citysim.util;

import java.util.Date;
import java.util.Random;

public class RandGen {
	
	private Random random = new Random(new Date().getTime());
	
	
	public void setSeed(long seed){
		
		random.setSeed(seed);
		
	}

	public int getRandomNumber(int upperBound){
		
		return random.nextInt(upperBound);
		
	}
	
}
