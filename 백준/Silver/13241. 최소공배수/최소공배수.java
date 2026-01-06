import java.util.*;
import java.io.*;
import java.lang.*;

class MyMath{
    public static long gcd(long a, long b) {
        while(true) {
            if(a==0) {
                return b;
            } 
            if(b==0) {
                return a;
            }
            if(a==b) {
                return a;
            }
            if(a>b) {
                if(a%b==0) {
                    return b;
                } else {
                    a=a-b;
                    continue;
                }
            } 
            if(b%a==0) {
                return a;
            }
            b=b-a;
        }
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        MyMath myMath = new MyMath();
        long num1 = Math.abs((long) Integer.parseInt(st.nextToken()));
        long num2 = Math.abs((long) Integer.parseInt(st.nextToken())); 
        System.out.print(num1*num2/myMath.gcd(num1,num2));
    }
}