package TicketsBancarios;

import java.util.Objects;

public class Client {
    private String name;
    private Type type;
    private int numberOnQueue;

    public Client(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Client(Type type, int numberOnQueue) {
        this.name = "Anonymous";
        this.type = type;
        this.numberOnQueue = numberOnQueue;
    }

    public void setNumberOnQueue(int numberOnQueue) {
        this.numberOnQueue = numberOnQueue;
    }

    public int compare(Client otherClient) {
        if (type == otherClient.type) {
            return Integer.compare(numberOnQueue, otherClient.numberOnQueue) * -1;
        } else if (type.equals(Type.VIP) && otherClient.type.equals(Type.NORMAL)) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return type.toString() + "-Client-" + numberOnQueue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return numberOnQueue == client.numberOnQueue && Objects.equals(name, client.name) && type == client.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, numberOnQueue);
    }
}
