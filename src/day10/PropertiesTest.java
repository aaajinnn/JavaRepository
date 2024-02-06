package day10;

//Ex05
import java.util.*;
import java.io.*;

/*Map계열
 * Properties
 * xxx.properties 유형의 파일을 읽어서 해당 파일에 저장된 내용을 자바로
 * 옮기고자 할 때 사용한다.
 * 
 * */
public class PropertiesTest {

	public static void main(String[] args) throws IOException { // 예외가 발생하기때문에 예외처리 해놓고 시작
		Properties prop = new Properties();
		prop.setProperty("OS", "Windows"); // key, value 쌍으로 저장
		prop.setProperty("Lang", "Java");
		System.out.println("사용하는 운영체제 : " + prop.getProperty("OS"));
		System.out.println("사용하는 언    어 : " + prop.getProperty("Lang"));
		System.out.println(prop);
		System.out.println("---------------------------------");

		// properties파일을 읽어와서 prop에 옮겨보자(FileInputStream 사용)
		// 파일과 노드 연결
		FileInputStream fis = new FileInputStream("src/day10/database.properties");
		prop.load(fis);
		// load() : xxx.properties파일을 읽어서 Properties객체로 옮겨 놓는다.
		fis.close();
		System.out.println(prop);

		// properties의 키값 가져와서 출력해보기
		// (이미 옮겨놓았기 때문에 getProperty 혹은 get으로 가져온다.)
		System.out.println(prop.getProperty("DbUser"));
		System.out.println(prop.get("DbPwd"));
		// 만약 없는 값을 부른다면?
		System.out.println(prop.getProperty("WAS")); // null값이 나온다.
		// null값이 나오지 않고 싶다면?
		System.out.println(prop.getProperty("WAS", "Tomcat(디폴드값)")); // 디폴트값을 넣어준다.

	}

}
