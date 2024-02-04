package day02;

import javax.swing.JOptionPane; // 대화상자 띄우는 애

public class MyDemo {

	public static void main(String[] args) {
		String age = JOptionPane.showInputDialog("당신의 나이는?");
		System.out.println("age : " + age);

		// 유효성 체크(취소누른경우, 빈문자열 입력한 경우)
		if (age == null) {
			return; // 아래 문장을 실행하지 않고 return을 가지고 있는 main으로 돌아가 종료
		}

//		if (age == "") {
//			System.out.println("나이값을 입력해야 해요.");
//			return;
//		}
		// String참조형 == (주솟값 비교)
		// 문자열의 내용 비교 boolean equals(Object o) 메서드를 사용한다.
		if (age.equals("")) { // 문자열 내용 비교
			System.out.println("나이값을 입력해야 해요.");
			return;
		}

		int nextAge = Integer.parseInt(age) + 1; // Integer.parseInt() : 정수로 변환
		// 1년 뒤의 나이를 출력해보자
		System.out.printf("당신의 내년 나이는 %d세 이겠군요~", nextAge);

	}

}
