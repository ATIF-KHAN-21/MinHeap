
import java.util.*;

class MinHeap {

    List<Integer> heap;

    public MinHeap() {
        // this create empty heap
        heap = new ArrayList<>();

    }

    // heapify from bottom
    public MinHeap(int[] idx) {

        // this always initialize ArrayList when new object is created with array
        // element
        // heap = new ArrayList<>();
        // instead this we can do constructor chaining
        this();

        for (int i : idx) {
            heap.add(i);
        }
        int n = heap.size();
        // Leaf nodes start from n/2, so last parent is n/2 - 1.
        // Ultra-simple sentence (interview)
        // We use n/2 - 1 because nodes after that are leaf nodes and don’t have
        // children.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i);
        }

    }

    // heapify logic
    public void heapify(int idx) {

        int size = heap.size();
        int small = idx;
        while (idx < size) {

            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            if (left < size && heap.get(left) < heap.get(small)) {
                small = left;
            }
            if (right < size && heap.get(right) < heap.get(small)) {
                small = right;
            }
            if (small != idx) {
                Collections.swap(heap, idx, small);
                idx = small;
            } else {
                break;
            }

        }
    }

    // Inserted Logic
    public void insert(int val) {

        heap.add(val);
        int idx = heap.size() - 1;

        while (idx > 0) {

            int parenIdx = (idx - 1) / 2;

            if (heap.get(parenIdx) > heap.get(idx)) {
                Collections.swap(heap, idx, parenIdx);
                idx = parenIdx;
            } else { // already heapify
                break;
            }
        }
    }

    // get top elemnt

    public int peek() {

        if (heap.size() == 0) {
            return -1;
        }
        int top = heap.get(0);
        return top;

    }

    // pop min in constant time logic
    public int pop() {
        if (heap.size() == 0) {
            return -1;
        }
        int lastdx = heap.size() - 1;

        int valr = heap.get(0);
        heap.set(0, heap.get(lastdx));
        heap.remove(lastdx);
        heapify(0);
        return valr;
    }

    // print
    public void print() {

        for (int i = 0; i < heap.size(); i++) {

            System.out.print(heap.get(i) + " ");
        }
    }

}

public class heap1 {

    public static void main(String[] args) {

        int[] a = { 5, 10, 20, 2, 30, 0 };
        MinHeap hp = new MinHeap(a);
        // hp.print();

        // insert
        // hp.insert(2);
        // hp.insert(3);
        // hp.insert(0);

        // //delete
        // int x = hp.pop();
        // System.out.println(x);
        hp.print();
    }
}
