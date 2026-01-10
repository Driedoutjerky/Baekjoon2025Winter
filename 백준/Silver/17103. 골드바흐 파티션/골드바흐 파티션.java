/*
* 문제 자체는 풀리긴 했는데 효율적인건 boolean[] 써서 체킹하고 넘어가는게 속도 면에선 더 빠름.
* 그런데 이럴거면 그냥 이런 코드 통과 못시키게 해야하는거 아닌가?
*/
import java.io.*;
import java.lang.*;
import java.util.*;

class MyMath{
    public HashSet<Integer> getAllPrime(int n) {
        //에라토스테네스의 채로 계속 쌀먹하기에는 조금 그래서 이번에는 순다람의 채를 가지고 왔다. 
        //근데 코드를 막상 짜보고 이것저것 알아보니
        // https://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n/3035188#3035188
        // 여기에 의하면 1 억 이하의 소수에 대해서는 에라토스테네스의 채가 조금 더 빠르다고 한다.
        // 그런데 n 이 100만 이하니까 그럼 순다람의 체로 통과가 안될 수도 있다 생각이 드는데
    	HashSet<Integer> primeSet = new HashSet<Integer>();
    	if(n<4) {
    		return primeSet;
        }
    	int nNew = (n-1)/2;
        boolean[] isPrimeCofactor = new boolean[nNew+1];
        Arrays.fill(isPrimeCofactor, true);
        for(long i=1;i<nNew+1;i++) {
            for(long j=i;2*i*j+i+j <= nNew;j++) {
                isPrimeCofactor[(int) (i+j+2*i*j)] = false;
            }
        }
        
        primeSet.add(2);
        for(int i=1;i<nNew+1;i++) {
            if(isPrimeCofactor[i]) {
                primeSet.add(2*i+1);
            }
        }
        
        return primeSet;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MyMath myMath = new MyMath();
        
        String newLine = System.lineSeparator();
        int count = Integer.parseInt(bf.readLine());
        for(int i=0;i<count;i++) {
            int quiz = Integer.parseInt(bf.readLine());
            int resultCount = 0;
            HashSet<Integer> primeSet = myMath.getAllPrime(quiz);
            if(primeSet.size()<1) {
            	sb.append(0 + newLine);
            	continue;
            }
            HashSet<Integer> usedPrime = new HashSet<Integer>();
            for(int j:primeSet) {
            	//System.out.println(j);
            	int result = quiz-j;
            	if(primeSet.contains(result) && !usedPrime.contains(result)) {
            		usedPrime.add(j);
            		usedPrime.add(result);
            		resultCount++;
            	}
            }
            sb.append(resultCount + newLine);
        }
        
        System.out.print(sb);
    }

}
