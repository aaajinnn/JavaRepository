package day10;
// Ex07-1

import java.util.ArrayList;
import java.util.List;

public class AbstractClassTest {

	public static void main(String[] args) {
		System.out.println("여러 도형의 면적을 구해봅시다.");
		System.out.printf("---가로 : %d, 세로 : %d인 도형 면적----\n", 12, 10);

		// 사각형 객체 생성해서 area()
		Rectangle rectangle = new Rectangle();
		rectangle.area(12, 10);

		// 직삼각형 객체 생성해서 area()
		Triangle triangle = new Triangle();
		triangle.area(12, 10);

		// 원 객체 생성해서 area()
//		Circle circle = new Circle(); // [X] 추상클래스는 타입 선언은 할 수 있으나 객체 생성(new)은 할 수없다.
		// 추상클래스 선언의 경우는
		Circle circle = new SubCircle(); // [o]
		SubCircle circle2 = new SubCircle();// [o]
//		circle.area(12);  // [x] 부모로부터 물려받은 고유한 메서드, 즉 자식이 만들어놓은 메서드나 변수는 불러오지 못한다.
		((SubCircle) circle).area(12); // 강제형변환해서 출력 가능하다.
		circle2.area(12); // [o]
		// Shape의 경우에도 상속받은 자식메서드의 객체 생성은 할 수 있다.
//		Shape sp = new Shape(); // [x]
		Shape sp = new Rectangle();
		sp.area(8, 10);

		// rectangle, triangle, circle, circle2 ,sp 을 저장할 배열을 생성하고
		// 저장한 후 반복문 돌려서 각 도형의 면적 출력하기
		// 가로:20, 세로 : 30
		// 반지름: 20
		Shape[] shapes = new Shape[5];
		shapes[0] = rectangle;
		shapes[1] = triangle;
		shapes[2] = circle;
		shapes[3] = circle2;
		shapes[4] = sp;

		for (Shape obj : shapes) {
			System.out.println("-------------------");
			if (obj instanceof SubCircle) { // 원의 면적
				((SubCircle) obj).area(20);
				continue;
			}
			obj.area(20, 30);
		}

		// ArrayList 저장
		List<Shape> list = new ArrayList<>();
		list.add(rectangle);
		list.add(triangle);
		list.add(circle);
		System.out.println(list);

	}

}
