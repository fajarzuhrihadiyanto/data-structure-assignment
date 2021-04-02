/**
 * Bubble Sort Program
 * Program to implement bubble sort
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 31st 2021
 * */

package assignment_03;

import java.util.Scanner;

/**
 * Class BubbleSort
 * Description :
 *      This class is used as main console application.
 *
 * Methods :
 *      private static void bubbleSort(int[] array, int direction)
 *      public static void main(String[] args)
 * */
public class BubbleSort {

    /** Constant for ascending sorting configuration */
    private static final int SORT_DIRECTION_ASCENDING = 1;

    /** Constant for descending sorting configuration */
    private static final int SORT_DIRECTION_DESCENDING = -1;

    /** Constant for input handler */
    private static final Scanner input = new Scanner(System.in);

    /**
     * Method bubbleSort
     * Description :
     *      This method is used to sort an array in a specific direction
     *
     * @param array array to be sorted
     * @param direction direction of sorting, either {@value #SORT_DIRECTION_ASCENDING} or {@value #SORT_DIRECTION_DESCENDING}
     * */
    private static void bubbleSort(int[] array, int direction) {
        int n = array.length;
        int temp;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < (n - i); j++) {
                // PROGRAMMATICALLY CHANGING COMPARISON SIGN BY DIRECTION
                // IF DIRECTION IS 1 (ASC), COMPARISON SIGN WILL BE THE SAME AS IT WRITTEN
                // IF DIRECTION IS -1 (DESC), COMPARISON SIGN WILL BE THE OPPOSITE OF IT'S CODE
                if(direction * array[j - 1] > direction * array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * Main Method
     * Description :
     *      This method is used as main method.
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {
        try {
            // DECLARING ARRAY
            int[] array;

            // INPUT ARRAY
            System.out.print("How Many Element of Array to be sorted : ");
            int nElems = input.nextInt();
            array = new int[nElems];
            for (int i = 0; i < nElems; i++) {
                System.out.print("Element no-" + (i + 1) + " : ");
                array[i] = input.nextInt();
            }

            // INPUT SORTING DIRECTION
            System.out.print("Ascending [" + SORT_DIRECTION_ASCENDING + "] or Descending [" + SORT_DIRECTION_DESCENDING + "] : ");
            int direction = input.nextInt();
            if (direction != SORT_DIRECTION_ASCENDING && direction != SORT_DIRECTION_DESCENDING)
                throw new Exception("Invalid Direction");

            // PRINT ARRAY BEFORE SORTING
            System.out.println("Array Before Doing Bubble Sort");
            for (int j : array) System.out.print(j + " ");
            System.out.println();

            // SORT THE ARRAY
            bubbleSort(array, direction);

            // PRINT ARRAY AFTER SORTING
            System.out.println("Array After Doing Bubble Sort");
            for (int j : array) System.out.print(j + " ");

        } catch (Exception e){
            // IF ERROR, PRINT THE ERROR
            System.out.println("ERROR : " + e.getMessage());
        }
    }
}
