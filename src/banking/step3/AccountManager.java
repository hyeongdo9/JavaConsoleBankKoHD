package banking.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager  {
	


	//계좌 객체를 저장할 배열 (50개)
	private Account[] accounts = new Account[50];
	
	//현재 저장된 계좌개수를 카운트할 변수
	private int accountCount = 0;
	
	//scanner 선언
	public Scanner scan = new Scanner(System.in);
	
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
		}
		for (int i = 0; i < accountCount; i++) {
			if (accounts[i].getAccId().equals(accId)) {
				//정수형 변수 선언
				int interest = 0;
			//배열 속 NormalAccount 계열인지 확인
			if (accounts[i] instanceof NormalAccount) {
				//NormalAccount를 강제형변환한다
				//HighCreditAccount도 NormalAccountdml 자식이므로 이 구조하나로 해결
				interest = ((NormalAccount)accounts[i]).calculateInterest();
				}
			//최종입금 : 사용자가 넣은 원금(money) + 은행이 주는 이자(interest)를 합산
			accounts[i].deposit(money + interest);
			System.out.println("입금이 완료되었습니다.");
			return;
			}
		}
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
			/*
			int i = 0; => 반복에 사용할 변수 i를 0으로 초기화
			i < accountCount => i가 accountCount보다 작을때까지만 루프를 실행한다.
			i++ => 반복문이 한번 실행될때마다 i의 값을 1씩 증가시킨다.
			 */
			for (int i = 0; i < accountCount; i++) {
				/*
				accounts 배열을 반복문(for 등)으로 돌면서, i번째 객체의
				계정ID(getAccId())와 찾고자하는 accId가 일치하는지
				확인하는 조건문이다.
				 */
				if (accounts[i].getAccId().equals(accId)) {
				
					//현재 계좌의 잔고가 출금하려는 금액보다 작은가?를 검사하는 조건문
					if (accounts[i].getBalance() < money) {
						System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
						System.out.print("YES 또는 NO 입력 : ");
						String answer = scan.next();
						/*
						equalsIgnoreCase : 사용자가 소문자 yes를 
						치든 대문자 YES를 치든 똑같이 통과시켜준다.
						 */
						if (answer.equalsIgnoreCase("YES")) {
							int allMoney = accounts[i].getBalance();
							/*
							accounts라는 계좌배열에서 i번째 위치에 있는 특정 계좌 객체에서
							특정 금액을 출금하겠다.
							 */
							accounts[i].withdraw(allMoney);
							System.out.println("계좌의 전액인 " + allMoney + "원이 전액 출금되었습니다.");
						} 
						else {
							System.out.println("출금 요청이 취소되었습니다.");
						}
						return;
					}
					accounts[i].withdraw(money);
					System.out.println("출금이 완료되었습니다.");
					return;
				}
			}
			System.out.println("일치하는 계좌번호가 존재하지 않습니다.");
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