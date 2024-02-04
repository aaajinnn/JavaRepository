package quiz01;

import javax.swing.JOptionPane;

public class Exam02 {
	public static void main(String[] args) {
		// 키 199.9일때 적정몸무게 구하기
		// (키 - 100) * 0.9
		String height = JOptionPane.showInputDialog("키 : ");
		double cal = (Double.parseDouble(height) - 100) * 0.9;
		System.out.println("적정 몸무게 : " + cal);
	}
}
