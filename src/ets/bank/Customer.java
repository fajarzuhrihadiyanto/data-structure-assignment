package ets.bank;

/**
 * This class represents customer as an object of queue
 * consist of queue number and queue type (either Teller
 * or Customer Service)
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since May 7th 2021
 * */
public class Customer {

    /** Field to contain order in the queue */
    private final int queueNumber;

    /**
     * Field to contain integer representation of queue type.
     * <ul>
     *     <li>1 for teller</li>
     *     <li>2 for customer service</li>
     * </ul>
     * */
    private final int queueType;

    /**
     * Field to contain formatted ticket value based on the
     * queue type and the queue number.
     * */
    private String queueTicket;

    /**
     * This constructor will set the {@link #queueNumber} and {@link #queueType}
     * directly from the given argument. This will also set the {@link #queueTicket}
     * from method {@link #setQueueTicket()}
     *
     * @param queueNumber order in the queue
     * @param queueType integer representation of queue type
     * */
    public Customer(int queueNumber, int queueType) {
        this.queueNumber = queueNumber;
        this.queueType = queueType;
        this.setQueueTicket();
    }

    /**
     * This method will set the {@link #queueTicket} by, first depends on the queue type
     * <ul>
     *     <li>if queue type is 1 (teller), then queue ticket will have prefix 'T'</li>
     *     <li>if queue type is 2 (customer service), then queue ticket will have prefix 'C'</li>
     * </ul>
     * Then followed by 3 digit formatted queue order (001, 027, 173, etc.)
     * */
    private void setQueueTicket() {
        StringBuilder queue = new StringBuilder();

        if (this.queueType == 1) queue.append("T");
        else queue.append("C");

        queue.append(String.format("%03d", this.queueNumber));

        this.queueTicket = queue.toString();
    }

    /**
     * This method will get the string representation of customer object
     * by return field {@link #queueTicket}.
     *
     * @return string representation of customer object
     * */
    @Override
    public String toString() {
        return this.queueTicket;
    }

}
