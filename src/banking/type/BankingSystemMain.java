package banking.type;

import java.util.Scanner;

/*
인터페이스에 정의된 추상메서드가 없다면 굳이 '구현'할 필요는 없다. 
상수는 모두 public static final로 정의 되므로 인터페이스명으로 직접
접근할 수 있다. 
 */
//public class BankingSystemMain implements ICustomDefine {
public class BankingSystemMain {

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
