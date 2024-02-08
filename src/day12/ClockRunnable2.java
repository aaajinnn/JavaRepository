package day12;
// Ex01-1

import java.util.*;

public class ClockRunnable2 implements Runnable {

	MultiThreadGUI remote; // ClockRunnable2가 MultiThreadGUI를 조종할 수 있다.

	public ClockRunnable2(MultiThreadGUI gui) {
		remote = gui;
	}

	@Override
	public void run() {
		while (true) {
//			Calendar cal = new Calendar(); // [x] Calandar는 추상클래스라 new로 객체생성 불가
			Calendar cal = Calendar.getInstance();

			String str = "";
			int yy = cal.get(Calendar.YEAR); // 년도
			str += yy + "-";

			int month = cal.get(Calendar.MONTH) + 1; // 월 0~11
			str += (month < 10) ? "0" + month + "-" : month + "-";

			int dd = cal.get(Calendar.DAY_OF_MONTH); // 일
			str += (dd < 10) ? "0" + dd + " " : dd + " ";

			int am_pm = cal.get(Calendar.AM_PM);
			str += (am_pm == Calendar.AM) ? "AM " : "PM ";

			int hh = cal.get(Calendar.HOUR_OF_DAY); // 24시간을 기준으로 한시간
			int mm = cal.get(Calendar.MINUTE); // 분
			int ss = cal.get(Calendar.SECOND); // 초
			str += hh + ":";
			str += (mm < 10) ? "0" + mm + ":" : mm + ":";
			str += (ss < 10) ? "0" + ss : ss;
			// System.out.println(str);

			// 객체를 가져와 GUI에 띄우기
			remote.lbClock.setText(str);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // while-----
	}// run() --------

}
