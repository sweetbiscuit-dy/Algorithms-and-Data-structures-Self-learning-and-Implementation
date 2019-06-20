package com.xdu.dingyu.binarysearchtree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * implement binary search tree
 * @author Ding Yu
 * @date 2019/5/18 morning in the lab
 */
public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        public E element;
        public Node leftChild;
        public Node rightChild;

        public Node(E element) {
            this.element = element;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add an elment to the binary search tree. for user level
     * @param element an element to be add to the binary search tree
     */
    public void add(E element) {
        root = add(element, root);
    }

    /**
     * recursive method. returns the new root of a binary search tree after the element 'element' is inserted in the right place
     * @param element the element to be inserted
     * @param root the root of a binary tree
     * @return the new root of a binary tree after the insertion operation
     */
    private Node add(E element, Node root) {
        // base case. just create a new node, but have not connected the new node to the tree
        if(root == null) {
            return new Node(element);
        }

        // recursion case. make connections between the new node and the tree
        if(element.compareTo(root.element) > 0) {
            root.rightChild = add(element, root.rightChild);
        }
        else if(element.compareTo(root.element) < 0) {
            root.leftChild = add(element, root.leftChild);
        }
        else { // if(e.compareTo(root.e) == 0)
            // do nothing
        }

        return root;
    }

    /**
     * check if a given element e is in the tree. for user level
     * @param element the element we are looking for
     * @return true: found. false: not found
     */
    public boolean contains(E element) {
        return contains(element, root);
    }

    /**
     * recursive method.
     * @param element the element we are looking for
     * @param root the root of a tree
     * @return true: found. false: not found
     */
    private boolean contains(E element, Node root) {
        if(root == null) {
            return false;
        }

        if(element.compareTo(root.element) > 0) {
            return contains(element, root.leftChild);
        }
        else if(element.compareTo(root.element) < 0) {
            return contains(element, root.rightChild);
        }
        else {
            return true;
        }
    }

    /**
     * traverse the whole tree in 'pre-order'. for user level
     */
    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    /**
     * recursive method.
     * @param root the root of a tree
     */
    private void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }

        // do something with the parent node, this is why we call it pre order traverse
        // because we process the parent node before its children.
        // here I just print out the node, and you can choose to do other things.
        System.out.println(root.element);

        // next I go on dealing with the left child and the right child.
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    /**
     * traverse the whole tree in 'pre-order' without recursion
     */
    public void preOrderTraverseNR() {
        Stack<Node> stack = new Stack<>();

        if(root == null) {
            System.out.println("tree is empty");
        }
        else {
            stack.push(root);
            while (!stack.empty()) {
                // here you can do some other things to the parent node other than just print it out
                Node popNode = stack.pop();
                System.out.println(popNode.element);
                if(popNode.rightChild != null) {
                    stack.push(popNode.rightChild);
                }
                if(popNode.leftChild != null) {
                    stack.push(popNode.leftChild);
                }
            }
        }
    }

    /**
     * traverse the whole tree in 'in-order'. for user level
     */
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    /**
     * recursive method
     * @param root the root of a tree
     */
    private void inOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        inOrderTraverse(root.leftChild);

        // actually you can do something to the parent node other than just print it out
        System.out.println(root.element);

        inOrderTraverse(root.rightChild);
    }

    /**
     * traverse the whole tree in 'in-order' without recursion
     */
    public void inOrderTraverseNR() {
        Stack<Node> stack = new Stack<>();
        Node rootCopy = root;

        while (rootCopy != null || !stack.empty()) {
            if(rootCopy != null) {
                stack.push(rootCopy);
                rootCopy = rootCopy.leftChild;
            }
            else {
                Node popNode = stack.pop();
                // you can do something else more than just print the node out here
                System.out.println(popNode.element);
                rootCopy = popNode.rightChild;
            }
        }
    }

    /**
     * traverse the whole tree in 'post-order'. for user level
     */
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    /**
     * recursive method
     * @param root the root of a tree
     */
    private void postOrderTraverse(Node root) {
        if(root == null) {
            return;
        }

        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);

        System.out.println(root.element);
    }

    /**
     * traverse the whole tree in 'post-order' without recursion
     */
    public void postOrderTraverseNR() {
        Stack<Node> stack = new Stack<>();
        Node preVisitedNode = null;
        Node currentNode = root;

        while (currentNode != null || !stack.empty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            }

            // the current node always comes from the top of the stack
            currentNode = stack.peek();

            // if the current has no right child or the current node's right child is the same as the pre-visited node which means the node itself
            // has already been visited, then we process this node
            if(currentNode.rightChild == null || currentNode.rightChild == preVisitedNode) {
                //you can do something to the current node other than just print it out
                System.out.println(currentNode.element);

                //set the current node to be the pre-visited node because we have already finished processing the current node
                preVisitedNode = currentNode;

                //
                stack.pop();

                // set the current node null to avoid infinite loop
                currentNode = null;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
    }

    /**
     * traverse the whole tree in 'level-order'.
     * all the traverse methods above belong to the DFS(Depth First Search), the below method is the BFS(Breadth First Search).
     */
    public void levelTraverse() {
        LinkedList<Node> queue = new LinkedList<>();

        Node rootCopy = root;
        queue.add(rootCopy);

        while (!queue.isEmpty()) {
            //you can do something to the current node other than just print it out
            Node popNode = queue.pop();
            System.out.println(popNode.element);

            if(popNode.leftChild != null) {
                queue.add(popNode.leftChild);
            }

            if(popNode.rightChild != null) {
                queue.add(popNode.rightChild);
            }

        }
    }

    /**
     * find the max or min node of a tree.
     * @param root the root node of a tree.
     * @param findMax true: find the max node. false: find the min mode.
     * @return the node found.
     */
    public Node findMaxMin(Node root, boolean findMax) {
        if(root == null) {
            return root;
        }

        Node rootCopy = root;
        if(findMax) {
            while(rootCopy.rightChild != null) {
                rootCopy = rootCopy.rightChild;
            }
        }
        else {
            while(rootCopy.leftChild != null) {
                rootCopy = rootCopy.leftChild;
            }
        }

        return rootCopy;
    }

    /**
     * delete the max or min node in a tree.
     * @param root the root node of a tree.
     * @param deleteMax true: delete the max node. false: delete the min node.
     * @return the node deleted.
     */
    public Node deleteMaxMin(Node root, boolean deleteMax) {
        if(root == null) {
            return root;
        }
        Node parentNode = root;
        Node deletedNode;
        Node nextNode;

        if(deleteMax) {
            nextNode = parentNode.rightChild;
            while(nextNode.rightChild != null) {
                parentNode = nextNode;
                nextNode = nextNode.rightChild;
            }

            if(nextNode.leftChild == null) {
                deletedNode = nextNode;
                parentNode.rightChild = null;
                nextNode = null;
            }
            else {
                deletedNode = nextNode;
                parentNode.rightChild = nextNode.leftChild;
                nextNode = null;
            }
        }
        else {
            nextNode = parentNode.leftChild;
            while(nextNode.leftChild != null) {
                parentNode = nextNode;
                nextNode = nextNode.leftChild;
            }

            if(nextNode.rightChild == null) {
                deletedNode = nextNode;
                parentNode.leftChild = null;
                nextNode = null;
            }
            else {
                deletedNode = nextNode;
                parentNode.leftChild = nextNode.rightChild;
                nextNode = null;
            }
        }

        return deletedNode;
    }

    public Node delete() {

    }
}