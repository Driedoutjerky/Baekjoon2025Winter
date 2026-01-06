import java.util.*;
import java.io.*;
import java.lang.*;

class MyMath{
    public static int gcd(int a, int b) {
        while(true) {
            if(a==0) return b;
            if(b==0) return a;
            if(a==b) return a;
            if(a>b) {
                if(a%b==0) return b;
                a=a-b;
                continue;
            }
            if(b%a==0) return a;
            b=b-a;
        }
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("Temporary");
        MyMath myMath = new MyMath();
        int[] numer = new int[2];
        int[] denom = new int[2];
        
        for(int i=0;i<2;i++) {
            st = new StringTokenizer(bf.readLine());
            numer[i] = Integer.parseInt(st.nextToken());
            denom[i] = Integer.parseInt(st.nextToken());
        }
        int comNum = numer[0]*denom[1] + numer[1]*denom[0];
        int comDen = denom[0]*denom[1];
        
        int gcd = myMath.gcd(Math.abs(comNum),Math.abs(comDen));
        
        /*
        int gcd = myMath.gcd(Math.abs(denom[0]), Math.abs(denom[1]));
        int hcf = denom[0]*denom[1]/gcd;
        int numResult = 0;
        for(int i=0;i<2;i++) {
            int temp = hcf/denom[i];
            numResult += numer[i]*temp;
        }
        */
        
        System.out.print(comNum/gcd + " " + comDen/gcd);
        
    }
}