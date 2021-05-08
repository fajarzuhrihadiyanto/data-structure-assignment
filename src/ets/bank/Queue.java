package ets.bank;

/**
 * This class represents queue data structure with specific type of each data.
 * This class implement behavior of linked list.
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 *
 * @param <E> type of each data in the queue object
 * */
public class Queue<E> {

    /** Field to contain size of the queue, or the number of data in the queue. */
    private int size;

    /** Field to contain head node of the queue. */
    private Node head;

    /** Field to contain tail node of the queue. */
    private Node tail;

    /**
     * This inner class represents node that contains data of the queue.
     * */
    class Node {

        /** Field to contain main data of the node. */
        private final E data;

        /** Field to contain reference to next node of the queue. */
        private Node next;

        /**
         * This constructor will initiate new node by a certain value for the new node object.
         * @param data {@link E} type data to be set as value of the new node.
         * */
        public Node(E data) {
            this.data = data;
        }

        /**
         * This method will get the string representation of node object
         * by return field {@link #data}.
         *
         * @return string representation of node object
         * */
        @Override
        public String toString() {
            return this.data.toString();
        }

    }

    /**
     * This constructor will initiate new queue object
     * by set the size to 0, head and tail to null
     * */
    public Queue() {
        this.size = 0;
        this.head = this.tail = null;
    }

    /**
     * This method is used to check if the queue is empty (does not have any data) or not
     * @return true if the size is 0, else false
     * */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * This method is used to add new data to the queue.
     * @param data {@link E} type data to be added to the queue
     * */
    public void enqueue(E data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) this.head = this.tail = newNode;
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    /**
     * This method is used to remove the front data of the queue.
     * if the queue is already empty, then it will throw an error
     * @throws IllegalStateException when the queue is already empty as program try to run this method
     * */
    public void dequeue() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("The queue is already empty !");
        } else {
            this.head = this.head.next;
            if (this.head == null) this.tail = null;
        }

        this.size--;
    }

    /**
     * This method is used to get the head data of the queue.
     * if the queue is empty, then return null.
     *
     * @return {@link E} type of head data of the queue if the queue is not empty, else null
     * */
    public E head() {
        return !this.isEmpty() ? this.head.data : null;
    }

}
