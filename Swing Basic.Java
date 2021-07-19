import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {
	static final File Name_File = new File("name.txt");
	public Main() {
		JPanel mainPnl = new JPanel(); // 메인패널생성
		mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));
		// 박스 레이아웃 정렬
		
		JPanel namePnl = new JPanel(); //네임패널 생성
		JLabel nameLbl = new JLabel("이름: "); // 이름글자 생성
		JTextField nameTf = new JTextField(); // 이름 텍스트필드 생성
		nameTf.setColumns(10);
		namePnl.add(nameLbl); // 네임패널안에 라벨 생성
		namePnl.add(nameTf); // 네임패널안에 텍스트필드 생성
		mainPnl.add(namePnl); // 메인 패널안에 네임패널 생성
		
		JPanel agePnl = new JPanel(); // 나이패널 생성
		JLabel ageLbl = new JLabel("나이: "); // 나이 라벨 생성
		JTextField ageTf = new JTextField(); // 나이 텍스트 필드 생성
		ageTf.setColumns(10); 
		agePnl.add(ageLbl); // 나이패널안에 나이라벨 생성
		agePnl.add(ageTf); // 나이패널안에 텍스트 필드 생성
		mainPnl.add(agePnl); // 메인 패널안에 나이패널 생성
	
		JPanel scorePnl = new JPanel(); // 점수 패널 생성
		JLabel scoreLbl = new JLabel("학점: "); // 점수 라벨 생성
		JTextField scoreTf = new JTextField(); // 점수 텍스트필드 생성
		scoreTf.setColumns(10); 
		scorePnl.add(scoreLbl); // 점수 패널 안에 라벨 생성
		scorePnl.add(scoreTf); // 점수 패널 안에 텍스트필드 생성
		mainPnl.add(scorePnl); // 메인 패널 안에 점수패널 생성
		
		JPanel btnPnl = new JPanel(); //버튼 패널 생성
		JButton saveBtn = new JButton("저장"); // 저장 버튼 생성
		saveBtn.addActionListener(new ActionListener() { // 버튼을 눌렀을때 이벤트 발생
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTf.getText(); // 네임 텍스트 필드 현재 텍스트박스내에 문자열을 읽어오기
				String age = ageTf.getText(); // 나이 텍스트 필드 현재 텍스트박스내에 문자열을 읽어오기
				String score = scoreTf.getText(); // 점수 텍스트 필드 현재 텍스트박스내에 문자열을 읽어오기
				
				makeFile(name, age, score); // 
				
				new showStudent(name, age, score); //  showStudent 메서드 생성
				dispose(); // 닫았을때 꺼지게 하기
			}

		});
		btnPnl.add(saveBtn); // 버튼 패널 추가 
		mainPnl.add(btnPnl); // 메인 패널에 버튼 패널 추가
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(Name_File));
			// 문자기반 스트림 텍스트 파일을 프로그램으로 읽어들일 때 사용.
			// 문자 단위로 읽으므로 텍스트만 읽을 수 있다.
			
			//FileReader 객체가 생성될 떄 파일이 직접 연결되므로 파일이 존재하지않으면
			//FilenotFoundException 발생 -> try-catch문으로 예외처리 해주어야함.
			// Reader의 하위 클래스이므로 사용방법이 Reader와 동일
			String name = br.readLine(); // 변수 네임 한줄 읽어들어오기
			String age = br.readLine();
			String score = br.readLine();
			nameTf.setText(name); // 네임 텍스트박스내에 문자열 읽어오기
			ageTf.setText(age);
			scoreTf.setText(score);
			
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
		}
		
		add(mainPnl);
		
		pack();
		setLocation(650,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	private void makeFile(String name, String age, String score) {
		try {
			PrintWriter pw = new PrintWriter(Name_File);
			pw.println(name);
			pw.println(age);
			pw.println(score);
			pw.flush();
			pw.close();
		} catch(FileNotFoundException e) {// FileReader 클래스 객체를 생성할때 해주어야하는
										  // 예외처리로써 해당 경로에 파일이 없을때 발생하는 예외
		}
		
	}

	public static void main(String[] args) {
		new Main();
	}
}
class showStudent extends JFrame{
	public showStudent(String name, String age, String score) { // showStudent 메서드 생성
		JPanel mainPnl = new JPanel(); // 메인패널 생성
		mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));
		// 메인 패널에서 레이아웃매니저 설정, 박스레이아웃 Y축으로 정렬
		JPanel showNamePnl = new JPanel();
		JLabel showNameLbl = new JLabel("이름 :" + name);
		showNamePnl.add(showNameLbl); // 네임패널 안에 네임 라벨 생성
		mainPnl.add(showNamePnl); // 메인패널안에 네임패널 생성
		
		JPanel showagePnl = new JPanel();
		JLabel showageLbl = new JLabel("나이 :" + name);
		showagePnl.add(showageLbl);
		mainPnl.add(showagePnl);
		
		JPanel showscorePnl = new JPanel();
		JLabel showscoreLbl = new JLabel("학점 :" + name);
		showscorePnl.add(showscoreLbl);
		mainPnl.add(showscorePnl);
		
		add(mainPnl);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(650,350);
	}
}
