package banking.step4;

import java.lang.Object;
import java.util.Objects;

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
	//setter 함수
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
	/*
	잔고나 이름처럼 언제든 바뀔 수 있거나 중복될 수 있는 데이터를 해시코드에 섞으면, 데이터가 조금만
	바뀌어도 컴퓨터가 통장을 못찾는 치명적인 버그가 생긴다. 따라서 절대변하지 않는 계좌번호(accId)만
	가지고 해시코드를 만들어야 정확하게 식별할 수 있다.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(accId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accId, other.accId);
	}
}
