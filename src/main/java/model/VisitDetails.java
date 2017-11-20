package model;

import java.sql.Timestamp;

public class VisitDetails {

	private Driver driver;
	private Timestamp dateStart;
	private Timestamp dateStop;
	
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
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
	
	
	
}
