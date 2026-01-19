import java.util.*;
import java.io.*;
import java.lang.*;

class MyClass{
    public void isParenthesis() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String newLine = System.lineSeparator();
        int count = Integer.parseInt(bf.readLine());
        //StringTokenizer 는 나누는 기준이 명확해야 쓸 수 있음. 전부 합쳐진 스트링들 하나하나 구분은 못하는듯.
        
        
        for(int i=0;i<count;i++) {
            String[] raw = bf.readLine().split("");
            Stack<String> stack = new Stack<>();
            for(int j=0;j<raw.length;j++) {
                String temp = raw[j];
                //System.out.println(temp);
                if(temp.equals("(")) {
                    stack.push(temp);    
                } else if(stack.size()!=0) {
                    stack.pop();
                } else {
                    stack.push("N");
                    break;
                }
                
            }
            
            if(stack.size()!=0) {
                sb.append("NO" + newLine);
            } else {
                sb.append("YES" + newLine);
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