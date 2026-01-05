import java.util.*;
import java.io.*;

class BinarySearch{
    public static int nameGivenSearch(String arr[][], int left, int right, String target) {
        while(left<=right) {
            int middle = (left+right)/2;
            if(arr[middle][0].compareTo(target) == 0) {
                return Integer.parseInt(arr[middle][1]);
            } else if (arr[middle][0].compareTo(target)>0) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        
        return -1;
    }
}

class Numbering{
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] rawData = bf.readLine().split(" ");
        
        int total = Integer.parseInt(rawData[0]);
        int quizCount = Integer.parseInt(rawData[1]);
        String[][] dict = new String[total][2];
        
        for(int i=0;i<total;i++) {
            dict[i][0] = bf.readLine();
            dict[i][1] = Integer.toString(i);
        }
        
        String[][] tempArr = new String[total][2];
        
        for(int i=0;i<total;i++) {
        	tempArr[i] = dict[i].clone();
        }
        
        for(int i=0;i<total;i++) {
            tempArr[i][0] = tempArr[i][0].toLowerCase();
        }
        
        Arrays.sort(tempArr,(x,y)->x[0].compareTo(y[0]));
        
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        BinarySearch bs = new BinarySearch();
        Numbering num = new Numbering();
        
        for(int q=0;q<quizCount;q++) {
            //System.out.println(q);
        	String quiz = bf.readLine();
            if(num.isNumeric(quiz)) {
            	//System.out.println("this happened");
            	int temp = Integer.parseInt(quiz);
                sb.append(dict[temp-1][0].toString() + newLine);
                continue;
                
            } else {
            	//System.out.println("else happened");
            	String quizraw = quiz.toLowerCase();
            	int goal = bs.nameGivenSearch(tempArr, 0, total-1,quizraw);
                sb.append((Integer.parseInt(dict[goal][1])+1) + newLine);
                continue;
                
            }
        }
        
        System.out.print(sb);
        
        
        
        
    }
}