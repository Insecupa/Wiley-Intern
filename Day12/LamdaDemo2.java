package Day12;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LamdaDemo2 {
    public static void main(String[] args) {
//        Consumer<String> s = (data)-> System.out.println(data);
//        s.accept("PP");

//        int a = 10;
//        int b = 20;
//        myFuncInter my = (c, d) -> {
//            return c + d;
//        };
//        System.out.println(my.add(a, b));
//    }

        Predicate<String> pr = (data) ->{
            return data.equals("Hello");
        };

        System.out.println(pr.test("Hello"));
    }
}
