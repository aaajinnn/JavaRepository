package day11;
// Ex01

/* 참조형
 * -클래스형, 배열, 인터페이스형
 * */
interface MyInter { // 키워드를 class 대신 interface

	// 추상메서드 + final 변수만 멤버로 갖는다.
	void foo(); // public absctract 가 자동으로 붙는다.

	void bar(String str);

}//////////////////////

interface YourInter {

	String GREETING = "Hi"; // public static final이 자동으로 붙는다.

	int baz();

}//////////////////////

// 상속받기
// 인터페이스는 다중상속이 가능하며
// implements로 상속받는다.
class MyClass implements MyInter, YourInter {

	// Override
	@Override
	// void foo() { } : 접근지정자 에러(인터페이스의 메서드에서는 public이 생략되어 있기때문에 public을 붙여주어야 한다.
	public void foo() {
		System.out.println("foo()");
	}

	@Override
	public void bar(String str) {
		System.out.println("bar() : " + str);
	}

	@Override
	public int baz() {
		System.out.println("baz()");
		return 100;
	}

}//////////////////////

public class InterfaceTest {

	public static void main(String[] args) {
//		MyInter mi = new MyInter(); // [x] 추상메서드와 마찬가지로 interface도 new 객체생성 x
		MyInter mi = new MyClass();
		// foo(), bar() 호출
		mi.foo();
		mi.bar("Hello");
		// baz() 호출
		int n = ((MyClass) mi).baz();// 자식인 MyClass로 강제형변환 하여 받을 수 있다.
		System.out.println(n);

		// YourInter yi = new YourInter(); // [x]
		YourInter yi = new MyClass();
		// baz()호출
		yi.baz();
		// foo(), bar() 호출
		((MyClass) yi).bar("Hi");
		((MyClass) yi).foo();
		// GREETING 값 호출 statc 붙어있음 => class명으로 접근가능
		System.out.println(MyClass.GREETING);
		System.out.println(YourInter.GREETING);
		System.out.println(yi.GREETING); // 객체명으로도 접근은 가능
//		System.out.println(mi.GREETING); // [x] MyInter는 접근 불가

//		MyClass.GREETING="Allo"; // [x] final은 값 할당을 받지 못한다
	}

}
