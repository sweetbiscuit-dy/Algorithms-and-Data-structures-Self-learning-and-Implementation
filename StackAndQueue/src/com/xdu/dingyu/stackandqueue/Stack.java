package com.xdu.dingyu.stackandqueue;

public interface Stack<E> {
    public abstract void push(E e);
    public abstract E pop();
    public abstract E peek();
    public abstract int getSize();
    public abstract boolean isEmpty();
}
