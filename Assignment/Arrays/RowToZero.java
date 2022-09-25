package Day13.Assignment.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RowToZero {
    public static void main(String[] args) {
        List<List<Integer>> mat = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        for(int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add(scanner.nextInt());
            }

            mat.add(temp);
        }

        for(int i = 0; i < mat.size(); i++){
            List<Integer> tempList = mat.get(i);
            if(tempList.contains(0))
                Collections.fill(tempList, 0);
        }

        //mat.stream().forEach(data -> data.stream().forEach(System.out::print));
    }
}
