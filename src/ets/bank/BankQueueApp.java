package ets.bank;

import java.util.*;

/**
 * This class represents console application of bank queue machine
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 * */
public class BankQueueApp {

    /** Field to contain number of teller queue line/counter. */
    private static int nTellerLine;

    /** Field to contain current teller line/counter to be added by new customer. */
    private static int currentTellerLine;

    /** Field to contain current teller line/counter to do a service. */
    private static int currentTellerServiceLine;

    /** Field to contain current order of teller queue. */
    private static int currentTellerQueueNumber;

    /** Field to contain list of teller queue*/
    private static Queue<Customer>[] tellerQueue;

    /** Field to contain number of customer service queue line/counter. */
    private static int nCSLine;

    /** Field to contain current customer service line/counter to be added by new customer. */
    private static int currentCSLine;

    /** Field to contain current customer service line/counter to do a service. */
    private static int currentCSServiceLine;

    /** Field to contain current order of customer service queue. */
    private static int currentCSQueueNumber;

    /** Field to contain list of customer service queue*/
    private static Queue<Customer>[] CSQueue;

    /**
     * Static field to contain all function with {@link Integer} key
     * to represent function order in the app menu, then {@link Function}
     * as a value
     * */
    private static HashMap<Integer, BankQueueApp.Function> functions;

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
        initQueue();
        appMenu();
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
     * This method is used to initialize the application by setting the app menu
     * */
    private static void initApp() {
        // INITIATE THE APP MENU
        functions = new HashMap<>();

        // ADD MENU TO THE APP
        functions.put(1, new Function("Add Teller Queue", BankQueueApp::tellerQueue));
        functions.put(2, new Function("Add Customer Service Queue", BankQueueApp::csQueue));
        functions.put(3, new Function("Do Teller Service", BankQueueApp::tellerService));
        functions.put(4, new Function("Do CS Service", BankQueueApp::csService));
        functions.put(5, new Function("Display Queue", BankQueueApp::display));
        functions.put(6, new Function("Reset", BankQueueApp::initQueue));
        functions.put(7, new Function("Exit", BankQueueApp::exit));
    }

    /**
     * This method is used to initiate the queue in the bank by
     * setting how many teller line/counter and how many customer
     * service line/counter
     * */
    private static void initQueue() {
        // INSERT HOW MANY TELLER QUEUE AND CS QUEUE
        System.out.print("How many teller line : ");
        nTellerLine = scanner().nextInt();

        System.out.print("How many customer service line : ");
        nCSLine = scanner().nextInt();

        // INITIATE TELLER QUEUE
        tellerQueue = new Queue[nTellerLine];
        for (int i = 0; i < tellerQueue.length; i++) {
            tellerQueue[i] = new Queue<>();
        }
        currentTellerLine = 0;
        currentTellerServiceLine = 0;
        currentTellerQueueNumber = 1;

        // INITIATE CUSTOMER SERVICE QUEUE
        CSQueue = new Queue[nCSLine];
        for (int i = 0; i < CSQueue.length; i++) {
            CSQueue[i] = new Queue<>();
        }
        currentCSLine = 0;
        currentCSServiceLine = 0;
        currentCSQueueNumber = 1;
    }

    /**
     * This method is used to print all menu of the app to be selected by user.
     * */
    private static void appMenu() {
        System.out.println("==========| PROGRAM MENU |==========");

        for (Map.Entry<Integer, BankQueueApp.Function> function: functions.entrySet()) {
            System.out.println(function.getKey() + ". " + function.getValue().getName());
        }

        programSwitcher();
    }

    /**
     * This method is used to handling user selection of the app menu
     * */
    private static void programSwitcher() {
        System.out.print("Choose Menu [1 - 7]: ");
        int indexMenu = scanner().nextInt();

        if (1 <= indexMenu && indexMenu <= 7)
            functions.get(indexMenu).run();

        appMenu();
    }

    /**
     * This method is used to handle the first menu of the app,
     * which is add customer to a teller queue.
     * */
    private static void tellerQueue() {
        Customer newCustomer = new Customer(currentTellerQueueNumber++, 1);
        tellerQueue[currentTellerLine++].enqueue(newCustomer);
        System.out.println("Add new Customer with ticket " + newCustomer + " at Teller " + currentTellerLine);
        currentTellerLine %= nTellerLine;

        scanner().nextLine();
    }

    /**
     * This method is used to handle the second menu of the app,
     * which is add customer to a customer service queue.
     * */
    private static void csQueue() {
        Customer newCustomer = new Customer(currentCSQueueNumber++, 2);
        CSQueue[currentCSLine++].enqueue(newCustomer);
        System.out.println("Add new customer with ticket " + newCustomer + " at customer service " + currentCSLine);
        currentCSLine %= nCSLine;

        scanner().nextLine();
    }

    /**
     * This method is used to handle the third menu of the app,
     * which is do a service in a teller line/counter
     * */
    private static void tellerService() {
        if (!tellerQueue[currentTellerServiceLine].isEmpty()) {
            System.out.println("Please " + tellerQueue[currentTellerServiceLine].head() + " go to teller " + (currentTellerServiceLine + 1));
            tellerQueue[currentTellerServiceLine++].dequeue();
        } else {
            System.out.println("Teller " + ++currentTellerServiceLine + " is empty");
        }

        currentTellerServiceLine %= nTellerLine;
        scanner().nextLine();
    }

    /**
     * This method is used to handle the fourth menu of the app,
     * which is do a service in a customer service line/counter
     * */
    private static void csService() {
        if (!CSQueue[currentCSServiceLine].isEmpty()) {
            System.out.println("Please " + CSQueue[currentCSServiceLine].head() + " go to customer service " + (currentCSServiceLine + 1));
            CSQueue[currentCSServiceLine++].dequeue();
        } else {
            System.out.println("Teller " + ++currentCSServiceLine + " is empty");
        }

        currentCSServiceLine %= nCSLine;
        scanner().nextLine();
    }

    /**
     * This method is used to handle the fifth menu of the app,
     * which is display the next customer to be serviced by
     * corresponding line/counter
     * */
    private static void display() {

        // DISPLAY TELLER QUEUE
        System.out.println("==========| TELLER NEXT SERVICE |==========");

        for (int i = 1; i <= nTellerLine; i++) System.out.print(".----------");
        System.out.println(".");

        for (int i = 1; i <= nTellerLine; i++) System.out.print("| Teller " + i + " ");
        System.out.println("|");

        for (int i = 1; i <= nTellerLine; i++) System.out.print("|----------");
        System.out.println("|");

        for (int i = 0; i < nTellerLine; i++) {
            if (tellerQueue[i].head() != null) System.out.print("| " + tellerQueue[i].head() + "     ");
            else System.out.print("|          ");
        }
        System.out.println("|");

        for (int i = 0; i < nTellerLine; i++) System.out.print("'----------");
        System.out.println("'\n");


        // DISPLAY CUSTOMER SERVICE QUEUE
        System.out.println("==========| CS NEXT SERVICE |==========");

        for (int i = 1; i <= nCSLine; i++) System.out.print(".------");
        System.out.println(".");

        for (int i = 1; i <= nCSLine; i++) System.out.print("| CS " + i + " ");
        System.out.println("|");

        for (int i = 1; i <= nCSLine; i++) System.out.print("|------");
        System.out.println("|");

        for (int i = 0; i < nCSLine; i++) {
            if (CSQueue[i].head() != null) System.out.print("| " + CSQueue[i].head() + " ");
            else System.out.print("|      ");
        }
        System.out.println("|");

        for (int i = 0; i < nCSLine; i++) System.out.print("'------");
        System.out.println("'");

        // Enter to go to the main menu
        scanner().nextLine();
    }

    /**
     * This method is used to handle the seventh menu of the app,
     * which is exit from the app.
     * */
    private static void exit() {
        System.exit(0);
    }

}
