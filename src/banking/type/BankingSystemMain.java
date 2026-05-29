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
		
		/*
		while(true) : 무한루프(계속) 프로그램을 반복적으로 실행한다
		break : '탈출'구문으로 특정 조건을 만족 시 무한루프를 탈출하기
			위해 사용한다.
		 */
		while (true) {
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
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해주세요");
			}
			System.out.println();
		}
	}
}
