package TicketsBancarios;

import java.util.ArrayList;
import java.util.Vector;

public class PriorityHeap implements ITreeHeap<Client> {
    private ArrayList<Client> vector;
    private int size;

    public PriorityHeap() {
        this.vector = new ArrayList<>();
        Client firstValue = new Client("NOT CLIENT", Type.VIP);
        firstValue.setNumberOnQueue(Integer.MIN_VALUE);
        vector.add(firstValue);
        this.size = 0;
    }

    @Override
    public int getParent(int pos) {
        return (pos / 2);
    }

    @Override
    public int getLeftChild(int pos) {
        return (pos * 2);
    }

    @Override
    public int getRightChild(int pos) {
        return (pos * 2) + 1;
    }

    @Override
    public void insert(Client element) {
        vector.add(element);
        size++;
        verifyParent(size);
    }

    @Override
    public void swap(int xPos, int yPos) {
        Client temp = vector.get(xPos);
        vector.set(xPos, vector.get(yPos));
        vector.set(yPos, temp);
    }

    @Override
    public void verifyParent(int pos) {
        Client temp = vector.get(pos);
        while (pos > 0 && temp.compare(vector.get(getParent(pos))) == 1) {
            vector.set(pos, vector.get(getParent(pos)));
            pos = getParent(pos);
        }
        vector.set(pos, temp);
    }

    @Override
    public Client peek() {
        Client max = vector.get(1);
        vector.set(1, vector.get(size));
        vector.remove(size);
        size--;
        verifyChildren(1);
        return max;
    }

    @Override
    public void verifyChildren(int pos) {
        int leftPos = getLeftChild(pos);
        int rightPos = getRightChild(pos);

        if (leftPos > size) {
            return;
        } else if (rightPos > size) {
            if (vector.get(pos).compare(vector.get(leftPos)) == -1) {
                swap(pos, leftPos);
                verifyChildren(leftPos);
            }
        } else if (vector.get(pos).compare(vector.get(leftPos)) == -1 || vector.get(pos).compare(vector.get(rightPos)) == -1) {
            if (vector.get(leftPos).compare(vector.get(rightPos)) == 1) {
                swap(pos, leftPos);
                verifyChildren(leftPos);
            } else {
                swap(pos, rightPos);
                verifyChildren(rightPos);
            }
        }
    }

    @Override
    public void print() {
        int counter = 1;
        if (size <= 1) return;
        String maxHeap = " [" + vector.get(1) + "] \n";
        for (int i = 2; i < size; i++) {
            maxHeap += " [" + vector.get(i) + "] " + " [" + vector.get(i + 1) + "] ";
            i++;
            if (i == (counter * 2 + 1)) {
                counter = counter * 2 + 1;
                maxHeap += "\n";
            }
        }
        System.out.println(maxHeap + "\n" + vector + "\n");
    }

    @Override
    public boolean delete(Client element) {
        return false;
    }

    @Override
    public int search(Client element) {
        return 0;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Client> getVector() {
        return vector;
    }
}
