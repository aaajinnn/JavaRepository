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

	private boolean flag = false;
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

		bt = new JButton("퇴   장");
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
			ta.setText("채팅 서버 연결 실패\n" + e + "\n");
		}
	}// -------------------------

	public void run() {
		String serverMsg = "";
		try {
			while (!flag) {
				serverMsg = in.readLine();
				if (serverMsg == null)
					return;
				ta.append(serverMsg + "\n");
				// 커서의 위치(스크롤바)를 ta의 끝으로 이동시키자
				ta.setCaretPosition(ta.getText().length());
			}
		} catch (IOException e) {
			ta.append("\n서버와 연결 끊김 : " + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 3
		// 5
		Object obj = e.getSource();
		if (obj == tf) {
			sendMsg();
		} else if (obj == bt) {
			exitChat();
		}

	}// ---------------------------

	/** 서버에 메시지를 보내는 메서드 */
	public void sendMsg() {
		String input = tf.getText();
		// 입력한 내용을 서버에 보내기
		out.println(input);
		tf.setText("");
		tf.requestFocus();
	}

	/** 퇴장처리하는 메서드 */
	public void exitChat() {
		String msg = "##[" + this.nickName + "님이 퇴장합니다.]##";
		out.println(msg);
		ta.setText("");
		tf.setText("");
		tf.setEnabled(false); // 입력박스 비활성화
		// 서버 메시지 듣는 스레드 중지시키기
		try {
			flag = true;
			// 자원반납
			if (in != null)
				in.close();
			if (out != null)
				out.close();
			if (sock != null)
				sock.close();
		} catch (Exception e) {
			System.out.println("퇴장처리중 예외 : " + e);
		}
	}

	public static void main(String[] args) {
		new MyChat();
	}// --------------------------------------------

}
