package day09;
// Ex09

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
		HashMap<Integer, String> map = new HashMap<>();
		// key : Integer, value : String
		map.put(1, "엄마");
		map.put(2, "아빠");
		map.put(3, new String("친구"));
		map.put(4, "오빠");

		System.out.println("단축키 2번? " + map.get(2)); // 아빠
		System.out.println(map.get(55)); // 없을 경우 null 반환
		System.out.println("map.size() : " + map.size()); // 4
		System.out.println(map); // {1=엄마, 2=아빠, 3=친구, 4=오빠}
	}

}
