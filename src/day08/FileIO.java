package day08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

// 파일을 읽어서 콘솔에 출력해보자
// D:\multicampus\java-workspace\JavaBasic\src\day07\Superman.java
// src/day01/HelloWorld.java

//FileInputStream(1byte) 또는 FileReader(2byte-char) : 파일을 읽기 위한 클래스
//FileOutputStream(1byte) 또는 FileWriter(2byte-char) : 파일에 쓰기 위한 클래스
//FileReader 를 이용해 파일을 읽어보자.
public class FileIO {

	public static void main(String[] args) {
		String fileName = JOptionPane.showInputDialog("읽을 파일명을 입력하세요.");
		if (fileName == null)
			return;
		System.out.println("파일명 : " + fileName);
		String content = reading(fileName); // 파일 내용 반환
		System.out.println(content);
	}

	// 파일을 읽어서 문자열로 돌려주는 메서드
	public static String reading(String fileName) {
		String str = "";
		FileReader fr = null;
		char[] data = new char[1000]; // 파일내용을 담을 배열

		try {
			// 읽을 파일과 노드 연결
			fr = new FileReader(fileName); // FileNotFoundException이 발생됨

			int n = 0;
			while ((n = fr.read(data)) != -1) { // 파일 끝에 도달하면 -1을 반환
				// 파일 내용은 data배열에 담긴다
				String content = new String(data, 0, n);
				str += content;
			}

			// 중요한 코드
			if (fr != null) {
				fr.close();
			}
		} catch (FileNotFoundException e) {
			str = fileName + "이란 파일은 없습니다.";
		} catch (IOException e) {
			str = "파일을 읽는 중 에러 발생 : " + e.getMessage();
		}
		return str;
	}
}
