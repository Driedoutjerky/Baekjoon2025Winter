import java.util.*;
import java.io.*;
import java.lang.*;

class Finding{
    public static int hcf(int a, int b){
        int gcd = Math.min(a,b);
        while(true) {
            if(a%gcd==0 && b%gcd==0) {
                break;
            }
            gcd--;
        }
        
        int hcfResult = a*b/gcd;   
        return hcfResult;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        Finding fd = new Finding();
        int quizCount = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<quizCount;i++){
            st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            sb.append(fd.hcf(num1,num2) + newLine);
        }
        
        System.out.print(sb);
        
    }
}