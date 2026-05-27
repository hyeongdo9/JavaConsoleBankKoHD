package banking.step1;

public class HighCreditAccount extends NormalAccount  {
	
	private int specialInterest; 
	
	public HighCreditAccount (String accId, String name, int balance, 
			int interestRate, int specialinterest) {
	
	super(accId, name, balance, interestRate);
	
	this.specialInterest = specialinterest;
	}
	@Override
	public void deposit(int money) {
		int basicInterest = (int)(balance * (this.interest / 100.0));
		int creditInterest = (int)(balance * (this.specialInterest / 100.0));
		balance = balance + basicInterest + creditInterest + money;
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("우대이자율 : "+ this.specialInterest + "%");
	}
}
