package banking.step4;

public interface ICustomDefine {
	//메뉴 선택을 위한 상수 선언
	int Make = 1; // 1. 계좌개설
	int Deposit = 2; // 2. 입금
	int Withdraw = 3 ; // 3. 출금
	int Inquire = 4; // 4. 전체계좌정보출력
	
	int Delete = 5; // 5. 계좌정보삭제 (신규 추가)
	int Exit = 6; // 6. 프로그램 종료
	
	//신용등급별 이자율 우대 상수 (HighCreditAccount에서 사용)
	int interestRate_A = 7; // A등급 우대이율 7%
	int interestRate_B = 4; // B등급 우대이율 4%
	int interestRate_C = 2; // C등급 우대이율 2%
}
