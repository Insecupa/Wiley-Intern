package Day9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class DogMain {
    public static void main(String[] args) {
        Dogs dog = new Dogs(4, "m");
        Dogs dog3 = new Dogs(10, "f");
//
//        try{
//            FileOutputStream fos = new FileOutputStream("Dog.dat");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(dog);
//            oos.writeObject(dog3);
//            System.out.println("Object Serialized");
//            oos.close();
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }

        try{
            FileInputStream fis = new FileInputStream("Dog.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dogs dogs1 =(Dogs) ois.readObject();
            Dogs dogs2 =(Dogs) ois.readObject();
            System.out.println(dogs1.toString());
            System.out.println(dogs2);

            ois.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
