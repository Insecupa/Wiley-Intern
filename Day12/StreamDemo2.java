package Day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Anil"));
        students.add(new Student("105", "Baig"));
        students.add(new Student("101", "Won"));
        students.add(new Student("104", "Kenny"));
        students.add(new Student("103", "Craig"));

        students.stream().filter((student) -> student.getId().compareTo("102") > 0).forEach((s) -> System.out.println(s));

        long count = students.stream().filter((student) -> student.getId().compareTo("102") > 0).count();
        System.out.println(count);

        students.stream().filter((student) -> student.getId().compareTo("102") > 0)
                .filter((s) -> s.getName().charAt(0) >= 'C').forEach(s -> System.out.println(s));

        List<String> studentGreatherThan102 = students.stream().
                filter((student) -> student.getId().compareTo("102") > 0).
                map(Student::getName).collect(Collectors.toList());

        studentGreatherThan102.forEach(System.out::println);

        Collections.sort(students, ((o1, o2) -> o1.getId().compareTo(o2.getId())));
        students.forEach(System.out::println);
    }
}
