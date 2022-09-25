package Day13.Assignment.Recursion;

public class MagicNumber {
    public static int findMagic(int[] arr, int k) {
        if(arr[k] == k)
            return k;
        return findMagic(arr, ++k);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,2,5,5,5};
        System.out.println(findMagic(arr, 0));
    }
}
