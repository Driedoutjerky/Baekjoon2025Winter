import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputNum = (long) Integer.parseInt(scanner.nextLine());
        long count = 0;
        long degree = 3;
        long temp = 0;
        
        if (inputNum < 3) {
            count = 0; 
        } else {
            for(int i=1;i<inputNum-1;i++) {
                temp+=i;
                count+=temp;
            }
        }

        // for 문 2개 이상 쓰면 시간 초과 됨
        
        System.out.println(count);
        System.out.println(degree);
    }
    

}
