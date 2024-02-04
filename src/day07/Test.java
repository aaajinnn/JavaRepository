package day07;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Test {

	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setSize(500,500);//width, height
		
		JButton btnNewButton = new JButton("New button");
		f.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("South");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.MAGENTA);
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
		lblNewLabel.setIcon(new ImageIcon(Test.class.getResource("/day07/animal.jpg")));
		lblNewLabel.setForeground(new Color(70, 130, 180));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		f.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		f.setVisible(true);//true값을 주어야 확인할 수 있음
		

	}

}
