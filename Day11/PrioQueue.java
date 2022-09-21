package Day11;

import java.util.PriorityQueue;

public class PrioQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(10);
        queue.add(7);
        queue.poll();
        System.out.println(queue.toString());
        queue.add(8);
        queue.add(1);
        queue.add(12);
        queue.add(22);
        queue.add(13);
        System.out.println(queue.toString());
        System.out.println(queue.poll());
    }
}
