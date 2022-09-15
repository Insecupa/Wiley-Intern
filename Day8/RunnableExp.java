package Day8;

public class RunnableExp implements Runnable{

    @Override
    public void run() {
        System.out.println("In the thread of runnable " + Thread.currentThread().getName());
    }
}
