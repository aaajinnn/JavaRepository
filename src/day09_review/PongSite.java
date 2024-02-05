package day09_review;

//Ex02
import java.io.IOException;
import java.util.Scanner;

public class PongSite {

	public void join(String name, String pwd) throws NotSupportedNameException {
		System.out.println(">>회원가입<<");
		if (name.startsWith("퐁")) {
			System.out.println("환영합니다~" + name + "님!");
		} else if (name.startsWith("콩")) {
			throw new NotSupportedNameException("콩씨는 접근 불가!");
		} else {
			throw new NotSupportedNameException("퐁씨가 아닌 분들은 이용에 제한이 있습니다.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이 름 : ");
		String name = sc.next();
		System.out.println("비밀번호 : ");
		String pwd = sc.next();

		// join() 호출
		PongSite ps = new PongSite();
		try {
			ps.join(name, pwd); // <-빨간줄 에러 try~catch
		} catch (NotSupportedNameException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
