import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] givenInfo = bf.readLine().split(" ");
        String[] givenList = bf.readLine().split(" ");
        int totalNum = Integer.parseInt(givenInfo[0]);
        int goalNum = Integer.parseInt(givenInfo[1]);
        int temp = 0;

        int[] givenListInt = new int[totalNum];

    
        
        for(int i=0;i<totalNum;i++) {
            givenListInt[i] = Integer.parseInt(givenList[i]);
        }
        
        for(int j=0;j+1<totalNum;j++) {
            if(givenListInt[j] > givenListInt[j+1]) {
                temp = givenListInt[j];
                givenListInt[j] = givenListInt[j+1];
                givenListInt[j+1] = temp;
                j = -1;
            }
            
        }
        
        System.out.println(givenListInt[totalNum - goalNum]);
    }
}
