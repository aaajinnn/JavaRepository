package day10;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class MyChatSub extends JFrame {
	private JTextField textField_msg;
	private JTextArea textArea_chat;

	public MyChatSub() {

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
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

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 25));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBounds(28, 591, 322, 60);
		panel_1.add(btnNewButton);
	}

	public static void main(String[] args) {
		MyChatSub sub = new MyChatSub();
		sub.setSize(400, 700);
		sub.setVisible(true);
	}
}
