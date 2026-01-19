import java.util.*;
import java.io.*;
import java.lang.*;

class MyClass{
    public void isParenthesis() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        
        
        
        while(true) {
            String rawData = bf.readLine();
            if(rawData.equals(".")) break;
            String[] raw = rawData.split("");
            Stack<String> stack = new Stack<>();
            for(int j=0;j<raw.length;j++) {
                String temp = raw[j];
                //System.out.println(temp);
                if(temp.equals("(") || temp.equals("[")) {
                    stack.push(temp);    
                } else if(temp.equals("]") || temp.equals(")")) {
                    if(stack.size()==0) {
                        stack.push("N");
                        break;
                    }
                    if(temp.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    } else if (temp.equals("]") && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        break;
                    }
                } 
                
            }
            
            if(stack.size()!=0) {
                sb.append("no" + newLine);
            } else {
                sb.append("yes" + newLine);
            }  
        }
        
        System.out.print(sb);
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        MyClass myClass = new MyClass();
        myClass.isParenthesis();
        
    }
}