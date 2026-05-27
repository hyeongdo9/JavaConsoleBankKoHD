package banking.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

//메인클래스가 해당 인터페이스를 사용한다는것
public class BankingSystemMain implements ICustomDefine {
	
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager();
		Scanner scan = new Scanner(System.in);
		
		//프로그램이 끝날때까지 무한반복
		while (true) {
			//try-catch로 예외 코드 감싸기
			try {
				//메뉴 출력
				manager.showMenu();
				int choice = scan.nextInt();
				if (choice < 1 || choice > 5) {
					//강제로 예외 발생
					throw new MenuSelectException();
				}
			switch (choice) {
			//계좌개설
			case Make:
				manager.makeAccount();
				break;
			//입금
			case Deposit:
				manager.depositMoney();
				break;
			//출금
			case Withdraw:
				manager.withdrawMoney();
				break;
			//전체계좌조회
			case Inquire:
				manager.showAccInfo();
				break;
			//프로그램 종료	
			case Exit:
				System.out.println("프로그램 종료");
				return;
			}
		} 
			//숫자를 입력해야하는데 문자를 입력할 경우 실행됨
			catch (InputMismatchException e) {
				System.out.println("문자는 입력할 수 없습니다.");
				//입력버퍼 청소역할
				scan.nextLine();
			}
			//1~5범위를 벗어난 숫자입력시 실행됨
			catch (MenuSelectException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
