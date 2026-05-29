package banking.step3;

//추상클래스 : 직접 객체 생성 불가능
public abstract class Account {
	//멤버변수
	private String accId; //계좌번호
	private String name; //이름
	private int balance; //잔고
	
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
	public void setBalance(int balance) {
		this.balance = balance;
	}
	//입금 메서드
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
