import TreeHeap.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    MaxHeap maxHeap;

    @Before
    public void start() {
        maxHeap = new MaxHeap(10);
    }

    @Test
    public void searchTest() {
        maxHeap.insert(10);
        maxHeap.insert(200);
        maxHeap.insert(40);
        maxHeap.insert(124);
        maxHeap.insert(51);
        maxHeap.insert(420);
        maxHeap.insert(65);
        maxHeap.insert(211);

        System.out.println(Arrays.toString(maxHeap.getVector()));
        assertEquals(7, maxHeap.search(65));
        assertEquals(1, maxHeap.search(420));
        assertEquals(4, maxHeap.search(124));
    }
}
