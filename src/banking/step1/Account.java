package banking.step1;

public abstract class Account {
	private String accId;
	private String name;
	protected int balance;
	
	
	public Account(String accId, String name, int balance) {
		this.accId = accId;
		this.name = name;
		this.balance = balance;
		
	}

	public String getAccId() {
		return accId;
	}

	public abstract void deposit(int money);
	
	public void withdraw(int money) {
		if (balance >= money) {
			balance-= money;
		}
		else {
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
		}
	}
	public void showAccInfo() {
		System.out.println("계좌번호 : "+ accId);
		System.out.println("이름 : "+ name);
		System.out.println("잔고 : "+ balance);
	}
}
