package day08;

// for루프 바깥쪽에서
public class ExeptionTest2 {

	public static void main(String[] args) {

		try {
			for (int i = 1; i <= 5; i++) {
				int y = 50 / (i - 3);
				System.out.println("y : " + y);
			} // for
		} catch (ArithmeticException e) {
			System.out.println("연산오류! 분모가 0이 되어서는 안됩니다.");
		}
		System.out.println("--The end------");
	}

}
