package com.xdu.dingyu.stackandqueue;
import com.xdu.dingyu.linkedlist.Linkedlist;

/**
 * stack implemented using linked list
 * @author Ding Yu
 * @date 2019/5/15
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {
    private Linkedlist<E> ll;

    public LinkedStack() {
        ll = new Linkedlist<>();
    }

    @Override
    public int getSize() {
        return ll.getSize();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public E peek() {
        return ll.deleteFirst();
    }

    @Override
    public E pop() {
        return ll.getFirst();
    }

    @Override
    public void push(E e) {
        ll.addFirst(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("TOP [ ");

        for(int i = 0; i < ll.getSize(); i++) {
            sb.append(ll.get(i));

            if(i != ll.getSize() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
