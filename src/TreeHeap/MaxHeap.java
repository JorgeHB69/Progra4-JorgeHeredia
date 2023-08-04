package TreeHeap;

public class MaxHeap {
    private int[] vector;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.vector = new int[maxSize + 1];
        this.size = 0;
        this.maxSize = maxSize;
        vector[0] = Integer.MAX_VALUE;
    }

    public int getParent(int pos) {
        return (pos / 2);
    }

    public int getLeftChild(int pos) {
        return (pos * 2);
    }

    public int getRightChild(int pos) {
        return (pos * 2) + 1;
    }

    public void insert(int element) {
        vector[++size] = element;
        int current = size;
        verifyParent(current);
    }

    public void verifyParent(int pos) {
        int temp = vector[pos];
        while(pos > 0 && temp > vector[getParent(pos)]){
            vector[pos] = vector[getParent(pos)];
            pos = getParent(pos);
        }
        vector[pos] = temp;
    }

    public void swap(int xPos, int yPos) {
        int temp = vector[xPos];
        vector[xPos] = vector[yPos];
        vector[yPos] = temp;
    }

    public int peek() {
        int max = vector[1];
        vector[1] = vector[size];
        vector[size] = 0;
        size--;
        verifyChildren(1);
        return max;
    }

    public void verifyChildren(int pos){
        if (pos >= (size / 2) && pos <= size && pos != 3)
            return;

        int leftPos = getLeftChild(pos);
        int rightPos = getRightChild(pos);

        if (vector[pos] < vector[leftPos] || vector[pos] < vector[rightPos]) {
            if (vector[leftPos] > vector[rightPos]) {
                swap(pos, leftPos);
                verifyChildren(leftPos);
            } else {
                swap(pos, rightPos);
                verifyChildren(rightPos);
            }
        }
    }

    public void print() {
        int counter = 1;
        String maxHeap = " [" + vector[1] + "] \n";
        for (int i = 2; i <= size; i++) {
            maxHeap += " [" + vector[i] + "] " + " [" + vector[i + 1] + "] ";
            i++;
            if (i == (counter * 2 + 1)) {
                counter = counter * 2 + 1;
                maxHeap += "\n";
            }
        }
        System.out.println(maxHeap);
    }

    public boolean delete(int element) {
        int indexElement = search(element);
        if (indexElement != 0) {
            vector[indexElement] = vector[size];
            vector[size] = 0;
            size--;
            verifyChildren(indexElement);
            return true;
        } else return false;
    }

    public int search(int element) {
        for (int i = 1; i <= size; i++) {
            if (vector[i] == element) return i;
        }
        return 0;
    }

    public int[] getVector() {
        return vector;
    }
}
