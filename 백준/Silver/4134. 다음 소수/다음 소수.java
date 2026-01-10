import java.util.*;
import java.io.*;
import java.lang.*;

class MyMath{
    public static boolean isPrime(int n) {
        //closePrime 메서드의 시간초과 이슈로, 에라토스테네스의 채 알고리즘을 이용한 소수 판별 사용하기.
        //그런데 이제 이건 메모리 초과난대 ㅋㅋㅋㅋㅋㅋ 
        if(n<=1) return false;
        if(n==2) return true;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(isPrime[i]) {
                for(int j = i*i;j<=n;j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        if(isPrime[n]) return true;
        return false;
    }
    
    public static long closePrime(long n) {
        if(n<=2) return 2;
        
        //문제를 제대로 읽지 않아 주어진 숫자에서 가장 가까운 소수 구하기가 되었다.
        // 원래는 주어진 숫자보다 큰 소수 중 작은 것 찾기인데.
        // 그런데 시간 초과로 인해 버려졌다가
        // 에라토스테네스의 채가 메모리 초과해버려서 다시 돌아옴.
        
        /*
        long lowerResult = 2;
        OuterLoop:
        for(long i=n;i>=3;i--) {
            for(long j=i-1;j>=2;j--) {
                if(i!=j && i%j==0) {
                    break;
                }
                if(j==3) {
                    lowerResult = i;
                    break OuterLoop;
                } 
            }
        }
        */
        
        long higherResult = -1;
        long numer = n;
        long denom = 2;
        while(true) {
            if(numer!=denom && numer%denom==0) {
                numer++;
                denom = 2;
                continue;
            }
            if(denom>=Math.sqrt(numer)) {
                higherResult = numer;
                break;
            }
            denom++;
        }
        /*
        if(Math.abs(lowerResult - n) >= Math.abs(higherResult - n)) {
            return higherResult;
        }
        return lowerResult;
        */
        
        return higherResult;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyMath myMath = new MyMath();
        String newLine = System.lineSeparator();
        int count = Integer.parseInt(bf.readLine());
        for(int i=0;i<count;i++) {
            long quiz = Long.parseLong(bf.readLine());
            /*
            //에라토스테네스의 버려진 채 
            while(true) {
                if(myMath.isPrime(quiz)) break;
                quiz++;
            }
            */
            sb.append(myMath.closePrime(quiz) + newLine);
        }
        System.out.print(sb);
    }
}