
public abstract class Vehicle {
	private String vehicleID, vehicleName, vehicleType;
	private int basePrice;
	private String gasType;
	
	public abstract int calculateTotalPrice(int basePrice, int quantity);
	public abstract void printDesc();
	
	public Vehicle(String vehicleID, String vehicleName, String vehicleType, int basePrice, String gasType) {
		super();
		this.vehicleID = vehicleID;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.basePrice = basePrice;
		this.gasType = gasType;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public String getGasType() {
		return gasType;
	}
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	
}
