package mergesort;

/**
 * a bottom-up implementation of merge sort on a sequence organized in a linked list.
 * @author Ding Yu
 * @date 2019/6/16
 */
public class MergeSort {
    private class Node<T> {
        T element;
        Node next;

        public Node(T val) {
            this.element = val;
        }
    }
    /**
     * merge sort bottom-up linked list
     */
    public static void mergeSortBULL(Node head) {

    }

    public static Node split(Node head, int step) {
        if(step < 0) {
            throw new IllegalArgumentException("argument step is negative. illegal");
        }
        if(head == null) {
            throw new IllegalArgumentException("argument head is NULL. illegal");
        }

        Node headCopy = head;
        for(int i = 0; i < step - 1; i++) {
            headCopy = headCopy.next;
        }
        Node nextHalf = headCopy.next;

        headCopy.next = null;

        return nextHalf;
    }
}
