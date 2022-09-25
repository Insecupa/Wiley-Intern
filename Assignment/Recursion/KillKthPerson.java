package Day13.Assignment.Recursion;

public class KillKthPerson {
    public static int kill(int n, int k) {
        if(n == 1)
            return 1;
        return (kill(n - 1, k)  + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        System.out.println(kill(5, 3));
    }
}
