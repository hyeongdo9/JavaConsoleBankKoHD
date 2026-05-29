package banking.step4;

import java.util.InputMismatchException;
import java.util.Scanner;

//메인클래스가 해당 인터페이스를 사용한다는것
public class BankingSystemMain implements ICustomDefine {
	
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager();
		Scanner scan = new Scanner(System.in);
		
		//사용자가 5번(종료)을 누르기 전까지 시스템은 무한반복
		while (true) {
			manager.showMenu();
			int choice = 0;
			//try-catch로 예외 코드 감싸기
			try {
				choice = scan.nextInt();
				/*
				메뉴가 6번까지 늘어났으므로 허용범위를 1~6으로 변경했다.
				사용자가 메뉴에 없는 번호를 입력했을때, 시스템을 강제로 멈추지 않고 예외
				(에러)를 직접 발생시켜 올바른 입력을 유도하겠다라는 의미
				throw new MenuSelectException(); => 조건이 맞으면 개발자가 직접
				만든 사용자 정의 에러인 MenuSelectException을 수동으로 발생(throw)시킨다.
				 */
				if (choice < Make || choice > Exit) {
					//강제로 예외 발생
					throw new MenuSelectException("에러 : 지정된 메뉴(1~6)의 숫자만 입력할 수 있습니다.");
				}
				/*
				💡 [개념 정리]
			      ICustomDefine 인터페이스를 implements(구현)했기 때문에, 
			      그 안에 선언된 Make, Deposit, Exit 등의 상수들을 
			      앞에 'ICustomDefine.' 이라는 접두사 없이 마치 내 클래스의 멤버처럼 
			      이름만 가지고 자유롭게 사용할 수 있다!
				 */
			switch (choice) {
			//1. 계좌개설
			case Make:
				manager.makeAccount();
				break;
				
			//2. 입금
			case Deposit:
				manager.depositMoney();
				break;
				
			//3. 출금
			case Withdraw:
				manager.withdrawMoney();
				break;
				
			//4. 전체계좌조회
			case Inquire:
				manager.showAccInfo();
				break;
				
			//5. 계좌정보삭제	
			case Delete:
				manager.deleteAccount();
				break;
				
			//6. 프로그램 종료	
			case Exit:
				System.out.println("프로그램 종료");
				scan.close();
				return;
			}
		} 
			//숫자를 입력해야하는데 문자를 입력할 경우 실행됨
			catch (InputMismatchException e) {
				System.out.println("문자는 입력할 수 없습니다.");
				//입력버퍼 청소역할
				scan.nextLine();
				System.out.println();
			}
			//1~5범위를 벗어난 숫자입력시 실행됨
			catch (MenuSelectException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		} // while문 끝 
	} //main 끝
}
