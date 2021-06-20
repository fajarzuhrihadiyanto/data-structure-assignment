package assignment_11;

import java.util.Hashtable;

/**
 * This class represents Phone Book
 * that contains Map of name and corresponding phone number
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 20th 2021
 * */
public class PhoneBook {

    /** Field that represents map of hashed name and corresponding phone number */
    private final Hashtable<Integer, PhoneNumber> hashtable;

    /**
     * This constructor will create new instance of {@link Hashtable}
     * */
    public PhoneBook() {
        this.hashtable = new Hashtable<>();
    }

    /**
     * This method is used to hash given key with a certain algorithm
     * and return the hashed key
     *
     * @param key key to be hashed
     * @return hashed key
     * */
    private int hashFunction(String key) {
        int hash = 97;

        for (char ch: key.toCharArray()) {
            hash = (19 * hash + ch) % Integer.MAX_VALUE;
        }

        return hash;
    }

    /**
     * This method is used to check if this phone book
     * include key in it
     *
     * @param key key to be looked for
     * @return true if key found, else false
     * */
    public boolean hasKey(String key) {
        return hashtable.containsKey(this.hashFunction(key));
    }

    /**
     * This method is used to put a new person and phone number pair
     * into this phone book
     *
     * @param key person's name as a key
     * @param phone phone number
     * @return true if key doesn't exist and inserted successfully, else false
     * */
    public boolean put(String key, PhoneNumber phone) {
        if(this.hasKey(key)) return false;

        this.hashtable.put(this.hashFunction(key), phone);
        return true;
    }

    /**
     * This method is used to get a phone number by given person's name
     *
     * @param key person's name as a key
     * @return phone number
     * */
    public PhoneNumber getByKey(String key) {
        return this.hashtable.get(this.hashFunction(key));
    }

    /**
     * This method is used to edit a phone number by given person's name
     *
     * @param key person's name as a key
     * @param phone new phone number
     * @return true if key exist and it's phone number edited successfully, else false
     * */
    public boolean editByKey(String key, PhoneNumber phone) {
        if(!this.hasKey(key)) return false;

        this.hashtable.replace(this.hashFunction(key), phone);
        return true;
    }

    /**
     * This method is used to removed a data by given person's name
     *
     * @param key person's name as a key
     * @return true if data removed successfully, else false
     * */
    public boolean removeByKey(String key) {
        return this.hashtable.remove(this.hashFunction(key)) != null;
    }

}
