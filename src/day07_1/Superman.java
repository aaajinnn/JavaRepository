package day07_1;

/* 생성자 오버로드
 * 메서드 이름 동일하게
 * 매개변수의 자료형, 갯수, 순서를 다르게 구성할것
 * 반환 타입은 같아도 되고 달라도 됨
 **/
public class Superman {

	String name; // 이름
	int height; // 키
	int power; // 초능력
	// this() : 생성자 안에서 첫번째 라인에서 호출 가능, 다른 생성자를 부르는 일종의 메서드
	// 기본 생성자

	public Superman() {
		this("슈퍼맨", 155, 100);
		/*
		 * name = "슈퍼맨"; height = 180; power = 100;
		 */
	}// ----------------------------------------

	// 인자 생성자 => 생성자 오버로딩(다중정의)
	public Superman(String name) {
		this(name, 160, 200);
//		this.name = name;
//		height = 190;
//		power = 200;
	}

	// 이름, 키
	public Superman(String name, int height) {
		this(name, height, 300);
//		this.name = name;
//		this.height = height;
//		this.power = 300;
	}

	// 이름, 키, 초능력
	public Superman(String name, int height, int power) { // target
		this.name = name;
		this.height = height;
		this.power = power;
	}// ------------------------------------------

	public void showInfo() {
		System.out.println(" 이름  : " + name);
		System.out.println("  키   : " + height);
		System.out.println("초능력 : " + power);
	}
}
