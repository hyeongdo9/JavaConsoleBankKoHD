package banking.step4;
/*
예외클래스 정의
Exception 클래스를 상속받아
사용자 정의 예외클래스(Custom Exception)를 생성한다.

메뉴에서 잘못된 번호를 입력했을때
사용할 예외 객체이다.
 */
//예외클래스 상속
public class MenuSelectException extends Exception {
	
	public MenuSelectException() {
		//오류 메세지 저장
		super("1~6 사이의 숫자만 입력하세요");
	}
	/*
	내가 직접 만든 예외(에러)클래스에 구체적인 에러 메세지를 담아서 생성할 수
	있도록 규칙을 정의하고, 그 메세지를 부모클래스로 전달하겠다는 의미
	
	자바에서 사용자 정의 예외(Custom Exception)를 만들 때 필수적으로
	작성하는 표준생성자 코드이다.
	
	이 코드가 정상적으로 작동하려면 클래스 상단에 extends Exception이 적혀
	있어야한다.
	 */
	public MenuSelectException(String message) {
		super(message);
	}
}
