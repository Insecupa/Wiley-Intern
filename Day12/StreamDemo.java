package Day12;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Anil"));
        students.add(new Student("105", "Baig"));
        students.add(new Student("101", "Won"));
        students.add(new Student("104", "Kenny"));
        students.add(new Student("103", "Craig"));

        students.stream().filter((student -> student.getId().endsWith("3"))).forEach((student -> System.out.println(student)));
        printCondition(students, (student) -> student.getId().equals("102"));
    }
    public static void printCondition(List<Student> studentList, Condition condition){
        for(Student student : studentList){
            if(condition.compare(student)){
                System.out.println(student);
            }
        }
    }


}
