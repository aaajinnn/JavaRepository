package quiz03;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {

		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		int com = rn.nextInt(100) + 1;

		int count = 0;

		System.out.println("::컴퓨터가 낸 숫자를 맞춰보세요::");
		while (count < 7) {
			count++;
			int me = sc.nextInt();

			if (me < com) {
				System.out.println("더 큰 수를 입력하세요");
			} else if (me > com) {
				System.out.println("더 작은 수를 입력하세요");
			} else {
				System.out.println(count + "번만에 맞췄네요");
				System.out.println("컴퓨터 숫자 : " + com);
			}
			if (count == 7) {
				System.out.println("7번을 초과하셨으므로 실패!");
				break;
			}
		}
	}

}
