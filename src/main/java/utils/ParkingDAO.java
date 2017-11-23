package utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.CarLog;
import model.Driver;
import model.VisitDetails;

public class ParkingDAO {
	
	public static long getParkingTimeSec(int driverId){
		String sql = 	"select TIMESTAMPDIFF(SECOND,DATE_START,CURRENT_TIMESTAMP()) " +
						"from  car_logs where DATE_STOP is null and driver_id =  ?";
		long parkingTimeSec = 0;	
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setInt(1, driverId);
			
			ResultSet rs = statment.executeQuery();
			
			if (rs.next()) {
				parkingTimeSec = rs.getLong(1);	
			}	
			return parkingTimeSec;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return parkingTimeSec;
		}
	}

	public static int startVisit(int driverId) {
		
		int respond = 0;
		String sql = "insert into CAR_LOGS(DRIVER_ID, DATE_START) values(?,CURRENT_TIMESTAMP())";
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setInt(1, driverId);
			
			respond = statment.executeUpdate();
			return respond;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return respond;
		}
		
	}
	
	public static int stopVisit(int driverId) {
		
		int respond = 0;
		String sql = "update CAR_LOGS set DATE_STOP = CURRENT_TIMESTAMP()"
				+ 	" where DRIVER_ID = ? and DATE_STOP is null";
		
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setInt(1, driverId);
			
			respond = statment.executeUpdate();
			return respond;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return respond;
		}
	}
	
	public static ArrayList<CarLog> getParkingHistory(int driverId, int driverType){
		String sql = 	"select DATE_START, DATE_STOP, TIMESTAMPDIFF(SECOND,DATE_START,DATE_STOP) " +
						"from  car_logs where DATE_STOP is not null and driver_id =  ? "
						+ "order by DATE_START DESC";
		
		ArrayList<CarLog> carLogList = new ArrayList<CarLog>();
		PreparedStatement statment;
		
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setInt(1, driverId);
			
			ResultSet rs = statment.executeQuery();
			
			while (rs.next()) {
				CarLog carLog = new CarLog();
				carLog.setDriverId(driverId);
				Timestamp dateStart = rs.getTimestamp(1);
				Timestamp dateStop = rs.getTimestamp(2);
				long parkingTimeSec = rs.getLong(3);
				
				carLog.setDateStart(dateStart);
				carLog.setDateStop(dateStop);
				carLog.setParkingTimeFromSec(parkingTimeSec);
				carLog.setToll(ParkingTollUtils.getTotalToll(driverType, parkingTimeSec));
				
				carLogList.add(carLog);
				
			}	
			return carLogList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}
	}
	
	public static ArrayList<Long> getSecondsInDayForEachVisit(String dateString, int driverType) {
		
		String sql = 	"select TIMESTAMPDIFF(SECOND,CAR_LOGS.DATE_START,CAR_LOGS.DATE_STOP) " +
						"from CAR_LOGS join DRIVERS on CAR_LOGS.DRIVER_ID = DRIVERS.DRIVER_ID " +
						"where date(CAR_LOGS.DATE_STOP) = ? and DRIVERS.DRIVER_TYPE = ?";
		
		PreparedStatement statment;
		ArrayList<Long> secondsInDayForEachVisit = new ArrayList<Long>();
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setDate(1, Date.valueOf(dateString));
			statment.setInt(2, driverType);
			
			ResultSet rs = statment.executeQuery();
			
			while (rs.next()) {
				secondsInDayForEachVisit.add(rs.getLong(1));
			}	
			return secondsInDayForEachVisit;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return secondsInDayForEachVisit;
		}
	}
	
	public static ArrayList<VisitDetails> getDriverListOnParking(){
		
		String sql = 	"select D.DRIVER_ID , D.DRIVER_NAME, D.VEHICLE_BRAND, D.VEHICLE_MODEL, D.VEHICLE_REG, C.DATE_START " +
						"from CAR_LOGS C join DRIVERS D on C.DRIVER_ID = D.DRIVER_ID " +
						"where C.DATE_STOP is null";
		
		PreparedStatement statment;
		ArrayList<VisitDetails> driverListOnParking = new ArrayList<VisitDetails>();
		
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			
			while (rs.next()) {
				Driver driver = new Driver();
				driver.setDriverId(rs.getInt(1));
				driver.setDriverName(rs.getString(2));
				driver.setVehicleBrand(rs.getString(3));
				driver.setVehicleModel(rs.getString(4));
				driver.setVehicleReg(rs.getString(5));
				Timestamp startDate = rs.getTimestamp(6);
				
				VisitDetails visit = new VisitDetails();
				visit.setDriver(driver);
				visit.setDateStart(startDate);
				driverListOnParking.add(visit);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return driverListOnParking;
	}

}
