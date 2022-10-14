
public class Transaction {
	private String transactionID, customerName, customerEmail, productName;
	private int basePrice, quantity;

	public Transaction(String transactionID, String customerName, String customerEmail, String productName,
			int basePrice, int quantity) {
		super();
		this.transactionID = transactionID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.productName = productName;
		this.basePrice = basePrice;
		this.quantity = quantity;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
