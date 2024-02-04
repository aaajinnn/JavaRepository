package day07_1.inheritance;
// 자식클래스(sub class)

// Superman is a Human "is a"관계 => 상속성

public class Superman extends Human {

	int power;

	// 기본 생성자
	public Superman() {
		this("아무개", 180, 200);
	}

	public Superman(String name, int height, int power) {
		this.name = name;
		this.height = height;
		this.power = power;
	}

	// 부모로부터 상속받은 메서드를 다시 재정의해보자
	// ==> Overriding(재정의)
	/*
	 * 오버라이딩 조건
	 * 
	 * 1. 부모와 메서드 이름을 동일하게 구성
	 * 
	 * 2. 매개변수도 동일하게
	 * 
	 * 3. 반환타입도 동일하게
	 * 
	 * 4. 접근 지정자는 부모와 동일하거나 더 넓은 범위를 지정
	 * 
	 */
	@Override
	public void showInfo() {
//		System.out.println("이 름 : " + name);
//		System.out.println("  키 : " + height);
		super.showInfo(); // 이름,키 출력
		System.out.println("초능력 : " + power);
	}

	// Overload
	public void showInfo(String title) {
		System.out.println(title);
		// 이름,키,초능력 출력
		this.showInfo();
	}

	public String showInfo(String title, int up) {
		System.out.println(title);
		power += up;
		return "초능력을 충전했어요. 현재 초능력은 " + power + "입니다.";
	}
}
