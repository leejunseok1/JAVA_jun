import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class test555 extends JFrame{
	static final File Name_File = new File("name.txt");
	public test555() {
		JPanel mainPnl = new JPanel();
		mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));
		
		JPanel namePnl = new JPanel();
		JLabel nameLbl = new JLabel("이름 : ");
		JTextField nameTf = new JTextField();
		nameTf.setColumns(10);
		namePnl.add(nameLbl);
		namePnl.add(nameTf);
		mainPnl.add(namePnl);
		
		JPanel agePnl = new JPanel();
		JLabel ageLbl = new JLabel("나이 : ");
		JTextField ageTf = new JTextField();
		ageTf.setColumns(10);
		agePnl.add(ageLbl);
		agePnl.add(ageTf);
		mainPnl.add(agePnl);
		
		JPanel scorePnl = new JPanel();
		JLabel scoreLbl = new JLabel("학점 : ");
		JTextField scoreTf = new JTextField();
		scoreTf.setColumns(10);
		scorePnl.add(scoreLbl);
		scorePnl.add(scoreTf);
		mainPnl.add(scorePnl);
		
		JPanel btnPnl = new JPanel();
		JButton saveBtn = new JButton("저장");
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTf.getText();
				String age = ageTf.getText();
				String score = scoreTf.getText();
				
				makeFile(name, age, score);
				
				new showStudent(name, age, score);
				dispose();
			}

		});
		btnPnl.add(saveBtn);
		mainPnl.add(btnPnl);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(Name_File));
			String name = br.readLine();
			String age = br.readLine();
			String score = br.readLine();
			nameTf.setText(name);
			ageTf.setText(age);
			scoreTf.setText(score);
		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
		}
		
		add(mainPnl);
		
		pack();
		setLocation(650, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private static void makeFile(String name, String age, String score) {
		try {
			PrintWriter pw = new PrintWriter(Name_File);
			pw.println(name);
			pw.println(age);
			pw.println(score);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	public static void main(String[] args) {
		new test555();
	}

}

class showStudent extends JFrame{
	public showStudent(String name, String age, String score) {
		JPanel mainPnl = new JPanel();
		mainPnl.setLayout(new BoxLayout(mainPnl, BoxLayout.Y_AXIS));
		
		JPanel showNamePnl = new JPanel();
		JLabel showNameLbl = new JLabel("이름 : " + name);
		showNamePnl.add(showNameLbl);
		mainPnl.add(showNamePnl);
		
		JPanel showAgePnl = new JPanel();
		JLabel showAgeLbl = new JLabel("나이 : " + age);
		showAgePnl.add(showAgeLbl);
		mainPnl.add(showAgePnl);
		
		JPanel showScorePnl = new JPanel();
		JLabel showScoreLbl = new JLabel("학점 : " + score);
		showScorePnl.add(showScoreLbl);
		mainPnl.add(showScorePnl);
		
		add(mainPnl);
		
		pack();
		setLocation(650, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
