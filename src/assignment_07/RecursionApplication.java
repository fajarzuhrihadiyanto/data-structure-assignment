package assignment_07;

public class RecursionApplication {

    static int count = 0;

    static void p() {
        if (++count <= 5) {
            System.out.println("Hello " + count);
            p();
        }
    }

    public static void main(String[] args) {
        p();
    }

}
