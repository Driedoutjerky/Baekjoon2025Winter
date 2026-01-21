import java.util.*;
import java.io.*;
import java.lang.*;

class MyClass {
    public void solveCard(int n){
        //링크드리스트를 써1보자
        Queue<Integer> deck = new LinkedList<>();
        for(int i=1;i<n+1;i++) {
            deck.add(i);
        }
        int counter = 0;
        while(deck.size()!=1) {
            if(counter%2==0) {
                deck.poll();
            } else {
                int temp = deck.poll();
                deck.add(temp);
            }
            counter++;
        }
        
        System.out.println(deck.poll());
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        MyClass myClass = new MyClass();
        int input = Integer.parseInt(bf.readLine()); 
        myClass.solveCard(input);
    }
}