package day11_review;

interface Repairable {
}

class Unit {
	int hitPoint;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit {

	GroundUnit(int hp) {
		super(hp);
	}

}

class AirUnit extends Unit {

	AirUnit(int hp) {
		super(hp);
	}

}

class Tank extends GroundUnit implements Repairable {

	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "tank";
	}
}

class DropShip extends AirUnit implements Repairable {

	DropShip() {
		super(150);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "dripship";
	}

}

class Marine extends GroundUnit {

	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}

}

class SCV extends GroundUnit implements Repairable {

	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		Unit u = (Unit) r;
		while (u.hitPoint != u.MAX_HP) {
			// Unit의 HP를 증가시킨다.
			u.hitPoint++;
		}
		System.out.println(u.toString() + "의 수리가 끝났습니다.");
	}

}

class Interface_RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		DropShip dropship = new DropShip();
		Marine marine = new Marine();
		SCV scv = new SCV();

		scv.repair(tank);
		scv.repair(dropship);
//		scv.repair(marine); // Repariable 인터페이스를 구현하지 않아서 에러

	}
}
