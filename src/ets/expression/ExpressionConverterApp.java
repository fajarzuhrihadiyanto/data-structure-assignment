package ets.expression;

import java.util.Scanner;

/**
 * This class represents console application for converting expression
 * from infix expression to postfix expression
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 * */
public class ExpressionConverterApp {

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
