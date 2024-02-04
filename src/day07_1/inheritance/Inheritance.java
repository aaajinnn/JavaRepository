package day07_1.inheritance;

public class Inheritance {

	public static void main(String[] args) {
		// 1.Human객체 생성해서, 이름,키 값을 할당하고 showInfo() 호출
		Human human = new Human();
		human.name = "흥부";
		human.height = 159;
		human.showInfo();
		System.out.println("-----------------");
		// 2. Superman객체 생성해서, 이름,키,초능력 값을 할당하고 showInfo() 호출
		Superman sm = new Superman();
		sm.showInfo(); // 기본생성자 호출

		Superman sm2 = new Superman("제비", 150, 200);
		sm2.showInfo();

		System.out.println("------------------");
		Aquaman a1 = new Aquaman("아쿠아맨", 180, 400.33);
		a1.showInfo();

		sm.showInfo("###슈퍼맨 정보###");
		sm2.showInfo("@@@슈퍼맨 정보@@@");

		String str = sm2.showInfo("***울트라 슈퍼맨***", 500);
		System.out.println(str);

		// 상속관계를 맺으면

		// 부모타입의 변수 선언 = new 자식객체(); 가능함
		Human hs = new Superman("김초롱", 157, 850);

		// 이때 이 참조변수로 접근할 수 있는 변수나 메서드는 제한이 있다.

		// [1] 부모가 물려준 변수,메서드는 접근 가능
		System.out.println("hs.name : " + hs.name);
		System.out.println("hs.height : " + hs.height);

		// [2] 그러나 오버라이드한 메서드가 있을 경우에는 자식의 오버라이드한 메서드를 적용한다
		hs.showInfo(); // 오버라이딩한 메서드를 우선 적용
		// [3] 자식만이 갖는 고유한 변수나 메서드는 접근 할 수 없다.
		// System.out.println("hs.power : "+hs.power); // [x]

		// 부모 > 자식 , 강제형변환하면 사용할 수 있다.
		System.out.println("((Superman)hs).power : " + ((Superman) hs).power);

//		hs.showInfo("***슈퍼맨 정보***"); //overload [X]
		((Superman) hs).showInfo("***슈퍼맨 정보***");

		System.out.println("------------------");
		// Human타입의 변수 선언하고 Aquaman객체를 생성해서 name,height,speed, showInfo() 호출
		Human hs2 = new Aquaman("아쿠아", 160, 44.3);
		System.out.println(hs2.name);
		System.out.println(hs2.height);
		System.out.println(((Aquaman) hs2).speed);
		hs2.showInfo();

		System.out.println("---반복문 사용하여 출력해보기---");
		// human,sm,a1,hs,hs2 객체들을 저장할 배열을 생성하고 저장하세요
		Human[] hero = { human, sm, a1, hs, hs2 };
		// 그런 뒤 반목문 이용해서 배열에 저장된 객체들의 showInfo()를 호출하세요
		for (Human arr : hero) {
			arr.showInfo();
			System.out.println("##########");
		}
	}

}
