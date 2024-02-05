package day09;
// Ex08

import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		// Generic => jdk5.0 이후부터 제너릭을 이용
		ArrayList<String> arr = new ArrayList<>();
		// String 유형만 저장 가능
		arr.add("꼬부기");
		arr.add("파이리");
		arr.add("피카츄");
		arr.add("라이츄");

		// Generic을 쓰면 형변환이 필요없다.
		String first = arr.get(0);
		System.out.println("1등 : " + first); // 1등 : 꼬부기

		// 삭제 => remove()
		String delName = arr.remove(1); // 인덱스를 String으로 받아서 출력
		System.out.println(delName + "님 탈락!"); // 파이리님 탈락!

		// for루프를 이용해 arr출력
		for (int i = 0; i < arr.size(); i++) {
			String name = arr.get(i);
			System.out.println((i + 1) + "등 : " + name);
			// 1등 : 꼬부기
			// 2등 : 피카츄
			// 3등 : 라이츄
		}
		System.out.println("###############");

		// Generic을 이용하면 for-each문 사용 가능
		for (String name : arr) {
			System.out.println(name);
		}

		// 중간 삽입(ArrayList에서는 중간삽입을 잘 하진 않는다.) => add(int index, Object value)
		arr.add(2, "야도란");
		System.out.println(arr); // [꼬부기, 피카츄, 야도란, 라이츄]

		// 포함 여부 => boolean contains(값)
		boolean b = arr.contains("마자용");
		System.out.println("b : " + b); // b : false

		// arr에 저장된 요소 모두 삭제 => clear
		arr.clear();
		System.out.println("arr.size() : " + arr.size()); // arr.size() : 0

	}

}
