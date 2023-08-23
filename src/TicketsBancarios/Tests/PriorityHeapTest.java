import TicketsBancarios.Client;
import TicketsBancarios.PriorityHeap;
import TicketsBancarios.Type;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriorityHeapTest {

    @Test
    public void insertVIPS() {
        PriorityHeap priorityHeap = new PriorityHeap();
        priorityHeap.insert(new Client(Type.VIP, 1));
        priorityHeap.insert(new Client(Type.VIP, 2));
        priorityHeap.insert(new Client(Type.VIP, 3));
        priorityHeap.insert(new Client(Type.VIP, 4));
        priorityHeap.insert(new Client(Type.VIP, 5));
        priorityHeap.insert(new Client(Type.VIP, 6));
        priorityHeap.print();
    }

    @Test
    public void insertNormal() {
        PriorityHeap priorityHeap = new PriorityHeap();
        priorityHeap.insert(new Client(Type.NORMAL, 1));
        priorityHeap.insert(new Client(Type.NORMAL, 2));
        priorityHeap.insert(new Client(Type.NORMAL, 3));
        priorityHeap.insert(new Client(Type.NORMAL, 4));
        priorityHeap.insert(new Client(Type.NORMAL, 5));
        priorityHeap.insert(new Client(Type.NORMAL, 6));
        priorityHeap.print();
    }

    @Test
    public void insertBoth() {
        PriorityHeap priorityHeap = new PriorityHeap();
        priorityHeap.insert(new Client(Type.NORMAL, 1));
        priorityHeap.insert(new Client(Type.NORMAL, 2));
        priorityHeap.insert(new Client(Type.NORMAL, 3));
        priorityHeap.insert(new Client(Type.VIP, 1));
        priorityHeap.insert(new Client(Type.NORMAL, 4));
        priorityHeap.insert(new Client(Type.VIP, 2));
        priorityHeap.insert(new Client(Type.VIP, 10));
        priorityHeap.insert(new Client(Type.NORMAL, 5));
        priorityHeap.print();
    }

    @Test
    public void peekTest() {
        PriorityHeap priorityHeap = new PriorityHeap();
        Client client1 = new Client(Type.NORMAL, 1);
        Client client2 = new Client(Type.NORMAL, 2);
        Client client3 = new Client(Type.NORMAL, 3);
        Client client4 = new Client(Type.VIP, 1);
        Client client5 = new Client(Type.NORMAL, 4);
        Client client6 = new Client(Type.VIP, 2);
        Client client7 = new Client(Type.VIP, 10);
        Client client8 = new Client(Type.NORMAL, 5);
        priorityHeap.insert(client1);
        priorityHeap.insert(client2);
        priorityHeap.insert(client3);
        priorityHeap.insert(client4);
        priorityHeap.insert(client5);
        priorityHeap.insert(client6);
        priorityHeap.insert(client7);
        priorityHeap.insert(client8);

        assertEquals(client4, priorityHeap.peek());
        assertEquals(client6, priorityHeap.peek());
        assertEquals(client7, priorityHeap.peek());
        assertEquals(client1, priorityHeap.peek());
        assertEquals(client2, priorityHeap.peek());
        assertEquals(client3, priorityHeap.peek());
        assertEquals(client5, priorityHeap.peek());
        assertEquals(client8, priorityHeap.peek());
    }
}
