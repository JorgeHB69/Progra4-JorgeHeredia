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
            priorityQueue.insert(new Client(type, vipClientCounter));
        }
    }

    public void nextTicket() {
        StringBuilder sb = new StringBuilder("\t\t---BANK OF AMERICA---\n");
        sb.append("\tCURRENT TICKET : ").append(priorityQueue.peek()).append("\n");

        sb.append("\tNEXT TICKET : ").append(priorityQueue.getVector().get(1)).append("\n");
        sb.append("\tON QUEUE : ").append(priorityQueue.getSize()).append("\n");

        System.out.println(sb);
    }
}
