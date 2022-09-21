package Day12;


import java.util.ArrayList;
import java.util.List;

public class ComparatorDemo2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("102", "Anil"));
        students.add(new Student("105", "Baig"));
        students.add(new Student("101", "Won"));
        students.add(new Student("104", "Kenny"));
        students.add(new Student("103", "Craig"));

        printCondition(students, new Condition() {
            @Override
            public boolean compare(Student s) {
                if((s.getId().compareTo("102")) > 0)
                    return true;
                return false;
            }
        });
    }

    public static void printCondition(List<Student> studentList, Condition condition){
        for(Student student : studentList){
            if(condition.compare(student)){
                System.out.println(student);
            }
        }
    }
}
