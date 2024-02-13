package day12_review;

// 자바의 정석_네트워킹
import java.net.*;
import java.util.*;

public class NetworkEx1 {
	public static void main(String[] args) {
		// InetAddress : IP주소를 다루기 위한 클래스
		InetAddress ip = null;
		InetAddress[] ipArr = null;

		try {
			ip = InetAddress.getByName("www.naver.com"); // 도메인명을 통해 IP주소를 얻는다.
			System.out.println("ip.getHostName() : " + ip.getHostName()); // 호스트의 이름을 반환
			System.out.println("ip.getHostAddress() : " + ip.getHostAddress()); // 호스트의 IP주소를 반환
			System.out.println("ip.toString() : " + ip.toString());

			byte[] ipAddr = ip.getAddress(); // IP주소를 byte 배열로 반환
			System.out.println("getAddress() : " + Arrays.toString(ipAddr)); // [-33, -126, -56, 107]

			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			System.out.println("getAddress() + 256 : " + result); // 223.130.200.107.
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			ip = InetAddress.getLocalHost(); // 지역호스트의 IP주소 봔환(내 IP)
			System.out.println("ip.getHostName() : " + ip.getHostName());
			System.out.println("ip.getHostAddress() : " + ip.getHostAddress());
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			ipArr = InetAddress.getAllByName("www.naver.com"); // 도메인명에 지정된 모든 호스트의 IP주소를 배열에 담아 반환
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println("ipArr[" + i + "] : " + ipArr[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
