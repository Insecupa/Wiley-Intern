package Day13.Assignment.LinkedListMap;

import java.util.LinkedList;
import java.util.TreeSet;

public class NulsAndBolts {
    public static int partition(char[] arr, int low, int high){
        char pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        char temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;
    }
    public static void sort(char[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);

            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }
    public static void main(String[] args) {
        char[] bolts= new char[]{'@','#','$','%','&'};
        char[] nuts = new char[]{'$', '%', '#', '&', '@'};

        for (char bolt : bolts) {
            System.out.print(bolt + " ");
        }
        System.out.println();

        for (char nut : nuts) {
            System.out.print(nut + " ");
        }
        System.out.println();
        sort(bolts, 0, bolts.length - 1);
        sort(nuts, 0, nuts.length - 1);

        for (char bolt : bolts) {
            System.out.print(bolt + " ");
        }
        System.out.println();

        for (char nut : nuts) {
            System.out.print(nut + " ");
        }
    }
}
