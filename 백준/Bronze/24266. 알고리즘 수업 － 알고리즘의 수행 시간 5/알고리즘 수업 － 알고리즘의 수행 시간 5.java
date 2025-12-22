import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputNum = (long) Integer.parseInt(scanner.nextLine());
        long count = 0;
        long degree = 3;
    
        for(int i=0;i<degree+1;i++) {
            count = count * inputNum;
            if(count==0) {
                count = 1;
            }
        }
    
        System.out.println(count);
        System.out.println(degree);

    }
}