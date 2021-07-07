import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String[] strArr = {"가위", "바위", "보" };
		System.out.println(Arrays.toString(strArr));
		
		for (int i = 0; i < 10; i++) {
			int tmp = (int)(Math.random()*3);
			System.out.println(strArr[tmp]);
		}
	}

}
