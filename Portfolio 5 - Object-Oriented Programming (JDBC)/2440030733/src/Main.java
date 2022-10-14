import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Repository repo = Repository.getInstance();
	
	public Main() {
		// TODO Auto-generated constructor stub
		int menu;
		while(true) {
			do {
				System.out.println("Bluejack Showroom");
				System.out.println("====================");
				System.out.println("1. View All Transaction");
				System.out.println("2. Buy Vehicle");
				System.out.println("3. Delete Transaction");
				System.out.println("4. Exit");
				menu = scanInt();
			} while (menu<1 || menu>4);
			
			switch (menu) {
			case 1:
				viewTransaction();
				break;
				
			case 2:
				buyVehicle();
				break;
				
			case 3:
				deleteTransaction();
				break;
				
			case 4:
				System.out.println("Thank you!");
				return;
				
			}
			System.out.println("Press Enter to Continue");
			scan.nextLine();
		}
	}

	private void deleteTransaction() {
		// TODO Auto-generated method stub
		viewTransaction();
		
		if(!repo.getTransactionData().isEmpty()) {
			int size = repo.getTransactionData().size();
			int toBeDel;
			do {
				System.out.printf("Choose number you want to delete [1-%s]: ", size);
				toBeDel = scanInt();
			} while (toBeDel<1 || toBeDel>size);
			
			String toBeDelID = repo.getTransactionData().get(toBeDel-1).getTransactionID();
			repo.deleteTransaction(toBeDelID);
			System.out.println("Transaction " + toBeDelID + " Deleted");
		}
	}

	private void buyVehicle() {
		// TODO Auto-generated method stub
		String name;
		do {
			System.out.print("Input name [must more than 3 characters]: ");
			name = scan.nextLine();
		} while (name.length()<=3);
		
		String email;
		do {
			System.out.print("Input email [must contains '@' and ends with '.com']: ");
			email = scan.nextLine();
		} while (!email.contains("@") || !email.endsWith(".com"));
		
		int count = 1;
		for (Vehicle vehicle : repo.getVehicleData()) {
			System.out.println("======================================");
			System.out.println("(No. " + count + ")");
			count++;
			System.out.println("Vehicle ID \t: " + vehicle.getVehicleID());
			System.out.println("Vehicle Name \t: " + vehicle.getVehicleName());
			System.out.println("Vehicle Type \t: " + vehicle.getVehicleType());
			System.out.println("Base Price \t: " + vehicle.getBasePrice());
			System.out.println("Gas Type \t: " + vehicle.getGasType());
			vehicle.printDesc();
			System.out.println("======================================");
		}
		
		int choose;
		int size =  repo.getVehicleData().size();
		do {
			System.out.printf("Choose vehicle [1-%s]: ", size);
			choose = scanInt();
		} while (choose<1 || choose>size);
		
		int quantity;
		do {
			System.out.print("Input quantity [must be greater than 0]: ");
			quantity = scanInt();
		} while (quantity<1);
		
		
		
		String vehicleID = repo.getVehicleData().get(choose-1).getVehicleID();
		String vehicleName = repo.getVehicleData().get(choose-1).getVehicleName();
		int basePrice = repo.getVehicleData().get(choose-1).getBasePrice();
		int TotalPrice = repo.getVehicleData().get(choose-1).calculateTotalPrice(basePrice, quantity);
		System.out.println("======================================");
		System.out.println("Detail Transaction");
		System.out.println("======================================");
		System.out.println("Name \t\t: " + vehicleName);
		System.out.println("Base Price \t: " + basePrice);
		System.out.println("Qty \t\t: "+ quantity);
		System.out.println("Total Price \t: " + TotalPrice);
		System.out.println("======================================");
		
		repo.insertTransaction(vehicleID, name, email, quantity);
		System.out.println("Successfully Inserted");
	}

	private void viewTransaction() {
		// TODO Auto-generated method stub
		if(repo.getTransactionData().isEmpty()) {
			System.out.println("No Transaction");
		}
		else {
			int count = 1;
			for (Transaction transaction : repo.getTransactionData()) {
				System.out.println("======================================");
				System.out.println("(No. " + count + ")");
				count++;
				System.out.println("Transaction ID\t: " + transaction.getTransactionID());
				System.out.println("Name \t\t: " + transaction.getCustomerName());
				System.out.println("Email \t\t: " + transaction.getCustomerEmail());
				System.out.println("Product \t: " + transaction.getProductName());
				System.out.println("Base Price \t: "+ transaction.getBasePrice());
				System.out.println("Qty \t\t: "+ transaction.getQuantity());
				System.out.println("======================================");
			}
		}
	}

	private int scanInt() {
		// TODO Auto-generated method stub
		int x = -1;
		try {
			x = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			scan.nextLine();
		}
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
