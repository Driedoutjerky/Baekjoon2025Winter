import java.util.*;
import java.io.*;

class Heap{
    
    public void heapify(int arr[][], int arrLength, int node) { 
        int largestRoot = node; 
        int leftNode = 2*node + 1; 
        int rightNode = 2*node + 2; 
        
        if(leftNode<arrLength && arr[leftNode][1] > arr[largestRoot][1]) { 
            largestRoot = leftNode; 
        } else if (leftNode<arrLength && arr[leftNode][1] == arr[largestRoot][1] && arr[leftNode][0] > arr[largestRoot][0] ) {
            largestRoot = leftNode; 
        }
        
        if(rightNode<arrLength && arr[rightNode][1] > arr[largestRoot][1]) { 
            largestRoot = rightNode;  
        } else if (rightNode<arrLength && arr[rightNode][1] == arr[largestRoot][1] && arr[rightNode][0] > arr[largestRoot][0]) {
            largestRoot = rightNode;
        }
        
        if(largestRoot != node) {  
            int tempX = arr[node][0];
            int tempY = arr[node][1];
            arr[node][0] = arr[largestRoot][0];
            arr[node][1] = arr[largestRoot][1];
            arr[largestRoot][0] = tempX;
            arr[largestRoot][1] = tempY;
            heapify(arr,arrLength,largestRoot); 
        }
        
   
    }
    
    
    public void heapSort(int arr[][]) {
         
        for(int i=arr.length/2 - 1;i>=0;i--) {
            heapify(arr,arr.length,i);
        }
        
        for(int j = arr.length-1;j>=0;j--) {
            int tempX = arr[0][0];
            int tempY = arr[0][1];
            arr[0][0] = arr[j][0];
            arr[0][1] = arr[j][1];
            arr[j][0] = tempX;
            arr[j][1] = tempY;
        
            heapify(arr,j,0);        
        }
    }
}

public class Main{
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int[][] arr = new int[count][2];
        for(int i=0;i<count;i++) {
            String[] rawDataArr = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(rawDataArr[0]);
            arr[i][1] = Integer.parseInt(rawDataArr[1]);
        }
        
        Heap heap = new Heap();
        
        heap.heapSort(arr); 
        
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        
        for(int j=0;j<count;j++) {
            sb.append(arr[j][0] + " " + arr[j][1] + newLine);
        }
        
        System.out.print(sb);
        
    }
}