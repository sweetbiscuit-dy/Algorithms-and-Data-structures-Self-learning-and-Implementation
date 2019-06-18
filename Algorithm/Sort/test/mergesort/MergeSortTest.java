package mergesort;

import org.junit.jupiter.api.Test;
import mergesort.MergeSort.Node;
import utility.Utility;

class MergeSortTest {

    @Test
    void sort() {
    }

    @Test
    void makesLinkedList() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] testArray  = {-5, 2, 6, 8, -2, 3, 5};
        // Integer[] testArray2 = {-2, 3, 5, 9};

        System.out.println(Utility.print(testArray));
        // System.out.println(Utility.printArray(testArray2));

        Node linkedList1;
        // Node linkedList2;
        linkedList1 = ms.makeLinkedList(testArray);
        // linkedList2 = ms.makeLinkedList(testArray2);

        Node result = ms.SortBULL(linkedList1);

        StringBuilder sb = new StringBuilder();

        Node copy = result;

        // sb.append(copy.element);
        while(copy != null) {
            sb.append(copy.element);
            if(copy.next != null) {
                sb.append(" -> ");
            }
            copy = copy.next;
        }

        System.out.println(sb.toString());
    }

    @Test
    void sort1() {
    }

    @Test
    void sortBULL() {
    }
}