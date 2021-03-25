/**
 * Ordered Array Program
 * Program to implement ordered array type using class
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 25th 2021
 * */

package assignment_02;

/**
 * Class OrderedArray
 * Description:
 *      This class represents an ordered array type.
 *
 * Methods :
 *      public int size()
 *      public int find(long searchKey)
 *      public void insert(long value)
 *      public boolean delete(long value)
 *      public void display()
 * */
public class OrderedArray {

    private final long[] array;     // REPRESENTS MAIN DATA
    private int nElems;             // REPRESENTS NUMBER OF THE ELEMENTS OF THE MAIN DATA

    /**
     * Constructor
     * Description :
     *      Constructor will create new array with a specific size.
     *
     * @param size size of the array.
     * */
    public OrderedArray(int size){
        array = new long[size];
        nElems = 0;
    }

    /**
     * Method size
     * Description :
     *      This method will return size of the array.
     *
     * @return field nElems that represents the size of the array.
     * */
    public int size() {
        return nElems;
    }

    /**
     * Method find
     * Description :
     *      This method is used to search element from the array.
     *      This method is using binary search method.
     *
     * @param searchKey key to be looked for from the array
     * @return index of the key if key found, else size of the array
     * */
    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curln;

        do {
           curln = (lowerBound + upperBound) / 2;
           if (array[curln] == searchKey){
               return curln;
           } else {
               if (array[curln] < searchKey) {
                   lowerBound = curln + 1;
               } else {
                   upperBound = curln - 1;
               }
           }
        } while(lowerBound <= upperBound);

        return nElems;
    }

    /**
     * Method insert
     * Description :
     *      This method is used to insert element to the array ordered by value
     *      by looking for index that have a greater value than a given value,
     *      then insert the given value before that value.
     *
     * @param value value to be inserted to the array.
     * */
    public void insert(long value){
        int j;
        for(j = 0; j < nElems; j++){
            if(array[j] > value){
                break;
            }
        }

        for (int k = nElems; k > j; k--){
            array[k] = array[k-1];
        }

        array[j] = value;
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
        int j = find(value);

        if (j == nElems) {
            return false;
        }

        for (int k = j; k < nElems; k++){
            array[k] = array[k+1];
        }
        nElems--;
        return true;
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
 * Class OrderedArrayApp
 * Description :
 *      This class is used as main console application.
 *
 * Methods:
 *      public static void main(String[] args)
 * */
class OrderedArrayApp {

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
        OrderedArray arr;
        arr = new OrderedArray(maxSize);

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

        // SEARCH ELEMENT FROM THE ARRAY
        long searchKey = 55;
        if(arr.find(searchKey) != arr.size()){
            System.out.println("Found : " + searchKey);
        } else {
            System.out.println("Can't find : " + searchKey);
        }

        // DISPLAY ALL ELEMENTS OF THE ARRAY
        arr.display();

        // DELETE SOME ELEMENT FROM THE ARRAY
        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        // DISPLAY CURRENT ELEMENT FROM THE ARRAY
        arr.display();
    }
}
