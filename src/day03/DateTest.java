package day03;

// Date, Scanner ==> java.util
//import java.util.Date;
//import java.util.Scanner;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		int year = date.getYear() + 1900; // getYear() : 1900을 뺀값 반환
		int month = date.getMonth() + 1; // getMonth() : 0~11
		int dd = date.getDate();

		int hh = date.getHours();
		int mm = date.getMinutes();
		int ss = date.getSeconds();

		int dy = date.getDay();// 0~6(일~월)
		String[] dayStr = { "일", "월", "화", "수", "목", "금", "토" };

		System.out.printf("오늘 날짜는 %d년 %d월 %d일 입니다.%n", year, month, dd);
		System.out.printf("현재 시간은 %d:%d:%d%n", hh, mm, ss);
		System.out.println(dayStr[dy] + "요일");

		// [1] month
		// 28 : 2월
		// 31 : 1, 3, 5, 7,8,10,12
		// 30 : 4,5,9,11
		// switch ~case문 이용해서 "9월을 30일까지 있습니다"
		// scanner "월을 입력하세요=>" 입력받은 뒤 해당월의 일수를 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요=>");
		month = sc.nextInt();
		int lastDay = 0;
		switch (month) {
		case 2:
			lastDay = 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			lastDay = 31;
			break;
		default:
			lastDay = 30;
		}
		System.out.println(month + "월은 " + lastDay + "일까지 있습니다.");
	}

}
