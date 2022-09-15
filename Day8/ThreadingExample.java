package Day8;

public class ThreadingExample extends Thread{
    public void run() {
        System.out.println("In the thread " + Thread.currentThread().getName());
//        for (int i = 0; i < 10; i++){
//            System.out.println(i + " in thread " + Thread.currentThread());
//        }
        System.out.println("We are running a thread " + Thread.currentThread().getName());
    }
}
