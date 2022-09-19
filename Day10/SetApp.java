package Day10;

import java.util.Set;
import java.util.TreeSet;

public class SetApp {
    public static void main(String[] args) {
        Set<Integer> arrList = new TreeSet<>();

        arrList.add(10);
        arrList.add(100);
        arrList.add(70);
        arrList.add(1);
        arrList.add(30);
        arrList.add(2);

        for(Integer i : arrList){
            System.out.println(i.intValue());
        }
    }
}
