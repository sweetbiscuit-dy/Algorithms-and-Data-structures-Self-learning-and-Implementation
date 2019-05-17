package com.xdu.dingyu.linkedlist;

/**
 * linked list implementation
 * @author Ding Yu
 * @date 2019/5/13 morning in the lab
 */
public class Linkedlist<E> {

    /**
     * the inner class, whose instance is the element of an linked list
     * @author Ding Yu
     * @date 2019/5/13 morning in the lab
     */
    private class Node {
        /**
         * the actual value of a node in a linked list
         */
        public E e;

        /**
         * the pointer that points to the next node
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * the first node in a linked list
     */
    private Node dummyHead;

    /**
     * the total number of nodes in a linked list
     */
    private int size;

    public Linkedlist() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public Linkedlist(E[] elementArray) {
        size = elementArray.length;
        dummyHead = new Node();

        if(elementArray.length == 0) {
        }
        else {
            Node headCopy = dummyHead;
            for(int i = 0; i < elementArray.length; i++) {
                Node currentNode = new Node(elementArray[i]);
                headCopy.next = currentNode;
                headCopy = currentNode;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal");
        } else {
            Node preNode = dummyHead;

            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }

            //the following three lines of code could be replaced by preNode.next = new Node(e, pre.next);
            Node insertNode = new Node(e);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
            size++;
        }
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E delete(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index is out of boundary");
        }

        Node deleted;
        E deletedValue;

        Node preDeleted = dummyHead;

        for(int i = 0; i < index; i++) {
            preDeleted = preDeleted.next;
        }
        deleted = preDeleted.next;
        deletedValue = deleted.e;

        preDeleted.next = deleted.next;
        deleted = null;

        size--;

        return deletedValue;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        else {
            Node currentNode = dummyHead.next;
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            return currentNode.e;
        }
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        else {
            Node current = dummyHead.next;

            for(int i = 0; i < index; i++) {
                current = current.next;
            }

            current.e = e;
        }
    }

    public boolean contains(E e) {
        Node currentNode = dummyHead.next;

        for(int i = 0; i < size; i++) {
            if(currentNode.e.equals(e)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node currentNode = dummyHead.next;

        for(int i = 0; i < size; i++) {
            sb.append(currentNode);
            if(i != size - 1) {
                sb.append(" --> ");
            }
            currentNode = currentNode.next;
        }

        sb.append(" -- > NULL");

        return sb.toString();
    }
}
