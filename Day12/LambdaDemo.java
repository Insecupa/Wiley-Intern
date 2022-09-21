package Day12;

public class LambdaDemo {
    public static void main(String[] args) {
        //only and only on functional interface
        Runnable r = () -> {
            System.out.println("In the run");
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}
