package practice;

public class Ex01_For {

	public static void main(String[] args) {
		// for문을 이용한 별찍기
		System.out.println("--------------");
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("--------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (i + j > 4) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("--------------");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (i + j >= 2 && j - i <= 2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

}
