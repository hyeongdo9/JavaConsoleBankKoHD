package banking.step2;

public class HighCreditAccount extends NormalAccount  {
	
	protected int interestRate;
	
	public String grade;
	
	public HighCreditAccount(String accId, String name, int balance, int interestRate, String grade) {
		
		super(accId, name, balance, interestRate);
		this.grade = grade;
	}
	@Override
	public void deposit(int money) {
		//추가이자 0% 부터
		int extraRate = 0;		
		
		if (grade.equals("A")) {
			extraRate = ICustomDefine.interestRate_A;
		}
		else if (grade.equals("B")) {
			extraRate = ICustomDefine.interestRate_B;
		}
		//정확한 코드는 else if(grade.equals("C")) { extraRate = 2;} 
		//이미 grade.equals("C")라고 가정하고 작성된 코드
		else { 
			extraRate = ICustomDefine.interestRate_C;
		}
		int depositMoney = super.getBalance() + (super.getBalance() * interestRate / 100) + 
				(super.getBalance() * extraRate /100) + money;
		super.setBalance(depositMoney);
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("신용등급 : "+ grade);
	}
}
