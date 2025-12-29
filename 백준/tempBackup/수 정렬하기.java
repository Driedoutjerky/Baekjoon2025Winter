import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int[] arr = new int[count];
        int[] result = new int[count];
        int temp = 0;
        int loc = 0;
        
        for(int i=0;i<count;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        
        for(int j=0;j<count;j++) {
            for(int k=0;k<count;k++) {
                if(arr[j]>arr[k] && j!=k) {
                    loc++;
                } 
            }
            result[loc] = arr[j];
            loc=0;
        }
        
        for(int l=0;l<count;l++) {
            System.out.println(result[l]);
        }
        
    }
}
