package assignment_08.models;

import java.util.Stack;

/**
 * This class represents model of the list of movement log
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class LogsModel {

    /** field to contain stack of logs */
    private final Stack<LogModel> logs;

    /**
     * This constructor will create new stack of logs
     * */
    public LogsModel() {
        logs = new Stack<>();
    }

    // ALL GETTER METHOD BELOW HERE

    public Stack<LogModel> getLogs() {
        return this.logs;
    }
}
