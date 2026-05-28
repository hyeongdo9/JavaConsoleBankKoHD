package banking.type;

import java.util.Scanner;

public class AccountManager {
	
	Scanner scan = new Scanner(System.in);
	
	
	public  void showMenu() {
		
		System.out.println("=====menu=====");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	public void makeAccount() {
		System.out.println("====신규계좌개설====");
		System.out.println("1.계좌번호");
		String accId = scan.next();
		System.out.println("2.고객이름");
		String name = scan.next();
		System.out.println("3.잔고");
		int balance = scan.nextInt();
		System.out.println("계좌개설완료");
	}
	public void depositMoney() {
		System.out.println("===입금====");
		System.out.println("1.계좌번호");
		String accId = scan.next();
		System.out.println("2.입금액");
		int balance = scan.nextInt();
	}
	public void withdrawMoney() {
		System.out.println("===출금===");
		System.out.println("1.계좌번호");
		String accId = scan.next();
		System.out.println("2.출금액");
		int balance = scan.nextInt();
	}
	public void showAccInfo() {
		System.out.println("==전체계좌정보출력==");
	} 
}
