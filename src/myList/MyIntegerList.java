package myList;

import java.util.Iterator;

/**
 * Created by Asus on 31.08.2016.
 */
public class MyIntegerList implements MyList {
    private Node root;
    private Node currentNode;
    private int size;

    public MyIntegerList() {
        size = 0;
    }

    @Override
    public void put(Object o) throws ClassCastException {
        if (o instanceof Integer) {
            if (size == 0) {
                root = new Node((Integer) o);
                currentNode = root;
            } else {
                currentNode.nextNode = new Node((Integer) o);
                currentNode = currentNode.nextNode;
            }
            size++;
        } else
            throw new ClassCastException("Class cast exception in put() method: provided argument is not instance of Integer.");
    }

    @Override
    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     */
    public boolean remove(Object o) {
        if (o instanceof Integer) {
            if (size == 0) {
                return false;
            }
            if (size == 1) {
                if (root.value.equals((Integer) o)) {
                    root = null;
                    currentNode = null;
                }
            }
            int size = this.size;
            Node previous = root;
            Node current = root.nextNode;
            while (size != 0) {
                if (current.value.equals((Integer) o)) {
                    previous.nextNode = current.nextNode;
                    current = null;
                    this.size--;
                    return true;
                }
                previous = current;
                current = current.nextNode;
                previous.nextNode = current;
                size--;
            }
            return false;
        }
        throw new ClassCastException("Class cast exception in remove() method: provided argument is not instance of Integer.");
    }

    @Override
    public String toString(){
     StringBuilder str = new StringBuilder("");
        int size = this.size;
        Node current = root;
        while (size != 0){
            str.append(String.valueOf(current.value.intValue()));
            str.append(" ");
            current = current.nextNode;
            size--;
        }
        return str.toString();
}

    private class Node {
        private Integer value;
        private Node nextNode;

        private Node(Integer value) {
            this.value = value;
        }
    }
public Iterator iterator(){
    Iterator iterator = new Iterator();
    iterator.currentNode = root;
    return iterator;
}
    private class Iterator implements java.util.Iterator<Integer> {
        Node currentNode;
        @Override
        public boolean hasNext() {
            if(currentNode.nextNode == null)
            return false;

            return true;
        }

        @Override
        public Integer next() {
            Integer value = currentNode.value;
            currentNode = currentNode.nextNode;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}