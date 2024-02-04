package day03;

import java.util.Scanner;

public class IfText2 {
	public static void main(String[] args) {
		// 입력값이
		// 11 22 33 44 55 ....
		// ==> "OK 10의 자리와 1의 자리가 같아요"
		System.out.println("두자리 정수를 입력하세요 => ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		if (num < 10 || num > 99) {
			System.out.println("입력오류! 2자리 정수여야 해요");
			return; // 밑에 문장 실행 안하고 돌아옴
		}

		// 방법 1
		if (num % 10 == num / 10) { // (num % 11 == 0)
			System.out.println("Ok 10의 자리와 1의 자리가 같아요");
		} else {
			System.out.println("No 10의 자리와 1의 자리가 달라요");
		}

		// 방법 2
		int n1 = num / 10;
		int n2 = num % 10;
		System.out.println("n1 : " + n1 + ", n2 : " + n2);
		if (n1 == n2) {
			System.out.println("Ok 10의 자리와 1의 자리가 같아요");
		} else {
			System.out.println("No 10의 자리와 1의 자리가 달라요");
		}

		// 삼항 연산자로 바꿔보기
		String result = (n1 == n2) ? "Ok 같아요" : "No 달라요";
		System.out.println(result);

		System.out.println((num % 11 == 0) ? "Ok Same" : "No Not Same"); // 1회용

		System.out.println(result.toLowerCase());// 재사용
	}

}
