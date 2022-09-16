package Day9;

import java.io.*;

public class Box implements Serializable {
    private int width;
    private int height;

    public Box(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public String toString() {
        return "Height: " + this.height + ", Width: " + this.width;
    }

    public static void main(String[] args) {
        Box mBox = new Box(11,12);
        try {
            FileOutputStream fis = new FileOutputStream("Saving.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(mBox);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("Saving.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
