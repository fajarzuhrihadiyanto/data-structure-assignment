package assignment_08.models;

/**
 * This class represents model of the state in the application
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class StateModel {

    /** field to contain number of the disk in the game */
    private int nDisk;

    /** field to contain total move done by the game */
    private int totalMoves;

    /**
     * This constructor will set new value for all state in the application
     *
     * @param nDisk number of the disk in the game
     * @param totalMoves total move done by the game
     * */
    public StateModel(int nDisk, int totalMoves) {
        this.nDisk = nDisk;
        this.totalMoves = totalMoves;
    }

    /**
     * This method is used to increase total move done by the game
     * */
    public void incrementTotalMoves() {
        this.totalMoves++;
    }

    /**
     * This method is used to decrease total move done by the game
     * */
    public void decrementTotalMoves() {
        this.totalMoves--;
    }

    /* ALL SETTER AND GETTER METHOD BELOW HERE */

    public int getnDisk() {
        return this.nDisk;
    }

    public int getTotalMoves() {
        return this.totalMoves;
    }

    public void setnDisk(int nDisk) {
        this.nDisk = nDisk;
    }

    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }
}
