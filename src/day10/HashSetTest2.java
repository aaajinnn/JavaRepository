package day10;
//Ex03

// 컬렉션을 이용하여 객체를 만들어보자
import java.util.HashSet;
import java.util.Iterator;

/* Set계열의 특징
 * - 순서를 기억하지 않는다.
 * - 데이터 중복을 허용하지 않는다.
 * 구현클래스
 * - HashSet
 *: 해쉬셋은 객체를 저장하기 전에 객체의 hashCode()를 호출하여 해시코드를 얻어낸다.
 *     그리고 이미 저장되어 있는 객체들의 해시코드와 비교한다. 만약 동일한 해시코드가 
 *     있다면 그다음에는 equals()메소드로 두 객체를 비교해서 true가 나오면 동일한
 *     객체로 판단하고 중복 저장을 하지 않는다. 	
 * 
 * */
public class HashSetTest2 {
	public static void main(String[] args) {
		// [1] Person객체 3명 생성해서 HashSet에 저장
		Person p1 = new Person(); // 김철수, 20
		Person p2 = new Person("박영희", 29);
		Person p3 = new Person("김진수", 28);

		HashSet<Person> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println(set.size() + "명 저장");

		// [2] HashSet에 저장된 Person객체의 이름과 나이를 한꺼번에 출력
		Iterator<Person> it = set.iterator();
		while (it.hasNext()) { // 반환타입을 안쓰면 형변환 오류
			Person p = it.next();
			System.out.println(p.getName() + " : " + p.getAge());
		}

		// 내용은 같지만 객체의 메모리 주소가 달라서 동일한 객체로 여기지 않는다.
		Person p4 = new Person("박영희", 29);
		set.add(p4);
		System.out.println(set.size() + "명 저장");
		System.out.println("********************");
		for (Person p : set) {
			System.out.println(p.getName() + " : " + p.getAge());
		}
//		System.out.println(p2);
//		System.out.println(p4); // 해쉬값(주소값)이 서로 다르다.
//		System.out.println(p2.equals(p4)); // false

		// Person에서 hashCode()와 equals()를 오버라이드 후 다시 실행해보면
		// 3명 저장, 박영희는 1명만 저장된 것을 확인 할 수 있다.(중복 저장 X)
		System.out.println(p2);
		System.out.println(p4); // 해쉬값(주소값)이 서로 같아졌다.
		System.out.println(p2.equals(p4)); // true

	}

}
