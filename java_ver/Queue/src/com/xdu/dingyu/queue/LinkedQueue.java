package com.xdu.dingyu.queue;

/**
 * implement queue with linked list. data structure linked list is reconstructed here.
 */
public class LinkedQueue<E> implements Queue<E>{
    class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this(null, null);
        }
    }


    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        this.head = new Node();
        this.tail = this.head;
    }

    public LinkedQueue(E[] elementArray) {
        if(elementArray.length == 0) {
            this.head = new Node();
            this.tail = this.head;
        }
        else {
            head = new Node(elementArray[0]);
            size = 1;

            Node headCopy = head;

            for(int i = 1; i < elementArray.length; i++) {
                Node currentNode = new Node(elementArray[i]);
                headCopy.next = currentNode;
                headCopy = currentNode;
                size++;
            }
            tail = headCopy;
            tail.next = null;
        }
    }

    @Override
    public E dequeue() {
        if(size == 0) {
            throw new IllegalArgumentException("Queue is already empty, dequeue failed");
        }

        Node temp = head;
        E deletedValue = temp.e;
        head = head.next;
        size--;
        temp = null;

        return deletedValue;
    }

    @Override
    public void enqueue(E e) {
        Node newNode = new Node(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node printHead = head;
        StringBuilder sb = new StringBuilder();

        sb.append("Linked Queue HEAD : [ ");
        for(int i = 0; i < size; i++) {
            sb.append(printHead.e);
            if(i != size - 1) {
                sb.append(", ");
            }
            printHead = printHead.next;
        }

        sb.append(" ] Linked Queue TAIL ").append("Size is : ").append(size);

        return sb.toString();
    }
}