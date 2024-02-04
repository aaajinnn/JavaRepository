package day08;

//학사관리 프로그램
//학생(학번,이름,연락처,학급), 교사(교번,이름,연락처,과목), 직원(사번,이름,연락처,부서)
// Person상속 받고 className(학급) 속성 추가하기 
public class Student extends Person {
	// Person()에 인자생성자를 생성했으므로 이대로 하면 에러
	// String className;

	String className;

	public Student() {
		// super(); ==> 자식클래스 생성자에서는 묵시적으로 super() 호출

		// 그렇다면 명시적으로 부모가 생성하면 문제가 해결됨
		super(0, "학생", "010"); // 부모에 기본생성자가 없을 경우 명시적으로 super(인자)생성자를 호출해준다.
	}

	public Student(int no, String name, String tel, String className) {
		// super(); ==> 자식클래스 생성자에서는 묵시적으로 super() 호출
		super(no, name, tel); // 부모를 통해 초기화됨

		// super() ==> 생성자에서만 호출 가능하며, 첫번째 라인에서 호출해야 함
		// super()호출 후 this
		this.className = className;
	}

	// toString() 오버라이드
	@Override
	public String toString() {
		String str = super.toString(); // no,name,tel 반환함
		str = str.replace("Person", "Student");// Person을 Student로 교체
		str += "\nClass : " + className;
		return str;
	}
}
