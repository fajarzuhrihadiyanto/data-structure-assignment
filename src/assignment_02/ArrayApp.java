/**
 * Array App Program
 * Program to implement an array type conventionally
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 25th 2021
 * */

package assignment_02;

/**
 * Class ArrayApp
 * Description :
 *      This class is used as main console application.
 *
 * Methods :
 *      public static void main(String[] args)
 * */
public class ArrayApp {

    /**
     * Main Method
     * Description :
     *      This method is used as main method.
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args){
        // INITIALIZE ARRAY VALUE AND SET THE NUMBER OF ELEMENTS BY ARRAY LENGTH
        long[] arr;
        arr = new long[] {77, 99, 44, 55, 22, 88, 11, 0, 66, 33};
        int nElems = arr.length;

        // DECLARE ANOTHER VARIABLE
        int j;
        long searchKey;

        // DISPLAY ALL ELEMENTS OF THE ARRAY
        for (j = 0; j < nElems; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        // SEARCH ELEMENT IN ARRAY
        searchKey = 66;
        for (j = 0; j < nElems; j++){
            if(arr[j] == searchKey){
                break;
            }
        }

        // DELETE FOUNDED ELEMENT
        for (int k = j; k < nElems; k++){
            arr[k] = arr[k+1];
        }
        nElems--;

        // DISPLAY CURRENT ARRAY ELEMENT
        for (j = 0; j < nElems; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
