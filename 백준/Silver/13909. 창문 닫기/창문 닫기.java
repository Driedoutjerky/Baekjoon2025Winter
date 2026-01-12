import java.util.*;
import java.io.*;
import java.lang.*;

class PleaseCloseTheGodDamnWindowItsColdOutside{
    public static long interactWindow(long max) {
        //너도 에라토스테네스의 채로 걸러주마
        //근데 메모리 초과됨.
        //배열 쓰지 말라는 것 같아 출력 규칙 뽑아보려고 일일이 1 에서부터 25까지 입력해봤는데 규칙을 발견함.
        /*
        int openCount = max;
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        for(int i=2;i<=max;i++) {
            for(int j = i;j<=max;j+=i) {
                if(!isPrime[j]) {
                    isPrime[j] = true; // 열어재껴
                    openCount++;
                } else {
                    isPrime[j] = false; // 닫아 
                    openCount--;
                }
            }
        }
        */
        long result = (long) Math.sqrt(max);
        
        return result;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PleaseCloseTheGodDamnWindowItsColdOutside window = new PleaseCloseTheGodDamnWindowItsColdOutside();
        long num = Long.parseLong(bf.readLine());
        long result = window.interactWindow(num);

        System.out.println(result);
        
    }
}
