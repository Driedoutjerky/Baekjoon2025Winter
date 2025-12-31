import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(bf.readLine());
        int[] arr = new int[count];
        int[] result = new int[count];
        int[] valMark = new int[10001];
        for(int i=0;i<count;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            valMark[arr[i]]++;
            
        }
        
        for(int k=1;k<valMark.length;k++) {
            valMark[k] += valMark[k-1];
        }
        
        for(int j=count-1;j>=0;j--) {
            valMark[arr[j]]--;
            result[valMark[arr[j]]] = arr[j];
        }
        
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        for(int k=0;k<count;k++) {
            sb.append(result[k] + newLine);
        }
        
        System.out.print(sb);
        
        
    }
}