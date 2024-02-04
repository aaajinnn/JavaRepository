package day02;

public class Primitive2 {
	public static void main(String[] args) {
		System.out.println("----2. 실수형(float, double)------------------");

		float ft1 = 10.123F;
		// float의 경우 부동소수점일 경우 반드시 뒤에 접미사 f, F 를 붙여준다.
		System.out.printf("ft1 = %f\n", ft1);
		System.out.printf("ft1 = %.3f\n", ft1); // 소수점 이하 3자리까지만 출력

		float ft2 = 55;
		// int값을 float타입 변수에 대입 ⇒ promotion(자동형변환) : 큰 자료유형으로 자동 형변환
		System.out.println("ft2 = " + ft2);

		float ft3 = 'A'; // char -> float
		System.out.println("ft3 = " + ft3);
		float ft4 = .879f; // 0.879f
		System.out.println("ft4 = " + ft4);

		// double (8byte) : 소수점 이하 15자리 내외
		double db1 = -741.258;
		double db2 = 4545.001D; // 접미사 d, D
		System.out.println("db1 = " + db1);
		System.out.println("db2 = " + db2);

		// 과학적 지수 표기방법 : E, e
		double db3 = 8E-2; // 8*10^-2
		double db4 = 8E+3; // 8*10^3
		System.out.println("db3 = " + db3);
		System.out.println("db4 = " + db4);

		float ft5 = 900e-7F;
		System.out.println("ft5 = " + ft5);
	}// main()---------------------
}// class()------------------------
