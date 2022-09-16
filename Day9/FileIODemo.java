package Day9;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileIODemo {
    /*
        Byte Hierarchy
        Character Hierarchy
     */

    public static void main(String[] args) throws IOException {
        File f = new File("first.txt");
//        System.out.println(f.canWrite());
//        System.out.println(f.canRead());

//        //FileOutputStream - Byte Hierarchy
//        FileOutputStream fileOutputStream = new FileOutputStream("first.txt");
//        fileOutputStream.close();
//        //Need to have bytes to store data in file
//        FileOutputStream fos = new FileOutputStream("first.txt", true);
//        byte[] data = " Appending data".getBytes();
//        try{
//            fos.write(data);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //File Writer - Character
        //File reader - Character, important to close, without it the data would not be added in CH

        try (FileInputStream fin = new FileInputStream(new File("first.txt")); ){
            int i = 0;
            while((i = fin.read()) != -1)
                System.out.print((char) i);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();

        //Adding from fileoutputstream
        try (FileOutputStream fos = new FileOutputStream(new File("first.txt"), true)) {
            String str = "\nThis is added from file output stream.";
            fos.write(str.getBytes(StandardCharsets.UTF_8));
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
