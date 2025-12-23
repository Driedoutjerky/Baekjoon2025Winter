import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int total = 0;
        int avg = 0;
        for(int i=0;i<5;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            total += arr[i];
            
        }
        avg = total/5;
        
        Arrays.sort(arr);
        System.out.println(avg);
        System.out.println(arr[2]);
    }
}             

        