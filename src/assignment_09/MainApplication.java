package assignment_09;

import java.util.*;

/**
 * This class represents application that show how
 * {@link BinaryTree} is implemented
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 9th 2021
 * */
public class MainApplication {

    /**
     * Static field to contain all function with {@link Integer} key
     * to represent function order in the app menu, then {@link Function}
     * as a value
     * */
    private static HashMap<Integer, Function> functions;

    /** Static field to contain the main data of this application */
    private static BinaryTree<Integer> data;

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
     * This method is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {
        initApp();
        programMenu();
    }

    /**
     * This method is used to initialize the app
     * by initialize the main data and configure all
     * possible function to be executed in the app
     * */
    private static void initApp() {
        data = new BinaryTree<>();
        functions = new HashMap<>();
        functions.put(1, new Function("Add Data", MainApplication::addData));
        functions.put(2, new Function("Remove Data", MainApplication::removeData));
        functions.put(3, new Function("Search Data", MainApplication::searchData));
        functions.put(4, new Function("Inorder Traverse", MainApplication::displayInorder));
        functions.put(5, new Function("Preorder Traverse", MainApplication::displayPreorder));
        functions.put(6, new Function("Postorder Traverse", MainApplication::displayPostorder));
        functions.put(7, new Function("Program Exit", MainApplication::programExit));
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
     * This is a utility method to inorder traverse value of {@link #data}
     * */
    private static void displayInorder(){
        System.out.println("----------| Inorder Traverse |----------");
        System.out.print("Inorder Traverse : "); data.inorderTraverse();
        System.out.println("\nTotal Data       : " + data.size());
        System.out.println("----------------------------------------");
    }

    /**
     * This is a utility method to preorder traverse value of {@link #data}
     * */
    private static void displayPreorder(){
        System.out.println("----------| Preorder Traverse |----------");
        System.out.print("Inorder Traverse : "); data.preorderTraverse();
        System.out.println("\nTotal Data       : " + data.size());
        System.out.println("-----------------------------------------");
    }

    /**
     * This is a utility method to postorder traverse value of {@link #data}
     * */
    private static void displayPostorder(){
        System.out.println("----------| Postorder Traverse |----------");
        System.out.print("Inorder Traverse : "); data.postorderTraverse();
        System.out.println("\nTotal Data       : " + data.size());
        System.out.println("------------------------------------------");
    }

    /**
     * This method is used to insert the data to the bst.
     * */
    private static void addData() {
        int tempData = promptInt("Input the data to be inserted: ");
        data.insert(tempData);
    }

    /**
     * This method is used to remove data in the bst.
     * */
    private static void removeData() {
        int tempData = promptInt("Input data to be deleted : ");
        data.remove(tempData);
    }

    private static void searchData() {
        int tempData = promptInt("Input data to be looked for : ");
        System.out.println(tempData + (data.find(tempData) ? " found " : " not found ") + "in the tree");
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
        int indexMenu = promptInt("Choose Menu [1 - 7]: ");

        if (1 <= indexMenu && indexMenu <= 7)
            functions.get(indexMenu).run();

        programMenu();
    }
}
