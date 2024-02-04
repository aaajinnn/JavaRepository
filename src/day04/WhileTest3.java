package day04;

public class WhileTest3 {

	public static void main(String[] args) {

		int i = 1;
		while (i < 10) {
			int k = 2;
			while (k < 10) {
				System.out.printf("%d x %d = %2d\t", k, i, k * i);
				k++;
			}
			System.out.println();
			i++;
		}
	}

}
