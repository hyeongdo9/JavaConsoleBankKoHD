package banking.step2;

public class NormalAccount extends Account {
	
	//기본이자율 저장
	private int interestRate;
	
	//생성자
	public NormalAccount(String accId, String name, int balance, int interestRate) {
		//부모클래스 생성자 호출
		super(accId, name, balance);
		
		this.interestRate = interestRate;
	}
	@Override
	public void deposit(int money) {
		//balance += (balance * interestRate / 100) + money;
		int depositMoney = super.getBalance() + (super.getBalance() * interestRate / 100) + money;
		super.setBalance(depositMoney);
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+ interestRate + "%");
	}
}


