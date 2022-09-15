package Day8;

class Test extends Thread{
    synchronized void print(){
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getId());
    }

//    void print(){
//        System.out.println(Thread.currentThread().getId());
//        System.out.println(Thread.currentThread().getId());
//        System.out.println(Thread.currentThread().getId());
//    }

    public void run() {
        print();
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        Thread test = new Test();
        Thread test2 = new Test();
        Thread test3 = new Test();

        test.start();
        test2.start();
        test3.start();
    }
}
