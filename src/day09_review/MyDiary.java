package day09_review;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyDiary extends JFrame {
	String[] userInfo = { "root", "123" };
	private JTextField textField_id;
	private JPasswordField passwordField_pw;

	Container cp;

	public MyDiary() {
		// 기본생성자
		super("::MyDiary v1.1::");
		cp = this.getContentPane(); // 컨텐트페인

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/diary.jpg")));
		lblNewLabel.setBounds(26, 5, 333, 282);
		panel.add(lblNewLabel);

		textField_id = new JTextField(); // id
		textField_id.setBounds(36, 297, 290, 45);
		panel.add(textField_id);
		textField_id.setColumns(10);
		textField_id.setBorder(new TitledBorder("아이디"));

		passwordField_pw = new JPasswordField(); // pw
		passwordField_pw.setColumns(10);
		passwordField_pw.setBounds(36, 363, 290, 45);
		panel.add(passwordField_pw);
		passwordField_pw.setBorder(new TitledBorder("비밀번호"));

		JButton loginButton = new JButton("New button"); // login
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 아이디, 비밀번호 입력값 얻기
				String id = textField_id.getText();
				char[] ch = passwordField_pw.getPassword();
				String pw = new String(ch);

				// 유효성검사
				if (id == null || ch == null || id.equals("") || pw.equals("")) {
					JOptionPane.showMessageDialog(loginButton, "아이디, 비밀번호를 입력해야 합니다.");
					return;
				}
				try {
					boolean isOk = loginCheck(id, pw);
					String result = (isOk) ? id + "님 환영합니다. 일기장으로 이동합니다." : "아이디 또는 비밀번호가 일치하지 않습니다.";
					JOptionPane.showMessageDialog(loginButton, result);
					MyDiary.this.setVisible(false);
					MyDiarySubFrame sub = new MyDiarySubFrame();
					sub.setSize(400, 700);
					sub.setVisible(true);
				} catch (NotSupportedNameException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(loginButton, e1.getMessage());
				}
				// LoginCheck(아이디, 비밀번호) ==> 로그인 결과를 문자열로 반환 ==> 대화창에 보여주기
			}
		});
		loginButton.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/kakaologin.png")));
		loginButton.setBounds(79, 439, 214, 60);
		panel.add(loginButton);

		JButton resetButton = new JButton("New button"); // reset
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		resetButton.setIcon(new ImageIcon(MyDiary.class.getResource("/day08/resetl.png")));
		resetButton.setBounds(79, 519, 214, 60);
		panel.add(resetButton);
	}

	public boolean loginCheck(String id, String pw) throws NotSupportedNameException {
		if (id.equalsIgnoreCase("Killer")) {
			throw new NotSupportedNameException("Kille는 접속 불가");
		}
		if (id.equals(userInfo[0]) && pw.equals(userInfo[1])) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyDiary my = new MyDiary();
		my.setSize(400, 700);
		my.setVisible(true);
	}
}
