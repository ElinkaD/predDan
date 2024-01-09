package Queue;
import Container.Container;
public interface ATD_Queue {
    public void enqueue(Container x);
    public Container dequeue();
    public Container front();
    public boolean empty();
    public boolean full();
    public void makeNull();
}
