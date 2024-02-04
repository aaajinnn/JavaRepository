package day07.inheritance;
//Human상속받고, speed추가, showInfo()오버라이딩 하기
public class Aquaman extends Human{
	
	double speed;
	
	public Aquaman(String n, int h, double s) {
		name=n;
		height=h;
		speed=s;
	}
	//annotation
	@Override
	public void showInfo() {
		super.showInfo();//이름, 키
		System.out.println("스피드: "+speed);
	}

}///////////////////////////
