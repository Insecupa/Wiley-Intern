package Day11;



public class GenMethod {
    static <T> void print(T data){
        System.out.println("Data : " + data);
    }

    static <T> T getData(T data){
        T thing = (T) ("Hello there : " + data);
        return thing;
    }
    public static void main(String[] args) {
        print(2);
        System.out.println(getData("2.3" + 4.6));

    }
}
