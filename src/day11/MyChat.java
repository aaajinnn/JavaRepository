package day11;
// Ex04

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.*;
import java.awt.event.*; //1

/*[실습]
 * - 입력 버튼에 대한 이벤트 처리=> ActionEvent
 * - 버튼을 누르면 tf에 입력한 값을 가져와서
 *   ta에 붙여주고
 * - tf는 다시 비워주기
 * - ta에는 그동안 입력한 내용을 모두 볼 수 있도록 처리하세요   
 * */

public class MyChat extends JFrame implements ActionListener { // 2

	Container cp;
	private JTextField tf;
	private JTextArea ta;
	private JButton bt;

	public MyChat() {
		super("MyChat");
		cp = this.getContentPane();
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// JScrollPane을 먼저 붙인 후 JTextArea를 붙여넣는다
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 360, 492);
		panel.add(scrollPane);

		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ta.setBorder(new LineBorder(Color.blue, 3));
		ta.setFont(new Font("sans-serif", Font.BOLD, 18));
		ta.setEditable(false); // 편집불가(읽기전용)

		tf = new JTextField();
		tf.setBounds(12, 522, 360, 40);
		panel.add(tf);
		tf.setColumns(10);
		tf.setFont(new Font("sans-serif", Font.BOLD, 18));
		tf.setBorder(new TitledBorder("Message"));

		bt = new JButton("입  력");
		bt.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		bt.setBounds(12, 577, 360, 40);
		panel.add(bt);
		// 버튼 단축키 설정 Alt+M
		bt.setMnemonic('M');

		// 4 리스너 부착
		bt.addActionListener(this);
		tf.addActionListener(this); // Enter칠때 ActionEvent 발생

		this.setSize(400, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyChat();
	}// --------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) { // 3
		// 5
		String input = tf.getText();
//		ta.setText(ta.getText() + input + "\n");
		ta.append(input + "\n"); // 입력한 내용 덧붙이기
		tf.setText("");
		tf.requestFocus();
	}
}
