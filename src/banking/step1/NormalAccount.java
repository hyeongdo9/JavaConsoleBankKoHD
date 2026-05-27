package banking.step1;

public class NormalAccount extends Account {
	protected int interest;
	
	public NormalAccount(String accId, String name, int balance, int interestRate) {
		
		super(accId, name, balance);
		this.interest = interestRate;
	}
	@Override
	public void deposit(int money) {
		int basicInterest = (int)(balance *(interest/100.0));
		balance = balance + basicInterest + money;
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자율 : "+ this.interest +"%");
	}
}

