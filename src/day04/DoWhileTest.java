package day04;

public class DoWhileTest {

	public static void main(String[] args) throws Exception {
		/*
		 * 변수 선언문 및 초기화식 do{ 실행문 조건식 }while(조건식);
		 * 
		 * while문의 경우는 조건체크를 먼저함. do~while문의 경우는 실행문을 먼저 실행한 뒤 조건 체크를 함
		 */

		// Hello문자열을 5번 출력해보자
		int count = 100;
		do {
			System.out.println("Hello : " + count);
			count++;
		} while (count < 6);
		System.out.println("The End : " + count);

		int num = 0;
		do {
			System.out.println("0~9사이의 정수값을 입력하세요. [종료 : X]");
			num = System.in.read() - '0'; // 아스키코드값이 들어감(0:48 ~ 9:57)
			// 엔터(\r\n)값 건너 뛰기
			System.in.skip(2); // 2byte 건너뜀
			System.out.println("num : " + num);

		} while (num != 'X');
	}

}
