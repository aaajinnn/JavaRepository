package day12_review;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiThreadGUI extends JFrame {

	JButton btStart, btStop;
	static JLabel lbCount, lbImage, lbClock; // 스레드에서 사용하기 위해 static을 붙여준다.

	// 스레드에 사용할 객체
	Thread trClock;
	ClockRunnable2 r1; // Runnable 외부클래스
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

		btStop = new JButton("게임 종료");
		panel.add(btStop);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		lbCount = new JLabel("카운트 : ");
		lbCount.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lbCount.setBounds(12, 58, 253, 133);
		panel_1.add(lbCount);

		lbImage = new JLabel("이미지");
		lbImage.setIcon(new ImageIcon(MultiThreadGUI.class.getResource("/day12_review/images/T0.gif")));
		lbImage.setBounds(357, 58, 217, 144);
		panel_1.add(lbImage);

		lbClock = new JLabel("시간");
		lbClock.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lbClock.setBounds(12, 248, 604, 50);
		panel_1.add(lbClock);

		// 1. 버튼 이벤트 처리----------------------------------------
		// btStart버튼 => inner class 방식으로
		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isStop = false;
				// 버튼을 눌렀을 때 버튼의 이름을 타이틀로 가져오기
				String cmd = e.getActionCommand();
				setTitle(cmd + "누름");
				panel_1.setBackground(Color.yellow);

				// 카운트 스레드 동작
				if (trCount == null) {
					trCount = new CountThread();
					trCount.start();
				}
				// 이미지 스레드 동작
				if (trImage == null) {
					trImage = new ImageThread();
					trImage.start();
				}
			}
		});

		// btStop버튼
		btStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isStop = true;
				// 버튼을 눌렀을 때 버튼의 이름을 타이틀로 가져오기
				String cmd = e.getActionCommand();
				setTitle(cmd + "누름");
				panel_1.setBackground(Color.orange);

				// 카운트 스레드 중지
				if (trCount != null) {
					// trCount.stop();
					trCount.interrupt();
					trCount = null; // 다시 null로 돌아가도록
				}

				// 이미지 카운트 중지
				if (trImage != null) {
					trImage.interrupt();
					trImage = null; // 다시 null로 돌아가도록
				}
			}
		});
		// ----------------------------------------------------------

		// ----------------------------------------------------------
		// 2. 시계 스레드 동작
		r1 = new ClockRunnable2(this); // Runnable객체생성
		trClock = new Thread(r1); // Thread 객체생성
		trClock.start(); // GUI에 띄우기 => runnable의 run에서 추가해야한다.
		// ----------------------------------------------------------

		setSize(700, 400);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료
	}// 생성자-------------------------------------------------------

	// ----------------------------------
	// 이미지 스레드
	class ImageThread extends Thread {
		public void run() {
			int i = 0;
			while (!isStop) {
				if (i > 9) {
					i = 0;
				}
				ImageIcon icon = new ImageIcon("src/day12_review/images/T" + i + ".gif");
				lbImage.setIcon(icon);
				i++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("이미지 스레드 예외 : " + e.getMessage());
					break;
				}
			}
		}
	}
	// ----------------------------------

	// ----------------------------------
	// 카운트 스레드
	static class CountThread extends Thread {

		static int count = 500; // 카운트할 수 지정

		public void run() {
			for (; count >= 0; count--) {
				lbCount.setText("카운트 : " + count);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("카운트 스레드 예외 : " + e.getMessage());
					return;
				}
			}
			JOptionPane.showMessageDialog(lbCount, "카운트다운 종료!");
		}
	}
	// ----------------------------------

	public static void main(String[] args) {
		new MultiThreadGUI();
	}

}
