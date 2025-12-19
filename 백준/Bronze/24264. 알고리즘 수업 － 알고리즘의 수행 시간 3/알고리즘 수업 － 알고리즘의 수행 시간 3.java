import java.util.*;

public class Main {
	public static void main(String [] args) {
		long inputNum = 0;
		long count = 1; // 실행 횟수
		long degree = 2; // Time Complexity
		Scanner scanner = new Scanner(System.in);
		
		inputNum = (long) Integer.parseInt(scanner.nextLine());
		
		if (inputNum != 0) {
			for (int i=0;i<degree;i++) {
				count = count*inputNum; 
			} 
		}
		
		System.out.println(count);
		System.out.println(degree);
	}
}