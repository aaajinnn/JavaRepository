package day08;

// 학사관리 프로그램
// 학생(학번,이름,연락처,학급), 교사(교번,이름,연락처,과목), 직원(사번,이름,연락처,부서)
public class Person { // 부모클래스(공통) // extends Object
	int no;
	String name;
	String tel;

//	public Person() {
//		// 부모에 기본생성자를 만들고 시작하면 Student 클래스에 에러없이 실행
//	}

	// 인자생성자
	public Person(int no, String name, String tel) {
		this.no = no;
		this.name = name;
		this.tel = tel;
	}

	// toString() 오버라이딩
	public String toString() {
		String str = "---Person---\n";
		str += "No : " + no + "\nName : " + name + "\nTel : " + tel;
		return str;
	}
}
