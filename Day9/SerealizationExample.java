package Day9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerealizationExample{
    public static void main(String[] args) {
        try{
            FileOutputStream fileStream = new FileOutputStream("myGame.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
