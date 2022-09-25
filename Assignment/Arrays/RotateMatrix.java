package Day13.Assignment.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateMatrix {
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
        List<List<Integer>> ans = new ArrayList<>();


        for(int i = n - 1; i >= 0; i--){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add(mat.get(j).get(i));
            }

            ans.add(temp);
        }

        ans.stream().forEach(data -> data.stream().forEach(System.out::print));
    }
}
