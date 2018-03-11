import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueToStack {
    Queue <Integer> myQueue = new LinkedList <Integer>();

    public QueueToStack(){

    }

    public void setMyQueue(Queue<Integer> newQueue) {
        this.myQueue = newQueue;
    }

    public void move(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(myQueue.peek());
    }
}
