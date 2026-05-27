package banking.step1;

import java.util.Scanner;

public class AccountManager {

	public static Scanner scan = new Scanner(System.in);
		
		Account[] accounts = new Account[50];
		int accNum = 0;
		
		public void showMenu() {
			System.out.println("#### Menu ####");
			System.out.println("1.계좌개설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.전체계좌정보출력");
			System.out.println("5.프로그램종료");
			System.out.print("선택 : ");
		}
		public void makeAccount() {
			System.out.println("===신규계좌개설===");
			System.out.println("1.보통계좌 2.신용신뢰계좌 : ");
			int accountType = scan.nextInt();
			
			System.out.print("계좌번호 : ");
			String accId = scan.next();
			
			System.out.print("고객이름 : ");
			String name = scan.next();
			
			System.out.print("잔고 : ");
			int balance = scan.nextInt();
			
			System.out.print("기본이자%(정수형태로입력) : ");
			int interestRate = scan.nextInt();
			
			if (accountType == 1) {
				accounts[accNum++] = new NormalAccount(accId, name, balance, interestRate);
			System.out.println("계좌생성완료 (보통계좌)");	
			}
			else if (accountType == 2) {
				System.out.println("신용등급(A, B, C) : ");
				String grade = scan.next().toUpperCase();
				
				int specialRate = 0;
				switch (grade) {
				case "A":
					specialRate = ICustomDefine.interestRate_A;
					break;
				case "B":
					specialRate = ICustomDefine.interestRate_B;
					break;
				case "C":
					specialRate = ICustomDefine.interestRate_C;
					break;
				default:
					System.out.println("잘못된 등급 입력으로 우대이율 0% 적용됩니다.");
				}
				accounts[accNum++] = new HighCreditAccount(accId, name, balance, 
														interestRate, specialRate);
				System.out.println("계좌생성완료(신용신뢰계좌)");
				
			}
		} 
		public void depositMoney() {
			
			System.out.println("==입금==");
			System.out.print("계좌번호 : ");
			String accId = scan.next();
			
			System.out.print("입금액 : ");
			int money = scan.nextInt();
			
			for (int i = 0; i < accNum; i++) {
				if (accounts[i].getAccId().equals(accId)) {
					accounts[i].deposit(money);
					System.out.println("입금완료");
					return;
				}
			}
		}
		public void withdrawMoney() {
			System.out.println("== 출금 ==");
			System.out.print("계좌번호 : ");
			String accId = scan.next();
			
			System.out.print("출금액 : ");
			int money = scan.nextInt();
			
			for (int i = 0; i < accNum; i++) {
				if (accounts[i].getAccId().equals(accId)) {
					accounts[i].withdraw(money);
					System.out.println("출금완료");
					return;
				}
			}
		}
		public void showAccInfo() {
			System.out.println("==전체계좌==");
			for (int i = 0; i < accNum; i++) {
				accounts[i].showAccInfo();
				System.out.println("-------------------------");
			}
		}
	}