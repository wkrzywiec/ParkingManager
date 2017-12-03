package model;

import java.sql.Timestamp;

public class CarLog {
	
	private int visitId;
	private int driverId;
	private Timestamp dateStart;
	private Timestamp dateStop;
	private int parkingTimeHour;
	private double toll;
	
	public CarLog(int driverId, Timestamp dateStart) {
		this.driverId = driverId;
		this.dateStart = dateStart;
	}
	
	public CarLog(){
		
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public Timestamp getDateStart() {
		return dateStart;
	}

	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}

	public Timestamp getDateStop() {
		return dateStop;
	}

	public void setDateStop(Timestamp dateStop) {
		this.dateStop = dateStop;
	}

	public double getToll() {
		return toll;
	}

	public void setToll(double toll) {
		this.toll = toll;
	}

	public int getParkingTimeHour() {
		return parkingTimeHour;
	}

	public void setParkingTimeHour(int parkingTimeHour) {
		this.parkingTimeHour = parkingTimeHour;
	}
	
	public void setParkingTimeFromSec (long parkingTimeSec){
		double hours = parkingTimeSec/60/60;
		this.parkingTimeHour = (int) Math.floor(hours) + 1;
	}
	
	
	
	

}
