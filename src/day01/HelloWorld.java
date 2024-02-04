package day01_1; // 1. 패키지 선언문

// 3. 클래스 선언문
// public class 클래스명{ 명령문... }
// 클래스명과 파일명을 동일하게(대소문자도 동일)
// 클래스명 => 대문자로 시작, camel표기법 사용

// [1] 원시코드를 컴파일 (javac) 
//		==> HelloWorld.class파일(JVM이 해석할 수 있는 byte code)이 생성됨
//			이클립스는 자동으로 컴파일 해준다.
// [2] 인터프리터(java)로 class 파일을 해석
public class HelloWorld {

	// main() 메서드 (동사형, 소문자로 시작, camel표기법)
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("안녕하세요?");
		System.out.print("Hi Java ");
		System.out.println("Bye Java");
		// 컴파일 : Ctrl+S (저장)
		// 실행 : Ctrl+F11 (실행)
		System.out.println("깃허브 푸시 충돌 해결");
	}
}
