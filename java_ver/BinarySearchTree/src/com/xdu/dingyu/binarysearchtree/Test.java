package com.xdu.dingyu.binarysearchtree;

/**
 * test BinarySearchTree
 * @author Ding Yu
 * @date 2019/5/18 afternoon created in the lab
 */
public class Test {
    public static void main(String[] args) {
        Integer i0 = 7;
        Integer i1 = 5;
        Integer i2 = 10;
        Integer i3 = 4;
        Integer i4 = 6;
        Integer i5 = 9;
        Integer i6 = 12;

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(i0);
        bst.add(i1);
        bst.add(i2);
        bst.add(i3);
        bst.add(i4);
        bst.add(i5);
        bst.add(i6);

        bst.postOrderTraverse();

        System.out.println("------------------pre order traverse-----------------------------------");
        bst.preOrderTraverse();
        System.out.println("------------------pre order traverse non recursion---------------------");
        bst.preOrderTraverseNR();
        System.out.println("------------------in order traverse------------------------------------");
        bst.inOrderTraverse();
        System.out.println("------------------in order traverse non recursion----------------------");
        bst.inOrderTraverseNR();
        System.out.println("------------------post order traverse----------------------------------");
        bst.postOrderTraverse();
        System.out.println("------------------post order traverse non recursion--------------------");
        bst.postOrderTraverseNR();
        System.out.println("------------------level traverse non recursion-------------------------");
        bst.levelTraverse();
    }
}
