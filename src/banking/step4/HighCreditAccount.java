package banking.step4;

public class HighCreditAccount extends NormalAccount  {
	
	public String grade;
	
	public HighCreditAccount(String accId, String name, int balance, int interestRate, String grade) {
		
		super(accId, name, balance, interestRate);
		this.grade = grade;
	}
	@Override
	//해당계좌가 가진 규칙에 따라 이자를 계산하여, 그 결과값을 정수(int)형태로 돌려주는(반환하는)기능
	public int calculateInterest() {
		//우대 이율 값을 담을 정수형 변수 extraRate를 선언하고 기본값인 0으로 초기화한다.
		int extraRate = 0;
		
		if (grade.equals("A")) {
			extraRate = ICustomDefine.interestRate_A;
		}
		else if (grade.equals("B")) {
			extraRate = ICustomDefine.interestRate_B;
		}
		else {
			extraRate = ICustomDefine.interestRate_C;
		}
		//부모클래스(Account)가 계산해 준 기본이자를 가져온다.
		int baseInterest = super.calculateInterest();
		// 앞선 조건문에서 A,B,C 등급에 따라 지정된 extraRate 값을 사용한다.
		int extraInterest = (int)(super.getBalance() * (extraRate / 100.0));
		//이렇게 얻은 기본이자와 신용 등급별 우대이자를 합쳐서 최종 총 이자 금액을 이 메서드를 호출한곳으로 돌려준다.
		return baseInterest + extraInterest;
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("신용등급 : "+ grade);
	}
}
