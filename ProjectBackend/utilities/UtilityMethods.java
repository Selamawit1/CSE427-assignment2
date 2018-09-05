package utilities;

import java.util.Random;

public class UtilityMethods {
	private static Random Rand = new Random();
	
	private static boolean leapYears(int year) {
		return ((year % 4 == 0) && year % 100 != 0) || year % 400 == 0;
	}
	
	private static int randIntFromOne(int endInclusive) {
		return Rand.nextInt(endInclusive) + 1;
	}
	public static Date getRandomDate() {
		int year = 2018 - Rand.nextInt(100);
		int month = randIntFromOne(12);
		int day;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = randIntFromOne(31);
		}else if(month == 2 && leapYears(year)) {
			day = randIntFromOne(29);
		}else if(month == 2) {
			day = randIntFromOne(28);
		}else {
			day = randIntFromOne(30);
 		}
		return new Date(month, day, year);
	}

}
