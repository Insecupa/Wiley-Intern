package Day11;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeQueueDemo {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(63);
        queue.offer(32);
        queue.offer(23);
        queue.offer(78);
        queue.offer(12);

        System.out.println(queue.toString());

        queue.offerFirst(232);
        queue.offerLast(123);

        System.out.println(queue.toString());

        queue.poll();

        int i = queue.peek();
        System.out.println(i);
        int j = queue.pollLast();
        System.out.println(j);
        System.out.println(queue);
    }
}
