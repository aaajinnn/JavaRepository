package day10;
//Ex01

import java.awt.Color;
import java.util.*;

/*Map계열
 * Hashtable, HashMap, Properties
 * - Object유형을 저장할 수 있다
 * - key와 value값을 매핑하여 저장한다.
 * - key값의 중복을 허용하지 않는다.
 * - 무순서
 * - 데이터가 75%차면 자동으로 저장 역역을 확대한다.
 * - 데이터 저장: Object put(Object key, Object value)
 * - 데이터 꺼내기: Object get(Object key)
 * */
public class HashMapTest {

	public static void main(String[] args) {
		// Hashtable : HashMap과 사용방법 동일
		Hashtable ht = new Hashtable();
		ht.put("하나", 1);
		ht.put("둘", "two");
		ht.put("파랑", "blue");
		ht.put("빨강", java.awt.Color.red);

		Object obj = ht.get("둘"); // 제너릭을 안쓸때는 무조건 반환타입은 Object
		System.out.println(obj);

		Color obj2 = (Color) ht.get("빨강"); // 강제형변환
		System.out.println(obj2.getRed() + "<= red값");
		System.out.println("-----------------------------");

		// Generic 이용 <K, V>
		HashMap<String, Integer> map = new HashMap<>();
		map.put("생년", 2000);
		map.put("나이", 24);
		map.put("용돈", 500000);
		System.out.println(map); // 순서X

		map.put("용돈", 700000);
		System.out.println("map.size() : " + map.size());
		System.out.println(map); // 중복X, 중복되는 값이 있다면 나중에 넣은 값이 출력
		System.out.println("------------------------------");
		// Set<K> keySet()
		// key 값들만 Set유형으로 반환한다.
		Set<String> set = map.keySet();
		for (String key : set) {
			// value값도 출력
			Integer val = map.get(key);
			System.out.println(key + "#" + val);
		}
		System.out.println("-------------------------------");
		// Set이 가진 메서드
		// Iterator<E(Set이 가진 유형)> iterator()
		Iterator<String> it = set.iterator();
		// key값을 집합유형으로 반환해서 해당 집합을 논리적 커서를 이용해서
		// 한번에 꺼내올 수 있는 방법을 제공한다
		/*
		 * boolean hasNext() : 커서를 이용해서 요소를 꺼내요는 메커니즘 첫번째에 위치하고 있다가 요소를 꺼내와 true반환 논리적
		 * 커서는 첫번째 요소 직전에 위치함(before First) ex) 첫번재커서(hasNext) -> "용돈"(next) ->
		 * "나이"(next) -> "생년"(next) next : 커서가 한칸 이동해 커서가 가르키고 있는 객체 반환 E next()
		 */
		while (it.hasNext()) {
			String key = it.next(); // 논리적 커서를 다음칸으로 이동, 가리키는 곳의 요소 반환
			System.out.println(key);
		}

		// Collection<V> values()
		// value값들만 collection유형으로 반환
		Collection<Integer> col = map.values();
		for (Integer k : col) {
			// value값으로는 key값을 알아내기 힘듬
			System.out.println(k);
		}

	}

}
