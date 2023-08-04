package TreeHeap;

public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(7);
        maxHeap.insert(40);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(1);
        maxHeap.insert(5);

        maxHeap.print();

        System.out.println(maxHeap.delete(15));
        maxHeap.print();
    }
}
