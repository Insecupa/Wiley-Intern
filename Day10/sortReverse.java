package Day10;

import java.util.Comparator;

public class sortReverse implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getId().compareTo(o1.getId());
    }
}
