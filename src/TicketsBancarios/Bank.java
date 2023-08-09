package TicketsBancarios;

public class Bank {

    private ITreeHeap<Client> priorityQueue;
    private int normalClientCounter;
    private int vipClientCounter;

    public Bank() {
        this.priorityQueue = new PriorityHeap();
        this.normalClientCounter = 0;
        this.vipClientCounter = 0;
    }

    public void getTicket(Type type) {
        if (type == Type.NORMAL) {
            normalClientCounter++;
            priorityQueue.insert(new Client(type, normalClientCounter));
        } else {
            vipClientCounter++;
            priorityQueue.insert(new Client(type, normalClientCounter));
        }
    }
}
