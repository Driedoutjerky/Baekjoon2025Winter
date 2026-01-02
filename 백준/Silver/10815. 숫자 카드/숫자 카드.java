import java.util.*;
import java.io.*;

class BinarySearch{
    
    public static int binarySearch(int arr[], int leftRange, int rightRange, int target) {
        while(leftRange <= rightRange) {
            int middle = (leftRange + rightRange)/2;
            if(arr[middle] == target) {
                return 1;
            } else if (arr[middle] > target) {
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
        
        int listCount = Integer.parseInt(bf.readLine()); 
        String[] rawList = bf.readLine().split(" ");
        int[] arrList = new int[listCount];
        for(int i=0;i<listCount;i++) {
            arrList[i] = Integer.parseInt(rawList[i]); 
        }
        
        Arrays.sort(arrList);
        
        int goalCount = Integer.parseInt(bf.readLine());
        String[] rawGoal = bf.readLine().split(" ");
        int[] goal = new int[goalCount];
        
        BinarySearch bs = new BinarySearch();
        StringBuilder sb = new StringBuilder();
        
        for(int j=0;j<goalCount;j++) {
            int temp = Integer.parseInt(rawGoal[j]);
            goal[j] = bs.binarySearch(arrList, 0, listCount-1, temp);
            sb.append(goal[j] + " ");
            
        }
        
        System.out.print(sb);
        
        
        
        
        
    }
}