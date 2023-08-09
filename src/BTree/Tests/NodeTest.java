import org.junit.Test;
import BTree.BTree;

public class NodeTest {
    @Test
    public void SplitTest() {
        BTree bTree = new BTree(4);
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(35);
        bTree.insert(34);
        bTree.insert(36);
        bTree.insert(40);

        System.out.println(bTree);
    }
}
