package assignment_07;

public class FactorialApplication {

    static long factorial(long n) {
        if (n == 1 || n == 0) return 1;

        return n * factorial(n - 1);

    }

    public static void main(String[] args) {
        System.out.println("factorial of 5 is " + factorial(31));
    }

}
