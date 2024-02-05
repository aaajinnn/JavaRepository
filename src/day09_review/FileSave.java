package day09_review;

//Ex03
import java.io.*;
import java.util.Scanner;

public class FileSave {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장할 파일명을 입력하세요=>");
		String fileName = sc.nextLine();
		System.out.println("저장할 내용을 입력하세요=>");
		String content = sc.nextLine();

		try {
			// 1.파일과 노드 연결
			FileWriter fw = new FileWriter(fileName, true);
			// 2. FileWriter의 write() 메서드 호출
			fw.write(content + "\n");
			fw.flush(); // 데이터가 남아있으면 밀어내기
			// 3. 파일과 노드 연결 닫기
			if (fw != null) {
				fw.close();
			}
			System.out.println(fileName + "에 작성 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
