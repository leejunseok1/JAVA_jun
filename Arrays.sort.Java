import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// N을 입력받아 해당 크기의 배열을 선언한 뒤 arr 배열 원소에 각각 입력받은 값을 넣습니다.
		int []arr = new int[n]; 		
		for (int i = 0; i < arr.length; i++) {  
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); //배열에 저장된 원소 값을 오름차순으로 정렬해주는 메소드입니다.
		System.out.println(arr[0] + " "+ arr[n-1]); //최솟값은 배열의 첫번째 원소(index 0)에, 최댓값은 배열의 마지막 원소(arr.length-1)에 있으니 출력하면됩니다.
	}

}
