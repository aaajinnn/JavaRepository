package day11;
// Ex06-2

// [1] java.lang.Thread클래스를 상속받아 구현
public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		// 스레드 2개를 생성해서 동작시키자
		// 동작시킬때는 run()이 아니라 start() 호출해야함!!!!!
		SnailThread1 tr1 = new SnailThread1("퐁퐁이 달팽이");
		SnailThread2 tr2 = new SnailThread2("거꾸로 달팽이");
//		tr1.run(); // [x]

		tr1.setPriority(10); // 높은 우선순위
		tr2.setPriority(3); // 낮은 우선순위
		tr1.start();
		tr2.start();

		tr1.join();
		// tr1이 작업을 마칠 때 까지 join()을 호출한 스레드는 block 상태가 된다.

		System.out.println("Hello World"); // 맨위에 출력
		// 현재 실행 중인 스레드를 알아보자
		Thread tr3 = Thread.currentThread();
		System.out.println(tr3.getName() + "스레드가 실행중..."); // main스레드가 실행중...

	}

}
