package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAO {

	
	public static boolean addUser(User user){
		
		String sql = "insert into USERS(USER_LOGIN, USER_PASSWORD, USER_TYPE) values(?,?,?)";
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setString(1, user.getUserLogin());
			statment.setString(2, user.getUserPassword());
			statment.setInt(3, user.getUserType());
			
			statment.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static int findUserId(String userLogin){
		
		String sql = "select USER_ID from USERS where USER_LOGIN = ?";
		
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setString(1, userLogin);
			
			ResultSet rs = statment.executeQuery();
			
			if (rs.next()) {
				int userId = rs.getInt("USER_ID");
		        return userId;
		    }
			return 0;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	
	public static boolean isNewUser(String userLogin){
		
		String sql = "select USER_ID from USERS where USER_LOGIN = ?";
		
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			statment.setString(1, userLogin);
			
			ResultSet rs = statment.executeQuery();
			
			if (rs.next()) {
		        return false;
		    }
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return true;
		}
	}
	
	public static int getUserType(String userLogin, String userPassword){
		
		String sql = "select USER_TYPE from USERS where USER_LOGIN = ? and USER_PASSWORD = ?";
		System.out.println("/" + userLogin +"/" + userPassword + "/");
		PreparedStatement statment;
		try {
			statment = DatabaseConnUtils.getConnection().prepareStatement(sql);
			
			statment.setString(1, userLogin);
			statment.setString(2, userPassword);
			
			ResultSet rs = statment.executeQuery();
			
			if (rs.next()) {
		        return rs.getInt("USER_TYPE");
		    }
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}


