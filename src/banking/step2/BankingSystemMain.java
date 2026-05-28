package banking.step2;

import java.util.Scanner;

public class BankingSystemMain {
	
	public static void main(String[] args) {
		
		//객체 생성
		AccountManager manager = new AccountManager();
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//메뉴 출력
			manager.showMenu();
			int choice = scan.nextInt();
			
			switch (choice) {
			
			case ICustomDefine.Make:
				manager.makeAccount();
				break;
			
			case ICustomDefine.Deposit:
				manager.depositMoney();
				break;
			
			case ICustomDefine.Withdraw:
				manager.withdrawMoney();
				break;
			
			case ICustomDefine.Inquire:
				manager.showAccInfo();
				break;
			
			case ICustomDefine.Exit:
				System.out.println("프로그램을 종료");
				scan.close();
				return;
			
			default:
				System.out.println("잘못된 선택입니다.");
			}
			System.out.println();
		}
	}
}
