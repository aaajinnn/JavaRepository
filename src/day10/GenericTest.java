package day10;
// Ex06

import java.awt.Color;

// 보통은 이렇게 정해져있는 타입을 지정하지만
class Car {

	String color;
	int capa;

	@Override
	public String toString() {
		return "Car [color=" + color + ", capa=" + capa + "]";
	}

}///////////////////

// Generic는 타입을 직접 지정한다.
class Truck<T1, T2, T3> {

	T1 weight;
	T2 distance;
	T3 color;

	@Override
	public String toString() {
		return "Trauk [weight=" + weight + ", distance=" + distance + ", color=" + color + "]";
	}

}///////////////////

public class GenericTest {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.color = "white";
		c1.capa = 2000;
		System.out.println(c1);

		System.out.println("----Generic----");
		Truck t1 = new Truck();
		System.out.println(t1); // Generic을 안쓰면 모두 null값으로 출력(default값이 null)
		Truck<Double, Integer, String> t2 = new Truck<>();
		t2.weight = 2.5;
		t2.distance = 5000;
		t2.color = "blue";
		System.out.println(t2);
		System.out.println("----Generic의 유형을 바꿔서 출력해보자----");
		Truck<String, Float, Color> t3 = new Truck<>();
		t3.weight = "매우 무거움";
		t3.distance = 450.3f;
		t3.color = Color.magenta;
		System.out.println(t3);
		// ==> Generic은 다양한 유형의 타입을 출력할 수 있다.

	}

}
