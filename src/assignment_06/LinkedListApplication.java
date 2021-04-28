package assignment_06;

import java.util.*;

/**
 * This class represents application that show how
 * {@link LinkedList} is implemented
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since 28th April 2021
 * */
public class LinkedListApplication {

    /**
     * Static field to contain all function with {@link Integer} key
     * to represent function order in the app menu, then {@link Function}
     * as a value
     * */
    private static HashMap<Integer, Function> functions;

    /** Static field to contain the main data of this application */
    private static LinkedList<String> data;

    /**
     * This static class represents function object
     * */
    static class Function {

        /**
         * Field to contain string representation of function as
         * function name to be shown in the app menu
         * */
        private final String name;

        /** Field to contain function to be executed */
        private final Runnable function;

        /**
         * This construction is used to initialize {@link Function} object
         *
         * @param name {@link String} representation of the function object
         * @param function {@link Runnable} object of function to be executed
         * */
        Function(String name, Runnable function) {
            this.name = name;
            this.function = function;
        }

        /**
         * This method is used to get the name of the function
         *
         * @return field {@link #name}
         * */
        public String getName() {
            return this.name;
        }

        /**
         * This method is used to run the {@link #function} field
         * */
        void run() {
            this.function.run();
        }
    }

    /**
     * This method is used to initialize the app
     * by initialize the main data and configure all
     * possible function to be executed in the app
     * */
    private static void initApp() {
        data = new LinkedList<>();
        functions = new HashMap<>();
        functions.put(1, new Function("Add Data", LinkedListApplication::addData));
        functions.put(2, new Function("Add Data at First", LinkedListApplication::addDataToFirst));
        functions.put(3, new Function("Add Data at Last", LinkedListApplication::addDataToLast));
        functions.put(4, new Function("Add Data at N Index", LinkedListApplication::addDataAtLocation));
        functions.put(5, new Function("Remove Data at N Index", LinkedListApplication::removeData));
        functions.put(6, new Function("Remove Data at First", LinkedListApplication::removeDataAtFirst));
        functions.put(7, new Function("Remove Data at Last", LinkedListApplication::removeDataAtLast));
        functions.put(8, new Function("Remove Data by Data Content", LinkedListApplication::removeDataByContent));
        functions.put(9, new Function("Program Exit", LinkedListApplication::programExit));
    }

    /**
     * This method is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {

        initApp();
        programMenu();

    }

    /**
     * This is a utility method to get a new {@link Scanner} object
     *
     * @return new {@link Scanner} object
     * */
    private static Scanner scanner() {
        return new Scanner(System.in);
    }

    /**
     * This is a utility method to prompt an integer data and return that value.
     * This method will reprompt if the input is not an integer.
     *
     * @param message prompt message to be shown
     * @return int data inputted by user
     * */
    private static int promptInt(String message) {
        int value;
        while(true) {
            System.out.print(message);
            try {
                value = scanner().nextInt();
                return value;
            } catch(InputMismatchException e) {
                System.out.println("Input must be an integer!");
            }
        }
    }

    /**
     * This is a utility method to prompt a string data and return that value
     *
     * @param message prompt message to be shown
     * @return string data inputted by user
     * */
    private static String promptString(String message) {
        System.out.print(message);
        return scanner().nextLine();
    }

    /**
     * This is a utility method to display current value of {@link #data}
     * */
    private static void displayData(){
        System.out.println("----------| Current Data |----------");
        System.out.println("Data in the list : " + data);
        System.out.println("Total Data       : " + data.size());
        System.out.println("------------------------------------");
    }

    /**
     * This method is used to insert the data by default (at last).
     * */
    private static void addData() {
        String tempData = promptString("Input the data to be inserted: ");
        data.add(tempData);
        displayData();
    }

    /**
     * This method is used to insert the data at a certain index.
     * */
    private static void addDataAtLocation() {
        displayData();
        int indexData = promptInt("Input index of data to be inserted by new data: [0 - " + (data.size() - 1) + "]: ");
        String tempData = promptString("Data to be inserted at index " + indexData + ": ");
        data.add(indexData, tempData);
        displayData();
    }

    /**
     * This method is used to insert the data at first.
     * */
    private static void addDataToFirst() {
        String tempData = promptString("Input the data to be inserted at first: ");
        data.addFirst(tempData);
        displayData();
    }

    /**
     * This method is used to insert the data at last.
     * */
    private static void addDataToLast() {
        String tempData = promptString("Input the data to be inserted at last: ");
        data.addLast(tempData);
        displayData();
    }

    /**
     * This method is used to find out if some value is in the main data.
     *
     * @return {@code true} if main data contains given value, else {@code false}
     * */
    private static boolean searchData(String value) {
        return data.contains(value);
    }

    /**
     * This method is used to remove data by index.
     * */
    private static void removeData() {
        displayData();
        int indexData = promptInt("Input index of data to be deleted: [0 - " + (data.size() - 1) + "]: ");
        data.remove(indexData);
        displayData();
    }

    /**
     * This method is used to remove data at first.
     * */
    private static void removeDataAtFirst() {
        data.removeFirst();
        displayData();
    }

    /**
     * This method is used to remove data at last.
     * */
    private static void removeDataAtLast() {
        data.removeLast();
        displayData();
    }

    /**
     * This method is used to remove data by it's content
     * */
    private static void removeDataByContent() {
        displayData();
        String value = promptString("Input data to be deleted: ");

        if(searchData(value))
            data.remove(value);
        else
            System.out.println("Please input data which is in the list !");

        displayData();
    }

    /**
     * This method is used to exit the application.
     * */
    private static void programExit() {
        System.exit(0);
    }

    /**
     * This method is used to display the program menu.
     * */
    private static void programMenu() {
        System.out.println("==========| PROGRAM MENU |==========");

        for (Map.Entry<Integer, Function> fun: functions.entrySet()) {
            System.out.println(fun.getKey() + ". " + fun.getValue().getName());
        }
        programSwitcher();
    }

    /**
     * This method is used to get menu index inputted by user
     * then, run the corresponding function.
     * */
    private static void programSwitcher() {
        int indexMenu = promptInt("Choose Menu [1 - 9]: ");

        if (1 <= indexMenu && indexMenu <= 9)
            functions.get(indexMenu).run();

        programMenu();
    }
}
