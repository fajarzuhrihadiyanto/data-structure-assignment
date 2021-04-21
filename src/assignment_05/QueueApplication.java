package assignment_05;

import java.util.Scanner;

/**
 * This class is used as main console application
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since April 21st 2021
 * */
public class QueueApplication {

    /**
     * This is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {

        // PREPARATION
        String input, output;
        Scanner scanner = new Scanner(System.in);

        // GET THE INFIX EXPRESSION
        System.out.print("Input the infix expression : ");
        input = scanner.nextLine();

        // CONVERT INFIX TO POSTFIX EXPRESSION
        output = ExpressionConverter.infixToPostfix(input);

        // DISPLAY BOTH INFIX AND POSTFIX EXPRESSION
        System.out.println("Infix Expression   : " + input);
        System.out.println("Postfix Expression : " + output);
    }
}
