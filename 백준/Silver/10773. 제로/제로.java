import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(bf.readLine());
        int total = 0;
        for(int i=0;i<count;i++) {
            int command = Integer.parseInt(bf.readLine()); 
            if(command!=0) {
                stack.push(command);
            } else {
                stack.pop(); 
            }
        }
        while(!stack.isEmpty()) {
            total+=stack.pop();
        }
        
        System.out.println(total);
    }
}