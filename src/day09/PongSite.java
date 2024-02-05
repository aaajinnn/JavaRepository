package day09;
// Ex02

import java.util.Scanner;

public class PongSite {

	public void join(String name, String pwd) throws NotSupportedNameException {
		System.out.println(">>> 회원가입 <<<");
		// '콩' => 예외 발생시키기 "콩씨는 절대로 안돼!!!"
		// 그 외의 성씨면 => 예외 발생시키기 "퐁씨 성이 아닌 분들은 이용에 제한이 있습니다"

		if (name.startsWith("퐁")) {
			System.out.println("환영합니다~" + name + "님!!");
		} else if (name.startsWith("콩")) {
			throw new NotSupportedNameException("콩씨는 절대로 안돼요!!");
			// throws와 throw는 쌍으로 존재
		} else {
			throw new NotSupportedNameException("퐁씨 성이 아닌 분들은 이용에 제한이 있어요");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름 : ");
		String name = sc.next();
		System.out.println("비밀번호 : ");
		String pwd = sc.next();

		// Join()호출하기
		PongSite ps = new PongSite();
		try {
			ps.join(name, pwd);
		} catch (NotSupportedNameException e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 디버그 잡아주는 스택기록
		}
	}

}
