package BTree;

public class Node {
    private int[] keys;
    private int order;
    private Node[] children;
    private int numKeys;
    private boolean leaf;

    public Node(int order, boolean leaf) {
        this.order = order;
        this.leaf = leaf;
        this.keys = new int[order - 1];
        this.children = new Node[order];
        this.numKeys = 0;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public void setKeys(int[] keys) {
        this.keys = keys;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public void incrementNumKeys() {
        this.numKeys++;
    }

    public void setNumKeys(int numKeys) {
        this.numKeys = numKeys;
    }

    public int[] getKeys() {
        return keys;
    }

    public int getNumKeys() {
        return numKeys;
    }

    public Node[] getChildren() {
        return children;
    }

    public int getOrder() {
        return order;
    }

    public boolean isLeaf() {
        return leaf;
    }
}
