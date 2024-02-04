package practice;

import java.util.Scanner;

public class Ex02_While {
	public static void main(String[] args) {
		// [문제1] 1~100까지 정수를 다음과 같은 식으로 계산한 수식과 결과값을 출력하세요
		// 1+ (-2) + 3+(-4) + 5 + (-6) ....+(-100)
		int i = 1;
		int sum = 0;
		while (i <= 100) {
			if (i % 2 != 0) {
				System.out.printf("%d+", i);
				sum += i;
			} else {
				int n = i * (-1);
				sum += n;
				System.out.printf("(%d)+", n);
			}
			i++;
		}
		System.out.println();
		System.out.println("결과 : " + sum);

		// [문제2]
		// 1+ (1+2) + (1+2+3) + (1+2+3+4)...+(1+2+...+10)
		// 의 결과값을 출력하세요
		i = 1;
		sum = 0;
		int total = 0; // sum을 누적할 변수
		String str1 = "", str2 = "";
		while (i <= 10) {
			sum += i;
			total += sum;
			if (i == 1) {
				str1 += i;
				str2 += i;
			} else {
				str2 += "+" + i;
				str1 += "+(" + str2 + ")";
			}
//			System.out.print(sum + "+");
			i++;
		}
		System.out.print(str1);
		System.out.println("=>" + total);

		// [문제3] Scanner이용해서 "구구단의 몇 단을 하시겠어요?" 입력받아 구구단식 출력하기
		System.out.println("구구단의 몇단을 하시겠어요? ");
		Scanner sc = new Scanner(System.in);
		i = 1;
		int dan = sc.nextInt();
		while (i <= 9) {
			System.out.printf("%d x %d = %d\n", dan, i, i * dan);
			i++;
		}

	}
}
