package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();

        arrList.add(10);
        arrList.add(100);
        arrList.add(70);
        arrList.add(1);
        arrList.add(30);
        arrList.add(2);

        for(Integer i : arrList){
            int data = i.intValue();
            System.out.println(data);
        }
        System.out.println();

        ListIterator<Integer> myListIterator = arrList.listIterator();
        while (myListIterator.hasNext()    ){
            System.out.println(myListIterator.next());
        }

        System.out.println();
        while(myListIterator.hasPrevious())
            System.out.println(myListIterator.previous());

        List<Integer> tempList = Arrays.asList(1,2,3,4,5);
        System.out.println(tempList);

        List<Student> students = Arrays.asList(new Student("John", "1A"), new Student("Graham", "1B"));
        System.out.println(students);
    }
}
