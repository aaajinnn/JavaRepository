package day10_review;

import java.io.IOException;
import java.util.*;

public class QueueEx1 {

	static Queue q = new LinkedList();
	static final int MAX_SEZE = 5; // 최대값 지정

	public static void main(String[] args) {
		while (true) {
			System.out.println(">> help를 입력하여 시작하세요.");
			try {
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();

				if ("".equals(input))
					continue;

				if (input.equalsIgnoreCase("q")) {
					System.out.println("종료합니다.");
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SEZE + "개 보여줍니다.");
				} else if (input.equalsIgnoreCase("history")) {
					// 입력받은 명령어를 저장하고
					int i = 0;
					save(input);
					// LinkedList의 내용을 보여준다.
					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator();

					while (it.hasNext())
						System.out.println(++i + "." + it.next());
				} else {
					save(input);
					System.out.println(input);
				}
			} catch (Exception e) {
				System.out.println("입력오류");
			}
		}
	}

	// 입력받은 값을 저장할 메서드
	public static void save(String input) {
		// 입력을 했다면 queue에 저장한다.
		if (!"".equals(input)) {
			q.offer(input);
		}

		// queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if (q.size() > MAX_SEZE)
			q.remove();
	}

}
