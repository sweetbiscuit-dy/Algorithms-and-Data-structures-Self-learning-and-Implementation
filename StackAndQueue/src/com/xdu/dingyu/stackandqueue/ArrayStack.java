package com.xdu.dingyu.stackandqueue;

import com.xdu.dingyu.ArraySecondEdition;


/**
 * use self-implemented array to implement stack
 * @author Ding Yu
 * @date 2019/5/6
 * @param <E>
 */

public class ArrayStack<E> implements Stack<E> {
    ArraySecondEdition ase;

    public ArrayStack(int capacity) {
        ase = new ArraySecondEdition(capacity);
    }

    public ArrayStack() {
        ase = new ArraySecondEdition();
    }

    @Override
    public void push(E e) {
        ase.addLast(e);
    }

    @Override
    public E pop() {
        return ase.removeLast();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int getSize() {
        return ase.getSize();
    }

    @Override
    public boolean isEmpty() {
        return ase.isEmpty();
    }

    public int getCapacity() {
        return ase.getCapacity();
    }
}
