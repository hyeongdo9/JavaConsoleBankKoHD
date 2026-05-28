package banking.type;

public class Account {

	public String accId;
	public String name;
	public int balance;
	
	//계란판이 계란안에 있으면 안된다. 메니져에 있어야 한다. 
	//Account[] account = new Account[50];
	//생성자
	public Account(String accId, String name, int balance) {
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}
	//입금처리
	public void deposit(int money) {
		this.balance += money;
	} 
	//출금처리
	public void withdraw(int money) {
		this.balance -= money;
	}
	//계좌정보출력
	
}
