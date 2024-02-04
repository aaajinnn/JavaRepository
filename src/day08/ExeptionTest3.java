package day08;

// for루프 안쪽에서
public class ExeptionTest3 {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			try {
				int y = 50 / (i - 3);
				System.out.println("y : " + y);
			} catch (ArithmeticException e) {
				System.out.println("연산오류! 분모가 0이 되어서는 안됩니다.");
			}
		} // for

		System.out.println("--The end------");
	}

}
