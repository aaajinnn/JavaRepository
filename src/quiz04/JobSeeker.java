package quiz04_1;

public class JobSeeker {
	// 속성
	String name;
	int age;
	String tel;
	String addr;
	boolean seekState; // true : 구직중 / false : 재직중

	// 행동양식
	public void printInfo() {
		System.out.println("---구직자 정보---");
		System.out.println("이  름 : " + name);
		System.out.println("나  이 : " + age);
		System.out.println("연락처 : " + tel);
		System.out.println("주  소 : " + addr);
		if (seekState == true) {
			System.out.println("구직상태 : 구직중");
		} else {
			System.out.println("구직상태 : 재직중");
		}
	}

	// 경력,자격증,보유기술
	public String resume(String carrer, String license, String skill) {
		String str = "";
		str = "---" + name + "의 이력서---\n";
		str += "경  력 : " + carrer + "\n";
		str += "자격증 : " + license + "\n";
		str += "보유기술 : " + skill;
		return str;
	}
}
