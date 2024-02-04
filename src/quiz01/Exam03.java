package quiz01;

import javax.swing.JOptionPane;

public class Exam03 {
	public static void main(String[] args) {
		String tell = JOptionPane.showInputDialog("통신사");
		System.out.println("통신사 : " + tell);
		String tellNum = JOptionPane.showInputDialog("전화번호");
		System.out.println("전화번호 : " + tellNum);
		String name = JOptionPane.showInputDialog("가입자 이름");
		System.out.println("가입자 이름 : " + name);
		if (!tell.equals("") && !tellNum.equals("") && !name.equals("")) {
			System.out.println(name + "님은 " + tell + "에 " + tellNum + "로 가입되셨습니다.");
		}
	}
}
