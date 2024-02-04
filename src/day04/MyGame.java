package day04;

import java.util.Random;
import java.util.Scanner;

//static 메서드(클래스 메서드) : "클래스명.메서드명()" 식으로 접근한다.
public class MyGame {
	// method 구성
	public static void menu() { // void 메서드 : "반환해주는 값이 없다"
		System.out.println("**********yGame v1.1***********");
		System.out.println("1.가위 / 2.바위 / 3.보 / 9.종료");
		System.out.println("*******************************");
		System.out.println("입력하세요 =>");
		System.out.println("*******************************");
	}

	public static void startGame() {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int win = 0;
		int count = 0;

		for (;;) { // 무한루프
			// menu() 메서드 호출하기
			MyGame.menu();

			int me = sc.nextInt();
			int com = ran.nextInt(3) + 1; // 1<= com < 4 (nextInt(범위)+시작수)
			// System.out.println("me : " + me + ", com : " + com);

			count++;
			if (me == 9) {
				// break; // 가장 가까운 반복문을 벗어난다. => main메서드로 넘어가면 반복될 가능성이 있따.
				System.out.println("종료합니다.");
				System.exit(0); // 시스템 종료
			}
			// 유효성 체크
			if (me < 1 || me > 3) {
				System.out.println("메뉴에 없는 번호입니다. 다시 입력하세요 =>");
				// return; // return문을 가진 메서드를 호출한 쪽으로 돌아간다. => main()
				continue; // 아래 실행문을 skip하고 반복문을 계속 수행한다
			}

			// System.out.println("게임 진행...");
			String msg = "";
			if (me == com) {
				msg = "무승부";
			} else if ((me == 1 && com == 3) || (me == 2 && com == 1) || (me == 3 && com == 2)) {
				msg = "내가 승";
				win++;
			} else {
				msg = "컴퓨터 승";
			}
			// show() 메서드 호출하기
			// 반환타입(STring)이 있다면 앞에 적어준다.
			String result1 = MyGame.show(me);

			System.out.println("당  신 : " + result1);
			System.out.println("컴퓨터 : " + MyGame.show(com)); // 바로 반환도 가능(일회용)
			System.out.println(msg);
			System.out.println("전체 시도 횟수 : " + count + ", 당신이 승리한 횟수 : " + win);

		}
	}

	public static String show(int num) { // String : 반환값을 String으로/ int num : 받는값은 int로
		String str = "";
		switch (num) {
		case 1:
			str = "가위 [☞]";
			break;
		case 2:
			str = "바위 [●]";
			break;
		case 3:
			str = "보 [▥]";
			break;
		}
		return str;
	}

	public static void main(String[] args) {

		// startGame 메서드 호출하기
		MyGame.startGame();

	}

}
