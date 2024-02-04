package day03;

public class Operator {
	public static void main(String[] args) {
		System.out.println("5. 논리 연산자(&, |, &&, ||)----------");
		/*
		 * & ,| : 앞의 연산으로 결과를 알 수 있어도 뒤의 문장까지 비교를 한다. && : 앞의 연산 결과가 false 이면 뒤의 연산을
		 * 생략한다. (&&는 &보다 연산속도가 빠르다. ) || : 앞의 연산결과가 true이면 뒤의 연산을 생략한다.( ||는 |보다 연산속도가
		 * 빠르다.)
		 */
		// 문제 1
		int i = 1;
		int j = i++; // j = 1, i = 2
		if ((i > ++j) & (i++ == j)) { // j = 2, i = 3
			// (2 > 2) & (2 == 2)
			i = i + j; // i = 3
		}
		System.out.println("i = " + i); // i = 3
		// 문제 2
		int k = 0;
		int p = 1;
		if ((k++ == 0) | (p++ == 2)) { // k = 1, p = 2
			// (0 == 0) | (1 == 2) => true
			k = 42;
		}
		System.out.println("k = " + k + ", p = " + p); // k = 42, p = 2
	}
}
