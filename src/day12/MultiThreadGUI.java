package day12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MultiThreadGUI extends JFrame {

	JButton btStart, btStop;
	static JLabel lbCount, lbImage, lbClock; // 스레드에서 count변수를 사용하기 위해 static을 붙여줌

	// 스레드에 사용할 객체
	Thread trClock;
	ClockRunnable2 r1;
	CountThread trCount = null;
	ImageThread trImage = null;
	boolean isStop = false;

	public MultiThreadGUI() throws HeadlessException {
		super("::MultiThreadGUI::");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		getContentPane().add(panel, BorderLayout.NORTH);

		btStart = new JButton("게임 시작");
		panel.add(btStart);

		btStop = new JButton("게임 중지");
		panel.add(btStop);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		lbCount = new JLabel("카운트 : ");
		lbCount.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lbCount.setBounds(34, 69, 227, 114);
		panel_1.add(lbCount);

		lbImage = new JLabel("");
		lbImage.setIcon(new ImageIcon(MultiThreadGUI.class.getResource("/day12/images/T0.gif")));
		lbImage.setBounds(414, 66, 216, 144);
		panel_1.add(lbImage);

		lbClock = new JLabel("시간 ");
		lbClock.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lbClock.setBounds(103, 257, 461, 48);
		panel_1.add(lbClock);

		// btStart에 대한 이벤트 처리. Anonymous class로 처리해보자 => inner class방식
		btStart.addActionListener(new ActionListener() {
			// ActionListener를 implement하는것이 아닌 new로 객체 생성
			// => 그러기 위해서는 inner class방식으로 처리한다. ActionListener(){상속받는 이름없는 자식클래스}

			@Override
			public void actionPerformed(ActionEvent e) {
				isStop = false;
				setTitle(e.getActionCommand() + " 누름");
				panel_1.setBackground(Color.yellow);
				// 카운트 스레드와 이미지 스레드를 동작
				if (trCount == null) {
					trCount = new CountThread();
					trCount.start();
				}
				if (trImage == null) {
					trImage = new ImageThread();
					trImage.start();
				}
			}

		}); // btStart를 위한 전용 이벤트핸들러

		// btStop에 대한 이벤트 처리
		btStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isStop = true;
				String cmd = e.getActionCommand();
				setTitle(cmd + " 누름");
				panel_1.setBackground(Color.orange);
				// 카운트 스레드와 이미지 스레드를 중지
				if (trCount != null) {
					// trCount.stop(); // 사용하지말자
					trCount.interrupt();
					// 스레드가 sleep(),join() 등 블럭 됐을 때 interruptedException을 발생시킨다.
					trCount = null;
				}
				if (trImage != null) {
					trImage.interrupt();
					// 이미지 스레드에 while isStop이라는 변수를 만들어 버튼 눌렀을 떄 멈추도록 한다.
					trImage = null;
				}
			}

		});

		// 시계 스레드 동작
		r1 = new ClockRunnable2(this);
		trClock = new Thread(r1);
		trClock.start(); // GUI에 띄우기 => runnable의 run에서 추가해야한다.

		setSize(700, 400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 생성자-------------------------------------------

	// 이미지 스레드
	class ImageThread extends Thread {

		public void run() {
			int i = 0;
			while (!isStop) { // 버튼을 누르면 true가 되어 실행
				if (i > 9) {
					i = 0;
				}
				ImageIcon icon = new ImageIcon("src/day12/images/T" + i + ".gif");
				lbImage.setIcon(icon);
				i++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("이미지 스레드 예외 : " + e.getMessage());
					break;
				}
			}
		}// run()--------

	}// inner class////////////

	// 카운트 스레드 => inner class
	static class CountThread extends Thread {

		static int count = 500; // static : 여러개 스레드끼리 이 변수를 공유

		public void run() {
			for (; count >= 0; count--) {
				lbCount.setText("카운트 : " + count);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("카운트 스레드 예외 :" + e.getMessage());
					return;
				}
			}
			JOptionPane.showMessageDialog(lbCount, "카운트다운 종료! 게임 종료됐어요.");
		} // run()-------

	}// inner class////////////

	public static void main(String[] args) {
		new MultiThreadGUI();
	}// main---------------------------------------------
}
