package day10;

// Ex07-2
/*
 * modifier
 * ----------------------------------------
 * 				abstract				final
 * ----------------------------------------
 * 클래스 앞  |상속받게할 목적		| 상속받지 못하게 함
 * 메서드 앞  |오버라이드할 목적	| 오버라이드 못하도록
 * 변수 앞    |   x					| 값 할당 못하도록
 * ----------------------------------------
 * */

// 일반 클래스
//class Parent{
//	int a = 10;
//}

// [1] finall + class : 상속 불가
final class Parent {

	int a = 10;

}///////////////

class Child { // extends Parent{ // [1-1] finall + class : 상속 불가

	void foo() {
		System.out.println("foo()");
	}

	// [2] final + method : 오버라이딩 불가
	final void bar() {
		System.out.println("bar()");
	}
}//////////////

class SubChild extends Child {

	// foo()
	@Override
	void foo() {
		super.foo();
		System.out.println("##############");
	}

	// bar()
	/*
	 * [2-1] final + method : 오버라이딩 불가 public void bar() { super.bar();
	 * System.out.println("**************"); }
	 */

	// [3] final + 변수 : 값 할당 불가
	// public final static 형태로 사용 ==> 상수로 만든다.
	public static final double PI = 3.14; // 보통 상수들은 대문자로 사용한다.
}/////////////

public class FinalTest {

	public static void main(String[] args) {
		// SubChild의 PI값 출력
		System.out.println(SubChild.PI);
		// [3-1] final + 변수 : 값 할당 불가
		// SubChild.PI = 30.14; // final인 변수 필드는 할당 될 수 없다.(값 변경 불가)

		SubChild sub = new SubChild();
		// foo() 호출
		sub.foo();
		// bar() 호출
		sub.bar(); // 오버라이드 X
	}

}
