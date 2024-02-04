package day05;

import java.util.Random;

public class Demo06ArrayTest {

	public static void solution1() {
		System.out.println("---성적 확인 문제---");
		String subject[] = { "국어", "수학", "영어", "과탐", "사탐" };
		// 1학기 성적
		int[] term1 = { 99, 75, 82, 50, 48 };
		// 2학기 성적
		int[] term2 = { 80, 82, 100, 50, 42 };

		// 1.성적이 2학기에 향상된 과목수 출력
		// 2.성적이 1,2학기 동일한 과목수, 과목명을 출력
		int count = 0, equalCount = 0;
		String str = "", str2 = "";
		for (int i = 0; i < subject.length; i++) {
			if (term1[i] < term2[i]) {
				count++;
				str += subject[i] + " ";
			} else if (term1[i] == term2[i]) {
				equalCount++;
				str2 += subject[i] + " ";
			}
		}
		System.out.println("2학기에 향상된 과목수 : " + count + "개 / 과목명 : " + str);
		System.out.println("1,2학기 동일한 과목수 : " + equalCount + "개 / 과목명 : " + str2);

	}

	public void solution2() {
		System.out.println("---토익 문제 채점---");
		Random rn = new Random();
		int score = 0;
		System.out.println("********************");
		System.out.println("번호\t정답\t내답");
		System.out.println("********************");

		// 2차원배열로
		int answer[][] = new int[990][2];
		for (int i = 0; i < answer.length; i++) {
			answer[i][0] = rn.nextInt(4) + 1; // 정답
			answer[i][1] = rn.nextInt(4) + 1; // 내답
			if (answer[i][0] == answer[i][1]) {
				score++;
				System.out.printf("%d\t%d\t%d\t\n", i + 1, answer[i][0], answer[i][1]);
			}
		}
		System.out.printf("내 토익 점수 : %3d점", score);

		// 1차원 배열로
//		int[] answer = new int[990];
//		int[] my_answer = new int[990];
//		for (int i = 1; i < answer.length; i++) {
//			answer[i] = rn.nextInt(4) + 1;
//			my_answer[i] = rn.nextInt(4) + 1;
//			if (answer[i] == my_answer[i]) {
//				score++;
//			}
//			System.out.println(i + ":   " + answer[i] + "   " + my_answer[i]);
//		}
//		System.out.println("내 점수 : " + score);
	}

	public static void main(String[] args) {
		// solution1() 호출
		Demo06ArrayTest.solution1();

		// solution2() 호출
		new Demo06ArrayTest().solution2(); // 일회용
//		Demo06ArrayTest at = new Demo06ArrayTest();
//		at.solution2();
	}

}
