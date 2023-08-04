import TreeHeap.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SwapTest {
    MaxHeap maxHeap;
    int[] arrayExpected;

    @Before
    public void start() {
        maxHeap = new MaxHeap(10);
    }

    @Test
    public void swapChildWithParent() {
        maxHeap.insert(15);
        maxHeap.insert(19);
        maxHeap.insert(50);
        maxHeap.insert(41);
        maxHeap.insert(61);
        maxHeap.insert(22);
        maxHeap.insert(28);

        maxHeap.swap(1, 2);
        arrayExpected = new int[]{Integer.MAX_VALUE,50, 61, 28, 15, 41, 19, 22, 0, 0, 0};
        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));
    }
}
