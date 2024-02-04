package day06;
/*Application의 종류

 * - CLI (Command Line Interface)

 * - GUI (Graphic User Interface)

 * 기본적 기능

 *   CRUD기능

 *   - C: Create => Insert 기능

 *   - R: Read => 조회 (Select), 검색 기능

 *   - U: Update=> 수정 (Update)

 *   - D: Delete=> 삭제 (Delete)

 * */

import java.util.Scanner;

public class JobKorea {
	static int count = 0; // 등록된 구직자수
	static JobSeeker[] persons = new JobSeeker[10]; // 구직자수 제한
	Scanner sc = new Scanner(System.in);

	public static void menu() {
		System.out.println("**** JobKorea v1.1 ****");
		System.out.println("1. 구직자 등록"); // C
		System.out.println("2. 회  사 등록");
		System.out.println("3. 구직자 정보 출력"); // R
		System.out.println("4. 회 사 정보 출력");
		System.out.println("5. 구직자 정보 조회"); // R
		System.out.println("6. 구직자 정보 수정"); // U
		System.out.println("7. 구직자 정보 삭제"); // D
		System.out.println("99.     종   료     ");
		System.out.println("*************************");
		System.out.println("메뉴 번호를 입력하세요 =>");
		System.out.println("*************************");
	}// --------------------------------

	/**
	 * 구직자 정보를 등록받는 메서드. 등록받아 배열에 저장한다.
	 */
	public void register() {
		if (count >= persons.length) {
			System.out.println("정원 마감!!! [" + persons.length + "명 등록 완료]");
			return;
		}
		// 구직자 객체 1개 생성해서
		JobSeeker seeker = new JobSeeker();
		// 정보를 입력받는 메서드 호출한 뒤에
		seeker.input();
		System.out.println(seeker.profile());
		System.out.println("::위 정보를 저장할까요?[1.yes 2.no]");
		int yn = sc.nextInt();
		if (yn == 2)
			return;
		// persons배열에 저장한다.
		JobKorea.persons[count++] = seeker;
		System.out.println(count + "명 구직자 정보 등록 완료!");
	}

	/**
	 * 등록된 모든 구직자 프로필을 출력하는 메서드
	 */
	public void printAll() {
		for (int i = 0; i < count; i++) {
			System.out.println(persons[i].profile());
		}

	}

	public void process() {
		// menu() 호출
		while (true) {
			menu();
			int no = sc.nextInt();
//			System.out.println("no : " + no);
			// 종료처리
			if (no == 99) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			// 유효성 체크
			if (no < 1 || no > 7) {
				System.out.println("입력오류! 메뉴에 없는 번호입니다.");
				continue;
			}

			switch (no) {
			case 1: // 1. 구직자 정보 등록 받아 배열에 저장
				register();
				break;
			case 2: // 2. 회사 정보 등록
				break;
			case 3: // 3. 등록된 모든 구직자 정보 출력
				printAll();
				break;
			case 4:
				break;
			case 5: // 구직자 정보를 이름으로 검색
				System.out.println("검색할 구직자 이름 입력 =>");
				String findName = sc.next();
				String result = search(findName);
				System.out.println(result);
				break;
			case 6:
				System.out.println("수정할 구직자 이름 입력 =>");
				String updateName = sc.next();
				String updateResult = update(updateName);
				System.out.println(updateResult);
				break;
			case 7:
				System.out.println("삭제할 구직자 이름 입력 =>");
				String deleteName = sc.next();
				String deleteResult = delete(deleteName);
				System.out.println(deleteResult);
				break;
			}// switch
		} // while
	}// --------------------------------

	/**
	 * 이름으로 배열에서 해당 이름의 구직자 정보를 찾아 문자열로 반환하는 메서드
	 */
	public String search(String name) {
		String str = "";
		for (int i = 0; i < count; i++) {
			if (persons[i].getName().equals(name)) {
				str += persons[i].profile();
			}
		}
		if (str.equals("")) {
			return name + "님 정보는 없습니다.";
		}
		return str;
	}

	/**
	 * 이름으로 배열에서 해당 이름의 구직자 정보를 찾아 수정하는 메서드
	 */
	public String update(String updateName) {
		String str = "";
		for (int i = 0; i < count; i++) {
			if (persons[i].getName().equals(updateName)) {
				persons[i].input();
			}
		}
		str += updateName + "님 정보를 수정했습니다.";
		return str;
	}

	/**
	 * 이름으로 배열에서 해당 이름의 구직자 정보를 찾아 삭제하는 메서드
	 */
	public String delete(String deleteName) {
		String str = "";
		for (int i = 0; i < count; i++) {
			if (persons[i].getName().equals(deleteName)) {
				persons[i] = null;
				count--;
			}
		}
		str += deleteName + "님 정보를 삭제했습니다. 현재 등록인원은 " + count + "명 입니다.";
		return str;

	}

	public static void main(String[] args) {
		// process() 호출
		JobKorea app = new JobKorea();
		app.process();
	}

}
