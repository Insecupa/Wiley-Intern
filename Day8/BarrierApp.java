package Day8;

import java.util.concurrent.CyclicBarrier;


class Barrier implements Runnable{
    CyclicBarrier cb;

    public Barrier(CyclicBarrier cb) {
        this.cb = cb;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Reached Barrier");
            cb.await();
            System.out.println(Thread.currentThread().getName() + " Running after the barrier");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

public class BarrierApp {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable () {
            public void run() {
                System.out.println("All threads passed the barrier");
            }
        });

        Thread t1 = new Thread(new Barrier(cb), "T1");
        Thread t2 = new Thread(new Barrier(cb), "T2");
        Thread t3 = new Thread(new Barrier(cb), "T3");

        t1.start();
        t2.start();
        t3.start();




    }
}
