package day09;
// Ex07

/*컬렉션: 
 * List, Set, Map,
 * - ArrayList
 *   - java.util.List계열
 *   - 입력순서를 기억한다
 *   - 데이터 중복을 허용한다.
 *   - 동적으로 저장크기를 늘릴 수 있다.
 *   - 참조형의 데이터를 저장함.
 *   - 다른 유형의 데이터도 저장 가능함
 * 
 * */
import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		// List계열
		ArrayList arr = new ArrayList(5); // 초기용량 5개 저장
		arr.add("홍길동");
		arr.add("홍길동");
		arr.add(100); // int => java.lang.Integer객체로 저장된다. auto boxing
		arr.add(11.22); // double => java.lang.Double
		System.out.println("arr.size() : " + arr.size() + "개 저장함");

		arr.add('남');
		arr.add(true);
		arr.add("홍길동");
		System.out.println("arr.size() : " + arr.size() + "개 저장함");

		// Object get(int index)
		// 반환타입을 부모타입으로 받아야 한다.
		Object val = arr.get(0);
		System.out.println(val);
		System.out.println(((String) val).charAt(0));
		// val : Object(자식) / charAt : String(부모) => String으로 강제형변환

		Integer val2 = (Integer) arr.get(2);
		System.out.println(Integer.toBinaryString(val2)); // 2진수 문자열 반환
		System.out.println("******************");

		HashSet set = new HashSet(); // Set계열. 순서x, 중복저장x

		// for루프 이용해서 꺼내보기
		for (int i = 0; i < arr.size(); i++) {
			Object obj = arr.get(i);
			System.out.println(obj);
			set.add(obj); // 리스트에서 꺼낸 객체를 Set에 저장해본다.
		}

		// Set계열과 비교해보자
		System.out.println("set : " + set);
	}

}
