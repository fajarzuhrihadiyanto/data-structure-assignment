package assignment_08.models;

/**
 * This class represents model of a single log
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class LogModel {

    /** field to contain index of the from rod */
    private final int fromRod;

    /** field to contain index of the to rod */
    private final int toRod;

    /** field to contain value of the disk moved */
    private final int diskVal;

    /**
     * This constructor will create new log by setting from rod, to rod, and value of the disk
     *
     * @param fromRod index of the from rod
     * @param toRod index of the to rod
     * @param diskVal value of the disk moved
     * */
    public LogModel(int fromRod, int toRod, int diskVal) {
        this.fromRod = fromRod;
        this.toRod = toRod;
        this.diskVal = diskVal;
    }

    /* ALL GETTER METHOD BELOW HERE */

    public int getFromRod() {
        return this.fromRod;
    }

    public int getToRod() {
        return this.toRod;
    }

    public int getDiskVal() {
        return this.diskVal;
    }
}
