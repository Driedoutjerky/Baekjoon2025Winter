import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] cond = bf.readLine().split(" ");
        String[] cardList = bf.readLine().split(" ");
        long cardCount = (long) Integer.parseInt(cond[0]);
        long goalVal = (long) Integer.parseInt(cond[1]);
        long bestVal = 0;
        int countCase = 0;
    
        for(int i=0;i<cardCount-2;i++) {
            for(int j=i+1;j<cardCount-1;j++) {
                for (int k=j+1;k<cardCount;k++) {
                    long cardSum = (long) Integer.parseInt(cardList[i]) + (long) Integer.parseInt(cardList[j]) + (long) Integer.parseInt(cardList[k]);
                    countCase++;
                    if(Math.abs(goalVal - cardSum) <= Math.abs(goalVal - bestVal) && cardSum <= goalVal){
                        bestVal = cardSum;
                        //System.out.println(bestVal);
                    }
                }
            }
        }
    
        System.out.println(bestVal);
        //System.out.println(countCase);
    }
}