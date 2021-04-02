/**
 * Selection Sort Program
 * Program to implement selection sort
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 31st 2021
 * */

package assignment_03;

import java.util.*;

/**
 * Class SelectionSort
 * Description :
 *      This class is used as main console application.
 *
 * Methods :
 *      private static void selectionSort(int[] array, int direction)
 *      public static void main(String[] args)
 * */
public class SelectionSort {

    /** Constant for ascending sorting configuration */
    private static final int SORT_DIRECTION_ASCENDING = 1;

    /** Constant for descending sorting configuration */
    private static final int SORT_DIRECTION_DESCENDING = -1;

    /** Constant for input handler */
    private static final Scanner input = new Scanner(System.in);

    /**
     * Method selectionSort
     * Description :
     *      This method is used to sort an array in a specific direction
     *
     * @param array array to be sorted
     * @param direction direction of sorting, either {@value #SORT_DIRECTION_ASCENDING} or {@value #SORT_DIRECTION_DESCENDING}
     * */
    private static void selectionSort(int[] array, int direction) {
        int n=array.length;
        for(int i = 0; i < n - 1; i++) {
            int tempIndex = i;

            for(int j = i + 1; j < n; j++)
                // PROGRAMMATICALLY CHANGING COMPARISON SIGN BY DIRECTION
                // IF DIRECTION IS 1 (ASC), COMPARISON SIGN WILL BE THE SAME AS IT WRITTEN
                // IF DIRECTION IS -1 (DESC), COMPARISON SIGN WILL BE THE OPPOSITE OF IT'S CODE
                if(direction * array[j] < direction * array[tempIndex]) tempIndex=j;

            int temp=array[i];
            array[i] = array[tempIndex];
            array[tempIndex] = temp;
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
            if (direction != SORT_DIRECTION_ASCENDING && direction != SORT_DIRECTION_DESCENDING) {
                throw new Exception("Invalid Direction");
            }

            // PRINT ARRAY BEFORE SORTING
            System.out.println("Elements in the array before Sorting: " + Arrays.toString(array));

            // SORT THE ARRAY
            selectionSort(array, direction);

            // PRINT ARRAY AFTER SORTING
            System.out.println("Elements in the array after Sorting: " + Arrays.toString(array));
        } catch (Exception e){
            // IF ERROR, PRINT THE ERROR
            System.out.println("ERROR : " + e.getMessage());
        }
    }
}
