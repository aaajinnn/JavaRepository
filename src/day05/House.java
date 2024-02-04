package day05;
// OOP언어의 4대 주요 특징

// [1] 추상화(Abstraction) : 프로그램과 관련된 객체들을 class로 구성하는 것.
// 관련된 속성(멤버변수) + 행동양식(메서드)

// [2] 캡슐화, 은닉화(Encapsulation)
// [3] 상속성 (Inheritance)
// [4] 다형성(Polymorphism)
public class House {
	// 1. 속성 ==> 멤버변수 (has a 관계가 성립 되어야 함)
	// non-static변수(instance변수) : 객체명.변수 식으로 접근
	int room; // House has a room
	String owner;
	String addr;
	// static 변수(클래스 변수) : 클래스명.변수 식으로 접근
	static int count;

	// 2. 행동양식(기능) ==> 메서드 : 동사형,소문자로시작,camel표기법 또는 언더바
	// void : 콘솔에 출력만 가능
	public void printInfo() {
		System.out.println("---House정보---");
		System.out.println("소유주 : " + owner);
		System.out.println("방  수 : " + room);
		System.out.println("주  소 : " + addr);
	}

	// 거래유형, 매매, 전세, 월세, 가격
	// void가 아닌 String은 여기저기 가져다가 쓸 수있음
	public String rent(String type, int price) {
		String str = "";
		str = "---" + owner + "의 집---\n";
		str += "거래유형 : " + type + "\n";
		str += "가    격 : " + price + "만원\n";
		return str;
	}
}
