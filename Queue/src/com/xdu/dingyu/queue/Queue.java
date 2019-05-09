package com.xdu.dingyu.queue;

/**
 * @author Ding Yu
 * @date 2019/5/9 night in the lab
 */
public interface Queue<E> {
    public abstract void enqueue(E e);
    public abstract E dequeue();
    public abstract E getFront();
    public abstract int getSize();
    public abstract boolean isEmpty();
}
