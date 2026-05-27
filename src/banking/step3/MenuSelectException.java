package banking.step3;

//예외클래스 상속
public class MenuSelectException extends Exception {
	
	public MenuSelectException() {
		//오류 메세지 저장
		super("1~5 사이의 숫자만 입력하세요");
	}
}
