package assignment_11;

import javafx.util.Pair;

import java.util.*;

/**
 * This class represents application that show how
 * {@link Hashtable} is implemented
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 20th 2021
 * */
public class MainApplication {

    /**
     * Static field to contain all function with {@link Integer} key
     * to represent function order in the app menu, then {@link Pair}
     * of {@link String} and {@link Runnable} as a representation of function
     * */
    private static HashMap<Integer, Pair<String, Runnable>> functions;

    /** Static field to contain the main data of this application */
    private static PhoneBook data;

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
        data = new PhoneBook();
        functions = new HashMap<>();

        functions.put(1, new Pair<>("Add data", MainApplication::addData));
        functions.put(2, new Pair<>("Check number", MainApplication::checkNumber));
        functions.put(3, new Pair<>("Edit data", MainApplication::editData));
        functions.put(4, new Pair<>("Remove data", MainApplication::removeData));
        functions.put(5, new Pair<>("Exit application", MainApplication::programExit));
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
     * This method is used to check if data exist by person's name.
     * If data exist, show name and phone number
     * */
    private static void checkNumber() {
        String name = promptString("Enter name to be looked for the number : ");
        PhoneNumber phone = data.getByKey(name);

        if (phone != null) {
            System.out.println("DATA FOUND");
            System.out.println("Name         : " + name);
            System.out.println("Phone number : " + phone);
        } else {
            System.out.println("DATA NOT FOUND !!!");
        }
    }

    /**
     * This method is used to add new data to the phone book
     * */
    private static void addData() {
        String name = promptString("Enter name         : ");
        int phoneCode = promptInt("Enter phone code   : ");
        String phoneNumber = promptString("Enter phone number : ");

        PhoneNumber phone = new PhoneNumber(phoneCode, phoneNumber);

        if (data.put(name, phone)) {
            System.out.println("Data added successfully ");
            System.out.println("Name         : " + name);
            System.out.println("Phone number : " + phone);
        } else {
            System.out.println("ADDITION FAILED !!!");
        }
    }

    /**
     * This method is used to edit phone number from phone book
     * by given name
     * */
    private static void editData() {
        String name = promptString("Enter name to be edited the phone number : ");

        if (data.hasKey(name)) {
            int newPhoneCode = promptInt("Enter new phone code   : ");
            String newPhoneNumber = promptString("Enter new phone number : ");

            PhoneNumber phone = new PhoneNumber(newPhoneCode, newPhoneNumber);

            data.editByKey(name, phone);
        } else {
            System.out.println("DATA NOT FOUND !!!");
        }
    }

    /**
     * This method is used to remove data from phone book
     * by given name
     * */
    private static void removeData() {
        String name = promptString("Enter name to be removed :");

        if (data.removeByKey(name)) {
            System.out.println("DATA REMOVED SUCCESSFULLY");
        } else {
            System.out.println("DATA NOT FOUND !!!");
        }
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

        for (Map.Entry<Integer, Pair<String, Runnable>> fun: functions.entrySet()) {
            System.out.println(fun.getKey() + ". " + fun.getValue().getKey());
        }
        programSwitcher();
    }

    /**
     * This method is used to get menu index inputted by user
     * then, run the corresponding function.
     * */
    private static void programSwitcher() {
        int indexMenu = promptInt("Choose Menu [1 - 5]: ");

        if (1 <= indexMenu && indexMenu <= 5)
            functions.get(indexMenu).getValue().run();

        programMenu();
    }
}
