import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int series = Integer.parseInt(bf.readLine());
        int tempNum = 0;
        int resultNum = 0;
        String castedTemp = "";
        
        for(int i = 0;i<series;i++) {
            while(true) {
                tempNum++;
                castedTemp = Integer.toString(tempNum);
                if(castedTemp.contains("666") && resultNum < tempNum) {
                    resultNum = tempNum;
                    break;
                }
            }
        }
        
        System.out.println(resultNum);
    }
}