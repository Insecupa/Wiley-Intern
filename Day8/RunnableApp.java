package Day8;

public class RunnableApp {
    public static void main(String[] args) {
        RunnableExp myThread = new RunnableExp();
        RunnableExp myThread2 = new RunnableExp();
        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread2);
        thread.start();
        thread1.start();
    }
}
