package day02;

public class Primitive3 {
	public static void main(String[] args) {
		System.out.println("3. 문자형(char)-----------------");
		// char(2byte : 0 ~ 65535)
		char c1 = '최';
		char c2 = '\uff57'; // 유니코드
		System.out.println(c1);
		System.out.println(c2);
		char c3 = 'A';
		System.out.println(c3);
		System.out.println(c3 + 1);
		// char + int ⇒ promotion, upcasting(자동형변환) : 큰 자료유형으로 자동 형변환
		System.out.println((char) (c3 + 1));
		// c3+1=>int형으로 ==> casting, downcasting(강제형변환) : char유형으로 형변환
		// char타입이 연산에 사용되면 자동으로 int형변환 되므로 주의해야함
		// char + char = int

		String str = "최길동"; // 문자열 => Reference Type(참조형)
		System.out.printf("str = %s%n", str);

		System.out.println("4. 논리형 (boolean)----------------");
		// boolean (1byte) : true, false값만 갖는다.
		boolean bool = true;
		boolean bool2 = 2 > 5;
		System.out.println("boo1 = " + bool);
		System.out.println("boo2 = " + bool2);
	}
}
