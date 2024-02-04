package day07_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Text {

	public static void main(String[] args) {
		// 기본적인 틀 구성
		JFrame f = new JFrame();
		f.setSize(500, 500); // width, height

		JButton btnNewButton = new JButton("New button");
		f.getContentPane().add(btnNewButton, BorderLayout.NORTH);

		JButton btnNewButton_1 = new JButton("South");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		f.getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);

		JButton btnNewButton_2 = new JButton("New button");
		f.getContentPane().add(btnNewButton_2, BorderLayout.WEST);

		JButton btnNewButton_3 = new JButton("New button");
		f.getContentPane().add(btnNewButton_3, BorderLayout.EAST);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Text.class.getResource("/day07_1/img2.jpg")));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		f.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		f.setVisible(true); // true값을 주어야 확인 할 수 있다.
	}

}
