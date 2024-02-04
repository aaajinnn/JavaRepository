package day08;
/*예외 처리 방법
 * [1] 직접 handle하는 방법
 * 		try~ catch절을 이용
 * [2] 선언(declare)하는 방법
 * 		throws 절을 이용
 * 
 * */

public class ExeptionTest {

	public static void main(String[] args) {
		String[] fruits = { "Apple", "Grape", "Orange" };
		try {
			// 예외 발생 코드
			for (int i = 0; i <= 3; i++) {
				System.out.println(fruits[i]);
			} // for
		} catch (ArrayIndexOutOfBoundsException e) {
			// 예외 처리 코드
			System.out.println("배열 인덱스가 초과됐습니다. 확인해보세요!");
		}
		System.out.println("##반드시 실행되어야 할 코드##");
	}

}
