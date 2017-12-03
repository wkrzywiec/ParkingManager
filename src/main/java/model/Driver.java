package model;

public class Driver {

	public static final int DRIVER_REGULAR = 1;
	public static final int DRIVER_VIP = 2;
	
	private int driverId;
	private int userId;
	private String driverName;
	private int driverType;
	private String vehicleBrand;
	private String vehicleModel;
	private String vehicleReg;
	
	public Driver(	int userId,
					String driverName,
					int driverType,
					String vehicleBrand,
					String vehicleModel,
					String vehicleReg){
		
		this.driverId = driverId;
		this.userId = userId;
		this.driverName = driverName;
		this.driverType = driverType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.vehicleReg = vehicleReg;
	}
	
	public Driver(){
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getDriverType() {
		return driverType;
	}
	public void setDriverType(int driverType) {
		this.driverType = driverType;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleReg() {
		return vehicleReg;
	}
	public void setVehicleReg(String vehicleReg) {
		this.vehicleReg = vehicleReg;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	
}
