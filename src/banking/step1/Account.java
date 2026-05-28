package banking.step1;

public class Account {
	//멤버변수
	private String accId; //계좌번호
	private String name; //이름
	protected int balance; //잔고
	
	//생성자
	public Account(String accId, String name, int balance) {
		this.accId = accId;
		this.name = name;
		this.balance = balance;
	}
	//getter 함수
	public String getAccId() {
		return accId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	//입금 메서드(정수형 변수 money를 받겠다.)
	public void deposit(int money) {
		this.balance += money;
	}
	//출금 메서드
	public void withdraw(int money) {
		this.balance -= money;
	}
	//단일 계좌 정보 출력
	public void showAccInfo() {
		System.out.println("계좌번호 : "+ accId);
		System.out.println("이름 : "+ name);
		System.out.println("잔고 : "+ balance);
		System.out.println("====================");
	}
}
