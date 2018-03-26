import java.util.*;

public class queue {

    public void stack(LinkedList<Integer> queue1) {
        LinkedList<Integer> queue2 = new LinkedList<Integer>();
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            while (queue1.size() > 1)
                queue2.add(queue1.poll());
            if (queue1.size() == 1)
                System.out.println(queue1.poll());
            while (queue2.size() > 1)
                queue1.add(queue2.poll());
            if(queue2.size() == 1)
                System.out.println(queue2.poll());
        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(47);
        queue.add(32);
        queue.add(59);
        queue.add(62);
        queue.add(21);
        queue q = new queue();
        q.stack(queue);
    }

}
