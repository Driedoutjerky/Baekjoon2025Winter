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
                a = a-b;
                continue;
            }
            if(b%a==0) return a;
            b = b-a;
        }
    }
    public static int missingTree(int arr[]){
        
        Set<Integer> given = new HashSet<Integer>(); 
        for(int i=0;i<arr.length-1;i++) {
            given.add(Math.abs(arr[i]-arr[i+1]));
        }
        int[] givenArr = given.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(givenArr);
        
        int gcdResult = givenArr[0];
        for(int i=1;i<givenArr.length;i++) {
            gcdResult = gcd(givenArr[i],gcdResult);
        }
        //System.out.println("gcd: " + gcdResult);
        int expectedCount = Math.abs(arr[arr.length-1]/gcdResult+1 - arr[0]/gcdResult);
        //System.out.println("expectedCount: " + expectedCount);
        return Math.abs(arr.length-expectedCount);
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        MyMath myMath = new MyMath();
        int count = Integer.parseInt(bf.readLine());
        int[] arr = new int[count];
        
        for(int i=0;i<count;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        
        System.out.print(myMath.missingTree(arr));
        
    }
}