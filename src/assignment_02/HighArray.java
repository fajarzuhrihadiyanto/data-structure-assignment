/**
 * High Array Program
 * Program to implement advanced array type using class
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 25th 2021
 * */

package assignment_02;

/**
 * Class HighArray
 * Description:
 *      This class represents an array type.
 *
 * Methods:
 *      public boolean find(long searchKey)
 *      public void insert(long value)
 *      public boolean delete(long value)
 *      public void display()
 * */
public class HighArray {
    private final long[] array;     // REPRESENTS MAIN DATA
    private int nElems;             // REPRESENTS NUMBER OF THE ELEMENTS OF THE MAIN DATA

    /**
     * Constructor
     * Description :
     *      Constructor will create new array with a specific size.
     *
     * @param size size of the array.
     * */
    public HighArray(int size){
        array = new long[size];
        nElems = 0;
    }

    /**
     * Method find
     * Description :
     *      This method is used to search element from the array.
     *
     * @param searchKey key to be looked for from the array.
     * @return true if key found, else false.
     * */
    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++){
            if (array[j] == searchKey) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method insert
     * Description :
     *      This method is used to insert element to a tail of the array.
     *
     * @param value value to be inserted to the array.
     * */
    public void insert(long value){
        array[nElems] = value;
        nElems++;
    }

    /**
     * Method delete
     * Description :
     *      This method is used to delete given value from the array.
     *
     * @param value value to be deleted from the array.
     * @return true if the given value is found and deleted, else false.
     * */
    public boolean delete(long value){
        int j;
        for (j = 0; j < nElems; j++){
            if(value == array[j]){
                break;
            }
        }
        if (j == nElems){
            return false;
        } else {
            for (int k = j; k < nElems; k++){
                array[k] = array[k+1];
            }
            nElems--;
            return true;
        }
    }

    /**
     * Method display
     * Description :
     *      This method is used to display all elements of the array.
     * */
    public void display(){
        for (int j = 0; j < nElems; j++){
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }
}

/**
 * Class HighArrayApp
 * Description :
 *      This class is used as main console application.
 *
 * Methods:
 *      public static void main(String[] args)
 * */
class HighArrayApp {

    /**
     * Main Method
     * Description :
     *      This method is used as main method.
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args){
        // INITIALIZE THE ARRAY
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        // ADD 10 ELEMENTS TO THE ARRAY
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        // DISPLAY ALL ELEMENTS OF THE ARRAY
        arr.display();

        // SEARCH ELEMENT FROM THE ARRAY
        long searchKey = 35;
        if(arr.find(searchKey)){
            System.out.println("Found : " + searchKey);
        } else {
            System.out.println("Can't find : " + searchKey);
        }

        // DELETE SOME ELEMENT FROM THE ARRAY
        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        // DISPLAY CURRENT ELEMENT FROM THE ARRAY
        arr.display();
    }
}
