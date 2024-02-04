package day05;

public class Demo04ArrayTest {
	public static void main(String[] args) {
		System.out.println("1. 2차원 배열--------");
		// 1. 선언
		int[][] a;
		int[] b[];
		int c[][];

		// 2. 메모리 할당
		a = new int[3][2]; // 행의 크기. 열의 크기 지정

		// 3. 초기화
		a[0][0] = 10;
		a[0][1] = 20;

		a[1][0] = 30;
		a[1][1] = 40;

		a[2][0] = 50;
		a[2][1] = 60;

		System.out.println(a[1][1]);

		System.out.println("a 행의 크기: " + a.length); // a는 행을 참조
		System.out.println("a 열의 크기: " + a[0].length); // a[0], a[1], a[2]는 열을 참조

		// for루프로 출력해보기 => 중첩 for루프 이용
		for (int i = 0; i < a.length; i++) { // 행의 크기
			for (int j = 0; j < a[i].length; j++) { // 열의 크기
				System.out.print(a[i][j] + ", ");
			}
			System.out.println();
		}
		// 1)+2)+3)
		byte[] data[] = { { -5, -9 }, { 10 }, { 0, 120, -128 } };
		// 3행 열은 가변적
		// for루프로 data에 저장된 값을 각각 출력하고, 합계값,평균값 출력
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println("############");
		// for each루프 출력
		for (byte[] val : data) {
			for (byte v : val) {
				System.out.print(v + ", ");
			}
			System.out.println();
		}

		String str[][] = { { "A", "B", "C", "D" }, { "E", "F", "G", "H" } };
		for (String[] row : str) {
			for (String val : row) {
				System.out.print(val.toLowerCase() + " ");
			}
			System.out.println();
		}

		// 행의 크기만 먼저 잡아놓고, 나중에 열의 크기를 할당하는 방법
		String[] arr[] = new String[3][];

		arr[0] = new String[2]; // 2열
		arr[1] = new String[3]; // 3열
		arr[2] = new String[1]; // 1열

		arr[0][0] = "HTML";
		arr[1][1] = "CSS";

		arr[1][0] = "JavaScript";
		arr[1][1] = "Java";
		arr[1][2] = "SQL";

		arr[2][0] = "Jsp";

		for (String[] val : arr) {
			for (String s : val) {
				System.out.print(s.toLowerCase() + ", ");
			}
		}

	}
}
