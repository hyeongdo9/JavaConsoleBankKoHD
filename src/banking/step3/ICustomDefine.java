package banking.step3;

public interface ICustomDefine {
	//메뉴 선택을 위한 상수
	int Make = 1;
	int Deposit = 2;
	int Withdraw = 3 ;
	int Inquire = 4;
	int Exit = 5;
	
	//차후 단계(신용등급별 이자율)를 위한 상수 미리 선언 가능
	int interestRate_A = 7;
	int interestRate_B = 4;
	int interestRate_C = 2;
}
