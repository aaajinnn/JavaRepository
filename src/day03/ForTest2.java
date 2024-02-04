package day03;

public class ForTest2 {

	public static void main(String[] args) {
		// [1]for루프 이용해서 1~10까지의 합과 곱을 구해 출력하세요
		// 1+2+3+....+10=55
		// 1*2*3* ....*10=3628800
		int i = 0;
		int sum = 0;
		int mul = 1;
		for (i = 1; i <= 10; i++) {
			sum += i;
			mul *= i;
//			if (i < 10) {
//				System.out.print(i + "+");
//			} else {
//				System.out.print(i + "=");
//			}
		}
		System.out.println(sum);
		System.out.println(mul);

//		for (i = 1; i <= 10; i++) {
//			mul *= i;
//			if (i < 10) {
//				System.out.print(i + "*");
//			} else {
//				System.out.print(i + "=");
//			}
//		}
//		System.out.print(mul);

		// -----------------------------------------------------

		// [2] 1~20까지 정수 중 (2 또는 3의 배수)가 아닌 수를
		// 출력하고, 이 수들의 총합을 구하세요
		int sum2 = 0;
		for (i = 1; i <= 20; i++) {
			// if (!(i % 2 == 0 || i % 3 == 0))
			if (i % 2 != 0 && i % 3 != 0) {
				sum2 += i;
			}
		}
		System.out.println(sum2);

		// -----------------------------------------------------
		// [3] 알파벳 대문자A,B...Z 를 for루프 이용해 출력하기
		char alp = ' ';
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
		System.out.println();

		// [3-1] 아스키코드로 풀어보기 65~90
		for (i = 65; i <= 90; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();
	}

}
