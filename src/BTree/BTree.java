package BTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTree {
    private Node root;
    private int order;

    public BTree(int order) {
        this.order = order;
        this.root = null;
    }

    // Insert a key into the BTree.BTree
    public void insert(int key) {
        if (root == null) {
            // If the tree is empty, create a new root node
            root = new Node(order, true);
            root.getKeys()[0] = key;
            root.incrementNumKeys();
        } else {
            // If the root is full, split it and create a new root
            if (root.getNumKeys() == order - 1) {
                Node newRoot = new Node(order, false);
                newRoot.getChildren()[0] = root;
                splitChild(newRoot, 0);
                root = newRoot;
            }
            insertNonFull(root, key);
        }
    }

    // Insert into a non-full node
    private void insertNonFull(Node node, int key) {
        int i = node.getNumKeys() - 1;
        if (node.isLeaf()) {
            // Move keys greater than the new key to the right
            while (i >= 0 && key < node.getKeys()[i]) {
                node.getKeys()[i + 1] = node.getKeys()[i];
                i--;
            }
            node.getKeys()[i + 1] = key;
            node.incrementNumKeys();
        } else {
            // Find the child to insert the key
            while (i >= 0 && key < node.getKeys()[i]) {
                i--;
            }
            i++;
            // Check if the child is full
            if (node.getChildren()[i].getNumKeys() == order - 1) {
                splitChild(node, i);
                if (key > node.getKeys()[i]) {
                    i++;
                }
            }
            insertNonFull(node.getChildren()[i], key);
        }
    }

    // Split a full child of a node
    private void splitChild(Node parentNode, int childIndex) {
        Node childNode = parentNode.getChildren()[childIndex];
        Node newNode = new Node(order, childNode.isLeaf());
        parentNode.incrementNumKeys();

        // Move keys to the right to make space for the new node
        for (int i = parentNode.getNumKeys() - 1; i > childIndex; i--) {
            parentNode.getKeys()[i] = parentNode.getKeys()[i - 1];
        }

        // Move the median key from the child to the parent
        parentNode.getKeys()[childIndex] = childNode.getKeys()[(order/2) - 1];

        // Move children to the right to make space for the new node
        for (int i = parentNode.getNumKeys(); i > childIndex + 1; i--) {
            parentNode.getChildren()[i] = parentNode.getChildren()[i - 1];
        }

        // Set the new child node
        parentNode.getChildren()[childIndex + 1] = newNode;

        // Copy keys from the full child to the new node
        for (int i = 0; i < (order/2) - 1; i++) {
            newNode.getKeys()[i] = childNode.getKeys()[order/2];
            childNode.getKeys()[order/2] = 0; // Clear the old keys from the child
        }

        // Copy children from the full child to the new node if it's not a leaf
        if (!childNode.isLeaf()) {
            for (int i = 0; i < order/2; i++) {
                newNode.getChildren()[i] = childNode.getChildren()[(order/2) + i];
                childNode.getChildren()[(order/2) + i] = null; // Clear the old children from the child
            }
        }

        // Update the number of keys in the nodes
        childNode.setNumKeys((order/2) - 1);
        newNode.setNumKeys((order/2) - 1);
        //newNode.set
    }

    public String toString() {
        if (root == null) {
            return "BTree.BTree is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                sb.append("[");
                for (int j = 0; j < currentNode.getNumKeys(); j++) {
                    sb.append(currentNode.getKeys()[j]);
                    if (j != currentNode.getNumKeys() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");

                if (!currentNode.isLeaf()) {
                    for (int j = 0; j <= currentNode.getNumKeys(); j++) {
                        if (currentNode.getChildren()[j] != null) {
                            queue.offer(currentNode.getChildren()[j]);
                        }
                    }
                }

                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
