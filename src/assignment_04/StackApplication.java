package assignment_04;

/**
 * This class is used as main console application
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since April 9th 2021
 * */
public class StackApplication {

    /**
     * This is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {

        // PREPARE STACK
        Stack<String> stack = new Stack<>();

        // PUSH DATA TO STACK
        stack.push("Fajar");
        stack.push("Zuhri");
        stack.push("Hadiyanto");

        // GET NUMBER OF ELEMENT IN STACK
        int count = stack.count();
        System.out.println("Number of data in stack : " + count);

        // GET TOP DATA FROM STACK
        String object = stack.peek();
        System.out.println("Top data in stack : " + object);

        // POP STACK AND PRINT THAT ELEMENT
        object = stack.pop();
        System.out.println("Object popped from stack : " + object);

        // RECOUNT THE NUMBER OF STACK
        count = stack.count();
        System.out.println("Number of data in current stack : " + count);

        // GET TOP DATA FROM STACK
        object = stack.peek();
        System.out.println("Top data in current stack : " + object);
    }
}
