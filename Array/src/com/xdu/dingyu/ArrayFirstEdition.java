package com.xdu.dingyu;
/**
 * ArrayFirstEdition class. This is the very prototype of the array implemented by myself.
 * Only very basic fields and functions are added to the class.
 * @author Dingyu
 * @date 2019/4/29
 */

public class ArrayFirstEdition {
    /**
     * capacity
     * the total slots assigned to the array while initializing
     */
    private int capacity;

    /**
     * size
     * the slots actually used.
     */
    private int size;

    /**
     * array
     * the real array
     */
    private int[] array;

    /**
     * construction method with an argument
     * @param capacity the initial slots assigned to the array, decided by the user
     */
    public ArrayFirstEdition(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * construction method without an argument
     * the default capacity is 10
     */
    public ArrayFirstEdition() {
        this(10);
    }

    /**
     * @return the capacity of the array
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the slots used
     */
    public int getSize() {
        return size;
    }

    /**
     * @return check if the array is empty(size == 0)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return check if the array is full(size == capacity)
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * insert an element e into the given position indicated by the argument index
     * @param index the position of insertion
     * @param e the element to be inserted to the certain position
     */
    public void add(int index, int e) {
        if(isFull()) {
            throw new IllegalArgumentException("the array is already");
        }

        if(index < 0 || index >= capacity) {
            throw new IllegalArgumentException("index out of bound");
        }

        for(int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        size++;
    }

    /**
     * add an element to the head of the array
     * @param e an element to be inserted to the head of the array
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * add an element to the tail of the array
     * @param e an element to be inserted to the tail of the array
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * remove an element according the the given index
     * @param index the position of the array where the corresponding element is removed
     */
    public int remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of bound");
        }

        int ret = array[index];

        if(isEmpty()) {
            throw new IllegalArgumentException("the array is already empty");
        }

        for(int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return ret;
    }

    /**
     * return an element according to the given index
     * @param index the position of the array where the corresponding element is returned
     * @return the corresponding element
     */
    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of bound");
        }

        return array[index];
    }

    public int getFirst() {
        return get(0);
    }

    public int getLast() {
        return get(size - 1);
    }

    /**
     * set the value of the element in the given position
     * @param index the position of the element whose value is going to be altered
     * @param e the new value
     */
    public void set(int index, int e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal");
        }

        array[index] = e;
    }

    /**
     * check if a given element e is in the array
     * @param e element
     * @return true if e is in the array and false if not
     */
    public boolean contains(int e) {
        for(int i = 0; i < size; i++) {
            if(array[i] == e) {
                return true;
            }
        }

        return false;
    }

    /**
     * find the index of the given element e, if it is not in the element, return -1
     * @param e element
     * @return the index of e if it is in the array, -1 if it is not
     */
    public int find(int e) {
        for(int i = 0; i < size; i++) {
            if(array[i] == e) {
                return i;
            }
        }

        return -1;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }

        sb.append(array[size - 1]);
        sb.append(String.format(" --- array capacity is : %d, array size is : %d", capacity, size));
        return sb.toString();
    }
}
