package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Driver;
import model.User;

public class DriversDAO {

	
	public static boolean addDriver(Driver driver){
		
		String sql = "insert into DRIVERS(USER_ID, DRIVER_NAME, DRIVER_TYPE, VEHICLE_BRAND, VEHICLE_MODEL, VEHICLE_REG) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement statment;
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
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
