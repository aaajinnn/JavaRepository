package day06;

public class Overloading {

	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();
		vm.makeTea(1, 2, 3);
		System.out.println("vm.coffee : " + vm.coffee);
		System.out.println("vm.sugar : " + vm.sugar);
		System.out.println("vm.cream : " + vm.cream);
		System.out.println("***********************");
		// 1. 설탕커피 만들기
		vm.makeTea(1, 2);

		// 2. 블랙커피 만들기
		String str = vm.makeTea(1);
		System.out.println(str);

		// 3. 크림커피 만들기
		vm.makeTea(2, (short) 3);
		vm.makeTea((short) 1, 2);

		// 4. 유자차 만들기
		Yuja yj = new Yuja();
		yj.setYuja(6);
		yj.setSugar(6);
		vm.makeTea(yj);
	}

}