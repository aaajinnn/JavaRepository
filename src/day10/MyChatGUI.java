package day10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MyChatGUI extends JFrame {
	private JTextField textField_id;
	private JPasswordField passwordField_pw;
	private JTextField textField_msg;
	private JTextArea textArea_chat;

	Container cp;

	public MyChatGUI() {

		super(":::My Chatting:::");

		cp = this.getContentPane();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 102));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField_id = new JTextField(); // id
		textField_id.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textField_id.setBounds(53, 174, 277, 60);
		panel.add(textField_id);
		textField_id.setColumns(10);
		textField_id.setBorder(new TitledBorder("ID"));

		passwordField_pw = new JPasswordField(); // pw
		passwordField_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		passwordField_pw.setBounds(53, 267, 277, 60);
		panel.add(passwordField_pw);
		passwordField_pw.setBorder(new TitledBorder("Password"));

		JLabel lblNewLabel = new JLabel("MyTalk");
		lblNewLabel.setForeground(new Color(135, 206, 235));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(141, 87, 112, 55);
		panel.add(lblNewLabel);

		JButton btn_login = new JButton("Login");
		btn_login.setFont(new Font("Cambria", Font.BOLD, 25));
		btn_login.setForeground(Color.YELLOW);
		btn_login.setBackground(Color.DARK_GRAY);
		btn_login.setBounds(53, 402, 277, 60);
		panel.add(btn_login);

		// ---------------------------------------------

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 384, 661);
		panel.add(panel_1);
		panel_1.setVisible(true);
		panel.setVisible(false);

//		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		textArea_chat = new JTextArea();
		textArea_chat.setBounds(28, 29, 322, 467);
		panel_1.add(textArea_chat);
//		panel.add(new JScrollPane(textArea));

		textField_msg = new JTextField();
		textField_msg.setBounds(28, 514, 322, 60);
		panel_1.add(textField_msg);
		textField_msg.setColumns(10);
		textField_msg.setBorder(new TitledBorder("Message"));

		JButton btn_logout = new JButton("Logout");
		btn_logout.setBackground(new Color(0, 102, 204));
		btn_logout.setFont(new Font("Cambria", Font.BOLD, 25));
		btn_logout.setForeground(Color.YELLOW);
		btn_logout.setBounds(28, 591, 322, 60);
		panel_1.add(btn_logout);
	}

	public static void main(String[] args) {
		MyChatGUI my = new MyChatGUI();
		my.setSize(400, 700);
		my.setVisible(true);
	}
}
