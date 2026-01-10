import java.util.*;
import java.io.*;
import java.lang.*;

class MyMath{
    public static boolean[] getAllPrime(int max) {
        //범위가 백만까지 밖에 안돼?
        //안되겠다 에라토스테네스의 채 맛좀 봐라 
        
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2;i<=Math.sqrt(max);i++) {
            if(isPrime[i]) {
                for(int j = i*i;j<=max;j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        MyMath myMath = new MyMath();
        String newLine = System.lineSeparator();
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        boolean[] primeList = myMath.getAllPrime(max);
        for(int i=min;i<max+1;i++) {
            if(primeList[i]) sb.append(i + newLine);
        }
        
        System.out.print(sb);
        
    }
}