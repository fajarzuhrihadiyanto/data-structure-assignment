package assignment_09.module;

/**
 * This interface represents behaviour of Tree object,
 * which is extending {@link DataStructure} behaviour
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 9th 2021
 * */
public interface Tree<E> extends DataStructure<E> {

    E root();
    E parent(E value);
    E successor(E value);
    E predecessor(E value);
    boolean isLeaf(E value);

}
