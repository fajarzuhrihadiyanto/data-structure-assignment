package ets.dataStructure;

/**
 * This class represents primitive data types demonstration
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 * */
public class Primitive {

    /**
     * This is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {
        // BOOLEAN
        int a = 10;
        int b = 8;
        boolean isTrue = a > b;
        System.out.println(a + " > " + b + " is " + isTrue);

        // BYTE
        byte age = 20;
        System.out.println("age : " + age);

        // CHAR
        char firstChar = 'A';
        System.out.println("First alphabet character : " + firstChar);

        // SHORT
        short height = 190;
        System.out.println("Height : " + height);

        // INT
        int num = 276325;
        System.out.println("Number : " + num);

        // LONG
        long population = 7155328792L;
        System.out.println("Current population : " + population);

        // FLOAT
        float weight = 61.5F;
        System.out.println("Weight (kg) : " + weight);

        // DOUBLE
        double netWorth = 251757488950.55;
        System.out.println("Net worth : " + netWorth);
    }
}
