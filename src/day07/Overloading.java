package day07;

public class Overloading {

	public static void main(String[] args) {
		Superman s1=new Superman();
		s1.showInfo();
		
		Superman s2=new Superman("이철수");
		s2.showInfo();

		Superman s3=new Superman("강호동",180);
		s3.showInfo();
		
		Superman s4=new Superman("손흥민",188,500);
		s4.showInfo();
		System.out.println("------------------");
		//Aquaman a1=new Aquaman();//[x]
		Aquaman a1=new Aquaman("인어공주",166,123.456);
		a1.showInfo();
		
		Aquaman a2=new Aquaman("고등어",70);
		a2.showInfo();
		
		//s1,s2,s3,s4를 저장할 배열을 생성하고 저장하세요
		Superman[] arr= {s1,s2,s3,s4};
		
		//반복문 이용해서 슈퍼맨 정보를 출력하기
		for(Superman man:arr) {
			//System.out.println(man);//toString()
			System.out.println("******");
			man.showInfo(); 
		}
		
		
	}

}








