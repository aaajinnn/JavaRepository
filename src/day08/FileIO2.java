package day08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

//FileInputStream(1byte) 또는 FileReader(2byte-char) : 파일을 읽기 위한 클래스
//FileOutputStream(1byte) 또는 FileWriter(2byte-char) : 파일에 쓰기 위한 클래스
//FileReader 를 이용해 파일을 읽어보자.
public class FileIO2 {

	public static void main(String[] args) throws IOException {
		String fileName = JOptionPane.showInputDialog("읽을 파일명을 입력하세요.");
		if (fileName == null)
			return;
		System.out.println("파일명 : " + fileName);
		String content = reading(fileName); // 파일 내용 반환
		System.out.println(content);
	}

	// 발생한 예외를 throws로 선언 해보자
	public static String reading(String fileName) throws FileNotFoundException, IOException {
		String str = "";
		FileReader fr = null;
		char[] data = new char[1000]; // 파일내용을 담을 배열

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
			fr.close(); // IOException 발생
		}

		return str;
	}
}
