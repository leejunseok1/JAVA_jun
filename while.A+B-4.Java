import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; // 문자열 분리
		String str;
		
		while((str = br.readLine())!= null ) { // 한행을 전부 읽음, 공백단위로 입력해준 문자열을 공백단위로
			                                     // 분리해주어야함.
			st = new StringTokenizer(str, " ");
			int A = Integer.parseInt(st.nextToken()); // 인트로 형변환
			int B = Integer.parseInt(st.nextToken()); // 문자열 반환
			sb.append(A+B).append("\n");
		}
		System.out.println(sb);
		
	}

}
