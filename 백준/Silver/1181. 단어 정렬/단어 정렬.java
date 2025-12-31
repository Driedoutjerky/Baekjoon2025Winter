import java.util.*;
import java.io.*;

class Heap{
    
    public void heapify(String arr[], int arrLength, int node) { 
        int largestRoot = node; 
        int leftNode = 2*node + 1; 
        int rightNode = 2*node + 2; 
        
        if(leftNode<arrLength && arr[leftNode].length() > arr[largestRoot].length()) { 
            largestRoot = leftNode; 
        } else if (leftNode<arrLength && arr[leftNode].length() == arr[largestRoot].length() && arr[leftNode].compareTo(arr[largestRoot]) > 0) {
            largestRoot = leftNode; 
        }
        
        if(rightNode<arrLength && arr[rightNode].length() > arr[largestRoot].length()) { 
            largestRoot = rightNode;  
        } else if (rightNode<arrLength && arr[rightNode].length() == arr[largestRoot].length() && arr[rightNode].compareTo(arr[largestRoot]) > 0) {
            largestRoot = rightNode;
        }
        
        if(largestRoot != node) {  
            String temp = arr[node];
            arr[node] = arr[largestRoot];
            arr[largestRoot] = temp;
            heapify(arr,arrLength,largestRoot); 
        }
        
   
    }
    
    
    public void heapSort(String arr[]) {
         
        for(int i=arr.length/2 - 1;i>=0;i--) {
            heapify(arr,arr.length,i);
        }
        
        for(int j = arr.length-1;j>=0;j--) {
            String temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
        
            heapify(arr,j,0);        
        }
    }
}

public class Main{
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        String[] arr = new String[count];
        for(int i=0;i<count;i++) {
            arr[i] = bf.readLine();
        }
        
        Heap heap = new Heap();
        
        heap.heapSort(arr); 
        
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        
        sb.append(arr[0] + newLine);
        for(int j=1;j<count;j++) {
            if(!arr[j].equals(arr[j-1])) {
                sb.append(arr[j] + newLine);   
            }
        }
        
        System.out.print(sb);
        
    }
}