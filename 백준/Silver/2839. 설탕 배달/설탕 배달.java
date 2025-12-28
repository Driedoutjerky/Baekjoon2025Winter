import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(bf.readLine());
        int guess = 0;
        int threeCount = 0;
        int fiveCount = 0;
        int totalCount = -1;
        
        Outerloop:
        while(true) {
            Innerloop:
            while(true) {
                guess = 5*fiveCount + 3*threeCount;
                if(guess > 5000) {
                    //System.out.println("Inner loop 1 escaped!");
                    break Innerloop;
                   
                }
                if(guess == goal && totalCount == -1) {
                    totalCount = fiveCount+threeCount;
                }
                if(guess == goal && fiveCount+threeCount < totalCount) {
                    totalCount = fiveCount+threeCount;
                }
                fiveCount++;
                
            }
            fiveCount = 0;
            threeCount++; 
            if(threeCount*3 > 5000){
                //System.out.println("Outer loop 1 escaped!");
                //System.out.println(totalCount);
                break Outerloop;
                
            }
        }
        
        fiveCount = 0;
        threeCount = 0;
        guess = 0;
        
        Outerloop2:
        while(true) {
            Innerloop2:
            while(true) {
                guess = 5*fiveCount + 3*threeCount;
                if(guess > 5000) {
                    //System.out.println("Inner loop 2 escaped!");
                    break Innerloop2;
                    
                }
                if(guess == goal && totalCount == -1) {
                    totalCount = fiveCount+threeCount;
                }
                if(guess == goal && fiveCount+threeCount < totalCount) {
                    totalCount = fiveCount+threeCount;
                }
                threeCount++;
                
            }
            threeCount = 0;
            fiveCount++; 
            if(fiveCount*5 > 5000){
                //System.out.println("Outer loop 2 escaped!");
                break Outerloop2;
            }
        }
        
        
        
        System.out.println(totalCount);
        
    }
}