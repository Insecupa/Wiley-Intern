package Day13.Assignment.StacksAndQueues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class MyStack{
    Queue<Integer> stack = new LinkedList<>();

    public void push(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        for(Integer t : stack){
            queue.add(t);
        }

        stack = queue;
    }

    public int pop() {
        return stack.remove();
    }
    public void print() {
        stack.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}

public class StacksViaQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);

        stack.print();

        System.out.println("Popoed Element from stack");
        System.out.println(stack.pop());
    }
}
