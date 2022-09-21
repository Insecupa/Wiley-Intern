package Day12;

public interface Person {
    public void talk();

    public default void breathe() {
        System.out.println("BReathign");
    }
//
//    public void breathe(String s);

    public static void live(){
        System.out.println("Living");
    }
}
