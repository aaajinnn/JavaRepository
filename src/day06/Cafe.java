package day06;

public class Cafe {

	public static void main(String[] args) {
		// 커피머신 생성해서 coffee,sugar,cream 값을 설정하고
		CoffeeMachine cm = new CoffeeMachine();
//		cm.coffee = 1;
		cm.setCoffee(1);
//		cm.sugar = 2;
		cm.setSugar((short) 2);
//		cm.cream = 3.5f;
		cm.setCream(3.5f);

		// 각각 출력하기
		int coffee = cm.getCoffee();
		System.out.println("cm.coffee : " + coffee); // cm.coffee);
		System.out.println("cm.sugar : " + cm.getSugar()); // cm.sugar);
		System.out.println("cm.cream : " + cm.getCream()); // cm.cream);
	}

}
