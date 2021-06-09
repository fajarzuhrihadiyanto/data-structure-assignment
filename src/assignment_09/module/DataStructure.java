package assignment_09.module;

/**
 * This interface represents behaviour of Data structure object
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 9th 2021
 * */
public interface DataStructure<E> {

    boolean insert(E value);
    boolean find(E value);
    boolean remove(E value);
    boolean isEmpty();
    int size();
    void clear();

}
