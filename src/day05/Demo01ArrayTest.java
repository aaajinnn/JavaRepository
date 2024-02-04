package day05;

public class Demo01ArrayTest {

	public void testArray() {
		System.out.println("1차원 배열-----------");
		// 기본 자료형의 1차원 배열
		// 1.선언
		int a[];
		boolean[] b;
		// 2.메모리 할당
		a = new int[3];
		b = new boolean[3];
		System.out.println(a[0]); // defaule 0
		System.out.println(b[0]); // defaule false
		// 3. 초기화
		a[0] = 100;
		a[1] = 017; // 8진수
		a[2] = 0x16;// 16진수
		// for루프 이용해 출력하기
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		b[0] = true;
		b[1] = false;
		b[2] = 4 > 2;
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		// for-each문
		for (int x : a) {
			System.out.println("x : " + x);
		}
		for (boolean y : b) {
			System.out.println("y : " + y);
		}
	}

	public static void testArray2() {
		System.out.println("2. 참조형 배열----------");
//		String[] st = {"Hi","Hello","Good", "Morning"};
		String s1 = "Good";
		String s2 = new String("Morning");
		String[] st = { "Hi", new String("Hello"), s1, s2 };

		st[3] = "Morning";
		// for루프 출력
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i]);
		}
		System.out.println("------------");
		// for-each루프 출력
		for (String x : st) {
			System.out.println(x);
		}

	}

	public static void main(String[] args) {
		// testArray() 호출하기(non-static)
		Demo01ArrayTest at = new Demo01ArrayTest();
		at.testArray();
		// testArray2() 호출하기(static)
		Demo01ArrayTest.testArray2();
	}
}
