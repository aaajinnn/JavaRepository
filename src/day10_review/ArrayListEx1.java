package day10_review;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10); // 객체 설정 및 초기용량 설정
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
		list1.add(1);

		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // subList(1, 4) : 1부터 4사이에 저장된 객체 반환
		print(list1, list2);

		Collections.sort(list1); // list1 정렬
		Collections.sort(list2); // list2 정렬
		print(list1, list2);

		System.out.println("list1.containsAll(list2): " + list1.containsAll(list2)); // list1이 list2의 모든 요소를 포함하고 있을 때만
																						// true
		print(list1, list2);

		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);

		list2.set(3, "AA");
		print(list1, list2);

		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
		System.out.println("list1.retainAll(list2): " + list1.retainAll(list2)); // list1에 변화가 있었으므로 true

		// list2에서 list1에 포함된 객체들을 삭제
//		for (int i = list2.size(); i >= 0; i--) {
//			if (list1.contains(list2.get(i)))
//				list2.remove(i);
//		}
		print(list1, list2);

	}

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println();

	}

}
