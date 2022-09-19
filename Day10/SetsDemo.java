package Day10;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();

//        set.add(22);
//        set.add(-2);
//        set.add(32);
//        set.add(62);
//        set.add(1);
//
//        System.out.println(set);

        Student s1 = new Student("John", "1A");
        Student s2 = new Student("Karl", "1B");
        Student s3 = new Student("Madison", "2A");
        Student s4 = new Student("Karl", "1B");
        Student s5 = new Student("Poot", "2B");

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        System.out.println(set);
    }
}
