package quiz01;

import javax.swing.JOptionPane;

// Exam01~04
// quiz_01_이름.zip
public class Exam01 {
	public static void main(String[] args) {
		// 가로 110, 세로 220 입력받아서 사각형의 면적을 구해 출력
		String width = JOptionPane.showInputDialog("가로값");
		String height = JOptionPane.showInputDialog("세로값");
		System.out.println("사각형의 면적 : " + Integer.parseInt(width) * Integer.parseInt(height));
	}
}
