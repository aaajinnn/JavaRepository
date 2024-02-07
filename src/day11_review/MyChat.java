package day11_review;

import java.awt.Container;
// 먼저 java.awt.event.*를 import 해준다.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class MyChat extends JFrame implements ActionListener { // 2. ~Listener 인터페이스를 상속받는다.

	Container cp;
	private JTextField tf;
	private JTextArea ta;
	private JButton bt;

	public MyChat() {
		super("::My Chat::");
		cp = this.getContentPane();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 22, 338, 493);
		panel.add(scrollPane);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setEditable(false);

		tf = new JTextField();
		tf.setBounds(22, 525, 338, 40);
		panel.add(tf);
		tf.setColumns(10);
		tf.setBorder(new TitledBorder("Message"));

		JButton bt = new JButton("입  력");
		bt.setBounds(22, 575, 338, 40);
		panel.add(bt);
//		this.setSize(400, 700);
		this.setBounds(1300, 50, 400, 700); // 보여주는 위치
		this.setVisible(true);

		// 4. 리스너 부착
		bt.addActionListener(this);
		tf.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 시스템 종료

	}

	public static void main(String[] args) {
		new MyChat();

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 3. 추상메서드 오버라이딩
		// 5. 오버라이딩한 메서드에 이벤트 구현
		String input = tf.getText();
		ta.append(input + "\n"); // 입력한 내용 덧붙이기
		tf.setText("");
		tf.requestFocus();
	}

}
