package Day10;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();

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

        List<Student> studentList = new ArrayList<>();
        studentList.addAll(set);
        System.out.println();
        System.out.println(studentList);
        System.out.println();
        Collections.sort(studentList, new sortReverse());
        System.out.println(studentList);
    }
}
