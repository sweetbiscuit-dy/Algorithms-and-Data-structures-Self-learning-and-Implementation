package mergesort;

import java.util.Arrays;

/**
 * implementation of merge sort
 * @author Ding Yu
 * @date 2019/6/15
 */
public class MergeSort<T extends Comparable<? super T>> {
    class Node {
        public T element;
        public Node next;

        public Node(T val) {
            this.element = val;
            this.next = null;
        }
    }

    public Node makeLinkedList(T[] tArray) {
        if(tArray == null || tArray.length == 0) {
            throw new IllegalArgumentException("tArray is illegal");
        }

        Node head = new Node(tArray[0]);
        Node headCopy = head;

        for(int i = 1; i < tArray.length; i++) {
            headCopy.next = new Node(tArray[i]);
            headCopy = headCopy.next;
        }

        headCopy.next = null;
        return head;
    }
    /**
     * for user only
     * @param array
     */
    public static void sort(Comparable[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        else {
            sort(array, 0, array.length - 1);
        }
    }

    /**
     * for internal call. a top down implementation
     * @param array
     * @param left
     * @param right
     */
    private static void sort(Comparable[] array, int left ,int right) {
        if(left >= right) {
            return;
        }

        // the calculation of 'middle' here can avoid overflow on int type. but this is not universal,
        // if the data are stored in linked list, this is invalid. we can use 'fast-slow pointer'
        // method to solve it.
        int middle = left + (right - left) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);

        // we can do some optimization here, because it is not necessary to merge two arrays
        // every time they are sorted, if the whole array is already in the expected order,
        // there is no need merging.

        // the original logic
        // merge(array, left, middle, right);

        // here is the optimization
        if(array[middle].compareTo(array[middle + 1]) > 0) {
            merge(array, left, middle, right);
        }
    }
    private static void merge(Comparable[] array, int left, int middle, int right) {
        // we use extra space to reduce the complexity in the merging process.
        Comparable[] arrayCopy = Arrays.copyOfRange(array,left, right + 1);

        int leftPartPointer = left;
        int rightPartPointer = middle + 1;

        for(int k = left; k <= right; k++) {
                if(leftPartPointer > middle) {
                array[k] = arrayCopy[rightPartPointer - left];
                rightPartPointer++;
            }
            else if(rightPartPointer > right) {
                array[k] = arrayCopy[leftPartPointer - left];
                leftPartPointer++;
            }
            else if(arrayCopy[leftPartPointer - left].compareTo(arrayCopy[rightPartPointer - left]) < 0) {
                array[k] = arrayCopy[leftPartPointer - left];
                leftPartPointer++;
            }
            else if(arrayCopy[leftPartPointer - left].compareTo(arrayCopy[rightPartPointer - left]) > 0) {
                array[k] = arrayCopy[rightPartPointer - left];
                rightPartPointer++;
            }
        }
    }

    /**
     * merge sort bottom-up linked list
     */
    public Node SortBULL(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        int length = 0;
        Node headCopy = head;
        while(headCopy != null) {
            length++;
            headCopy = headCopy.next;
        }

        Node left;
        Node right;
        Node current;
        Node dummyHead = new Node(null);
        Node tail = dummyHead;
        tail.next = head;

        for(int i = 1; i <= length; i += i) {
            current = dummyHead.next;
            tail = dummyHead;
            while(current != null) {
                left = current;
                right = split(current, i);
                current = split(right, i);
                tail = mergeLLAsc(left, right, tail, true);
            }
        }

        return dummyHead.next;
    }

    /**
     * split the given array in two parts with the length of the first part being 'step'.
     * @param head head node of a given array.
     * @param step the length of the first part after splitting.
     * @return the second part's head node.
     */
    private Node split(Node head, int step) {
        if(step < 0) {
            throw new IllegalArgumentException("argument step is negative. illegal");
        }
        if(head == null) {
            // throw new IllegalArgumentException("argument head is NULL. illegal");
            return null;
        }

        Node headCopy = head;
        for(int i = 0; i < step - 1; i++) {
            headCopy = headCopy.next;
        }
        if(headCopy == null) {
            return null;
        }

        Node nextHalf = headCopy.next;

        headCopy.next = null;

        return nextHalf;
    }

    /**
     * merge two linked lists in the expected order.
     * @param a one linked list
     * @param b the other linked list
     * @param flag true: merge in ascending order. false: merge in descending order.
     * @return the tail node after the merging process.
     */
    public Node mergeLLAsc(Node a, Node b, Node tail, boolean flag) {
        Node aCopy = a;
        Node bCopy = b;
        //Node current = a.element.compareTo(b.element) < 0 ? a : b;
        while (aCopy != null && bCopy != null) {
            if(flag) {
                if(aCopy.element.compareTo(bCopy.element) <= 0) {
                    // current = aCopy;
                    tail.next = aCopy;
                    aCopy = aCopy.next;
                    tail = tail.next;
                    // bCopy = bCopy.next;
                }
                else {
                    // current = bCopy;
                    tail.next = bCopy;
                    bCopy = bCopy.next;
                    tail = tail.next;
                    // aCopy = aCopy.next;
                }
            }
            else {
                if(aCopy.element.compareTo(bCopy.element) > 0) {
                    tail.next = aCopy;
                    aCopy = aCopy.next;
                    tail = tail.next;
                    // bCopy = bCopy.next;
                }
                else {
                    tail.next = bCopy;
                    bCopy = bCopy.next;
                    tail = tail.next;
                    // aCopy = aCopy.next;
                }
            }
        }

        tail.next = (aCopy == null) ? bCopy : aCopy;

        while(tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }
}
