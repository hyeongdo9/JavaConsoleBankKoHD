package banking.type;

public class NormalAccount extends Account {
	
	public int interestRate;
	
	public NormalAccount(String accId, String name, int balance, int interestRate) {
		
		super(accId, name, balance);
		this.interestRate = interestRate;
		
		
	}
}
