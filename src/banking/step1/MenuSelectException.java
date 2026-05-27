package banking.step1;

public class MenuSelectException extends Exception {
	public MenuSelectException() {
		super("에러: 메뉴 선택이 잘못되었습니다. 1~5 사이의 숫자를 입력하세요");
	}
}
