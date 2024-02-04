package quiz02;

import java.util.Random;
import java.util.Scanner;

public class MyGame {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int win = 0;

		for (;;) {
			System.out.print("me(0이면 가위, 1이면 바위, 2이면 보) >>");
			String answer = sc.next();
			count++;

			int r = ran.nextInt(3);
			System.out.println(r + " " + answer);

			if (Integer.parseInt(answer) == r) {
				System.out.println("무승부");
			} else if (Integer.parseInt(answer) >= r) {
				win++;
				System.out.println("내가승");
			} else if (Integer.parseInt(answer) <= r) {
				System.out.println("컴퓨터승");
			}
			System.out.print("종료하실래요?[X] >>");
			answer = sc.next();
			if (answer.equals("X")) {
				break;
			}
		}
		System.out.println("종료합니다.");
		System.out.println("전체 " + count + "중에 내가 승리한 수는 " + win);
	}
}
