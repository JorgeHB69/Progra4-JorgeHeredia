package TicketsBancarios;

import java.util.ArrayList;

public interface ITreeHeap<T> {
    int getParent(int pos);
    int getLeftChild(int pos);
    int getRightChild(int pos);
    void insert(T element);
    void swap(int xPos, int yPos);
    void verifyParent(int pos);
    T peek();
    void verifyChildren(int pos);
    void print();
    boolean delete(T element);
    int search(T element);
    int getSize();
    ArrayList<T> getVector();
}
