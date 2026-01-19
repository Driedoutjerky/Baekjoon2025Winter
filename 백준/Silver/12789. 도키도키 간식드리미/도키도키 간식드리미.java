import java.util.*;
import java.lang.*;
import java.io.*;

class MyClass{
    public void isPossible() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int goalCount = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<Integer> tempLine = new Stack<>();
        int count = 1;
        int currentLineTag = 0;
        
        while(true) {
            //System.out.println(count);
            
            if(st.hasMoreTokens()){
                currentLineTag = Integer.parseInt(st.nextToken());
                //System.out.println("Properly saved currentLineTag: " + currentLineTag);
            } else if (tempLine.peek()==currentLineTag) {
                currentLineTag = 0;
                //System.out.println("currentLineTag is empty");
            }
            
            if(currentLineTag == count) {
                count++;
                //System.out.println("currentLineTag is in correct order: " + currentLineTag);
                currentLineTag = 0;
                continue;
            }
            
            
            try {
                while(tempLine.peek() == count) {
                    tempLine.pop();
                    count++;
                    //System.out.println("tempLine had the right order person, next is: " + tempLine.peek());
                }
                if(currentLineTag!=0) {
                    tempLine.push(currentLineTag); // 통과시키기 전 검문, continue 로 미처 넘어갈 수도 있으니까.
                    continue;
                }
               
                
                
            } catch (EmptyStackException e) {
                //뭘 시켜야함 이때?
                // 그냥 가만히 있으렴
                //System.out.println("EmptyStack");
            }
            
            if(currentLineTag == 0 && tempLine.size() == 0 && count > goalCount) {
                System.out.println("Nice");
                break;
            }
            if(currentLineTag == 0) {
                System.out.println("Sad");
                break;
            }
            tempLine.push(currentLineTag);
            //System.out.println("Pushed: " + tempLine.peek());
        }
        
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        MyClass myClass = new MyClass();
        myClass.isPossible();
    }
}