package day07;
/*생성자 오버로드
 * - 메서드 이름 동일하게
 * - 매개변수의 자료형,갯수, 순서를 다르게
 * - 반환타입은 같아도 되고 달라도 되고
 * */
public class Superman {
	String name;//이름
	int height;//키
	int power;//초능력
	//this() : 생성자 안에서 첫번째 라인에서 호출 가능. 다른 생성자를 부르는 일종의 메서드. 
	public Superman() {//기본 생성자
		this("슈퍼맨",155,100);
		
	}//--------------------
	public Superman(String name) {//인자 생성자 => 생성자 오버로딩(다중정의)
		this(name,160,200);

	}//------------------------
	//이름, 키
	public Superman(String name, int height) {
		this(name,height,300);
		//System.out.println("생성자 호출됨...");

	}//--------------------------
	//이름,키, 초능력
	public Superman(String n, int h, int p) {//target		
		name=n;
		height=h;
		power=p;
	}//--------------------------
	
	public void showInfo() {
		//this("aa",1,2);[x] 생성자 안에서 호출 가능
		System.out.println("이름: "+name);
		System.out.println("키 : "+height);
		System.out.println("초능력: "+power);
	}

}//////////////////////////////2
