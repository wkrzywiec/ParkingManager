package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Driver;
import model.User;

public class DriversDAO {

	
	public static boolean addDriver(Driver driver){
		
		String sql = "insert into DRIVERS(USER_ID, DRIVER_NAME, DRIVER_TYPE, VEHICLE_BRAND, VEHICLE_MODEL, VEHICLE_REG) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement statment = null;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setInt(1, driver.getUserId());
			statment.setString(2, driver.getDriverName());
			statment.setInt(3, driver.getDriverType());
			statment.setString(4, driver.getVehicleBrand());
			statment.setString(5, driver.getVehicleModel());
			statment.setString(6, driver.getVehicleReg());
			
			statment.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			
		}
	}
	
	public static Driver getDriver(String userLogin){
		
		String sql = "select DRIVERS.*  from USERS inner join DRIVERS on USERS.USER_ID = DRIVERS.USER_ID"  +
					" where USERS.USER_LOGIN = ?";
		
		PreparedStatement statment;
		ResultSet rs = null;

			try {
				statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
				statment.setString(1, userLogin);
				rs = statment.executeQuery();
				
				if (rs.next()) {
					int driverId = rs.getInt("DRIVER_ID");
					int userId = rs.getInt("USER_ID");
					String driverName = rs.getString("DRIVER_NAME");
					int driverType = rs.getInt("DRIVER_TYPE");
					String vehicleBrand = rs.getString("VEHICLE_BRAND");
					String vehicleModel = rs.getString("VEHICLE_MODEL");
					String vehicleReg = rs.getString("VEHICLE_REG");
					Driver driver = new Driver(userId, driverName, driverType, vehicleBrand, vehicleModel, vehicleReg);
			        driver.setDriverId(driverId);
					return driver;
			    }
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
	}
	
}
