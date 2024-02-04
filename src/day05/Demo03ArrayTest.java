package day05;

import java.util.Random;

// 배열 교안 63p
public class Demo03ArrayTest {

	public void getScores() {
		System.out.println("수능점수 구하기");

		int[] score = new int[10000];
		Random ran = new Random(50); // Random(long seed)
		for (int i = 0; i < score.length; i++) {
			score[i] = ran.nextInt(451);
			System.out.println(score[i]);
		}

		int cnt450 = 0, cnt0 = 0, sum = 0, cnt50 = 0;
		float avg = 0.0f;

		// 1) 만점자, 0점자 인원
		for (int i = 0; i < score.length; i++) {
			if (score[i] == 450) {
				cnt450++;
//				System.out.println("만점자 번호 : " + i);
			} else if (score[i] == 0) {
				cnt0++;
			}
			sum += score[i];
		}
		// 평균
		avg = sum / (float) score.length;

		// 평균보다 +-50점
		for (int jumsu : score) {
			if (jumsu >= avg - 50 && jumsu <= avg + 50) {
				cnt50++;
			}
		}

		System.out.println("총 합계 점수 : " + sum + "점");
		System.out.println("평균 점수 : " + avg + "점");
		System.out.println("만점자 수 : " + cnt450);
		System.out.println("0점자 수 : " + cnt0);
		System.out.println("평균 점수 +-50인 학생 : " + cnt50);
	}

	public static void main(String[] args) {
		Demo03ArrayTest at = new Demo03ArrayTest();
		at.getScores();
	}

}
