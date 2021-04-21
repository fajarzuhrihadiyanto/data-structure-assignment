package assignment_05;

/**
 * This class represents queue data structure
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since April 21st 2021
 *
 * @param <E> type of each element
 * */
public class Queue<E> {

    /** Field to contain main list */
    private final E[] queue;

    /** Field to contain capacity of the queue*/
    private final int capacity;

    /** Field to contain front index of the queue */
    private int front;

    /** Field to contain rear index of the queue */
    private int rear;

    /** Field to contain current size of the queue */
    private int currentSize;

    /**
     * Constructor to initiate the queue
     * */
    public Queue(int capacity) throws IllegalArgumentException {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be non zero positive integer");
        }
        this.front = 0;
        this.rear = -1;
        this.capacity = capacity;
        this.queue = (E[]) new Object[capacity];
        this.currentSize = 0;
    }

    /**
     * This method is used to check if the queue is full or not
     *
     * @return true if current size is equal to the capacity, else false
     * */
    public boolean isFull() {
        return this.currentSize == this.capacity;
    }

    /**
     * This method is used to check if the queue is empty or not
     *
     * @return true if current size is equal to 0, else false
     * */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * This method is used to insert new data to the queue
     *
     * @param data data to be inserted to the queue
     * @throws IllegalStateException when the queue is full
     * */
    public void enqueue(E data) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Queue is full !!!");
        } else {
            rear++;
            if (rear == capacity) rear = 0;
            queue[rear] = data;
            currentSize++;
        }
    }

    /**
     * This method is used to pull out front element of the queue
     *
     * @throws IllegalStateException when the queue is empty
     * */
    public void dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty !!!");
        }

        front++;
        if (front == capacity) front = 0;
        currentSize--;
    }

    /**
     * This method is used to get value of the front element of the queue
     *
     * @throws IllegalStateException when the queue is empty
     * @return value of the front element of the queue
     * */
    public E front() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty !!!");
        }

        return this.queue[front];
    }

    /**
     * This method is used to convert queue instance to string
     *
     * @return string representation of the queue
     * */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        while(!this.isEmpty()){
            result.append(this.front());
            this.dequeue();
        }

        return result.toString();
    }
}
