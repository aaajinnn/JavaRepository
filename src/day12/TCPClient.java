package day12;
//Ex02-1

import java.net.*;
import java.io.*;

/* 클라이언트 단
 * Socket 필요 => 서버 ip주소, port번호
 * */
public class TCPClient {

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) { // 클라이언트 10명이 접속했다고 가정
			Socket sock = new Socket("192.168.35.209", 9100); // 127.0.0.1 : localhost
			System.out.println("클라이언트 " + i + " : 서버에 접속되었음!!");
		}
	}

}
