import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int a1Val = Integer.parseInt(strs[0]);
        int a0Val = Integer.parseInt(strs[1]);
        
        int c = Integer.parseInt(bf.readLine());
        int nZ = Integer.parseInt(bf.readLine());
        
        int fFuncValue = a1Val*nZ + a0Val;
        int gFuncValue = c * nZ;
        
        if(fFuncValue <= gFuncValue && a1Val <= c) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        
        
    }
    

}