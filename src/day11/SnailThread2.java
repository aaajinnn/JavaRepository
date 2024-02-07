package day11;
// EX06-1

// 100부터 시작해서 1씩 감소하는 달팽이 스레드 구현해보자
public class SnailThread2 extends Thread {

	public SnailThread2(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		for (int x = 100; x >= 0; x--) {
			System.out.println(getName() + "가 뒤로 기어감 : " + x);

//			try {
//				Thread.sleep(20); // 0.02초동안 block상태가 된다
//			} catch (Exception e) {
//				System.out.println("예외 : " + e.getMessage());
//				e.printStackTrace();
//			}
		}
	}
}
