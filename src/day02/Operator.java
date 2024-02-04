package day02;

import java.util.Date;

public class Operator {

	public static void main(String[] args) {
		System.out.println("1. 산술 연산자 (+, -, *, /, %)");
		int a = 5;
		int b = 2;
		System.out.println(a * b); // 10
		System.out.println(a / b); // 2
		System.out.println(a % b); // 1

		System.out.println((float) a / b); // float/int => float

		System.out.println("2. 증감 연산자(++, --)");
		int c = 7;
		long d = 10;
		c++;
		System.out.println(c); // 8
		++c;
		System.out.println(c); // 9
		d--;
		System.out.println(d); // 9
		--d;
		System.out.println(d); // 8

		float e = 5.6f;
		double g = 8.7;

		// e를 먼저 출력시킨 후 1 증가 ==> e = 6.6
		System.out.println(e++); // 5.6
		System.out.println(e); // 6.6
		// e를 7.6으로 만들고 출력
		System.out.println(++e); // 7.6
		System.out.println("----------");

		// g를 먼저 출력시킨 후 1 감소 ==> g = 7.7
		System.out.println(g--); // 8.7
		System.out.println(g); // 7.7
		// g를 7.7로 만들고 출력
		System.out.println(--g); // 6.7

		System.out.println("3. 논리 부정 연산자(!)");
		// ! : 논리값 or 논리식에만 사용된다. true를 false로, false를 true로 만든다.
		boolean b1 = false;
		System.out.printf("b1 = %b%n", b1);
		System.out.printf("!b1 = %b%n", !b1);
		System.out.println(!true);

		System.out.println("4. 비교 연산자(==, !=, >, <, >=, <=) ");
		/*
		 * = : 대입연산자 == : 비교연산자 ===: 자바에는 없다[x] 비교연산자(==) [1] 기본자료형 : 값이 같은지를 비교함 [2]
		 * 참조형 : 주소값이 같은지를 비교한다
		 * 
		 * != : 값이 서로 다른가? 다르면 true, 같으면 false
		 */
		int x = 9;
		double y = 9.0;
		// 기본자료형은 값을 비교함
		System.out.println("x == y " + (x == y)); // true
		System.out.println("x != y " + (x != y)); // false
		// 참조형의 경우 주소값을 비교함
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = d2; // d3는 d2가 가르키는 객체를 같이 가르킨다.(주솟값 같음)
		System.out.println("d1 == d2 " + (d1 == d2)); // false
		System.out.println("d2 == d3 " + (d2 == d3)); // true

		int m = 5;
		int n = 7;
		System.out.println(m > n); // false
		System.out.println(m < n); // true
		System.out.println(m >= n); // false
		System.out.println(m <= n); // true

	}

}
