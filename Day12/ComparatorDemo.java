package Day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Anil"));
        students.add(new Student("105", "Baig"));
        students.add(new Student("101", "Won"));
        students.add(new Student("104", "Kenny"));
        students.add(new Student("103", "Craig"));

        //forEach is a terminal function
        //Optional is used when u are unsure if objects are created or not
        //Problem - even if a object is returned the returned object is also optional
        students.forEach((student) -> {
            System.out.println(student.getId() + " " + student.getName());
        });

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("Sorted based on names");
        students.forEach((student) -> {
            System.out.println(student.getId() + " " + student.getName());
        });

        System.out.println("Sorted based on number:");
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        students.forEach((student) -> {
            System.out.println(student.getId() + " " + student.getName());
        });

    }
}
