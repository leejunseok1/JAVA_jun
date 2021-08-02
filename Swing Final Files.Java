import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TFiles {
	private final String INFOR = "information.txt";
	// INFOR의 변수에 information.txt 선언
	
	void save(String name, String password, String phoneNumber) {
		//name, password, phoneNumber 순서대로 파일에 입력
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(INFOR, true));
			pw.print(name + ",");
			pw.print(password+ ",");
			pw.println(phoneNumber);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
	public List<String> load() {
		BufferedReader br = null;
		List<String> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(INFOR));
			
			String line;
			while((line = br.readLine()) != null) { // 한줄씩 읽어줌, null 값이 안될때
				list.add(line); // 줄마다 읽어준것을 추가
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public List<String> searchbye(String line) {
		BufferedReader br = null;
		List<String> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(INFOR));
			String bye;
			while((bye = br.readLine()) != null) {
				if(line.equals(bye)) {
				}else
					list.add(bye);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void infsave(List<String> list) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(INFOR));
			for (int i = 0; i < list.size(); i++) {
				String[] getInf = list.get(i).split(",");
				String getId = getInf[0];
				String getPw = getInf[1];
				String getPn = getInf[2];
				pw.print(getId + ",");
				pw.print(getPw + ",");
				pw.println(getPn);
			}
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
	
//	public List<String> delete() {
//		BufferedReader br = null;
//		List<String> list = new ArrayList<>();
//		try {
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(INFOR)));
//			String line;
//			if((line = br.readLine()) != null) {
//				list.add(line);
//			}
//		} catch (Exception e) {
//			
//		}
//	}
	
}
