//원본
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] cond = bf.readLine().split(" ");
        int goal = 8;
        int given = Integer.parseInt(cond[1]);
        int givenY = Integer.parseInt(cond[0]);
        String[] givenArray = new String[givenY];
        int[][] counter = new int[givenY-goal+1][given-goal+1];
        boolean isItBlack = false;
        int bestRawResult = 0;
        int bestResult = 0;
        
        
        // Saves given array 
        for(int i=0;i<givenY;i++) {
            givenArray[i] = bf.readLine();
        }
        
        // Reads given array and save the best.
        // (j,k) is the standard point. 
        for(int j=0;j<givenY-goal+1;j++) {
            for (int k=0;k<given-goal+1;k++) {
                //Initialize 
                counter[j][k] = 0;
                
                // Is the standard point black?
                if(givenArray[j].substring(k,k+1).equals("B")) {
                    isItBlack = true;
                    //System.out.println("Standard is black");
                } else {
                    isItBlack = false;
                    //System.out.println("Standard is white");
                }
                
                // Based on standard point, see if the goal-sized array's accurate. if accurate by a tile, then counter++
                
                for(int m=0;m<goal;m+=2) { // Start of odd row inspection
                    //System.out.println(m + "th row analyzing.");
                    int curYLoc = j+m;
                    for(int l=0;l<goal;l+=2) { // Start of column value inspection
                        int curXLoc = k+l;
                        //System.out.println(l + "th column analyzing");
                        //System.out.println("base part to be analyzed looks as below.");
                        //System.out.println(givenArray[j+m].substring(k+l,k+l+1));
                        if(givenArray[j+m].substring(k+l,k+l+1).equals("B") && isItBlack == true) {
                            counter[j][k]++;
                            //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                           
                        } else if (givenArray[j+m].substring(k+l,k+l+1).equals("W") && isItBlack == false) {
                            counter[j][k]++;
                            //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                        }
                        if(l<goal-2 || goal%2==0) {
                            //System.out.println("base part+1 to be analyzed looks as below.");
                            //System.out.println(givenArray[j+m].substring(k+l+1,k+l+2));
                            if(givenArray[j+m].substring(k+l+1,k+l+2).equals("W") && isItBlack == true) {
                                counter[j][k]++; 
                                //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                            } else if (givenArray[j+m].substring(k+l+1,k+l+2).equals("B") && isItBlack == false) {
                                counter[j][k]++;
                                //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                            }
                        } else {
                            //System.out.println("Seems like the goal is odd here.");
                        }
                    } // end of column value inspection
                    //System.out.println(m + "th row analyzed complete.");
                } // end of odd row inspection
                //System.out.println("Odd row completed");
                    
                for(int n=1;n<goal;n+=2) { // Start of even row inspection
                    //System.out.println(n + "th row analyzing.");
                    int curYLoc = j+n;
                    for(int l=0;l<goal;l+=2) { // Start of column value inspection 
                        int curXLoc = k+l;
                        //System.out.println(l + "th column analyzing");
                        //System.out.println("base part to be analyzed looks as below.");
                        //System.out.println(givenArray[j+n].substring(k+l,k+l+1));
                        if(givenArray[j+n].substring(k+l,k+l+1).equals("W") && isItBlack == true) {
                            counter[j][k]++;
                            //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                        } else if (givenArray[j+n].substring(k+l,k+l+1).equals("B") && isItBlack == false) {
                            counter[j][k]++;
                            //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                        }
                        if(l<goal-2 || goal%2==0) {
                            //System.out.println("base part+1 to be analyzed looks as below.");
                            //System.out.println(givenArray[j+n].substring(k+l+1,k+l+2));
                            if(givenArray[j+n].substring(k+l+1,k+l+2).equals("B") && isItBlack == true) {
                                counter[j][k]++; 
                                //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                            } else if (givenArray[j+n].substring(k+l+1,k+l+2).equals("W") && isItBlack == false) {
                                counter[j][k]++;
                                //System.out.println("Hit on Y: " + curYLoc + " X: " + curXLoc);
                            }
                        } else {
                            //System.out.println("Seems like the goal is odd here.");
                        }
                    } // end of column value inspection
                    //System.out.println(n + "th row analyzed.");
                } // end of even row inspection
                //System.out.println("Even row completed");
            }
        } // end of given array analysis + counter ready
        
        //System.out.println("Result:");
        for(int i=0;i<givenY-goal+1;i++) {
            for(int j=0;j<given-goal+1;j++) {
                if(counter[i][j] < goal*goal/2) {
                    counter[i][j] = goal*goal - counter[i][j];
                }
                if(bestRawResult<counter[i][j]) {
                    bestRawResult = counter[i][j];
                }
            }
        }
        
        bestResult = goal*goal - bestRawResult;
        System.out.println(bestResult);
        
        
    }
}             

        