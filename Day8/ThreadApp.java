package Day8;

public class ThreadApp {
    public static void main(String[] args) throws InterruptedException {
        ThreadingExample thread = new ThreadingExample();
        ThreadingExample thread2 = new ThreadingExample();

//        thread.start();
//        thread.join(100);
//        thread2.start();

        thread.start();
        thread2.start();
        thread.setPriority(1);
        thread2.setPriority(2);

    }
}
