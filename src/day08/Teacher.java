package day08;

//학사관리 프로그램
//학생(학번,이름,연락처,학급), 교사(교번,이름,연락처,과목), 직원(사번,이름,연락처,부서)
//Person상속 받고 subject(과목) 속성 추가, 생성자 오버로드하기
public class Teacher extends Person {
	String subject;

	public Teacher() {
		super(0, "교사", "010");
	}

	public Teacher(int no, String nm, String t, String sub) {
		super(no, nm, t);
		subject = sub;
	}

	// toString() 오버라이드
	@Override
	public String toString() {
		String str = super.toString().replace("Person", "Teacher");
		str += "\nSubject : " + subject;
		return str;
	}
}
