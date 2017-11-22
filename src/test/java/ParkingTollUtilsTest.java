import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import utils.ParkingTollUtils;

public class ParkingTollUtilsTest {

	
	@Test
	public void givenHoursNumber_whenCalcualteVIPFee_thenReceiveFeeForGivenHour(){
		assertEquals(0, ParkingTollUtils.getVIPDriverTollInHour(1), 0.1);
		assertEquals(2, ParkingTollUtils.getVIPDriverTollInHour(2), 0.1);
		assertEquals(3, ParkingTollUtils.getVIPDriverTollInHour(3), 0.1);
		assertEquals(4.5, ParkingTollUtils.getVIPDriverTollInHour(4), 0.1);
		assertEquals(10.125, ParkingTollUtils.getVIPDriverTollInHour(6), 0.001);
		assertEquals(51.258, ParkingTollUtils.getVIPDriverTollInHour(10), 0.001);
		assertEquals(14963.655, ParkingTollUtils.getVIPDriverTollInHour(24), 0.001);
		assertEquals(251899851.9, ParkingTollUtils.getVIPDriverTollInHour(48), 0.1);
	}
	
	@Test
	public void givenInvalidHoursNumber_whenCalcualteVIPFee_thenReceiveZeroFee(){
		assertEquals(0, ParkingTollUtils.getVIPDriverTollInHour(0), 0.1);
		assertEquals(0, ParkingTollUtils.getVIPDriverTollInHour(-1), 0.1);
	}
	
	@Test
	public void givenHoursNumber_whenCalcualteRegularFee_thenReceiveFeeForGivenHour(){
		assertEquals(1, ParkingTollUtils.getRegularDriverTollInHour(1), 0.1);
		assertEquals(2, ParkingTollUtils.getRegularDriverTollInHour(2), 0.1);
		assertEquals(4, ParkingTollUtils.getRegularDriverTollInHour(3), 0.1);
		assertEquals(8, ParkingTollUtils.getRegularDriverTollInHour(4), 0.1);
		assertEquals(32, ParkingTollUtils.getRegularDriverTollInHour(6), 0.001);
		assertEquals(512, ParkingTollUtils.getRegularDriverTollInHour(10), 0.001);
		assertEquals(8388608, ParkingTollUtils.getRegularDriverTollInHour(24), 0.001);
	}
	
	@Test
	public void givenInvalidHoursNumber_whenCalcualteRegularFee_thenReceiveZeroFee(){
		assertEquals(0, ParkingTollUtils.getRegularDriverTollInHour(0), 0.1);
		assertEquals(0, ParkingTollUtils.getRegularDriverTollInHour(-1), 0.1);
	}
	
	@Test
	public void givenHoursNumberAndDriverType_whenCalcualteFee_thenReceiveFeeForGivenHour(){
		
		assertEquals(1, ParkingTollUtils.getTollInHour(1, 1), 0.1);
		assertEquals(16, ParkingTollUtils.getTollInHour(1, 5), 0.1);
		
		assertEquals(0, ParkingTollUtils.getTollInHour(2, 1), 0.1);
		assertEquals(6.75, ParkingTollUtils.getTollInHour(2, 5), 0.1);
	}
	
	@Test
	public void givenSecondsNumbersAndDriverType_whenCalcualteTotalFee_thenReceiveTotalFee(){
		
		assertEquals(1, ParkingTollUtils.getTotalToll(1, 3), 0.1);
		assertEquals(15, ParkingTollUtils.getTotalToll(1, 3*60*60), 0.1);
		assertEquals(511, ParkingTollUtils.getTotalToll(1, 8*60*60), 0.1);
		
		assertEquals(0, ParkingTollUtils.getTotalToll(2, 3), 0.1);
		assertEquals(9.5, ParkingTollUtils.getTotalToll(2, 3*60*60), 0.1);
		assertEquals(98.52, ParkingTollUtils.getTotalToll(2, 8*60*60), 0.01);
	}
	
	
	@Test
	public void givenSecondsForEachVisitAndDriverType_whenCalcualteFeesSum_thenReceiveFeesSum(){
		
		ArrayList<Long> secondsInDayForEachVisit = new ArrayList<Long>();
		assertEquals(0, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 1), 0.1);
		assertEquals(0, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 2), 0.1);
		
		secondsInDayForEachVisit.add((long) 4);
		assertEquals(1, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 1), 0.1);
		assertEquals(0, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 2), 0.1);
		
		secondsInDayForEachVisit.add((long) 3.1*60*60);
		assertEquals(16, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 1), 0.1);
		assertEquals(9.5, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 2), 0.1);
		
		secondsInDayForEachVisit.add((long) 2*60*60);
		assertEquals(23, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 1), 0.1);
		assertEquals(14.5, ParkingTollUtils.getTotalTollInDay(secondsInDayForEachVisit, 2), 0.1);
	}
	
}
