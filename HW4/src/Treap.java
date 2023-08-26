//Aya Salama
//I pledge my honor that I have abided by the Stevens Honor System.

import java.util.Random;

public class Treap<E extends Comparable<E>>{

    private static class Node<E>{

        public E data; // key for the search
        public int priority; // random heap priority
        public Node <E> left;
        public Node <E> right;

        /**
         * constructor
         * @param data
         * @param priority
         */
        public Node(E data, int priority ){
            if(data == null)
                throw new NullPointerException("Data is null.");
            this.data = data;
            this.priority = priority;
            left = null;
            right = null;
        }

        /**
         * performs a right rotation and updates the data
         * and priority attributes as well as the left and
         * right pointers of the involved nodes accordingly.
         * @return root of the result
         */
        Node<E> rotateRight(){
            return rotateRight(this);
        }

        /**
         * helper function to rotateRight()
         * @param root
         * @return updated root after rotating right
         */
        private Node<E> rotateRight(Node<E> root){
            if(root == null)
                throw new NullPointerException("Root is null.");
            Node<E> newRoot = root.left;
            Node<E> move = null;
            if(root.left != null)
                move = root.left.right;
            newRoot.right = root;
            root.left = move;
            return newRoot;
        }

        /**
         * performs a left rotation and updates the
         * attributes of the nodes accordingly.
         * @return root of the result
         */
        Node<E> rotateLeft(){
            return rotateLeft(this);
        }

        /**
         * helper function to rotateLeft()
         * @param root
         * @return updated root after rotating left
         */
        private Node<E> rotateLeft(Node<E> root) {
            if(root == null)
                throw new NullPointerException("Root is null.");
            Node<E> newRoot = root.right;
            Node<E> move = null;
            if(root.right != null)
                move = root.right.left;
            newRoot.left = root;
            root.right = move;
            return newRoot;
        }
    }

    private Random priorityGenerator;
    private Node<E> root;

    /**
     * constructor
     */
    public Treap(){
        root = null;
        priorityGenerator = new Random();
    }

    /**
     *constructor
     * @param seed
     */
    public Treap(long seed){
        root = null;
        priorityGenerator = new Random(seed);
    }

    /**
     *
     * @return root of the tree
     */
    public Node<E> getRoot(){
        return root;
    }


    /**
     * inserts the given element into tree
     * @param key
     * @return true if no node contains the same key
     */
    boolean add(E key){
        return add(key, priorityGenerator.nextInt());
    }

    /**
     * inserts the given element into tree
     * @param key
     * @param priority
     * @return true if no node contains the same key
     */
    boolean add(E key, int priority){
        if(find(key) || key == null)
            return false;
        root = insert(root, key, priority);
        return true;
    }


    /**
     * code taken from class but altered accordingly to fit the heap
     * requirement using rotations
     * @param x
     * @param key
     * @return
     */
    private Node<E> insert(Node<E> x, E key, int priority){
        if(x == null) {
            x = new Node(key, priority);
        }
        int compare = key.compareTo((E) x.data);
        if(compare < 0) {
            x.left = insert(x.left, key, priority);
            if (x.left.priority > x.priority) {
                x = x.rotateRight();
            }
        }
        if(compare > 0) {
            x.right = insert(x.right, key, priority);
            if (x.right.priority > x.priority) {
                x = x.rotateLeft();
            }
        }
        return x;
    }

    /**
     * deletes the node with the given key
     * @param key
     * @return true if key was found, false otherwise
     */
    boolean delete(E key){
        if(!find(key) || key == null)
            return false;
        root = delete(root, key);
        return true;
    }


    /**
     * code taken from class!!
     * used as a helper function to delete
     * @param x
     * @return
     */
    private Node<E> deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    /**
     * code taken from class but adjusted to fit
     * requirements of heap using priority.
     * used as a helper function to delete
     * @param x
     * @param key
     * @return
     */
    private Node<E> delete(Node<E> x, E key){
        if(x == null)
            return null;
        int compare = key.compareTo((E) x.data);
        if(compare < 0)
            x.left = delete(x.left, key);
        else if(compare > 0)
            x.right = delete(x.right, key);
        else{
            if(x.left == null && x.right == null)
                return null;
            else if(x.right == null)
                return x.left;
            else if(x.left == null)
                return x.right;
            else{
                if(x.left.priority > x.right.priority)
                    return delete(x.rotateRight(), key);
                if(x.left.priority < x.right.priority)
                    return delete(x.rotateLeft(), key);
            }
            Node temp = x;
            x = min(x.right);
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        return x;
    }

    /**
     * code taken from cass!!
     * used as a helper function to delete
     * @param x
     * @return
     */
    private Node min(Node x){
        if(x.left == null) return x;
        else return min(x.left);
    }

    /**
     * Finds a node with the given key in
     * the treap rooted at root
     * @param root
     * @param key
     * @return true if key is found, false otherwise
     */
    private boolean find(Node <E> root, E key){
        if(root == null || key == null)
            return false;
        int compare = root.data.compareTo(key);
        if(compare > 0)
            return find(root.left, key);
        else if(compare < 0)
            return find(root.right, key);
        else
            return true;
    }

    /**
     * Finds a node with the given key in the treap
     * @param key
     * @return true if key is found, false otherwise
     */
    public boolean find(E key){
        return find(root, key);
    }

    /**
     * Carries out a preorder traversal of the tree
     * @return representation
     * of the treap as a string
     */
    public String toString(){
        return toString(root, 0);
    }

    /**
     * code taken from class but adjusted accordingly
     * @param current
     * @return
     */
    private String toString(Node<E> current, int level){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < level; i++)
            s.append("  ");
        if(current == null)
            s.append("null\n");
        else{
            s.append("(key=" + current.data.toString() + ", priority=" + current.priority + ")" + "\n");
            s.append(toString(current.left, level + 1));
            s.append(toString(current.right, level + 1));
        }
        return s.toString();
    }
}