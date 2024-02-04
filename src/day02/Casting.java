package day02;

public class Casting {

	public static void main(String[] args) {
		// 형변환
		// [1] 자동형변환
		// [2] 강제형변환 => 형변환 연산자를 사용 (자료형)변수
		// byte < short < int < long < float < double
		// char
		byte b = 10;
		float f = b; // byte타입 => float으로 자동형변환
		System.out.println(b);
		System.out.println(f);

		double d = 123.456;
		// short s = d; // double에서 short으로 변환할 수 없어 에러
		short s = (short) d; // 강제형변환은 데이터 손실이 발생할 수 있다.
		System.out.println(d);
		System.out.println(s);

		int x = 68;
		char y = (char) x;
		System.out.printf("x = %d%n", x);
		System.out.printf("y = %c%n", y);

		float result = b + y * f; // 자동으로 promotion
		System.out.println(result);

		byte m = 1;
		byte n = 5;
		// byte result2 = m + n; // 에러
		int result2 = m + n;
		// ** int형보다 작은 유형의 데이터(byte / short / char)가 연산에 사용되면 자동으로 int형으로 형변환 된다.
		System.out.println(result2);

		char c1 = 'A';
		char c2 = 'B';
		// char c3 = c1 + c2; // 에러
		int c3 = c1 + c2;
		System.out.println(c3);
		String c4 = "" + c1 + c2;
		System.out.println(c4);
	}

}
