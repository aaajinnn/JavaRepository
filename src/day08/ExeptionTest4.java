package day08;

/*
 * try블럭 하나에 catch블럭을 여러 개 사용할 수 있다.
 * 이 때 주의사항. 자식 예외를 먼저 catch하고
 * 부모 예외를 나중에 catch해야 한다.
 * 
 * 발생된 예외 handle하세요
 * 
 * try{
 * 
 * }catch(  ){
 * 
 * }finally{
 * 		//반드시 한번은 수행하는 블럭이다.
 *      //위에 return문이 있더라도 반드시 finally수행하고 제어권을 넘긴다
 *      //단, 위에 System.exit()코드가 있다면 =>바로 프로그램 종료된다
 * }
 * */
import javax.swing.JOptionPane;

public class ExeptionTest4 {

	public static void main(String[] args) {
		String num1 = JOptionPane.showInputDialog("정수 1을 입력하세요.");
		String num2 = JOptionPane.showInputDialog("정수 2를 입력하세요.");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		try {
			// java.lang.Integer 클래스
			// static int parseInt(String str)
			int n1 = Integer.parseInt(num1);
			// static Integer valueOf(String str)
			int n2 = Integer.valueOf(num2); // auto unboxing
			int result = n1 / n2;
			System.out.println("result : " + result);

			String str = "null";
			System.out.println(str.toUpperCase());

		} catch (NumberFormatException e) {
			System.out.println("정수를 입력하세요.");
			System.exit(-1); // 시스템 종료
		} catch (ArithmeticException e) {
			System.out.println("0이 아닌 정수를 입력하세요.");
			return;
		} catch (Exception e) {
			String msg = e.getMessage(); // 예외 메세지를 반환
			System.out.println("기타 예상치 못한 예외 발생 : " + msg);
			e.printStackTrace();
			// 예외가 발생한 스택기록을 출력하는 메서드 => 디버그시 사용
		} finally {
			System.out.println("###반드시 실행되어야 할 중요한 코드###");
		}
		System.out.println("---The End---");
	}

}
