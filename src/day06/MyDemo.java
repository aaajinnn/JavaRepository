package day06;

class Car {
	// 멤버변수 (1. 클래스(static) 변수, 2. 인스턴스(non-static) 변수)
	String color; // 인스턴스 변수 Car has a color
	static int capa; // 클래스 변수

	// 멤버 메서드(1. 클래스(static) 메서드, 2. 인스턴스(non-static) 메서드)
	public void run(int km) { // 매개변수 => 지역변수(local variable, automatic variable)
		System.out.println(color + "색 자동차가 시속 " + km + "km로 달려요");
	}

	public static String info() {
		String str = "---자동차 정보---\n";
		str += "용량 : " + capa + "cc\n";
//		Car c = new Car(); // null
//		str+= "색상 : "+ c.color + "색\n";

		return str;
	}
}//////////

class Tv {

}//////////

public class MyDemo { // MyDemo.java

	String str = "나는 인스턴스 변수"; // 후발대
	static String str2 = "나는 클래스 변수"; // 선발대

	public static void main(String[] args) { // 선발대
		System.out.println(MyDemo.str2); // 선발대
		System.out.println(str2); // 선발대

//		System.out.println(str); // 후발대
		MyDemo md = new MyDemo(); // 후발대
		System.out.println(md.str); // 후발대

		// Car클래스의 color변수값 출력
		Car car = new Car(); // 객체생성 => Car가 메모리에 올라가 car가 레퍼런스하여 color가 자리잡게된다.
		// static이 아니므로 객체이름으로 출력
		System.out.println("car.color : " + car.color); // null

		// Car클래스의 capa값 출력
		System.out.println("Car.capa : " + Car.capa); // 0

		car.color = "red";
		Car.capa = 2000;
		System.out.println("car.color : " + car.color); // red
		System.out.println("Car.capa : " + Car.capa); // 2000

		// run() 호출
		// static이 아니므로 객체이름으로 출력
		car.run(30);

		// info() 호출 => static 메서드
		System.out.println(car.info());

		Car car2 = new Car();
		car2.color = "blue";
		car.capa = 3000;
		car2.run(130);
		System.out.println(car.info());

		System.out.println("car.capa : " + car.capa);
		System.out.println("car2.capa : " + car2.capa);
		// => static은 객체들간 같은 속성을 공유되어야할 때만 사용해야한다.

	}

}
