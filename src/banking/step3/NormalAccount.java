package banking.step3;

public class NormalAccount extends Account {
	
	//정보은닉 / 기본이자율 저장
	private int interestRate;
	
	//생성자
	public NormalAccount(String accId, String name, int balance, int interestRate) {
		//부모클래스 생성자 호출
		super(accId, name, balance);
		
		this.interestRate = interestRate;
	}
	//외부에서 이자율을 읽어갈 수 있게 getter 사용
	public int getInterestRate() {
		return interestRate;
	}
	/*
	기존의 deposit()을 덮어쓰는 대신, "이자 금액이 얼마인지"만
	계산해서 던져주는 대리인 역할을 한다.
	 */
	//이자전용메서드 
	public int calculateInterest() {
		//소수점을 버리기 위해 double(100.0)로 계산한뒤 int로 강제형변환(다운캐스팅)을 한다.
		return (int)(super.getBalance() * (interestRate / 100.0));
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+ interestRate + "%");
		System.out.println("=============================");
	}
}


