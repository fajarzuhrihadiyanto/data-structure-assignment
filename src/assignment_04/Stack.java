package assignment_04;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents stack data structure
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since April 9th 2021
 *
 * @param <type> type of each element
 * */
public class Stack<type> {

    /** Field to contain main list */
    private final List<type> list;

    /** Field to contain peak index */
    private int currentIndex;

    /**
     * Constructor to initiate the list and current index
     * */
    public Stack() {
        this.list = new ArrayList<>();
        this.currentIndex = -1;
    }

    /**
     * This method is used to add new data to the top of the list
     *
     * @param data value for the new data
     * */
    public void push(type data) {
        this.list.add(data);
        currentIndex++;
    }

    /**
     * This method is used to delete last data from the list
     *
     * @return value of the last element of the list
     * */
    public type pop() {
        type object = this.list.remove(currentIndex);
        currentIndex--;
        return object;
    }

    /**
     * This method is used to get the number of element in the list
     *
     * @return size of the list
     * */
    public int count() { return this.list.size(); }

    /**
     * This method is used to get value of the last element in the list
     *
     * @return value of the last element in a list
     * */
    public type peek() { return list.get(currentIndex); }

    /**
     * This method is used to remove all elements from the list
     * */
    public void clear() {
        this.list.clear();
        currentIndex = -1;
    }

}
