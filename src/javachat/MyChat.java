package javachat;
// Ex03

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.*;
import java.awt.event.*; //1
//서버 연결*********
import java.net.*;
import java.io.*;

//******************
public class MyChat extends JFrame implements ActionListener, Runnable { // 2

	Container cp;
	private JTextField tf;
	private JTextArea ta;
	private JButton bt;

	private String nickName = "noname";
	// 서버 연결 및 전송 *************
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	// *******************************

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

		// *******리스너받아 넘기기**************
		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		if (nickName != null) {
			setTitle(nickName + "님 대화창");
			// 챗서버에 접속
			connectChat();
		}
		// ***************************************

		this.setSize(400, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void connectChat() {
		try {
			sock = new Socket("localhost", 9999);
			ta.append("##챗 서버에 연결됨##\n");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);
			out.println(nickName); // 서버에 나의 닉네임 보내기
			// 서버의 메시지를 듣는 스레드 동작
			Thread listener = new Thread(this);
			listener.start();
		} catch (Exception e) {
//			ta.setText("채팅 서버 연결 실패\n" + e + "\n");
		}
	}// -------------------------

	public void run() {

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 3
		// 5
		String input = tf.getText();
//		ta.setText(ta.getText() + input + "\n");
//		ta.append(input + "\n"); // 입력한 내용 덧붙이기

		// 입력한 내용을 서버에 보내기

		tf.setText("");
		tf.requestFocus();
	}// ---------------------------

	public static void main(String[] args) {
		new MyChat();
	}// --------------------------------------------

}
