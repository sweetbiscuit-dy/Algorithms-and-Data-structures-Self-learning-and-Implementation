package com.xdu.dingyu.queue;

/**
 * based on Array, the running time of dequeue() is now reduced to O(1)
 * @author Ding Yu
 * @date 2019/5/10 morning in the lab
 */
public class LoopQueue<E> implements Queue<E> {
    E[] emelents;
    int front;
    int tail;
    int size;

    public LoopQueue(int capacity) {
        //note that the actual space is capacity + 1, because we need an extra slot to make
        emelents = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(16);
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % emelents.length == front) {
            resize(2 * getCapacity());
        }
        emelents[tail] = e;
        tail = (tail + 1) % emelents.length;
        size++;
    }

    @Override
    public E dequeue() {
        front++;
        size--;
        return emelents[front];
    }

    @Override
    public E getFront() {
        return emelents[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return emelents.length - 1;
    }

    private void resize(int newSize) {
        E[] newArray = (E[]) new Object[newSize + 1];

        for(int i = front; i % emelents.length < tail; i++) {
            newArray[i - front] = emelents[i % emelents.length];
        }

        front = 0;
        tail = size;
        emelents = newArray;
        newArray = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loop Queue HEAD : [");

        for(int i = front; i % emelents.length < tail; i++) {
            sb.append(emelents[i % emelents.length]);
            if(i % getSize() != tail - 1) {
                sb.append(", ");
            }
        }

        sb.append("] Loop Queue TAIL --- Size is : ").append(getSize()).append(" --- Capacity is : ").append(getCapacity());
        return sb.toString();
    }
}
