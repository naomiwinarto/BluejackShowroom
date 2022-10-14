import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Repository {

	private static Repository instance;
	Connect connect = Connect.getConnection();
	
	public Repository() {
		// TODO Auto-generated constructor stub
	}
	
	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
		}
		return instance;
	}

	public ArrayList<Vehicle> getVehicleData(){
		ArrayList<Vehicle> vehicleList = new ArrayList<>();
		
		vehicleList = getCarData(vehicleList);
		vehicleList = getMotorcycleData(vehicleList);
		
		return vehicleList;
	}
	
	private ArrayList<Vehicle> getMotorcycleData(ArrayList<Vehicle> vehicleList) {
		String query = "SELECT * FROM motorcycle";
		ResultSet rs = connect.executeQuery(query);
		
		try {
			while(rs.next()) {
				String vehicleType = "Motor";
				String vehicleID = rs.getString(1);
				String vehicleName = rs.getString(2);
				int basePrice = rs.getInt(3);
				String gasType = rs.getString(4);
				int helmCount = rs.getInt(5);
				
				vehicleList.add(new Motorcycle(vehicleID, vehicleName, vehicleType, basePrice, gasType, helmCount));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehicleList;
	}

	private ArrayList<Vehicle> getCarData(ArrayList<Vehicle> vehicleList) {
		String query = "SELECT * FROM car";
		ResultSet rs = connect.executeQuery(query);
		
		try {
			while(rs.next()) {
				String vehicleType = "Car";
				String vehicleID = rs.getString(1);
				String vehicleName = rs.getString(2);
				int basePrice = rs.getInt(3);
				String gasType = rs.getString(4);
				String seatbeltColor = rs.getString(5);
				
				vehicleList.add(new Car(vehicleID, vehicleName, vehicleType, basePrice, gasType, seatbeltColor));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleList;
	}

	public ArrayList<Transaction> getTransactionData(){
		ArrayList<Transaction> transactionList = new ArrayList<>();
		
		String query = "SELECT TransactionId,  CustomerName, CustomerEmail, VehicleName, VehiclePrice, Quantity "
				+ "FROM transactions JOIN car ON transactions.VehicleId = car.VehicleId\r\n" + 
				"UNION\r\n" + 
				"SELECT TransactionId,  CustomerName, CustomerEmail, VehicleName, VehiclePrice, Quantity "
				+ "FROM transactions JOIN motorcycle ON transactions.VehicleId = motorcycle.VehicleId\r\n" + 
				"ORDER BY TransactionId";
		ResultSet rs = connect.executeQuery(query);

		try {
			while(rs.next()) {
				String transactionID = rs.getString(1);
				String customerName = rs.getString(2);
				String customerEmail = rs.getString(3);
				String productName = rs.getString(4);
				int basePrice = rs.getInt(5);
				int quantity = rs.getInt(6);
				
				transactionList.add(new Transaction(transactionID, customerName, customerEmail, productName, basePrice, quantity));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionList;
	}

	public void deleteTransaction(String toBeDelID) {
		// TODO Auto-generated method stub
		String query = String.format("DELETE FROM transactions WHERE TransactionId = '%s'", toBeDelID);
		connect.executeUpdate(query);
	}

	public void insertTransaction(String vehicleID, String customerName, String customerEmail, int quantity) {
		// TODO Auto-generated method stub
		String query = String.format("INSERT INTO `transactions`(`TransactionId`, `VehicleId`, "
				+ "`CustomerName`, `CustomerEmail`, `Quantity`) VALUES ('%s','%s','%s','%s','%d')", 
				generateTransactionID(), vehicleID, customerName, customerEmail, quantity);
		connect.executeUpdate(query);
	}

	private String generateTransactionID() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		String transactionID;
		do {
			transactionID = "TR" + rand.nextInt(1000);
		} while (idExists(transactionID));
		return transactionID;
	}

	private boolean idExists(String transactionID) {
		// TODO Auto-generated method stub
		String query = String.format("SELECT null FROM transactions WHERE TransactionId = '%s'", transactionID);
		ResultSet rs = connect.executeQuery(query);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
