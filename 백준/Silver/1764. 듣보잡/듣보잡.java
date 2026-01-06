import java.util.*;
import java.io.*;
import java.lang.*;

class BinarySearch{
    public static boolean binarySearch(String arr[], int r, String target) {
        int l = 0; 
        while(l<=r) {
            int m = (l+r)/2;
            if(arr[m].compareTo(target)==0) {
                return true;
            } else if (arr[m].compareTo(target)>0) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return false;
        
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BinarySearch bs = new BinarySearch();
        int listenCount = Integer.parseInt(st.nextToken());
        int seeCount = Integer.parseInt(st.nextToken());
        int sCount = 0;
        
        String[] listen = new String[listenCount];
        String[] see = new String[seeCount];
        Set<String> both = new HashSet<String>();
        String newLine = System.lineSeparator();
       
        
        
        for(int i=0;i<listenCount;i++) {
            st = new StringTokenizer(bf.readLine());
            listen[i] = st.nextToken();    
        }
        Arrays.sort(listen);
        for(int i=0;i<seeCount;i++) {
            st = new StringTokenizer(bf.readLine());
            see[i] = st.nextToken();
        }
        Arrays.sort(see);
        
        if(listenCount>=seeCount) {
            for(int i=0;i<seeCount;i++) {
                if(bs.binarySearch(listen, listenCount-1, see[i])) {
                    both.add(see[i]);
                }
            }    
        } else {
            for(int i=0;i<listenCount;i++) {
                if(bs.binarySearch(see, seeCount-1, listen[i])) {
                    both.add(listen[i]);
                }
            }
        }
        
        String[] bothArr = both.toArray(new String[both.size()]);
        Arrays.sort(bothArr);
        for(int i=0;i<bothArr.length;i++) {
            sb.append(bothArr[i] + newLine);
        }
        
        System.out.println(bothArr.length);
        System.out.println(sb);
        
        
    }
}