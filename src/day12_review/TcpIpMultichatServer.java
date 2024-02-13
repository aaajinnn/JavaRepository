package day12_review;
//자바의 정석_TCP소켓 프로그래밍

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
	HashMap clients;

	TcpIpMultichatServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	}

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버소켓을 생성하여 7777번 포트와 결합시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");

			while (true) {
				// 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// start

	void SendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// sendToAll

	public static void main(String[] args) {
		new TcpIpMultichatServer().start();
	}// main

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				SendToAll("#" + name + "님이 들어오셨습니다.");

				clients.put(name, out);
				System.out.println("현재 서버 접속자수는 " + clients.size() + "명 입니다.");

				while (in != null) {
					SendToAll(in.readUTF());
				}
			} catch (IOException e) {
				// ignore
			} finally {
				// 반드시 한번은 수행
				SendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버 접속자수는 " + clients.size() + "명 입니다.");

			}
		}
	}// ServerReceiver Thread

}
