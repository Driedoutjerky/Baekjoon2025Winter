import java.util.*;
import java.io.*;

class BinarySearch{
    
    public static int binarySearch(String arr[], int leftRange, int rightRange, String target) {
        while(leftRange <= rightRange) {
            int middle = (leftRange + rightRange)/2;
            if(arr[middle].compareTo(target) == 0) {
                return 1;
            } else if (arr[middle].compareTo(target) > 0) {
                rightRange = middle-1; 
            } else {
                leftRange = middle+1;
            }
        }
        
        return 0; 
    }
    
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] rawData = bf.readLine().split(" ");
        int goalCount = Integer.parseInt(rawData[0]);
        int arrCount = Integer.parseInt(rawData[1]);
        String[] goal = new String[goalCount];
        String[] arr = new String[arrCount];
        
        for(int i=0;i<goalCount;i++) {
            goal[i] = bf.readLine(); 
        }
        
        for(int j=0;j<arrCount;j++) {
            arr[j] = bf.readLine();
        }
        
        Arrays.sort(goal);
        
        int result = 0; 
        BinarySearch bs = new BinarySearch();
        
        for(int j=0;j<arrCount;j++) {
            if(bs.binarySearch(goal, 0, goalCount-1, arr[j]) == 1) result++;
        } 
        
        System.out.print(result);
        
        
        
        
        
    }
}