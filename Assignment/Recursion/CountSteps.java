package Day13.Assignment.Recursion;

public class CountSteps {
    public static int steps(int n){
        if(n == 0)
            return 1;
        else if(n < 0)
            return 0;

        return steps(n - 3) + steps(n - 2) + steps(n - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(steps(n));
    }
}
