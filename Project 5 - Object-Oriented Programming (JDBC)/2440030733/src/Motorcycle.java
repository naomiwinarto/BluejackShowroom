
public class Motorcycle extends Vehicle{
	private int helmCount;

	public Motorcycle(String vehicleID, String vehicleName, String vehicleType, int basePrice, String gasType,
			int helmCount) {
		super(vehicleID, vehicleName, vehicleType, basePrice, gasType);
		this.helmCount = helmCount;
	}
	public int getHelmCount() {
		return helmCount;
	}
	public void setHelmCount(int helmCount) {
		this.helmCount = helmCount;
	}

	@Override
	public int calculateTotalPrice(int basePrice, int quantity) {
		// TODO Auto-generated method stub
		int totalPrice = (basePrice+(500*helmCount));
		
		return totalPrice;
	}

	@Override
	public void printDesc() {
		// TODO Auto-generated method stub
		System.out.println("Description \t: Get " + helmCount + " Helm(s)");
	}

}
