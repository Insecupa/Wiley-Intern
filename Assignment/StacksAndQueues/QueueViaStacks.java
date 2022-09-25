package Day13.Assignment.StacksAndQueues;

import java.util.Stack;

class myQueue{
    Stack<Integer> queue = new Stack<>();

    public myQueue() {

    }

    public void enQueue(int i){
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        for(Integer t  : queue){
            stack.push(t);
        }
        queue = stack;
    }

    public int deQueue() {
        return queue.pop();
    }

    public void print() {
        System.out.println("Queue data is: ");
        queue.stream().forEach(System.out::println);
    }
}

public class QueueViaStacks {
    public static void main(String[] args) {
        myQueue queue = new myQueue();
        queue.enQueue(10);
        queue.enQueue(11);
        queue.enQueue(12);
        queue.enQueue(13);
        queue.enQueue(14);
        queue.enQueue(15);

        queue.print();

        System.out.println("Dequeued one: ");
        System.out.println(queue.deQueue());
        System.out.println("Dequeud two: ");
        System.out.println(queue.deQueue());
    }
}
