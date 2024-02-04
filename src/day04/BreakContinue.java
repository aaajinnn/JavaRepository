package day04;

public class BreakContinue {

	public static void main(String[] args) {

		System.out.println("1. ---------------");
		for (int i = 0; i < 3; i++) {
			if (i == 1)
				break;
			System.out.println("i = " + i); // i = 0
		}

		System.out.println("2. ---------------");
		for (int i = 0; i < 3; i++) {
			if (i == 1)
				continue;
			// 조건에 부합하면 아래 문장을 skip 하고 반복문을 계속 수행
			System.out.println("i = " + i); // i = 0, 2
		}

		System.out.println("3. ---------------");
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k == 1)
					break;
				System.out.println("i = " + i + ", k = " + k);
				// i = 0, k = 0
				// i = 1, k = 0
				// i = 2, k = 0
			}
		}

		System.out.println("4. ---------------");
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k == 1)
					continue;
				System.out.println("i = " + i + ", k = " + k);
				// i = 0, k = 0
				// i = 0, k = 2
				// i = 1, k = 0
				// i = 1, k = 2
				// i = 2, k = 0
				// i = 2, k = 2

			}
		}

		/*
		 * break 레이블명; :레이블과 가까운 반복문을 이탈 continue 레이블명; :레이블과 가까운 반복문을 계속 수행
		 */

		System.out.println("5. ---------------");
		outer: // lable
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k == 1)
					break outer;
				System.out.println("i = " + i + ", k = " + k);
				// i = 0, k = 0
			}
		}

		System.out.println("6. ---------------");
		aaa: // lable
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k == 1)
					continue aaa; // aaa와 가까운 반복문을 계속 수행하라
				System.out.println("i = " + i + ", k = " + k);
				// i = 0, k = 0
				// i = 1, k = 0
				// i = 2, k = 0

			}
		}
	}

}
