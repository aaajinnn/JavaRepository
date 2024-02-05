package day09;
// Ex05

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MyDiary extends JFrame {

	Container cp;

	String[] UserInfo = { "root", "123" }; // 아이디, 비밀번호 (임의)
	private JTextField textField; // 아이디
	private JPasswordField passwordField; // 비밀번호

	// 생성자. GUI구성
	public MyDiary() {
		// super(); 기본생성자
		super(":::MyDiary v1.1:::"); // JFrame의 문자열을 받는 생성자 => 문자열이 title에 올라간다.
		cp = this.getContentPane(); // 컨텐트 페인

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/diary.jpg")));
		lblNewLabel.setBounds(43, 28, 299, 207);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textField.setBounds(98, 259, 189, 37);
		panel.add(textField);
		textField.setColumns(10);
		textField.setBorder(new TitledBorder("아이디"));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		passwordField.setBounds(98, 306, 189, 37);
		panel.add(passwordField);
		passwordField.setBorder(new TitledBorder("비밀번호"));

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(btnNewButton, "로그인버튼클릭");

				// 아이디, 비번 입력값 얻기
				String id = textField.getText();
//				String pw = new String(passwordField.getPassword());
				char[] ch = passwordField.getPassword();
				String pw = new String(ch);

				// 유효성 체크(다이얼로그박스 띄우기)
//				if (id.equals("")) {
//					JOptionPane.showMessageDialog(btnNewButton, "아이디를 입력하세요.");
//					textField.requestFocus();
//					return;
//				} else if (pw.equals("")) {
//					JOptionPane.showMessageDialog(btnNewButton, "비밀번호를 입력하세요.");
//					passwordField.requestFocus();
//					return;
//				}
				if (id == null || ch == null || id.equals("") || pw.equals("")) {
					showMsg(panel, "아이디, 비밀번호를 입력해야 합니다.");
					return;
				}
//				if (id.equals(UserInfo[0]) && pw.equals(UserInfo[1])) {
//					String LoginCheck = "아이디 : " + id + ", 비밀번호 : " + pw;
//					JOptionPane.showMessageDialog(btnNewButton, id + "님 환영합니다.");
//				
//					JOptionPane.showMessageDialog(btnNewButton, LoginCheck + "");
//				} else {
//					JOptionPane.showMessageDialog(btnNewButton, "아이디 또는 비밀번호가 틀립니다.");
//				}

				// LoginCheck(아이디, 비밀번호) ==> 로그인 결과를 문자열로 반환 ==> 대화창에 보여주기
				try {
					boolean isOk = loginCheck(id, pw);

					String result = (isOk) ? id + "님 환영합니다. 일기장으로 이동합니다." : "아이디 또는 비밀번호가 일치하지 않습니다.";
					showMsg(panel, result);
					if (isOk) {
						// 메인프레임(MyDiary) 닫기
						MyDiary.this.setVisible(false);

						// 일기장(MyDiarySubFrame)으로 이동하기
						MyDiarySubFrame sub = new MyDiarySubFrame();
						sub.setSize(400, 700);
						sub.setVisible(true);
					}

				} catch (NotSupportedNameException ex) {
					showMsg(panel, ex.getMessage());
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/kakaologin.png")));
		btnNewButton.setBounds(98, 353, 189, 37);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset처리
				textField.setText("");
				passwordField.setText("");
				textField.requestFocus();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/resetl.png")));
		btnNewButton_1.setBounds(98, 415, 189, 37);
		panel.add(btnNewButton_1);

		// 창닫기 처리
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // System.exit(0)와 동일
	}// 생성자-----------------------

	public boolean loginCheck(String id, String pw) throws NotSupportedNameException {
		// id가 killer로 들어오면 "Killer는 절대로 접속 불가!!" => NotSupportedNameException 발동
		if (id.equalsIgnoreCase("Killer")) { // equalsIgnoreCase : 대소문자 구분없이
			throw new NotSupportedNameException("Killer는 절대로 접속 불가!!");
		}

		if (id.equals(UserInfo[0]) && pw.equals(UserInfo[1])) {
			return true;
		}
		return false;

	}

	public void showMsg(JPanel p, String msg) {
		JOptionPane.showMessageDialog(p, msg);
	}

	public static void main(String[] args) {
		MyDiary my = new MyDiary();
		my.setSize(400, 700);
		my.setVisible(true); // default : false

	}
}
