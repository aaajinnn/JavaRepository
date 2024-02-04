package day02;

// import java.lang.System; 
// java.lang 패키지 import문은 생략해도 된다. => 컴파일러가 자동으로 import함
import java.util.Date;

public class Primitive {
	// main()
	public static void main(String[] args) {
		System.out.println("---기본 자료형(Primitive Type)-------");
		Date d = new Date();
		System.out.println("오늘 날짜 : " + d);

		System.out.println("-----1. 정수형 (byte < short < [int] < long)------");
		// 변수 선언시 : 자료형 변수명 = 값(literal);

		byte bt1 = -128; // 1byte (-128 ~ 127)
		byte bt2 = 127; // byte범위에 벗어나는 값을 적으면 오류가 난다.
		System.out.println("bt1 = " + bt1);
		System.out.println("bt2 = " + bt2);

		short st1 = 3000; // 2byte : 2^15 ~ 2^15 -1
		short st2 = -5578;
		System.out.println("st1 = " + st1);
		System.out.println("st2 = " + st2);

		int it = 500000; // 4byte(32bit) : -2^31 ~ 2 41 -1
		// int => 정수형의 default
		System.out.println("it = " + it);

		long ln1 = 80; // 8byte(64bit) : -2^63 ~ 2^63 -1
		long ln2 = 80L; // 뒤에 접미사 L,l을 붙인다.=> 값 자체가 long타입이 된다.
		System.out.println("ln1 = " + ln1);
		System.out.println("ln2 = " + ln2);

		int i = 1000000000; // int형 -2147483648 ~ 2147483647
		long j = 10000000000L; // 정수형의 default가 int이기때문에 int로 인식 => 이럴때 접미사 L을 붙여준다.

		// printf(포맷문자열, 값, ...)
		System.out.printf("i = %d%n", i);
		System.out.printf("j = %d\n", j);

		int a = 010; // 8진수 정수 : 앞에 '0'을 접두어로 붙인다.
		int b = 011;
		System.out.printf("a = %d%n", a);
		System.out.printf("b = %d%n", b);
		int c = 0217;
		System.out.printf("c = %d%n", c);

		int d1 = 0x1A; // 16진수 정수 => 앞에 0x를 접두어로 붙인다.
						// 0~15 => 0~9,a,b,c,d,e,f
		// 1*16 + 10*1 = 26
		System.out.println("d1 = " + d1);
		// 1*16^2 + 10*16 + 15*1
		int d2 = 0x1AF;
		System.out.println("d2 = " + d2);

	}

}
