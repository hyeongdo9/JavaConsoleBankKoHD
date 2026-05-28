package banking.type;

public class Account {

	public String accId;
	public String name;
	public int balance;
	
	Account[] account = new Account[50];
	
	public Account(String accId, String name, int balance) {
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}
	public void deposit(int money) {
		this.balance += money;
	} 
	public void withdraw(int money) {
		this.balance -= money;
	}
}
