package banking.type;

import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {

	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			manager.showMenu();
			int choice = scan.nextInt();
			
			switch (choice) {
			case Make:
				manager.makeAccount();
				break;
			case Deposit:
				manager.depositMoney();
				break;
			case Withdraw:
				manager.withdrawMoney();
				break;
			case Inquire:
				manager.showAccInfo();
				break;
			case Exit:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
