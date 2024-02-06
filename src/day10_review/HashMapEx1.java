package day10_review;

import java.util.*;

public class HashMapEx1 {
	static HashMap phoneBook = new HashMap();

	// 그룹을 추가하는 메서드
	static void addGroup(String groupName) {
		// 만약 groupName key값을 가지고 있지 않다면 HashMap에 추가해라
		if (!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}

	// 그룹에 전화번호를 추가하는 메서드
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name); // 이름은 중복될 수 있으니 전화번호를 key로 저장
	}

	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	// 전화번호부 전체를 출력하는 메서드
	static void printList() {
		Set set = phoneBook.entrySet(); // entrySet() : Map의 전체 key와 value를 꺼낸다.
		Iterator it = set.iterator();

		while (it.hasNext()) {
			// Map.Entry : Map에 저장된 모든 key-value 쌍을 각각의 key-value를 갖고 있는 하나의 객체를 얻는다
			Map.Entry e = (Map.Entry) it.next();

			Set subSet = ((HashMap) e.getValue()).entrySet(); // 한쌍으로 가져온 값에서 이름(value)값만 반복문을 돌려서 받기
			Iterator subIt = subSet.iterator();

			System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]"); // subSet.size() : 가지고있는 이름의 개수

			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-1111-1111");
		addPhoneNo("친구", "김자바", "010-2222-2222");
		addPhoneNo("친구", "김자바", "010-3333-3333");
		addPhoneNo("회사", "김대리", "010-4444-4444");
		addPhoneNo("회사", "김대리", "010-5555-5555");
		addPhoneNo("회사", "박대리", "010-6666-6666");
		addPhoneNo("회사", "이과장", "010-7777-7777");
		addPhoneNo("세탁", "010-8888-8888");

		printList();
	}

}
