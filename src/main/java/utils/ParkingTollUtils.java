package utils;

import java.util.ArrayList;

import model.Driver;

public class ParkingTollUtils {

	public static double getTotalTollInDay(ArrayList<Long> secondsInDayForEachVisit, int driverType){
		
		double sum = 0;
		
		for(Long seconds : secondsInDayForEachVisit){
			sum = sum + getTotalToll(driverType, seconds);
		}
		return sum;
	}
	
	
	public static double getTotalToll(int driverType, long seconds){

		double totalToll = 0;

		int hours = (int) Math.ceil(seconds/60/60);

		for(int i = 1; i <= hours; i++) {
			totalToll= totalToll + getTollInHour(driverType, i);
		}
		return totalToll;

	}

	private static double getTollInHour(int driverType, int i){

		if (driverType == Driver.DRIVER_VIP){	
			return getVIPDriverTollInHour(i);
		} else {
			return getRegularDriverTollInHour(i);
			}
	}

	private static double getRegularDriverTollInHour(int hour){
			
		if (hour == 1){
		    return 1;
		} else if (hour == 2){
		    return 3;
		} else {
		    return 2*getRegularDriverTollInHour(hour-1);
		}
	}

	private static double getVIPDriverTollInHour(int hour){
			
		if (hour == 1){
			return 0;
		} else if (hour == 2){
		    return 2;
		} else {
			return 1.5*getVIPDriverTollInHour(hour-1);
		}

	}
}
