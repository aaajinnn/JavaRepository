package day09_review;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MyDiarySubFrame extends JFrame {

	Container cp;
	private JTextField textField_fileName;
	private JTextField textField_title;
	private JTextArea textArea_content;

	public MyDiarySubFrame() {
		super("::나의 일기장::");
		setBackground(SystemColor.activeCaption);
		cp = this.getContentPane();

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField_fileName = new JTextField(); // 파일명
		textField_fileName.setBounds(36, 30, 293, 44);
		panel.add(textField_fileName);
		textField_fileName.setColumns(10);
		textField_fileName.setBorder(new TitledBorder("파일명(yyyymmdd)"));

		textField_title = new JTextField(); // 제목
		textField_title.setColumns(10);
		textField_title.setBounds(36, 104, 293, 44);
		panel.add(textField_title);
		textField_title.setBorder(new TitledBorder("제 목"));

		textArea_content = new JTextArea(); // 내용
		textArea_content.setBounds(36, 182, 293, 275);
		panel.add(textArea_content);
		textArea_content.setBorder(new TitledBorder("일기 내용"));

		JButton btnNewButton = new JButton("저장");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeFile();
			}
		});
		btnNewButton.setBounds(50, 503, 97, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("가져오기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readFile();
			}
		});
		btnNewButton_1.setBounds(204, 503, 97, 23);
		panel.add(btnNewButton_1);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로세스 종료
	}

	// 가져오기
	public void readFile() {
		// 1. JFileChooser를 열기 모드로 띄우자
		JFileChooser jfc = new JFileChooser("D:/multicampus"); // JFileChooser("띄울 폴더명");
		int n = jfc.showOpenDialog(cp); // 띄울 곳
		setTitle("n : " + n);// 열기 : 0. 취소 : 1
		if (n == 1)
			return; // 취소시 되돌아감
		// 2. JFileChooser에서 선택한 파일명의 절대경로 얻어오기
		File file = jfc.getSelectedFile(); // 선택한 파일
		String path = file.getAbsolutePath(); // 선택한 파일의 절대경로
		System.out.println("path : " + path);

		// 3. FileReader생성 => 파일과 노드 연결
		try {
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
			// 6. textArea_content에 읽은 내용 셋팅
			textField_fileName.setText(file.getName());
			textArea_content.setText(str);

			// 7. close()
			if (fr != null) {
				fr.close();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(cp, "파일 읽기 중 에러" + e.getMessage());
			e.printStackTrace();
		}
	}

	// 저장
	public void writeFile() {
		// 입력한 날짜값 가져오기 ==> 파일명으로 활용 "20240205"
		String dateStr = textField_fileName.getText();
		// 입력한 제목 가져오기
		String title = textField_title.getText();
		// 입력한 일기 내용 가져오기
		String content = textArea_content.getText();
		// 유효성 체크
		if (dateStr == null || dateStr.equals("")) {
			JOptionPane.showMessageDialog(cp, "파일명을 날짜형태로 입력하세요.(ex 240205");
			textField_fileName.requestFocus();
			return;
		}
		// 파일에 쓰기 위한 스트림객체 생성 => fileWriter 활용
		String fileName = "src/day09_review/" + dateStr + ".txt";
		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write("작성일 : " + dateStr + "\n");
			fw.write("제  목 : " + title + "\n");
			fw.write("내  용 : " + content + "\n");
			fw.flush();
			// close() 호출
			if (fw != null) {
				fw.close();
				setTitle(fileName + "에 일기 작성 완료!");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(cp, "파일작성 중 에러 : " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MyDiarySubFrame sub = new MyDiarySubFrame();
		sub.setSize(400, 700);
		sub.setVisible(true);

	}

}
