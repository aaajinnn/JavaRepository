package day09;
// Ex04

import java.util.Scanner;
import java.io.*;

//FileInputStream(1byte) ==> read(byte[] data)
//FileOutputStream(1byte) ==> write(byte[] data, int off, int len)
public class FileCopy {

	// src파일을 읽어서 dest파일로 내보내기
	public static void imageCopy(String src, String dest) throws IOException {
		// 1. 노드 연결
		FileInputStream fis = new FileInputStream(src); // FileNotFoundException예외 발생
		FileOutputStream fos = new FileOutputStream(dest); // FileNotFoundException예외 발생

		byte[] data = new byte[1024]; // 1KB => 파일 데이터를 담을 배열
		int n = 0; // 읽은 바이트 수
		int total = 0; // 읽은 바이트 수 누적 => 파일 크기

		while ((n = fis.read(data)) != -1) { // IOException 예외 발생
			// read(data) => data가 배열에 담기고, n은 읽은 바이트 수가 됨
			fos.write(data, 0, n);// 남는 바이트를 배열 0에서부터 남는 바이트까지 내보내기
			fos.flush();
			// System.out.println("n(읽은 바이트 수) :" + n);
			total += n; // 파일 크기
		}
		System.out.println(total + "bytes 카피 완료!!");

		if (fis != null)
			fis.close(); // IOException 예외 발생
		if (fos != null)
			fos.close(); // IOException 예외 발생
	}

	public static void main(String[] args) {
		// 원본파일 : C:\Users\USER\Pictures\Saved Pictures\img3.jpg
		// 목적파일 : src/day09/copy.jpg
		Scanner sc = new Scanner(System.in);
		System.out.println("원본 파일명 입력 : ");
		String file1 = sc.nextLine();

		System.out.println("목적 파일명 입력 : ");
		String file2 = sc.nextLine();

		System.out.println(file1 + "파일을 " + file2 + "로 카피합니다.");

		try {
			FileCopy.imageCopy(file1, file2);
			System.out.println("파일 카피 완료!!");
		} catch (IOException e) {
			System.out.println("파일 카피 중 에러 : " + e.getMessage());
		}
	}

}
