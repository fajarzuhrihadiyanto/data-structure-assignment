/**
 * Task 2 Calculator Program
 * Program that calculate a simple arithmetic
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 17th 2021
 */

package assignment_01;

import java.util.Scanner;


public class Calculator {

    // DECLARE VARIABLE
    static Scanner scanner;
    static int option;
    static double first;
    static double second;
    static double result;
    static char sign;
    static String repeat;

    // MAIN METHOD
    public static void main(String[] args){
        // INITIALIZE THE SCANNER
        scanner = new Scanner(System.in);

        do {
            try {
                // DISPLAY THE OPTION FOR SIMPLE CALCULATION
                System.out.println("==========| SIMPLE CALCULATOR |==========");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");

                // GET THE OPERATOR
                System.out.print("Choose calculation (1-4) : ");
                option = scanner.nextInt();

                // CHECK THE OPTION CHOSEN BY USER
                switch (option) {
                    case 1:
                        // IF 1, THEN GET THE OPERAND
                        input();

                        // THEN DO THE ADDITION
                        result = first + second;
                        sign = '+';
                        break;
                    case 2:
                        // IF 2, THEN GET THE OPERAND
                        input();

                        // THEN DO THE SUBTRACTION
                        result = first - second;
                        sign = '-';
                        break;
                    case 3:
                        // IF 3, THEN GET THE OPERAND
                        input();

                        // THEN DO THE MULTIPLICATION
                        result = first * second;
                        sign = '*';
                        break;
                    case 4:
                        // IF 4, THEN GET THE OPERAND
                        input();

                        // CHECK IF THE DENOMINATOR IS 0
                        if(second == 0){
                            // THEN THROW NEW ERROR
                            throw new Exception("DIVIDE BY ZERO");
                        }

                        // DO THE DIVISION
                        result = first / second;
                        sign = '/';
                        break;
                    default:
                        // IF NOT 1 - 4, THROW NEW ERROR
                        throw new Exception("INVALID OPTION");
                }

                // DISPLAY THE OUTPUT WITH A CERTAIN FORMAT
                System.out.println(first + " " + sign + " " + second + " = " + result);

                // ASK IF USER WANT TO TRY AGAIN
                System.out.print("Wanna try again [y/n] : ");
                repeat = scanner.next();
            } catch(Exception e){
                // IF ERROR, THEN PRINT THE ERROR MESSAGE
                // THEN DO AUTO REPEAT
                System.out.println("ERROR : " + e.getMessage());
                repeat = "y";
            }
        }
        // DO ALL OF THAT WHILE THE REPEAT IS "Y"
        while(repeat.equalsIgnoreCase("y"));

    }

    // INPUT METHOD
    private static void input(){
        // GET THE FIRST INPUT
        System.out.print("Input first number : ");
        first = scanner.nextDouble();

        // GET THE SECOND INPUT
        System.out.print("Input second number : ");
        second = scanner.nextDouble();
    }

}
