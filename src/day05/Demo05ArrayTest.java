package day05;

public class Demo05ArrayTest {

	public static void main(String[] args) {
		String name[] = { "아버지", "어머니", "형", "나", "동생" };
		int age[] = { 100, 88, 33, 24, 10 };
		double height[] = { 177.5, 152.2, 190.3, 167.7, 155.3 };

		System.out.println("우리집 식구 정리");
		System.out.println("-----------------");
		System.out.println("이름   나이   키");
		System.out.println("-----------------");

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " " + age[i] + " " + height[i]);
		}

	}

}
