package banking.step3;

import java.util.Scanner;

public class AccountManager implements ICustomDefine {
	


	//계좌 객체를 저장할 배열 (50개)
	private Account[] accounts = new Account[50];
	
	//현재 저장된 계좌개수를 카운트할 변수
	private int accountCount = 0;
	
	//scanner 선언
	private Scanner scan = new Scanner(System.in);
	
	//메뉴 출력
	public void showMenu() {
			
		System.out.println("#### Menu ####");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택: ");
	}

	//계좌개설을 위한 함수
	public void makeAccount() {
			
		System.out.println("====계좌개설====");
		
		System.out.println("1. 보통예금계좌");
		System.out.println("2. 신용신뢰계좌");
		System.out.println("선택: ");
		int choice = scan.nextInt();
		
		System.out.print("계좌번호 : ");
		String accId = scan.next();
		System.out.print("고객이름 : ");
		String name = scan.next();
		System.out.print("잔고 : ");
		int balance = scan.nextInt();
		System.out.println("기본이자%(정수형태로입력) : ");
		int interestRate = scan.nextInt();
		
		//배열크기 초과 체크
		if (accountCount >= 50) {
			System.out.println("더이상 계좌를 생성할 수 없습니다. (최대 50개)");
			return;
		}
		//1번을 선택했을때
		if (choice == 1) {
			
			//신용계좌 객체를 생성해서 배열에 저장하고 계좌 개수를 증가시키는 코드
			accounts[accountCount++]= new NormalAccount(accId, name, balance, interestRate);
			System.out.println("계좌계설이 완료되었습니다."); 
		}
		//2번을 선택했을때
		else if (choice == 2) {
			
			//신용등급을 입력받기 위한 코드
			System.out.println("신용등급(A,B,C) : ");
			//자유롭게 받고 저장과 출력은 대문자로 통일
			String grade = scan.next().toUpperCase();
			
			accounts[accountCount++]= new HighCreditAccount(accId, name, balance, interestRate, grade);
			System.out.println("계좌계설이 완료되었습니다."); 
		}
	} 
	
	//입금
	public void depositMoney() {
		
		System.out.println("====입금====");
		System.out.print("계좌번호 : ");
		String accId = scan.next();
		System.out.print("입금액 : ");
		int money = scan.nextInt();
		
		for (int i = 0; i < accountCount; i++) {
			//배열에 저장된 계좌번호와 사용자가 입력한 계좌번호가 같은지 비교
			if (accounts[i].getAccId().equals(accId)) {
				accounts[i].deposit(money);
				System.out.println("입금이 완료되었습니다.");
				return;
			}
			if (money < 0) {
				System.out.println("음수는 입금할 수 없습니다.");
				return;
			}
			//money % 500 != 0 => 500으로 나누어 떨어지지 않음
			if (money % 500 != 0) {
				System.out.println("500원 단위만 입금가능");
				return;
			}
		}
	}
		//출금
		public void withdrawMoney() {
			System.out.println("====출금====");
			System.out.print("계좌번호 : ");
			String accId = scan.next();
			System.out.print("출금액 : ");
			int money = scan.nextInt();
			for (int i = 0; i < accountCount; i++) {
				
				if (accounts[i].getAccId().equals(accId)) {
					//현재 계좌의 잔고가 출금하려는 금액보다 작은가?를 검사하는 조건문
					if (accounts[i].getBalance() < money) {
						System.out.println("잔액이 부족합니다.");
						return;
					}
				
					accounts[i].withdraw(money);
					System.out.println("출금이 완료되었습니다.");
				}
				if (money < 0) {
					System.out.println("음수는 입금할 수 없습니다.");
					return;
				}
				//money % 1000 != 0 => 1000으로 나누어 떨어지지 않음
				if (money % 1000 != 0) {
					System.out.println("1000원 단위만 출금가능");
					return;
				}
			}
		}
		//전체계좌정보출력
		public void showAccInfo() {
			System.out.println("==전체계좌정보출력==");
			if (accountCount == 0) {
				System.out.println("등록된 계좌가 없습니다.");
				return;
			}
			for (int i = 0; i < accountCount; i++) {
				accounts[i].showAccInfo();
				System.out.println("===========================");
			}
		}
	}