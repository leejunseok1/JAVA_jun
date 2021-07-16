import java.util.Scanner;

public class Main_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] res = new int[10];
		int A = 150;
		int B = 266;
		int C = 427;
		
		int D = A*B*C;
		System.out.println(D);
		String E = D+ "";
		System.out.println(E);
		
		for (int i = 0; i < E.length(); i++) {
			int tmp = Integer.parseInt(E.substring(i,i+1));
			res[tmp]++;
		}
		for (int i : res) {
			System.out.println(i);
		}
	}

}
