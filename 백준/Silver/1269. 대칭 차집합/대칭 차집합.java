import java.util.*;
import java.io.*;
import java.lang.*;

class BinarySearch{
    public static boolean binarySearch(int arr[], int r, int target) {
        int l = 0; 
        while(l<=r) {
            int m = (l+r)/2;
            if(arr[m] == target) {
                return true;
            } else if (arr[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return false;
        
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BinarySearch bs = new BinarySearch();
        int firstCount = Integer.parseInt(st.nextToken());
        int secondCount = Integer.parseInt(st.nextToken());
        
        Set<Integer> first = new HashSet<Integer>();
        Set<Integer> second = new HashSet<Integer>();
        int sameCount = 0;
       
        
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<firstCount;i++) {
            first.add(Integer.parseInt(st.nextToken()));    
        }
        int[] firstArr = first.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(firstArr);
        
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<secondCount;i++) {
            second.add(Integer.parseInt(st.nextToken()));
        }
        int[] secondArr = second.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(secondArr);
        
        for(int i=0;i<firstCount;i++) {
            if(bs.binarySearch(secondArr, secondCount-1, firstArr[i])) {
                sameCount++;
            }
        }
        System.out.print((firstCount+secondCount)-2*sameCount);
        
        
    }
}