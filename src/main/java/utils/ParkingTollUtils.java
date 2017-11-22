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

		int hours = (int) Math.floor(seconds/60/60);
		hours = hours + 1;
		
		for(int i = 1; i <= hours; i++) {
			totalToll= totalToll + getTollInHour(driverType, i);
		}
		return totalToll;

	}

	public static double getTollInHour(int driverType, int hour){

		if (driverType == Driver.DRIVER_VIP){	
			return getVIPDriverTollInHour(hour);
		} else {
			return getRegularDriverTollInHour(hour);
			}
	}

	public static double getRegularDriverTollInHour(int hour){
		if(hour >= 0){
			if (hour == 1){
			    return 1;
			} else if (hour == 2){
			    return 2;
			} else {
			    return 2*getRegularDriverTollInHour(hour-1);
			}
		} else 
			return 0;
		
	}

	public static double getVIPDriverTollInHour(int hour){
		if (hour >= 0){
			if (hour == 1){
				return 0;
			} else if (hour == 2){
			    return 2;
			} else {
				return 1.5*getVIPDriverTollInHour(hour-1);
			}
		} else 
			return 0;
	}
}
