package com.xdu.dingyu.queue;

/**
 * based on Array, the running time of dequeue() is now reduced to O(1)
 * @author Ding Yu
 * @date 2019/5/10 morning in the lab
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] elements;
    private int front;
    private int tail;
    private int size;
    private int enlargeFactor = 2;
    private int shrinkFactor = 2;
    private int shrinkJudgeFactor = 4;

    public LoopQueue(int capacity) {
        //note that the actual space is capacity + 1, because we need an extra slot to make
        elements = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(16);
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % elements.length == front) {
            resize(enlargeFactor * getCapacity());
        }
        elements[tail] = e;
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is already empty");
        }
        front = (front + 1) % elements.length;
        size--;
        //make sure that when shrinking the size, the capacity cannot be reduced to zero
        if(size == getCapacity() / shrinkJudgeFactor && getCapacity() / shrinkFactor != 0) {
            resize(getCapacity() / shrinkFactor);
        }
        return elements[front];
    }

    @Override
    public E getFront() {
        return elements[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private int getCapacity() {
        return elements.length - 1;
    }

    private void resize(int newSize) {
        E[] newArray = (E[]) new Object[newSize + 1];

        for(int i = front; i % elements.length < tail; i++) {
            newArray[i - front] = elements[i % elements.length];
        }

        front = 0;
        tail = size;
        elements = newArray;
        newArray = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loop Queue HEAD : [");

        for(int i = front; i % elements.length < tail; i++) {
            sb.append(elements[i % elements.length]);
            if(i % getSize() != tail - 1) {
                sb.append(", ");
            }
        }

        sb.append("] Loop Queue TAIL --- Size is : ").append(getSize()).append(" --- Capacity is : ").append(getCapacity());
        return sb.toString();
    }
}
