package day10;
//Ex03-1

// JobSeeker, Student, Teacher, Superman,... : 도메인객체 => VO객체(Value Object), DTO객체(Data Transfer Object)

public class Person {
	// 캡슐화
	private String name;
	private int age;

	// 기본생성자
	public Person() {
		this("김철수", 20);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// setter, getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 이름,나이가 같으면 동일인물로 간주하여 해시셋에 중복저장하지 않도록
	// hashCode(), equals() 메서드를 Override 하자
	// hashCode()
	@Override
	// public 반환타입 hashCode()
	public int hashCode() {
		System.out.println("name의 해시코드 : " + name.hashCode());
		return name.hashCode() + age; // name의 hashCode를 int로 반환 + int age
	}

	// equals()
	@Override
	// public boolean equals(매개변수)
	public boolean equals(Object obj) {
		// 부모의 Object를 Person유형으로 형변환
		// instanceof 연산자 : boolean값 반환
		// 참조변수 instanceof 클래스명
		// 참조변수가 클래스의 객체면 true반환, 그렇지 않으면 false반환
		if (obj instanceof Person) { // obj가 Person의 객체인가? 물어봄
			Person p = (Person) obj; // true라면 강제형변환해 getName을 쓸수있다
			boolean bool = (this.name.equals(p.getName()) && this.age == p.getAge());
			return bool;
		} else {
			return false;
		}
	}

}
