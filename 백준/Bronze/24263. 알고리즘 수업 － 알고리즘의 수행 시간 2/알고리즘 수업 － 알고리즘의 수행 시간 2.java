import java.util.*;

public class Main {
	public static void main(String [] args) {
		int inputNum = 0;
		int count = 0; // 실행 횟수
		int degree = 1; // Time Complexity
		Scanner scanner = new Scanner(System.in);
		
		inputNum = Integer.parseInt(scanner.nextLine());
		
		if (inputNum != 0) {
			count = inputNum; 
		}
		
		System.out.println(count);
		System.out.println(degree);
	}
}