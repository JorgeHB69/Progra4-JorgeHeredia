import TreeHeap.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsertTest {
    MaxHeap maxHeap;
    @Before
    public void start() {
        maxHeap = new MaxHeap(10);
    }
    @Test
    public void InsertInOrder() {
        maxHeap.insert(40);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(12);

        int[] arrayExpected = new int[]{Integer.MAX_VALUE,40,15,20,7,6,10,12,0,0,0};
        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));
    }

    @Test
    public void insertBiggerElements() {
        maxHeap.insert(15);
        maxHeap.insert(12);
        maxHeap.insert(30);

        int[] arrayExpected = new int[]{Integer.MAX_VALUE,30,12,15,0,0,0,0,0,0,0};
        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));

        maxHeap.insert(70);
        maxHeap.insert(50);
        maxHeap.insert(21);
        maxHeap.insert(61);
        arrayExpected = new int[]{Integer.MAX_VALUE,70,50,61,12,30,15,21,0,0,0};
        assertTrue(Arrays.equals(arrayExpected, maxHeap.getVector()));
    }
}
