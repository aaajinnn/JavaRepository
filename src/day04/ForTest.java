package day04;

public class ForTest {

	public static void main(String[] args) {
		// 4행 5열 별찍기
		for (int k = 0; k < 4; k++) { // 행의 조건
			for (int i = 0; i < 5; i++) { // 열의 조건
				System.out.print("★");
			}
			System.out.println(); // 별 다섯개 찍고 줄바꿈
		}

		System.out.println("------------------------");

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 2; k++) {
				System.out.println("i = " + i + ", k= " + k);
			}
			System.out.println("*************");
		}

		System.out.println("1. ------------------------");
		// [문제1]
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("1-2. ------------------------");
		// [문제1-2]
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i >= j) {
					System.out.print("*");
				}
			}
			System.out.println("");
		}

		System.out.println("2. ------------------------");
		// [문제2]
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i + j >= 3) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		System.out.println("2-1. ------------------------");
		// [문제2-1]
		for (int i = 0; i < 5; i++) {
			System.out.print(" ");
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

		System.out.println("3. ------------------------");
		// [문제3]
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 5; k++) {
				if (i + k >= 2 && k - i <= 2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
