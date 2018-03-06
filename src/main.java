import java.util.*;

public class main {
    public static void main(String args[]){

       /* fact f= new fact();
        System.out.println(f.fact(5));
        System.out.println(f.fact(7));
        System.out.println(f.fact(14));
        Stack<Integer> tempList = new Stack<Integer>();
        tempList.push(47);
        tempList.push(32);
        tempList.push(59);
        tempList.push(62);
        tempList.push(21);
        while(!tempList.isEmpty())
            System.out.println(tempList.pop());*/
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(47);
        queue.add(32);
        queue.add(59);
        queue.add(62);
        queue.add(21);
        Integer []list = new Integer[5];
        int i = 0;
        while (!queue.isEmpty()){
            list[i] = queue.poll();
            i ++;
        }
        for(int j = list.length; j >= 0; j --)
            System.out.println(list[j]);


    }
}
