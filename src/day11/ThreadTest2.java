package day11;
// Ex07-1

public class ThreadTest2 {

	public static void main(String[] args) {
		// 시계를 동작시켜 보세요
//		ClockRunnable cr = new ClockRunnable();
		ClockRunnable2 cr = new ClockRunnable2();
		// => run() 코드를 가짐

		Thread tr = new Thread(cr);
		// Thread와 Runnable객체를 결합
		tr.start();
	}

}
