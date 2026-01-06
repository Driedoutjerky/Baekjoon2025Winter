import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Set<String> result = new HashSet<String>();
        
        for(int i=0;i<str.length();i++) {
            for(int j=i;j<str.length();j++) {
                result.add(str.substring(i,j+1));
            }
        }
        
        System.out.println(result.size());
        
        
    }
}
