
public class Car extends Vehicle{
	private String seatbeltColor;

	public Car(String vehicleID, String vehicleName, String vehicleType, int basePrice, String gasType,
			String seatbeltColor) {
		super(vehicleID, vehicleName, vehicleType, basePrice, gasType);
		this.seatbeltColor = seatbeltColor;
	}

	public String getSeatbeltColor() {
		return seatbeltColor;
	}

	public void setSeatbeltColor(String seatbeltColor) {
		this.seatbeltColor = seatbeltColor;
	}

	@Override
	public int calculateTotalPrice(int basePrice, int quantity) {
		// TODO Auto-generated method stub
		int totalPrice = (basePrice+2000)*quantity;
		
		return totalPrice;
	}

	@Override
	public void printDesc() {
		System.out.println("Description \t: Get " + seatbeltColor + " Seatbelt");
	}
	
}
