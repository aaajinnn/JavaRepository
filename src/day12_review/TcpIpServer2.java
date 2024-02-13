package day12_review;
// 자바의 정석_TCP소켓 프로그래밍

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TcpIpServer2 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버소켓을 생성하여 7777번 포트와 결합시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
//			System.out.println(getTime() + "연결요청을 기다립니다.");
			// 요청대기시간을 5초로 설정한다.
			// 5초동안 접속요청이 없으면 SocketTimeoutException이 발생한다.
//			serverSocket.setSoTimeout(5 * 1000);

			// 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
			// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
			socket = serverSocket.accept();
//			System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

			// ---------------------------------------------
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();

			// ---------------------------------------------
//		} catch (SocketTimeoutException e) {
//			System.out.println("지정된 시간동안 접속요청이 없어서 서버를 종료합니다.");
//			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

//	static String getTime() {
//		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
//		return f.format(new Date());
//	}

class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;

	Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (out != null) {
			try {
				out.writeUTF(name + scanner.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}// Sender class

class Receiver extends Thread {
	Socket socket;
	DataInputStream in;

	Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (in != null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
} // Receiver class
