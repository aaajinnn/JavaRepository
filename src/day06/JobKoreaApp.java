package day06;

public class JobKoreaApp {

	public static void main(String[] args) {
		// JobSeeker객체 1개 생성해서 속성값을 각각 부여한 뒤
		// profile()메서드를 호출해 정보를 출력하세요
		JobSeeker js1 = new JobSeeker();
//		js1.name = "홍길동";
		js1.setName("홍길동");
//		js1.birth = 1994;
		js1.setBirth(1994);
//		js1.phone = "010-2222-3333";
		js1.setPhone("010-2222-3333");
//		js1.gender = 'M';
		js1.setGender('M');

		String str = js1.profile();
		System.out.println(str);

		// [1] 구직자 객체를 1개 더 생성하고 속성값 부여하고 프로필출력
		JobSeeker js2 = new JobSeeker();
		js2.setName("김영희");
		js2.setBirth(1992);
		js2.setPhone("010-3333-4444");
		js2.setGender('F');
		String str2 = js2.profile();
		System.out.println(str2);

		// [2] 위에서 생성한 구직자 객체 2개를 배열에 저장한 뒤
		// 반복문 이용해서 구직자 정보를 모두 출력
		JobSeeker[] arr = new JobSeeker[2];
		arr[0] = js1;
		arr[1] = js2;
		System.out.println("************************");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].profile());
		}
		System.out.println("########################");
		// for-each
		for (JobSeeker seeker : arr) {
//			System.out.println(seeker.profile());
			System.out.println(seeker.getName());
		}
	}

}
