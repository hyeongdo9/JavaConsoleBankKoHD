package banking.step4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.HashSet;

public class AccountManager  {
	/*
	[4단계리모델링] 
	기존의 고정 칸 배열(Account[50])과 개수 세기 변수(accountCount)는
	마법의 주머니(HashSet) 도입으로 인해 완전히 불필요해졌으므로 과감히 지웁니다.
	 */
//	private Account[] accounts = new Account[50]; 크기제한있던시절
//	private int accountCount = 0; 카운트변수
	
	private HashSet<Account> accounts = new HashSet<Account>();
	
	public Scanner scan = new Scanner(System.in);
	
	//메뉴 출력
	public void showMenu() {
			
		System.out.println("#### Menu ####");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.println("5. 계좌정보삭제"); // 4단계 신규메뉴
		System.out.println("6. 프로그램종료");
		System.out.print("선택: ");
	}

	//계좌개설을 위한 함수(중복 제어 및 정석 add 위치 반영)
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
		
		
		//사용자가 입력한 데이터로 만든 통장 객체를 잠시 올려둘 임시대를 만든다.
		Account newAccount = null;
		
		
		//1번을 선택했을때
		if (choice == 1) {
			newAccount = new NormalAccount(accId, name, balance, interestRate);
		}
		
		//2번을 선택했을때
		else if (choice == 2) {
			//신용등급을 입력받기 위한 코드
			System.out.print("신용등급(A,B,C) : ");
			//자유롭게 받고 저장과 출력은 대문자로 통일
			String grade = scan.next().toUpperCase();
			newAccount = new HighCreditAccount(accId, name, balance, interestRate, grade);
		}
			/*
			[4단계 핵심 검색대 : 중복 계좌 필터링]
			Account.java에 심어놓은 HashCode와 equals 센서 덕분에
			이 한줄로 중복 여부를 완벽히 판별한다.
			 */
		if (newAccount != null) {
		
			if (accounts.contains(newAccount)) {
				System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n) : ");
				String answer = scan.next();
				
				//사용자가 입력한 문자열(answer)이 대문자 'Y'든 소문자'y'든 상관없이 'y'이기만
				//하면 아래코드를 실행하겠다는 것
				if (answer.equalsIgnoreCase("y")) {
					/*
					기존 계좌 목록에서 특정계좌(newAccount)를 찾아 제거한 뒤, 동일한계좌를 리스트의
					맨 마지막에 다시 추가하겠다는것
					 */
					accounts.remove(newAccount);
					accounts.add(newAccount);
					System.out.println("기존정보가 삭제되고 새로운 정보로 덮어쓰기 되었습니다.");
				}
				//'n'을 입력하거나 다른글자를 입력했다면 새 통장은 주머니에 넣지 않고 그대로 무시한다.
				else {
					System.out.println("기존의 정보가 유지되고 새 정보는 무시되었습니다.");
				}
			}
			//똑같은 계좌번호가 '없을 때'만 작동하는 else 구역이다.
			else {
				//새로운 계좌이므로 최종 저장(add)한다.
				accounts.add(newAccount);
				System.out.println("계좌개설이 완료되었습니다.");
			}
		} // 'if (newAccount != null)' 마감
	} //makeAccount() 메서드 끝
	
	//입금 (Iterator 적용)
	public void depositMoney() {
		
		System.out.println("====입금====");
		System.out.print("계좌번호 : ");
		String accId = scan.next();
		/*
		int money = 0;
		: 정수형 변수 money를 선언하고 초기값으로 0을 대입하는 코드
		주로 프로그램이나 게임에서 소지금의 기본값을 초기화할때 사용되며, 예산
		계산 및 거스름돈 반환 알고리즘에서 자주 볼 수 있는 형태이다.
		 */
		int money = 0;
		
		try {
			System.out.print("입금액 : ");
			//사용자로부터 정수를 입력받는다.
			money = scan.nextInt();
		} 
		//사용자가 숫자(정수)가 아니라 문자나 기호를 입력하면 에러를 잡아낸다.
		catch (InputMismatchException e) {
			System.out.println("에러 : 금액은 숫자만 입력할 수 있습니다.");
			//버퍼가 남아있는 잘못된 입력값(엔터 등)을 비워주어 다음
			//입력에 문제가 없도록 초기화합니다.
			scan.nextLine();
			//해당 메서드를 종료합니다.
			return;
		}
		/*
		if문 기본구조 3가지
		단일 if문 : 조건이 참(true)일때만 실행한다.
		=> if (조건식) { //조건이 참일 때 실행할 코드}
		if else 문 : 참일때와 거짓(false)일 때 각각 다른 코드를 실행한다.
		=> if (조건식) { //조건이 참일 때 실행할 코드}
		 	else { //조건이 거짓일때 실행할 코드}
		if else if else문 : 여러개의 조건을 차례대로 검사합니다.
		=> if (조건1) { //조건1이 참일 때 실행할 코드}
			else if (조건2) { //조건1이 거짓이고, 조건2가 참일때 실행 }
			else { //모든 조건이 거짓일 때 실행}
		 */
		//입금 금액이 0보다 작을때 오류를 발생시키고 메서드를 종료하는 예외처리 
		if (money < 0) {
			System.out.println("에러 : 음수는 입금할 수 없습니다.");
			return;
		}
		//"money를 500으로 나눈 나머지가 0이 아니다."
		//입력한 금랙이 500원 단위가 아니면 경고문을 출력한다.
		if (money % 500 != 0) {
			System.out.println("에러 : 입금은 500원 단위로만 가능합니다.");
			//단위 에러 시 하단 입금코드가 돌면 안되므로 함수를 즉시 멈춘다.
			return;
		}
		//Set 주머니는 인덱스[i]가 없으므로 무작위 통장 무리를 뒤져줄 Iterator를 꺼낸다.
		Iterator<Account> itr = accounts.iterator();
		
		// itr.next() : 주머니 안에 아직 확인 안 한 통장이 남아있는 동안 무한 질주(while)한다.
		while (itr.hasNext()) {
			
			/*
			반복자(Iterator)를 사용하여 계좌목록에서 다음 차례에 있는 계좌 객체를 꺼내어
			acc변수에 담겠다.
			for문이나 while문안에서 계좌목록(List나 Set등)을 처음부터 끝까지 하나씩 순회하며
			꺼내볼 때 사용하는 자바코드이다.
			 */
			Account acc =  itr.next();
			/*
			목록에서 꺼낸 계좌(acc)의 계좌번호가 내가 찾고있는 계좌번호(accId)와 일치한다면
			이자를 계산하기 위해 정수형 변수 interest를 0으로 초기화 하겠다라는것.
			 */
			if (acc.getAccId().equals(accId)) {
				int interest = 0;
			/*
			꺼내온계좌(acc)가 일반계좌(NormalAccount)타입이 맞는 확인한 뒤, 맞다면 
			해당 타입으로 강제형변환 하여 일반계좌만의 이자계산기능을 실행하겠다는것.
			 */
			if (acc instanceof NormalAccount) {
				interest =((NormalAccount)acc).calculateInterest();
				}
			acc.deposit(money + interest);
			System.out.println("입금이 완료되었습니다.");
			return;
			}
		}
		//while문이 끝날 때까지 return을 못 만나고 빠져나왔다는 건 일치하는 계좌가 
		//주머니에 없다는 뜻.
		System.out.println("일치하는 계좌번호가 존재하지 않습니다.");
	}
		//출금
		public void withdrawMoney() {
			System.out.println("====출금====");
			System.out.print("계좌번호 : ");
			String accId = scan.next();
			
			int money = 0;
			
			try {
				System.out.print("출금액 : ");
				money = scan.nextInt();
			} 
			catch (InputMismatchException e) {
				System.out.println("에러 : 금액은 숫자만 입력할 수 있습니다. ");
				scan.nextLine();
				return;
			}
			
			if (money < 0) {
				System.out.println("에러 : 음수는 입금할 수 없습니다.");
				return;
			}
			//money % 1000 != 0 => 1000으로 나누어 떨어지지 않음
			if (money % 1000 != 0) {
				System.out.println("에러 : 1000원 단위만 출금가능");
				return;
			}
			Iterator<Account> itr = accounts.iterator();
			while (itr.hasNext()) {
				Account acc = itr.next();
				
			if (acc.getAccId().equals(accId)) {
				
				if (acc.getBalance() < money) {
					System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요?");
					System.out.println("YES 또는 NO 입력 : ");
					String answer = scan.next();
					
					if (answer.equalsIgnoreCase("YES")) {
						int allmoney = acc.getBalance();
						acc.withdraw(allmoney);
						System.out.println("계좌의 전액인 "+ allmoney + "원이 전액 출금되었습니다.");
					}
					else {
						System.out.println("출금 요청이 취소되었습니다.");
					}
					return;
				}
				acc.withdraw(money);
				System.out.println("출금이 완료되었습니다.");
				return;
			}	
		}
		System.out.println("일치하는 계좌번호가 존재하지 않습니다.");
	}
		//계좌정보삭제 기능
		public void deleteAccount() {
			System.out.println("==계좌정보삭제==");
			System.out.println("삭제할 계좌번호 입력 : ");
			String deleteId = scan.next();
			
			Iterator<Account> itr = accounts.iterator();
			while (itr.hasNext()) {
				Account acc = itr.next();
				/*
				목록을 돌면서 확인한 계좌번호가 삭제할 계좌번호(deleteId)와 일피하면, 해당 계좌를 목록(리스트)에서 안전하게
				삭제하겠다는 의미. 반복문(Iterator)을 사용해 데이터를 순회하는중에 특정 조건에 맞는 요소를 지울때
				사용하는 가장 올바르고 안전한 방법이다.
				
				[accounts.remove()가 아닌 itr.remove()]를 쓰는 이유
				- for-each문(for(Account acc : accounts)) 안에서 accounts.remove(acc); 처럼 리스트를 직접
					수정하면, 자바는 리스트 변형을 감지하고 ConcurrentModificationException 이라는 치명적 오류를 
					던지며 프로그램을 멈춰버린다. 
				반면, itr.remove()를 사용하면 자바가 내부적으로 인덱스를 자동으로 조절해주기 때문에 오류 없이 안전하게
					데이터를 삭제할 수 있다.
				 */
				if (acc.getAccId().equals(deleteId)) {
					itr.remove();
					System.out.println("계좌 정보가 정상적으로 삭제되었습니다.");
					return;
				}
			}
			System.out.println("삭제하려는 계좌번호가 존재하지 않습니다.");
		}
		//전체계좌정보출력
		public void showAccInfo() {
			System.out.println("==전체계좌정보출력==");
			if (accounts.isEmpty()) {
				System.out.println("등록된 계좌가 없습니다.");
				return;
			}
			/*
			for (Account acc : accounts) : 자바의 향상된 for문(Enhanced for loop)
			-> accounts 리스트의 첫 번째 칸부터 마지막 칸까지 저장된 계좌들을 순서대로 하나씩 꺼내서
			acc라는 변수에 자동으로 담아주며 반복한다.
			 */
			//계좌목록에(accounts)에 들어있는 모든 계좌를 처음부터 끝까지 하나씩 꺼내어, 각 계좌의
			//상세 정보를 화면에 출력하고 구분선(===)을 그어주겠다라는것
			for (Account acc : accounts) {
				acc.showAccInfo();
				System.out.println("==================");
			}
		}
	}