/**
 * Low Array Program
 * Program to implement basic array type using class
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 25th 2021
 * */

package assignment_02;

/**
 * Class LowArray
 * Description :
 *      This class represents an array type.
 *
 * Methods :
 *      public void setElem(int index, long value)
 *      public long getElem(int index)
 * */
public class LowArray {
    private final long[] array;     // REPRESENTS MAIN DATA

    /**
     * Constructor
     * Description :
     *      Constructor will create new array with a specific size.
     *
     * @param size size of the array.
     * */
    public LowArray(int size){
        array = new long[size];
    }

    /**
     * Method setElem
     * Description :
     *      This method will set the specific index
     *      of the array with the specific value.
     *
     * @param index index of the array to be set.
     * @param value value to be inserted to the array.
     * */
    public void setElem(int index, long value){
        array[index] = value;
    }

    /**
     * Method getElem
     * Description :
     *      This method will return specific element
     *      of the array from the given index.
     *
     * @param index index of the array to be gotten.
     * @return element of the array with the given index.
     * */
    public long getElem(int index){
        return array[index];
    }
}

/**
 * Class LowArrayApp
 * Description :
 *      This class is used as main console application.
 *
 * Methods :
 *      public static void main(String[] args)
 * */
class LowArrayApp {

    /**
     * Main Method
     * Description :
     *      This method is used as main method.
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args){
        // INITIALIZE ARRAY OBJECT
        LowArray arr;
        arr = new LowArray(100);
        int nElems;

        // DECLARE ANOTHER VARIABLE
        int j;

        // ADD 10 ELEMENTS TO THE ARRAY
        arr.setElem(0, 77);
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 66);
        arr.setElem(8, 0);
        arr.setElem(9, 33);
        nElems = 10;

        // DISPLAY ALL ELEMENTS OF THE ARRAY
        for(j = 0; j < nElems; j++){
            System.out.print(arr.getElem(j) + " ");
        }
        System.out.println();

        // SEARCH ELEMENT FROM THE ARRAY
        int searchKey = 26;
        for (j = 0; j < nElems; j++){
            if (arr.getElem(j) == searchKey){
                break;
            }
        }

        if (j == nElems){
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        // SEARCH ELEMENT FROM THE ARRAY TO BE DELETED
        for (j = 0; j < nElems; j++){
            if(arr.getElem(j) == 55){
                break;
            }
        }

        // DELETE THAT ELEMENT FROM THE ARRAY
        for (int k = j; k < nElems; k++){
            arr.setElem(k, arr.getElem(k+1));
        }
        nElems--;

        // DISPLAY CURRENT ARRAY ELEMENTS
        for(j = 0; j < nElems; j++){
            System.out.print(arr.getElem(j) + " ");
        }
        System.out.println();
    }
}
