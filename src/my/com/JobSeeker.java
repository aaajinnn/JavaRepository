package my.com;

import java.util.Scanner;

public class JobSeeker {
	// 1. 속성 => has a 관계
	private String name;
	private int birth; // 생년
	private String phone; // 연락처
	private char gender; // 성별(F, M)

	/**
	 * 구직자 정보를 문자열로 반환하는 메서드
	 */
	public String profile() {
		String str = "---" + name + "님 프로필---\n";
		str += "이  름 : " + name + "\n";
		str += "생  년 : " + birth + "\n";
		str += "연락처 : " + phone + "\n";
		str += "성  별 : " + gender + "\n";
		return str;
	}

	/**
	 * 문서화 주석 => javadoc를 이용해서 API문서를 만들 수 있다. 구직자 정보를 입력받는 메서드
	 */
	public void input() {
		System.out.println(":::구직자 정보 등록:::");
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요 => ");
		String nm = sc.next();
		setName(nm); // name = nm;

		System.out.println("태어난 년도를 입력하세요 => ");
		int year = sc.nextInt();
		setBirth(year);

		System.out.println("연락처를 입력하세요 => ");
		String tel = sc.next();
		setPhone(tel);

		System.out.println("성별을 입력하세요[여:F, 남:M] => ");
		char gender = sc.next().charAt(0); // char를 스트링으로 받아 첫번째 문자 출력
		setGender(gender);
	}

	// setter
	public void setName(String jsName) {
		name = jsName;
	}

	public void setBirth(int jsBirth) {
		birth = jsBirth;
	}

	public void setPhone(String jsPhone) {
		phone = jsPhone;
	}

	public void setGender(char jsGender) {
		gender = jsGender;
	}

	// getter
	public String getName() {
		return name;
	}

	public int getBirth() {
		return birth;
	}

	public String getPhone() {
		return phone;
	}

	public char getGender() {
		return gender;
	}

}////////////////////////////
