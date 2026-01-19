import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        Deque<Integer> deque = new ArrayDeque<>(); 
        int size = 0;
        int commandCount = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<commandCount;i++) {
            st = new StringTokenizer(bf.readLine());
            String command = st.nextToken(); 
            if(command.equals("push") && st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                deque.add(value);
                
            } else if(command.equals("pop")) {
                try {
                    sb.append(deque.pop() + newLine);
                } catch(NoSuchElementException e) {
                    sb.append(-1 + newLine);
                }
            } else if (command.equals("size")) {
                sb.append(deque.size() + newLine);
            } else if (command.equals("empty")) {
                if(deque.isEmpty()) {
                    sb.append(1 + newLine);
                } else {
                    sb.append(0 + newLine);
                }
            } else if (command.equals("front")) {
                try {
                    sb.append(deque.getFirst() + newLine);
                } catch(NoSuchElementException e) {
                    sb.append(-1 + newLine);
                }
            } else if (command.equals("back")) {
                try {
                    sb.append(deque.getLast() + newLine);
                } catch(NoSuchElementException e) {
                    sb.append(-1 + newLine);
                }
            }
        }
        
        System.out.print(sb);
    }
}