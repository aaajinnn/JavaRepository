package day09;
// EX06

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MyDiarySubFrame extends JFrame {

	Container cp;
	private JTextField tfDate;
	private JTextField tfTitle;
	private JTextArea ta;

	public MyDiarySubFrame() {
		super(":::MyDiarySubFrame:::");
		cp = this.getContentPane();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tfDate = new JTextField();
		tfDate.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		tfDate.setBounds(57, 29, 273, 52);
		panel.add(tfDate);
		tfDate.setColumns(10);
		tfDate.setBorder(new TitledBorder("::파일명(yyyymmdd)::"));

		tfTitle = new JTextField();
		tfTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		tfTitle.setColumns(10);
		tfTitle.setBounds(57, 107, 273, 52);
		panel.add(tfTitle);
		tfTitle.setBorder(new TitledBorder("::제   목::"));

		ta = new JTextArea();
		ta.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		ta.setBounds(57, 185, 279, 280);
//		panel.add(new JScrollPane(ta)); // JScrollPane : 스크롤바 생성
		ta.setBorder(new TitledBorder("::일기 내용::"));

		JButton btnNewButton = new JButton("파일에 저장");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeFile();
			}
		});
		btnNewButton.setBounds(64, 494, 130, 40);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("일기 가져오기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readFile();
			}
		});
		btnNewButton_1.setBounds(210, 494, 130, 40);
		panel.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setBounds(57, 185, 279, 280);
		panel.add(scrollPane);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로세스 종료
	}// 생성자---------------

	public void readFile() {
		try {
			// 1. JFileChooser를 열기 모드로 띄우자
			JFileChooser jfc = new JFileChooser("D:/multicampus");
			int n = jfc.showOpenDialog(cp);
			setTitle("n :" + n); // 열기 : 0. 취소 : 1
			if (n == 1)
				return; // 취소시

			// 2. JFileChooser에서 선택한 파일명의 절대경로 얻어오기
			File file = jfc.getSelectedFile();
			String path = file.getAbsolutePath(); // 절대경로
			System.out.println("path : " + path);

			// 3. FileReader생성 => 파일과 노드 연결
			FileReader fr = new FileReader(path);

			// 4. 배열 준비
			char[] data = new char[2000];

			// 5. 반복문 이용해서 파일 데이터를 읽어들임 => 문자열 변수에 누적
			int k = 0;
			String str = "";
			while ((k = fr.read(data)) != -1) {
				String content = new String(data, 0, k);
				str += content;
			}

			// 6. ta에 읽은 내용 셋팅
			tfDate.setText(file.getName());
			ta.setText(str);

			// 7. close()
			if (fr != null)
				fr.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(cp, "파일 읽기 중 에러" + e.getMessage());
		}
	}

	public void writeFile() {
		// 날짜값 가져오기 ==> 파일명으로 활용 "20240205"
		String dateStr = tfDate.getText();

		// 제목 가져오기
		String title = tfTitle.getText();

		// 일기 내용 가져오기
		String content = ta.getText();
		// 유효성 체크
		if (dateStr == null || dateStr.equals("")) {
			JOptionPane.showMessageDialog(cp, "파일명을 날짜형태로 입력하세요(ex 20240205)");
			tfDate.requestFocus();
			return;
		}

		String fileName = "src/day09/" + dateStr + ".txt"; // 파일명 만들기
		// 파일에 쓰기 위한 스트림객체 생성 => fileWriter 활용
		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write("작성일 : " + dateStr + "\n");
			fw.write("제  목 : " + title + "\n\n");
			fw.write("내  용 : \n" + content + "\n");
			fw.flush();
			// 파일에 쓰기
			// 작성일 : 20240205
			// 제목 : 오늘의 일기
			// 일기내용 : 어쩌구 저쩌구..

			// close() 호출
			if (fw != null)
				fw.close();
			setTitle(fileName + "에 일기쓰기 완료");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(cp, "파일 쓰기 중 에러 : " + e.getMessage());
		}

	}
}// class //////////////////////
