package model;

public class User {
	
	public static final int USER_TYPE_OWNER = 1;
	public static final int USER_TYPE_OPERATOR = 2;
	public static final int USER_TYPE_DRIVER = 3;
	
	private String userLogin;
	private String userPassword;
	private int userType;
	
	public User(	String userLogin,
					String userPassword,
					int userType){
		
		this.userLogin = userLogin;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	

}
