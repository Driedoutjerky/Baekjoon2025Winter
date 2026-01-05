import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        Set<String> log = new HashSet<String>();
        
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        
        for(int i=0;i<count;i++) {
            String[] temp = bf.readLine().split(" ");
            if(temp[1].equals("enter")) {
                log.add(temp[0]);
            } else {
                log.remove(temp[0]);
            }
            
            
        }
        
        String[] result = log.toArray(new String[log.size()]);
        Arrays.sort(result);
        for(int i=result.length-1;i>=0;i--) {
            sb.append(result[i] + newLine);
        }
        
        System.out.print(sb);
        
        
        
        
    }
}