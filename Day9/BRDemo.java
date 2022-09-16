package Day9;

import java.io.*;

//Buffered Reader
public class BRDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(new File("first.txt"));) {
            BufferedReader reader = new BufferedReader(fr);
            String lines = reader.readLine();
            while(lines != null) {
                System.out.println(lines);
                lines = reader.readLine();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

//        try (FileWriter fw = new FileWriter(new File("first.txt"))) {
//            fw.write("This is another line added.");
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }

        try (FileReader fr = new FileReader(new File("first.txt"));) {
            BufferedReader reader = new BufferedReader(fr);
            String lines = reader.readLine();
            while(lines != null) {
                System.out.println(lines);
                lines = reader.readLine();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }


        //Appending to a file using filewriterss
        try (FileWriter fw = new FileWriter(new File("first.txt"), true)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\nWrite this from buffered writer.");
            bw.newLine();
            bw.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
