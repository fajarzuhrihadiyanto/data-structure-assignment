package ets.expression;

import java.util.Stack;

/**
 * This class represents expression converter tools
 * between infix and postfix
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 * */
public class ExpressionConverter {

    /**
     * This method is used to get the precedence level of the operator
     *
     * @param operator operator to be looked for the precedence level
     * @return precedence level of the operator
     * */
    private static int precedence(char operator){
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    /**
     * This method is used to convert infix expression to postfix expression
     *
     * @param expression infix expression to be converted
     * @return postfix expression
     * */
    public static String infixToPostfix(String expression) {

        // PREPARE NEW STACK FOR OPERATOR AND
        // STRING FOR THE FINAL RESULT
        Stack<Character> operator = new Stack<>();
        StringBuilder result = new StringBuilder();

        // REPEAT FOR EACH CHARACTER IN THE EXPRESSION
        for (char a: expression.toCharArray()) {

            // IF CHARACTER IS A LETTER OR A DIGIT ...
            if(Character.isLetterOrDigit(a)) {

                // ... JUST PUSH IT TO THE FINAL RESULT
                result.append(a);
            }
            // IF CHARACTER IS AN OPENING PARENTHESES ...
            else if(a == '(') {

                // ... PUSH IT TO THE OPERATOR STACK
                operator.push(a);
            }
            // IF CHARACTER IS A CLOSING PARENTHESES ...
            else if(a == ')') {

                // ... MOVE ALL OPERATORS BETWEEN THIS CLOSING AND
                // NEAREST OPENING PARENTHESES TO THE FINAL RESULT ...
                while(operator.size() != 0 && operator.peek() != '(') {
                    result.append(operator.pop());
                }

                // ... AND ALSO THROW THE OPENING PARENTHESES
                operator.pop();
            }
            // IF CHARACTER IS AN ARITHMETIC OPERATOR ...
            else {

                // ... MOVE ALL OPERATORS IN STACK THAT HAVE
                // PRECEDENCE LOWER OR EQUAL TO THIS OPERATOR ...
                while(operator.size() != 0 && precedence(a) <= precedence(operator.peek())) {
                    result.append(operator.pop());
                }

                // ... THEN, PUSH THE CHARACTER TO THE STACK
                operator.push(a);
            }
        }

        // MOVE THE REST OPERATORS TO THE QUEUE
        while(operator.size() != 0) {
            if(operator.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(operator.pop());
        }

        // RETURN THE RESULT IN STRING
        return result.toString();
    }
}
