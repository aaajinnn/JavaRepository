package day10;
// Ex04

import java.util.*;

/*
 * Queueu
 *  - List계열
 *  - 구현한 클래스 LinkedList, PriorityQueue
 *  - FIFO구조 (First In First Out) *  
 * */
public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		// add() : 추가
		q.add("어제 들어온 우유");
		q.add("오늘 들어온 우유");
		q.add("내일 들어올 우유");

		System.out.println(q); // [어제 들어온 우유, 오늘 들어온 우유, 내일 들어올 우유]

		// 선입선출
		// poll() : 큐의 앞에 있는 요소를 꺼내 삭제하고, 삭제한 요소 반환
		String str = q.poll();
		System.out.println(str + "를 꺼냈어요."); // 어제 들어온 우유를 꺼냈어요.
		System.out.println(q); // [오늘 들어온 우유, 내일 들어올 우유]
		q.remove(); // poll()과 동일
		System.out.println(q); // [내일 들어올 우유]

	}

}
