import java.util.*;
import java.io.*;

class Heap{
    
    public void heapify(int arr[], int arrLength, int node) { 
        int largestRoot = node; 
        int leftNode = 2*node + 1; 
        int rightNode = 2*node + 2; 
        
        if(leftNode<arrLength && arr[leftNode] > arr[largestRoot]) { 
            largestRoot = leftNode; 
        }
        
        if(rightNode<arrLength && arr[rightNode] > arr[largestRoot]) { 
            largestRoot = rightNode;  
        }
        
        if(largestRoot != node) {  
            int temp = arr[node];
            arr[node] = arr[largestRoot];
            arr[largestRoot] = temp;
            heapify(arr,arrLength,largestRoot); 
        }
        
   
    }
    
    
    public void heapSort(int arr[]) {
         
        for(int i=arr.length/2 - 1;i>=0;i--) {
            heapify(arr,arr.length,i);
        }
        
        for(int j = arr.length-1;j>=0;j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
        
            heapify(arr,j,0);        
        }
    }
}

public class Main{
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] rawArr = bf.readLine().split("");
        int[] arr = new int[rawArr.length];
        for(int i=0;i<rawArr.length;i++) {
            arr[i] = Integer.parseInt(rawArr[i]); 
        }
        Heap heap = new Heap();
        
        heap.heapSort(arr); 
        
        StringBuilder sb = new StringBuilder();
        
        for(int j=arr.length-1;j>=0;j--) {
            sb.append(arr[j]);
        }
        
        System.out.print(sb);
        
    }
}