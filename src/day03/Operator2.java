package day03;

public class Operator2 {
	public static void main(String[] args) {
		System.out.println("6. 삼항 연산자( ? : )");
		/*
		 * 변수 선언문 = (조건식)? 값1 : 값2 ⇒ 조건식이 true이면 값1을 변수에 대입하고, false이면 값2를 변수에 대입한다.
		 */
		int a = 50, b = 60;
		int result = (a > b) ? a : b;
		System.out.println("result = " + result); // 60
		if (a < b) {
			result = a;
		} else {
			result = b;
		}
		System.out.println("result = " + result); // 60

		String result2 = (a > b) ? String.valueOf(a) : String.valueOf(b); // 타입이 서로 다르면 값을 넣어줄 수 없다.
		System.out.println("result2 = " + result2); // 60
	}
}
