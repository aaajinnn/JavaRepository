package quiz04;

// 구직자 or 구인회사 클래스를 별도
public class JobKoreaApp {

	public static void main(String[] args) {
		JobSeeker seeker1 = new JobSeeker();
		JobSeeker seeker2 = new JobSeeker();

		seeker1.name = "홍길동";
		seeker1.age = 29;
		seeker1.tel = "010-2222-3333";
		seeker1.addr = "경기도 수원시 영통구";
		seeker1.seekState = true;

		seeker2.name = "김철수";
		seeker2.age = 30;
		seeker2.tel = "010-4444-5555";
		seeker2.addr = "경기도 수원시 장안구";
		seeker2.seekState = false;

		// printInfo() 호출하기
		seeker1.printInfo();
		seeker2.printInfo();

		// resume() 호출하기
		System.out.println(seeker1.resume("프론트엔드 개발자 2년", "정보처리기사", "HTML5, CSS, JAVA, Javascript"));
		System.out.println(
				seeker2.resume("소프트웨어 개발자 3년", "정보처리기사, SQLD", "HTML5, CSS, JAVA, Javascript, MySQL, MariaDB"));

	}

}
