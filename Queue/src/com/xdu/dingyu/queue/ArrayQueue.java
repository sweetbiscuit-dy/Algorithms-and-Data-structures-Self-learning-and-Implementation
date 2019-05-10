package com.xdu.dingyu.queue;

import com.xdu.dingyu.ArraySecondEdition;

/**
 * use array to implement queue
 * @author Ding Yu
 * @date 2019/5/9 night in the lab
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    private ArraySecondEdition<E> ase;
    private int front;

    public ArrayQueue(int capacity) {
        ase = new ArraySecondEdition<>(capacity);
    }

    public ArrayQueue() {
        ase = new ArraySecondEdition<>();
    }

    @Override
    public void enqueue(E e) {
        ase.addLast(e);
    }

    @Override
    public E dequeue() {
        return ase.removeFirst();
    }

    @Override
    public E getFront() {
        return ase.getFirst();
    }

    @Override
    public int getSize() {
        return ase.getSize();
    }

    @Override
    public boolean isEmpty() {
        return ase.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue HEAD : [");

        for(int i = 0; i < ase.getSize(); i++) {
            sb.append(ase.get(i));
            if(i != ase.getSize() - 1) {
                sb.append(", ");
            }
        }

        sb.append("] Queue TAIL --- Size is : ").append(ase.getSize());

        return sb.toString();
    }
}
