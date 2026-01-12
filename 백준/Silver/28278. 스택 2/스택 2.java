import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        Stack<Integer> stack = new Stack<>(); 
        int commandCount = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<commandCount;i++) {
            st = new StringTokenizer(bf.readLine());
            int command = Integer.parseInt(st.nextToken()); 
            if(command==1&&st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if(command==2) {
                try {
                    sb.append(stack.pop() + newLine);
                } catch(EmptyStackException e) {
                    sb.append(-1 + newLine);
                }
            } else if (command==3) {
                sb.append(stack.size() + newLine);
            } else if (command==4) {
                if(stack.isEmpty()) {
                    sb.append(1 + newLine);
                } else {
                    sb.append(0 + newLine);
                }
            } else if (command==5) {
                try {
                    sb.append(stack.peek() + newLine);
                } catch(EmptyStackException e) {
                    sb.append(-1 + newLine);
                }
            }
        }
        
        System.out.print(sb);
    }
}