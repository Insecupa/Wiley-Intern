package Day8;


public class Main {
    /*
        Threading
        Packages
     */
    //java.lang is already imported

    //Date class

    //Multiple ways to create a thread

    //Can invoke run method but it is not recommmended.
    //Run should be running implicitly

    //Threading is possible using Thread class and also implementing
    //Runnable which is a interface.

    /*
        We can only use run directly by extending Thread class
        whereas we have to override run method from runnable class
     */

    /*
        why does start() method doesnt work when implementing runnable interface
        -> start() method isnt implemented in the class
     */

    /*
        Fix is create a object of thread class and call runable ref inside that
        Ans -> TheadDemo - implements Runnable
        to run start()
        ThreadDemo demo = new ThreadDemo();
        Thread newT = new Thread(demo);
        newT.start() -> will be able to create a new thread
     */

    /*
        run isnt abstract
        no output will print as there is no run implementation
     */

    /*
        setName, getName, setId, getId, setPriority, getPrio etc.
     */

    /*
        Implicitly calling run method will only invoke the method not the thread
        Hence we should only call start() method.
     */

    /*
        .sleep() will delay
     */

    /*
        Deamon thread do not need any user interaction
     */

    /*
        Higher number is higher prio
     */

    /*
        yield first checks if any other thread having higher prio or same prio and if no such threads are avail the current thread
        continues;
     */

    /*
        Synchronization
        Process by which if mutlple threads are accessing the same method we should be able to control it.
        Why?
        to apply lock on that method.
     */

    /*
        you need to inclued 'synchronized'
     */

    /*
        synchronized block

        synchronization static
     */

    /*
        if static is synchronized no thread can enter other static block
     */

    /*

     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.pow(2,3));

        Thread thread = Thread.currentThread();
        thread.setPriority(1);
        System.out.println(thread);

        Thread thread1 = new Thread();
        System.out.println(thread.getThreadGroup());

        thread1.wait();
        System.out.println("Watied");
    }
}
