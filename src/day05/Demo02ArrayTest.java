package day05;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Demo02ArrayTest {
	/*
	 * 배열 - 동종의 데이터만 저장가능 - 고정 크기
	 * 
	 * 참조형 배열 - 같은 종류 => 부모 자식 상속관계를 갖고있을 경우 동종의 데이터로 간주된다.
	 */
	public static void foo() {
		System.out.println("2. 참조형 배열---------");
		// java.lang.Object클래스 => 모든 클래스의 부모 클래스
		Object[] arr = new Object[5];
		// Object유형의 배열에는 모든 유형의 객체를 저장할 수 있다.
		arr[0] = new Object();
		arr[1] = "Hello";
		arr[2] = new Random();
		arr[3] = new Date();
		arr[4] = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			System.out.println(arr[i].toString());
			System.out.println("*********");
		}
		System.out.println("------------");
		// for-each
		for (Object x : arr) {
			System.out.println(x); // x.toString();
		}
	}

	public void bar() {
		System.out.println("1. 1차원 배열---------");
		int[] a = { 10, 20 };
		int b[] = { 9, 8, 7, 6 };
		int c[]; // 배열 선언만(메모리할당X)
		c = a; // c는 a가 참조하는 배열을 같이 참조하는 형태가 된다.
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		for (int v : a) {
			System.out.println(v);
		}

		c[1] = 70; // 값변경
		System.out.println("c[1] = " + c[1]);
		System.out.println("a[1] = " + a[1]);

		// x와 y의 배열을 서오 바꿔 참조하도록 해보기 - swap
		int[] x = { 1, 2, 3, 4, 5 };
		int[] y = { 100, 200 };
		int[] tmp;

		tmp = x;
		x = y;
		y = tmp;
		for (int i = 0; i < x.length; i++) {
			System.out.printf("x[%d] : %d\n", i, x[i]);
		}
		// x[0] : 100
		// x[1] : 200
		for (int i = 0; i < y.length; i++) {
			System.out.printf("y[%d] : %d\n", i, y[i]);
		}
		// y[0] : 1
		// y[1] : 2
		// y[2] : 3
		// y[3] : 4
		// y[4] : 5
	}

	public static void main(String[] args) {
		Demo02ArrayTest.foo();

		Demo02ArrayTest at = new Demo02ArrayTest();
		at.bar();
	}

}
