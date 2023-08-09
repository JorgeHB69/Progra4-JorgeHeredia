import TreeHeap.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class DeleteTest {
    MaxHeap maxHeap;

    @Before
    public void start() {
        maxHeap = new MaxHeap(10);
    }

    @Test
    public void peekTest() {
        maxHeap.insert(40);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(12);

        int[] arrayExpected = new int[]{Integer.MAX_VALUE,20,15,12,7,6,10,0,0,0,0};
        maxHeap.peek();
        System.out.println(Arrays.toString(maxHeap.getVector()));
        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));
    }

    @Test
    public void deleteChildTest() {
        maxHeap.insert(40);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(12);

        int[] arrayExpected = new int[]{Integer.MAX_VALUE,40,15,20,12,6,10,0,0,0,0};
        maxHeap.delete(7);

        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));
    }

    @Test
    public void deleteParentTest() {
        maxHeap.insert(40);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(12);

        int[] arrayExpected = new int[]{Integer.MAX_VALUE,40,15,12,7,6,10,0,0,0,0};
        maxHeap.delete(20);

        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));
    }
}
