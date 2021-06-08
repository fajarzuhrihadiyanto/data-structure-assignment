package assignment_08.models;

import java.util.Stack;

/**
 * This class represents model of the three rods of the game
 *
 * @since June 8th 2021
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * */
public class RodsModel {

    /** field to contain all three rods data */
    private final RodModel[] towers = new RodModel[3];

    /**
     * This class represents model of a single rod
     *
     * @since June 8th 2021
     * @author Fajar Zuhri Hadiyanto
     * @version 1.0
     * */
    public class RodModel {

        /** field to contain list of disk */
        private Stack<Integer> disks;

        /**
         * This constructor will create new list of disk with a given maximum disk value
         *
         * @param maximum maximum value of the disk in the list
         * */
        public RodModel(int maximum) {
            disks = new Stack<>();

            for (int i = maximum; i > 0; i--) {
                disks.push(i);
            }
        }

        /**
         * This method is used to check if field disks is empty or not
         *
         * @return true if field disks is empty, else false
         * */
        public boolean empty() {
            return this.disks.empty();
        }

        /**
         * This method is used to get the top value of disk
         *
         * @return top value of the disks if its not empty, else null
         * */
        public Integer getTopDisk() {
            return !this.empty() ? this.disks.peek() : null;
        }

        /**
         * This method is used to pop the top value of the disk of its not empty
         * */
        public void pickTopDisk() {
            if (!this.empty()) this.disks.pop();
        }

        /**
         * This method is used to put a new disk to the stack, if the value is valid
         *
         * @param value value of the new disk
         * */
        public void putDisk(int value) {
            if (this.disks.empty() || value < this.disks.peek()) this.disks.push(value);
        }

    }

    /**
     * This constructor will create new list of rods with the initial number of the disk for every rods
     *
     * @param startDisk number of the disk in the start rod
     * @param auxDisk number of the disk in the aux rod
     * @param destDisk number of the disk in the destination rod
     * */
    public RodsModel(int startDisk, int auxDisk, int destDisk) {
        this.reinitiate(startDisk, auxDisk, destDisk);
    }

    /**
     * This constructor will create new list of rods with the initial number of the disk
     * that will be placed in the start rod initially
     *
     * @param nDisk number of the disk
     * */
    public RodsModel(int nDisk) {
        this(nDisk, 0, 0);
    }

    /**
     * This method is a utility method to create new list of rods with the initial number of the disk for every rods
     *
     * @param startDisk number of the disk in the start rod
     * @param auxDisk number of the disk in the aux rod
     * @param destDisk number of the disk in the destination rod
     * */
    public void reinitiate(int startDisk, int auxDisk, int destDisk) {
        this.towers[0] = new RodModel(startDisk);
        this.towers[1] = new RodModel(auxDisk);
        this.towers[2] = new RodModel(destDisk);
    }

    /**
     * This method is a utility method to create new list of rods with the initial number of the disk
     * that will be placed in the start rod initially
     *
     * @param nDisk number of the disk
     * */
    public void reinitiate(int nDisk) {
        this.reinitiate(nDisk, 0, 0);
    }

    /**
     * This method is used to move top disk of the from rod to the to rod
     *
     * @param from index of the from rod
     * @param to index of the to rod
     * */
    public void moveDisk(int from, int to) {
        this.towers[to].putDisk(this.towers[from].getTopDisk());
        this.towers[from].pickTopDisk();
    }

}
