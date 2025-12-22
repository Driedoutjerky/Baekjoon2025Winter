import java.util.*;
import java.lang.Math;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        float aVal = Integer.parseInt(input[0]);
        float bVal = Integer.parseInt(input[1]);
        int cal = Integer.parseInt(input[2]);
        float dVal = Integer.parseInt(input[3]);
        float eVal = Integer.parseInt(input[4]);
        int fVal = Integer.parseInt(input[5]);
        int xGoal = 0;
        int yGoal = 0;

        if(aVal/bVal != dVal/eVal) {
            outerLoop:
            for(int x = -999;x<1000;x++) {
                for (int y = -999;y<1000;y++) {
                    if(x*aVal + y*bVal == cal && x*dVal + y*eVal == fVal) {
                        xGoal = x;
                        yGoal = y;
                        break outerLoop;
                    }
                }
            }
        }

        
        System.out.println(xGoal + " " + yGoal);
        
        
    }
}