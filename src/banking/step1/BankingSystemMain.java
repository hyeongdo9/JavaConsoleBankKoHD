package banking.step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	//github연동
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
		try {
				manager.showMenu();
				int choice = scan.nextInt();
				
			if (choice < 1 || choice> 5) {
				throw new MenuSelectException();
			}
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
				System.out.println("종료 메뉴를 선택하셨습니다. 프로그램을 종료합니다.");
				System.exit(0);
			}
			
		} 
		catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
		catch (InputMismatchException e) {
			System.out.println("에러: 메뉴는 숫자만 입력하셔야 합니다.");
			scan.nextLine();
			}
		}
	}
}
