import java.util.*;
import java.io.*;
import java.lang.*;

// 1 2 3 3 3 4 4 4 5


class BinarySearch{
    public static boolean binarySearch(int[] arr, int l, int r, int target) {
        while(l<=r) {
            int m = (l+r)/2;
            if(arr[m]==target) {
                return true;
            } else if(arr[m]>target) {
                r = m-1;
            } else {
                l = m+1;
            }
            
        }
        return false;
    }
    public static int binaryBoundarySearch(int[] arr, int l, int r, int target) {
        int originL = l;
        int originR = r;
        int lowBound = 0;
        int highBound = 0;
        while(l<r) {
            //System.out.println("Looping lowBound");
            int m = (l+r)/2;
            if(arr[m]>=target) {
                r = m;
            } else {
                l = m+1;
            }
        }
        lowBound = l;
        //System.out.println(lowBound);
        l = originL;
        r = originR;
        while(l<r) {
            //System.out.println("Looping highBound");
            int m = (l+r)/2;
            if(arr[m]>target) {
                r = m;
            } else {
                l = m+1;
            }
        }
        highBound = l;
        //System.out.println(highBound);
        return highBound-lowBound;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BinarySearch bs = new BinarySearch();
        StringBuilder sb = new StringBuilder();
        int givenCount = Integer.parseInt(st.nextToken());
        int[] givenArr = new int[givenCount];
        
        st = new StringTokenizer(bf.readLine()); 
        for(int i=0;i<givenCount;i++) {
            givenArr[i] = Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(givenArr);
        
        st = new StringTokenizer(bf.readLine());
        int goalCount = Integer.parseInt(st.nextToken()); 
        //int[] goalArr = new int[goalCount];
        
        st = new StringTokenizer(bf.readLine()); 
        for(int i=0;i<goalCount;i++) {
            int goal = Integer.parseInt(st.nextToken());
            //System.out.println("this is " + goal);
            if(bs.binarySearch(givenArr,0,givenCount-1,goal)) {
                sb.append(bs.binaryBoundarySearch(givenArr,0,givenCount,goal) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        
        System.out.print(sb);
    }
}