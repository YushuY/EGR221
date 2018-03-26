import java.util.*;

public class stack{
    public static void main(String args[]){
        Stack<Integer> tempList = new Stack<>();
        tempList.push(47);
        tempList.push(32);
        tempList.push(59);
        tempList.push(62);
        tempList.push(21);
        while(!tempList.isEmpty())
            System.out.println(tempList.pop());
    }
}