package day03;

import java.util.Scanner;

// 국어 영어 점수를 받아서, 총합계 점수, 평균점수, 학점을 출력하는 프로그램을 작성하세요
// 평균점수를 이용한 학점
/*
 * 100 ~90 : A 89 ~ 80 : B 79 ~ 70 : C 69 ~ 60 : D 그 외: F
 * 
 */
// 성적 테이블표 형태로 출력
/*-------------------------
 * 국어		영어
 * ----------------------
 * 85.3		92.5
 * -----------------------
 * 합계점수: xx 점
 * 평균점수: 
 * 학   점: B
 * -----------------------
 * */
public class IfTest3 {

	double x; // 인스턴스 변수
	static double y; // 클래스변수(전역변수)
	static boolean z;
	static String str;

	// => 인스턴스변수, 전역변수는 초기화하지 않으면 default값이 들어간다.
	/*
	 * 기본값 byte : 0 short : 0 shart : '\u0000' int : 0 long : 0L float : 0.0f double
	 * : 0.0 boolean : false 참조형 : null
	 */

	public static void main(String[] args) {
		System.out.println("전역변수 y : " + y);
		System.out.println("전역변수 z : " + z);
		System.out.println("전역변수 str : " + str);

		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수 =>");
		float kor = sc.nextFloat();
		System.out.println("영어점수 =>");
		float eng = sc.nextFloat();

		float sum = kor + eng;
		float avg = sum / 2;

		char grade = ' '; // 지역변수는 초기화하지 않고 사용하면 에러발생, 공백이라도 들어가야함
		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("------------------");
		System.out.println("국어\t영어");
		System.out.println("------------------");
		System.out.println(kor + "\t" + eng);
		System.out.println("------------------");
		System.out.println("합계점수 : " + String.format("%.1f", sum) + " 점");
		System.out.println("평균점수 : " + String.format("%.1f", avg) + " 점");
		System.out.println("학    점 : " + grade);
		System.out.println("------------------");
	}
}
