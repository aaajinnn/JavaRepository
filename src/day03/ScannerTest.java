package day03;

import java.util.Scanner; // Scanner를 사용하기 위함

public class ScannerTest {

	public static void main(String[] args) throws Exception {
		System.out.println("정수를 입력하세요 => ");
		// int n = System.in.read();
		// System.out.println("n : " + n); // 0의 아스키코드값이 출력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("n : " + n);

		System.out.println("키를 입력 => "); // 185.3
		double height = sc.nextDouble();
		System.out.println("당신의 키는 " + height);

		System.out.println("아침을 먹었는지 입력(true/false) => ");
		boolean food = sc.nextBoolean();
		System.out.println("아침식사 여부 : " + food);

		System.out.println("올해 목표는? => ");
		String goal = sc.next();
		System.out.println("당신의 목표 : " + goal);

		System.out.println("올해 목표를 문장으로 작성 => ");
		// 엔터값 건너뛰기
		sc.skip("\r\n");
		String goal2 = sc.nextLine();
		// 개행문자가 오기 전까지 입력을 받는다.(\n 직전까지의 문자열)
		System.out.println("당신의 목표 : " + goal2);
	}

}
