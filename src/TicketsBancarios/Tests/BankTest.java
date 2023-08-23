import TicketsBancarios.Bank;
import TicketsBancarios.Type;
import org.junit.Test;

public class BankTest {
    @Test
    public void testQueueBank() {
        Bank bank = new Bank();
        bank.getTicket(Type.NORMAL);
        bank.getTicket(Type.NORMAL);
        bank.getTicket(Type.VIP);
        bank.getTicket(Type.VIP);
        bank.getTicket(Type.NORMAL);
        bank.getTicket(Type.NORMAL);
        bank.getTicket(Type.VIP);

        bank.nextTicket();
        bank.nextTicket();
    }
}
