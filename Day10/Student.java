package Day10;

public class Student implements Comparable<Student> {
    String name;
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{Student Name: " + this.name + ", Student Id: " + this.id + "}";
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Invoked");
        Student o = (Student) obj;
        return this.name.equals(o.name) && this.id.equals(o.id);
    }

    @Override
    public int hashCode() {
//        return 1;
        return name.length();
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
