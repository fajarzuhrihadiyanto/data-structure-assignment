package assignment_09;

import assignment_09.module.Tree;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This class is representation of binary tree data structure.
 * This class implements {@link Tree} interface.</p>
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since April 28th 2021
 *
 * @param <E> element type that must implement {@link Comparable} interface
 * */
public class BinaryTree<E extends Comparable<E>> implements Tree<E> {

    /** Field to contain tree size. In the other word, it contains numbers of tree node */
    protected int size;

    /** Field to contain root node of the tree */
    protected Node root;

    /**
     * This class represents node of the tree.
     * This class implements {@link Comparable Comparable} interface
     * */
    class Node implements Comparable<Node> {

        /** Field to contain value of the node with type {@link E}*/
        private final E data;

        /** Field to contain {@link Node} type element as a left child */
        private Node left;

        /** Field to contain {@link Node} type element as a right child */
        private Node right;

        /**
         * Constructor to initialize the node with type {@link E} value
         *
         * @param value {@link E} type value to be assigned to the node
         * */
        public Node(E value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }

        /**
         * <p>This method is used to compare node to the other node by comparing their data field.
         * This method will return :</p>
         * <ul>
         *     <li>-1 if this node data value is lower than parameter data value.</li>
         *     <li>0 if this node data value is equal to parameter data value.</li>
         *     <li>1 if this node data value is greater than parameter data value.</li>
         * </ul>
         *
         *
         * @param o {@link Node} type object to be compared to this node
         * @return either -1, 0, or 1
         * */
        @Override
        public int compareTo(Node o) {
            return this.data.compareTo(o.data);
        }

        /**
         * <p>This method is used to check the equality between this node with the other node
         * by check if they have the same value</p>
         *
         * @param o general {@link Object} type
         * @return {@code true} if the given object is instance of {@link Node} and have the same value, else {@code false}
         * */
        @Override
        public boolean equals(Object o) {
            return (o instanceof BinaryTree.Node) && this.compareTo((Node) o) == 0;
        }

        /**
         * <p>This method is used to get string representation of this node
         * which is string representation of data field</p>
         *
         * @return string representation of this node
         * */
        @Override
        public String toString() {
            return this.data.toString();
        }

    }

    /**
     * <p>Constructor to initialize the binary tree by set root to {@code null}
     * and set the size to 0</p>
     * */
    public BinaryTree() {
        this.size = 0;
        this.root = null;
    }

    /**
     * <p>This method is used to get the minimum node value from the given node.
     * This method will recursively dig deep into left child of the node until there is no left child anymore.
     * Then, it will return the deepest node with no left child</p>
     *
     * @param node {@link Node} type object to be gotten it's left child
     * @return {@link Node} object with the lowest value
     * */
    protected Node findMinUtil(@NotNull Node node) {
        if (node.left != null) {
            return this.findMinUtil(node.left);
        }

        return node;
    }

    /**
     * <p>This method is used to get the maximum node value from the given node.
     * This method will recursively dig deep into right child of the node until there is no right child anymore.
     * Then, it will return the deepest node with no right child</p>
     *
     * @param node {@link Node} type object to be gotten it's right child
     * @return {@link Node} object with the highest value
     * */
    protected Node findMaxUtil(@NotNull Node node) {
        if (node.right != null) {
            return this.findMaxUtil(node.right);
        }

        return node;
    }

    /**
     * <p>This method is used to get lowest ancestor of the given node which locate on the right of the node.</p>
     *
     * @param node {@link Node} type object to be looked for the lowest right ancestor
     * @return {@link Node} object with the lowest value locate on the right of the node parameter
     * */
    protected Node findParentRightUtil(@NotNull Node node) {

        Node temp = this.root;
        Node parent = null;

        if (!node.equals(temp)) {
            while (node.compareTo(temp) < 0 ? temp.left != null : temp.right != null) {
                if (node.compareTo(temp) < 0) {
                    parent = temp;
                    if (node.equals(temp.left)) return parent;
                    temp = temp.left;
                } else if (node.compareTo(temp) > 0) {
                    if (node.equals(temp.right)) return parent;
                    temp = temp.right;
                }
            }
        }

        return null;
    }

    /**
     * <p>This method is used to get lowest ancestor of the given node which locate on the left of the node.</p>
     *
     * @param node {@link Node} type object to be looked for the lowest left ancestor
     * @return {@link Node} object with the highest value locate on the left of the node parameter
     * */
    protected Node findParentLeftUtil(@NotNull Node node) {
        Node temp = this.root;
        Node parent = null;

        if (!node.equals(temp)) {
            while (node.compareTo(temp) < 0 ? temp.left != null : temp.right != null) {
                if (node.compareTo(temp) < 0) {
                    if (node.equals(temp.left)) return parent;
                    temp = temp.left;
                } else if (node.compareTo(temp) > 0) {
                    parent = temp;
                    if (node.equals(temp.right)) return parent;
                    temp = temp.right;
                }
            }
        }

        return null;
    }

    /**
     * <p>This method is used as a utility method to search an inorder successor of a specific node.
     * If there is right child on the node parameter, it will run {@link #findMinUtil(Node)}
     * with the right child as a first argument. Else, it will run {@link #findParentRightUtil(Node)}
     * with the node as a first argument.</p>
     *
     * @param node {@link Node} type object to be looked for the successor
     * @return {@link Node} object as a successor of the node parameter
     * */
    protected Node successorUtil(@NotNull Node node) {
        if (node.right != null) {
            return this.findMinUtil(node.right);
        }
        return this.findParentRightUtil(node);
    }

    /**
     * <p>This method is used as a utility method to search an inorder predecessor of a specific node.
     * If there is left child on the node parameter, it will run {@link #findMaxUtil(Node)}
     * with the left child as a first argument. Else, it will run {@link #findParentLeftUtil(Node)}
     * with the node as a first argument.</p>
     *
     * @param node {@link Node} type object to be looked for the predecessor
     * @return {@link Node} object as a predecessor of the node parameter
     * */
    protected Node predecessorUtil(@NotNull Node node) {
        if (node.left != null) {
            return this.findMaxUtil(node.left);
        }
        return this.findParentLeftUtil(node);
    }

    /**
     * <p>This method is used to get successor value of the given value</p>
     *
     * @param value {@link E} type value to be looked for the successor
     * @return {@link E} object as a successor
     * */
    public E successor(@NotNull E value) {
        Node node = this.search(value);
        Node successor = null;

        if (node != null) {
            successor = this.successorUtil(node);
        }

        return successor != null ? successor.data : null;
    }

    /**
     * <p>This method is used to get predecessor value of the given value</p>
     *
     * @param value {@link E} type value to be looked for the predecessor
     * @return {@link E} object as a predecessor
     * */
    public E predecessor(@NotNull E value) {
        Node node = this.search(value);
        Node predecessor = null;

        if (node != null) {
            predecessor = this.predecessorUtil(node);
        }

        return predecessor != null ? predecessor.data : null;
    }

    /**
     * <p>This method is used as a utility method to search node by
     * dig deeper into the left or right child until find the node with
     * the same key as key parameter</p>
     *
     * @param node temporary {@link Node} object
     * @param key key to be found
     * @return {@link Node} object that has a key parameter as a value
     * */
    protected Node searchUtil(@Nullable Node node, @NotNull E key) {
        if (node != null) {

            if (key.compareTo(node.data) < 0) {
                return searchUtil(node.left, key);
            }

            if (key.compareTo(node.data) > 0) {
                return searchUtil(node.right, key);
            }

            if (key.compareTo(node.data) == 0) {
                return node;
            }

        }

        return null;
    }

    /**
     * <p>This method is used to search a specific key in a tree by running
     * {@link #searchUtil(Node, Comparable)} with the root as first argument
     * and key parameter as a second argument.</p>
     *
     * @param key key to be found
     * @return {@link Node} object that has a key parameter as a value
     * */
    protected Node search(@NotNull E key) {
        return this.searchUtil(this.root, key);
    }

    /**
     * <p>This method is used as a utility method to check if the node is a leaf node or not
     * by check if the node doesn't have both right and left child</p>
     *
     * @param node {@link Node} type object to be checked
     * @return {@code true} if the node doesn't have both right and left child, else {@code false}
     * */
    protected boolean isLeafUtil(@NotNull Node node) {
        return node.right == null && node.left == null;
    }

    /**
     * <p>This method is used to check if node with specific value
     * in the tree is a leaf node</p>
     *
     * @param value {@link E} type value to be checked
     * @return {@code true} if node with the given value found and is leaf node, else {@code false}
     * */
    public boolean isLeaf(@NotNull E value) {
        Node node = this.search(value);
        return node != null && this.isLeafUtil(node);
    }

    /**
     * <p>This method is used as a utility method to get parent node
     * by dig deep until get child with specific key as a value</p>
     *
     * @param node temporary {@link Node} object
     * @param key key to be looked for the parent
     * @return {@link Node} object as a parent node of the given key
     * */
    protected Node parentUtil(@Nullable Node node, @NotNull Node key) {

        if (node != null) {

            if (key.compareTo(node) < 0 && node.left != null) {
                if (key.equals(node.left)) return node;

                return parentUtil(node.left, key);
            }

            if (key.compareTo(node) > 0 && node.right != null) {
                if (key.equals(node.right)) return node;

                return parentUtil(node.right, key);
            }

        }

        return null;
    }

    /**
     * <p>This method is used to get parent node of the given node
     * by running {@link #parentUtil(Node, Node)} with root as a first argument
     * and the node as a second argument</p>
     *
     * @param node {@link Node} type object to be looked for the parent
     * @return {@link Node} object as a parent node
     * */
    protected Node parent(@NotNull Node node) {

        if (!node.equals(this.root)) {
            return this.parentUtil(this.root, node);
        }

        return null;
    }

    /**
     * <p>This method is used to get parent value of the given value</p>
     *
     * @param value {@link E} type value to be looked for the parent
     * @return {@link E} type object as a parent of the given value
     * */
    public E parent(@NotNull E value) {
        Node node = this.search(value);
        Node parent = node != null ? this.parent(node) : null;
        return parent != null ? parent.data : null;
    }

    /**
     * <p>This method is used to get list of children value of the given value.
     * First element of the list contains left child of the given value.
     * Second element of the list contains right child of the given value.
     * If value doesn't exist, it will return null instead.</p>
     *
     * @param value {@link E} type value to be looked for the children
     * @return {@link List} type children
     * */
    public List<E> children(@NotNull E value) {
        Node node = this.search(value);

        if (node != null) {
            List<E> res = new ArrayList<>(2);
            res.add(node.left != null ? node.left.data : null);
            res.add(node.right != null ? node.right.data : null);
            return res;
        }

        return null;
    }

    /**
     * <p>This method is used to get the root data of the tree</p>
     *
     * @return {@link E} type root value
     * */
    public E root() {
        return this.root.data;
    }

    /**
     * <p>This method is used as a utility method to insert new value to
     * the tree by dig deep recursively</p>
     *
     * @param node temporary {@link Node} type object
     * @param value {@link E} type value for the new node
     * @return {@link Node} object
     * */
    protected Node insertUtil(@Nullable Node node, @NotNull E value) {
        if (node == null) {
            this.size++;
            return new Node(value);
        }

        if (value.compareTo(node.data) < 0)
            node.left = insertUtil(node.left, value);
        else if (value.compareTo(node.data) > 0)
            node.right = insertUtil(node.right, value);

        return node;
    }

    /**
     * <p>This method is used to insert new node with specific value to the tree</p>
     *
     * @param value {@link E} type value of the new node to be inserted to the tree
     * @return {@code true} if new node is inserted, else (if value exist in the tree) {@code false}
     * */
    @Override
    public boolean insert(@NotNull E value) {
        int preAddSize = this.size;
        this.root = this.insertUtil(this.root, value);
        return preAddSize != this.size;
    }

    /**
     * <p>This method is used to check if a value is exist in the tree
     * by check if method {@link #search(Comparable)} doesn't return null</p>
     *
     * @param value {@link E} type value to be found
     * @return {@code true} if value found, else {@code false}
     * */
    @Override
    public boolean find(@NotNull E value) {
        return this.search(value) != null;
    }

    /**
     * <p>This method is used as a utility method to delete node
     * by dig deep recursively. If node to be deleted found, there are two cases :</p>
     *
     * <ul>
     *     <li>
     *         If node found is either leaf node or has only 1 child,
     *         return the opposite child of the null child (1 child case), even though
     *         the opposite child is also null (leaf node case)
     *     </li>
     *     <li>
     *         If node found has 2 children, get the successor of the node
     *         to replace the node found, then remove the successor from
     *         the old place recursively
     *     </li>
     * </ul>
     *
     * @param node temporary {@link Node} type object
     * @param value {@link E} type value to be found and deleted
     * @return {@link Node} object
     * */
    protected Node removeUtil(@Nullable Node node, @NotNull E value) {
        if (node == null) return null;

        if (value.compareTo(node.data) < 0) {
            node.left = removeUtil(node.left, value);
        } else if (value.compareTo(node.data) > 0) {
            node.right = removeUtil(node.right, value);
        } else {

            if (node.left == null) {
                this.size--;
                return node.right;
            } else if (node.right == null) {
                this.size--;
                return node.left;
            }

            Node successor = this.successorUtil(node);

            node.right = this.removeUtil(node.right, successor.data);

            successor.right = successor.equals(node.right) ? null : node.right;
            successor.left = node.left;

            return successor;
        }

        return node;
    }

    /**
     * <p>This method is used to remove node with a certain value from the tree
     * by running {@link #removeUtil(Node, Comparable)} with the root as a first argument
     * and the value as a second argument</p>
     *
     * @param value {@link E} type value to be found and deleted
     * @return {@code true} if node with the given value found and deleted, else {@code false}
     * */
    @Override
    public boolean remove(@NotNull E value) {
        int preDelSize = this.size;
        this.root = this.removeUtil(this.root, value);
        return preDelSize != this.size;
    }

    /**
     * <p>This method is used to check if the tree is empty, or in other word
     * have 0 node by checking field size</p>
     *
     * @return {@code true} if the size is 0, else {@code false}
     * */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * <p>This method is used to get size of the tree</p>
     *
     * @return int type of size of the tree
     * */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * <p>This method is used to print all tree node by inorder method
     * which is dig deep to the left child recursively until there is no left child,
     * then print the current node, then dig deep to the right child recursively
     * until there is no right child. This method will print tree node in sequential order</p>
     *
     * @param node temporary {@link Node} type object
     * */
    protected void inorderTraverseUtil(@Nullable Node node) {
        if (node != null) {
            inorderTraverseUtil(node.left);
            System.out.print(node + " ");
            inorderTraverseUtil(node.right);
        }
    }

    /**
     * <p>This method is used to print all tree node in sequential order
     * by running {@link #inorderTraverseUtil(Node)} with the root as a first argument</p>
     * */
    public void inorderTraverse() {
        this.inorderTraverseUtil(this.root);
    }

    /**
     * <p>This method is used to print all tree node by preorder method
     * which is print the current node, then dig deep to the left child recursively
     * until there is no left child, then dig deep to the right child recursively
     * until there is no right child.</p>
     *
     * @param node temporary {@link Node} type object
     * */
    protected void preorderTraverseUtil(@Nullable Node node) {
        if (node != null) {
            System.out.print(node + " ");
            preorderTraverseUtil(node.left);
            preorderTraverseUtil(node.right);
        }
    }

    /**
     * <p>This method is used to print all tree node by running
     * {@link #preorderTraverseUtil(Node)} with the root as a first argument</p>
     * */
    public void preorderTraverse() {
        this.preorderTraverseUtil(this.root);
    }

    /**
     * <p>This method is used to print all tree node by postorder method
     * which is dig deep to the left child recursively until there is no left child,
     * then dig deep to the right child recursively until there is no right child,
     * then print the current node.</p>
     *
     * @param node temporary {@link Node} type object
     * */
    protected void postorderTraverseUtil(@Nullable Node node) {
        if (node != null) {
            postorderTraverseUtil(node.left);
            postorderTraverseUtil(node.right);
            System.out.print(node + " ");
        }
    }

    /**
     * <p>This method is used to print all tree node
     * by running {@link #postorderTraverseUtil(Node)} with the root as a first argument</p>
     * */
    public void postorderTraverse() {
        this.postorderTraverseUtil(this.root);
    }

    /**
     * <p>This method is used to clear all tree nodes
     * by just set size to 0 and the root to null.</p>
     * */
    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

}
