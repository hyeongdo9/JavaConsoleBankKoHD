package banking.step2;

public class Account {
	//멤버변수
	private String accId; //계좌번호
	private String name; //이름
	/*
	protected로 지정하면 상속관계에서 접근이 가능하므로 getter 도움없이 접근 가능. 
	private로 지정하면 상속관계라도 접근이 안되므로 getter가 반드시 필요함. 
	 */
	//protected int balance; //잔고
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
	
	//잔고에 대해서는 getter/setter 모두 필요함
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
