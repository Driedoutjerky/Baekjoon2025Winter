import java.util.*;
import java.io.*;

class Heap{
    /*
    * heap 구성.
    */
    public void heapify(int arr[], int arrLength, int node) { // node 는 어레이의 어느 인덱스값. 
        int largestRoot = node; // 임의적으로 node가 root로 간주되지만, 이후 결국 가장 큰 값이 root가 될것.
        int leftNode = 2*node + 1; // 예를 들어 root 인덱스 값이 1 이면 left child 인덱스 값은 3. CBT인데다 BFS 방식으로 어레이 구성되니까.
        int rightNode = 2*node + 2; // 예를 들어 root 인덱스 값이 1 이면 right child 인덱스는 그냥 left child 인덱스보다 1 높은 값. 
        
        if(leftNode<arrLength && arr[leftNode] > arr[largestRoot]) { // leftNode에 해당하는 값이 root 노드에 해당하는 값보다 큰가? 이 때 leftNode (인덱스값)이 arrLength 보다 길면 실행되면 안됨.
            largestRoot = leftNode; // 조건 성립할 경우 가장 큰 값이 root로 와야하니 스왑.  
        }
        
        if(rightNode<arrLength && arr[rightNode] > arr[largestRoot]) { // rightNode에 해당하는 값이 root 노드에 해당하는 값보다 큰가? 이 때 rightNode (인덱스값)이 arrLength 보다 길면 실행되면 안됨.
            largestRoot = rightNode;  // 조건 성립할 경우 가장 큰 값이 root로 와야하니 스왑.
        }
        
        if(largestRoot != node) { // 만일 위에서 기존 largest 가 node 가 아닌 다른 leftNode 나 rightNode 로 인덱스값 변경되었을 경우 이에 상응해 노드의 value 도 변경해야함.  
            int temp = arr[node];
            arr[node] = arr[largestRoot];
            arr[largestRoot] = temp;
            heapify(arr,arrLength,largestRoot); // 변동 발생한 leftNode 또는 rightNode 를 또 다시 Root 로 간주해서 recursive 
        }
        
   
    }
    
    // Heap sort
    public void heapSort(int arr[]) {
        //heap 구성 
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
        int count = Integer.parseInt(bf.readLine());
        int[] arr = new int[count];
        for(int i=0;i<count;i++) {
            arr[i] = Integer.parseInt(bf.readLine()); 
        }
        
        Heap heap = new Heap();
        
        heap.heapSort(arr); 
        
        for(int j=0;j<count;j++) {
            System.out.println(arr[j]); 
        }
    }
}