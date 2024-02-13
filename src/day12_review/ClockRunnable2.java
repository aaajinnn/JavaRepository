package day12_review;

import java.util.*;

public class ClockRunnable2 implements Runnable {

	MultiThreadGUI remote; // // ClockRunnable2가 MultiThreadGUI를 조종할 수 있다.

	public ClockRunnable2(MultiThreadGUI gui) {
		remote = gui;
	}

	@Override
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			int am_pm = cal.get(Calendar.AM_PM);
			String str = "";
			int yy = cal.get(Calendar.YEAR);
			str += yy + "-";
			int month = cal.get(Calendar.MONTH) + 1;
			str += (month < 10) ? "0" + month + "-" : month + "-";
			int dd = cal.get(Calendar.DAY_OF_MONTH);
			str += (dd < 10) ? "0" + dd + " " : dd + " ";
			str += (am_pm == Calendar.AM) ? "AM " : "PM ";

			int hh = cal.get(Calendar.HOUR_OF_DAY); // 24시간을 기준으로 한시간
			int mm = cal.get(Calendar.MINUTE); // 분
			int ss = cal.get(Calendar.SECOND); // 초
			str += hh + ":";
			str += (mm < 10) ? "0" + mm + ":" : mm + ":";
			str += (ss < 10) ? "0" + ss : ss;

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
