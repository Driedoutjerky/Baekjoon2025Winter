import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long goalVal = (long) Integer.parseInt(bf.readLine());
        //System.out.println("Goal: " + goalVal);
        long solution = 0;
        outerLoop:
        for(long i=0;i<10;i++) {
            for(long j=0; j<10; j++) {
                for(long k=0;k<10;k++) {
                    for(long l=0;l<10;l++) {
                       for(long m=0;m<10;m++) {
                           for(long n=0;n<10;n++) {
                               //System.out.println(n*1 + m*10 + l*100 + k*1000 + j*10000 + i*100000);
                               //System.out.println("And " + (n*2 + m*11 + l*101 + k*1001 + j*10001 + i*100001));
                               if(n*2 + m*11 + l*101 + k*1001 + j*10001 + i*100001 == goalVal) {
                                   solution = n*1 + m*10 + l*100 + k*1000 + j*10000 + i*100000;
                                   break outerLoop;
                               } 
                           }
                       }
                    }
                }
            }
        }
        
        System.out.println(solution);
        
        
        
    }
}