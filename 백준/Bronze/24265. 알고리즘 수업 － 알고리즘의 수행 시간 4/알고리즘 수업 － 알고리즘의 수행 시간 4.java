import java.util.*;

public class Main {
	public static void main(String [] args) {
		long inputNum = 0;
		long count = 0; // 실행 횟수
		long degree = 2; // Time Complexity
		Scanner scanner = new Scanner(System.in);
		
		inputNum = (long) Integer.parseInt(scanner.nextLine());

		// 이거 팩토리얼 실행횟수
		
		if (inputNum != 0) {
			for (int i=1;i<inputNum;i++) {
				count += i;
			} 
		}
		
		System.out.println(count);
		System.out.println(degree);
	}

}
