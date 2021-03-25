/**
 * High Array Program
 * Program to implement ordered array type using class
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since March 25th 2021
 * */

package assignment_02;

/**
 * Class Person
 * Description :
 *      This class represents person object.
 *
 * Methods :
 *      public void displayPerson()
 *      public String getLastName()
 * */
class Person {

    private final String lastName;      // REPRESENTS LAST NAME OF THE PERSON
    private final String firstName;     // REPRESENTS FIRST NAME OF THE PERSON
    private final int age;              // REPRESENTS AGE OF THE PERSON

    /**
     * Constructor
     * Description :
     *      Constructor will create new Person with the given lastname, firstname, and age.
     *
     * @param last lastname of the person.
     * @param first firstname of the person.
     * @param age age of the person.
     * */
    public Person(String last, String first, int age){
        lastName = last;
        firstName = first;
        this.age = age;
    }

    /**
     * Method displayPerson
     * Description :
     *      This method will display all information of the person (firstname, lastname, and age).
     * */
    public void displayPerson(){
        System.out.println("Last name : " + lastName);
        System.out.println("First name : " + firstName);
        System.out.println("Age : " + age);
    }

    /**
     * Method getLastName
     * Description :
     *      This method will return lastname of the person.
     *
     * @return lastname of the person.
     * */
    public String getLastName(){
        return lastName;
    }
}

/**
 * Class ClassDataArray
 * Description:
 *      This class represents array of person type.
 *
 * Methods:
 *      public Person find(String searchName)
 *      public void insert(String last, String first, int age)
 *      public boolean delete(String searchName)
 *      public void display()
 * */
public class ClassDataArray {

    private final Person[] array;       // REPRESENTS MAIN DATA
    private int nElems;                 // REPRESENTS NUMBER OF THE ELEMENTS OF THE MAIN DATA

    /**
     * Constructor
     * Description :
     *      Constructor will create new person array with a specific size.
     *
     * @param size size of the array.
     * */
    public ClassDataArray(int size){
        array = new Person[size];
        nElems = 0;
    }

    /**
     * Method find
     * Description :
     *      This method is used to search person from the array by lastname.
     *
     * @param searchName lastname of the person to be looked for from the array.
     * @return person object if found, else null.
     * */
    public Person find(String searchName){
        int j;
        for (j = 0; j < nElems; j++){
            if(array[j].getLastName().equalsIgnoreCase(searchName)){
                return array[j];
            }
        }
        return null;
    }

    /**
     * Method insert
     * Description :
     *      This method is used to insert element to the array.
     *
     * @param last lastname of the person to be added to the array.
     * @param first firstname of the person to be added to the array.
     * @param age age of the person to be added to the array.
     * */
    public void insert(String last, String first, int age){
         array[nElems] = new Person(last, first, age);
         nElems++;
    }

    /**
     * Method delete
     * Description :
     *      This method is used to delete element from the array by lastname.
     *
     * @param searchName lastname of the person to be deleted from the array.
     * @return true if person found and deleted, else false.
     * */
    public boolean delete(String searchName){
        int j;
        for(j = 0; j < nElems; j++){
            if(array[j].getLastName().equalsIgnoreCase(searchName)){
                break;
            }
        }

        if(j == nElems){
            return false;
        }

        for(int k = j; k < nElems; k++){
            array[k] = array[k+1];
        }

        nElems--;
        return false;

    }

    /**
     * Method display
     * Description :
     *      This method is used to display all person of the array.
     * */
    public void display(){
        for(int j = 0; j < nElems; j++){
            array[j].displayPerson();
        }
    }

}

/**
 * Class ClassDataApp
 * Description:
 *      This class is used as main console application.
 *
 * Methods:
 *      public static void main(String[] args)
 * */
class ClassDataApp {

    /**
     * Main Method
     * Description:
     *      This method is used as main method.
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args){
        // INITIALIZE THE ARRAY
        int maxSize = 100;
        ClassDataArray arr;
        arr = new ClassDataArray(maxSize);

        // ADD 10 ELEMENTS TO THE ARRAY
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Loraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        // DISPLAY ALL ELEMENTS OF THE ARRAY
        arr.display();

        // SEARCH ELEMENT FROM THE ARRAY
        String searchKey = "Stimson";
        Person found = arr.find(searchKey);
        if(found != null){
            System.out.println("Found");
            found.displayPerson();
        } else {
            System.out.println("Can't find " + searchKey);
        }

        // DELETE SOME ELEMENTS FROM THE ARRAY
        System.out.println("Deleting Smith, Yee, and Creswell");
        arr.delete("Smith");
        arr.delete("Yee");
        arr.delete("Creswell");

        // DISPLAY CURRENT ELEMENTS OF THE ARRAY
        arr.display();
    }
}
