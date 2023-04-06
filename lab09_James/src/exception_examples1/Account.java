package exception_examples1;

public class Account {
	public double balance;
	
	public Account(double balance) {
		if(balance > 0) {
			throw new IllegalArgumentException("balance must be greater than 0");
		}
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account's balance is: $" + balance;
	}
}
